package com.gep.customerservice.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustomerRestApi {

    //GET: http://localhost:8081/customers
    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')") //only users with SCOPE_ADMIN can access this endpoint
    public Map<String,Object> customer(Authentication authentication){
        return Map.of("name","Christian","email","c1@gmail.com",
                "username",authentication.getName(),"scope",authentication.getAuthorities());
    }

    //Levantar el proyecto security-aouth-jwt y obtener el token de acceso
     /* Para generar el token:  ->  POST: http://localhost:8080/token
       -→ EN Postman clic en Authorization -> Seleccionar Basic Auth -> Agregar username:user1 y password: 1234
       -> Clic en Body y seleccionar x-www-form-urlencoded o form-data  luego agregar los siguientes parametros:
         en la columna KEY: grantType y en VALUE: password     o  refreshToken
            en la columna KEY: username y en VALUE: user1
            en la columna KEY: password y en VALUE: 1234
            en la columna KEY: withRefreshToken y en VALUE: true    o   fase

            //NOTA: si en grantType se coloca refreshToken: se debe agregar el refreshToken generado en el campo refreshToken: agregar otra
            // columna Key: refreshToken y en VALUE: "pegar el refreshToken generado"
         -> Enviar la petición generará un token de acceso y un token de actualización.
    */

    /* Para acceder al recurso protegido:  ->  GET: http://localhost:8081/customers
       -→ EN Postman clic en Authorization -> Seleccionar Bearer Token -> Agregar el token de acceso generado
       -> Enviar la petición y se obtendrá la respuesta con los datos del usuario autenticado.
    */

}
