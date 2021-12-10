package com.tiendagenerica.proveedores;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public List<Proveedor> getAll(){
        return proveedorRepository.findAll();
    }

    public void insertProveedor(Proveedor proveedor){
        proveedorRepository.save(proveedor);
    }

    public void removeProveedor(String id){
        proveedorRepository.deleteById(id);
    }

    public void updateProveedor(String id, Proveedor proveedor){
        proveedorRepository.save(proveedor);
    }

    public Optional<Proveedor> getProveedor(String id){
        return proveedorRepository.findById(id);
    }
}
