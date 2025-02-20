package com.gep.customerservice.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private RsaKeysConfig rsaKeysConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( //Configuramos la autorización para las peticiones HTTP
                        (auth) -> auth.anyRequest().authenticated()
                )

                //Configura el servidor de recursos para usar JWT como mecanismo de autenticación
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()))  //Configura Spring Security para que el servidor actúe como un OAuth2 Resource Server y use JWT como mecanismo de autenticación.
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt) //deprecated

                .httpBasic(Customizer.withDefaults())
                .build();
    }

    //Decodificar y validar tokens JWT entrantes (Usan la clave pública)
    @Bean
    JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withPublicKey(rsaKeysConfig.publicKey()).build();
    }

}
