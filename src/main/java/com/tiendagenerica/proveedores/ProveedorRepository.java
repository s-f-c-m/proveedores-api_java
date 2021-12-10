package com.tiendagenerica.proveedores;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProveedorRepository extends MongoRepository<Proveedor, String> {
}
