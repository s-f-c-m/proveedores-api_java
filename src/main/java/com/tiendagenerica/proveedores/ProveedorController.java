package com.tiendagenerica.proveedores;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
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
    public void insertProveedor(@RequestHeader Map<String, String> headers, @RequestBody Proveedor proveedor) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            proveedorService.insertProveedor(proveedor);
        }else{
            throw new AuthException("No authorizado");
        }
    }

    @GetMapping
    public List<Proveedor> getProveedores(@RequestHeader Map<String, String> headers) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            return proveedorService.getAll();
    }else{
        throw new AuthException("No authorizado");
        }
    }

    @GetMapping("/{id}")
    public Optional<Proveedor> getProveedor(@RequestHeader Map<String, String> headers, @PathVariable String id) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            return proveedorService.getProveedor(id);
        }else{
        throw new AuthException("No authorizado");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@RequestHeader Map<String, String> headers, @PathVariable String id) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            proveedorService.removeProveedor(id);
        }else{
        throw new AuthException("No authorizado");
        }
    }

    @PutMapping("/{id}")
    public void updateProveedor(@RequestHeader Map<String, String> headers, @PathVariable String id, @RequestBody Proveedor proveedor) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            proveedorService.updateProveedor(id, proveedor);
        }else{
        throw new AuthException("No authorizado");
        }
    }

}
