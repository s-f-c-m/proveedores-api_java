package com.tiendagenerica.proveedores;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class Proveedor {

    @Id
    private String nitProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private String ciudadProveedor;
    private String telefonoProveedor;

}
