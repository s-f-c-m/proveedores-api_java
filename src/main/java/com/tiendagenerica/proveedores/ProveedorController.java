package com.tiendagenerica.proveedores;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins="*")
@RequestMapping("api/v1/proveedores")
public class ProveedorController {

    private ProveedorService proveedorService;
    private final JWTChecker jwtchecker;

    @PostMapping
    public void insertProveedor(@RequestHeader Map<String, String> headers, @RequestBody Proveedor proveedor){
        if(jwtchecker.doFilter(headers)){
            proveedorService.insertProveedor(proveedor);
        }
    }

    @GetMapping
    public List<Proveedor> getProveedores(@RequestHeader Map<String, String> headers){
        if(jwtchecker.doFilter(headers)){
            return proveedorService.getAll();
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Proveedor> getProveedor(@RequestHeader Map<String, String> headers, @PathVariable String id){
        if(jwtchecker.doFilter(headers)){
            return proveedorService.getProveedor(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@RequestHeader Map<String, String> headers, @PathVariable String id){
        if(jwtchecker.doFilter(headers)){
            proveedorService.removeProveedor(id);
        }
    }

    @PutMapping("/{id}")
    public void updateProveedor(@RequestHeader Map<String, String> headers, @PathVariable String id, @RequestBody Proveedor proveedor){
        if(jwtchecker.doFilter(headers)){
            proveedorService.updateProveedor(id, proveedor);
        }
    }

}
