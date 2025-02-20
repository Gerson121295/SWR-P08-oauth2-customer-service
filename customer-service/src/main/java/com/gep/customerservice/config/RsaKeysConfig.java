package com.gep.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPublicKey;


//Este record RsaKeysConfig vincula la clave pública RSA definida en aplicación.properties para extraer la clave publica y poder utilizarla en la autenticación de los servicios
@ConfigurationProperties(prefix = "rsa")
public record RsaKeysConfig(RSAPublicKey publicKey) {
}
