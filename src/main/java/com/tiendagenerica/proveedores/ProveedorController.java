package com.tiendagenerica.proveedores;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/v1/proveedores")
public class ProveedorController {

    private ProveedorService proveedorService;

    @PostMapping
    public void insertProveedor(@RequestBody Proveedor proveedor){
        proveedorService.insertProveedor(proveedor);
    }

    @GetMapping
    public List<Proveedor> getProveedores(){
        return proveedorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Proveedor> getProveedor(@PathVariable String id){
        return proveedorService.getProveedor(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable String id){
        proveedorService.removeProveedor(id);
    }

    @PutMapping("/{id}")
    public void updateProveedor(@PathVariable String id, @RequestBody Proveedor proveedor){
        proveedorService.updateProveedor(id, proveedor);
    }

}
