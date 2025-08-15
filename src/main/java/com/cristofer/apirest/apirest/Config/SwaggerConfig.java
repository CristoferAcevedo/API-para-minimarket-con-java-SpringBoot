package com.cristofer.apirest.apirest.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Ventas")
                        .description("Documentación de la API para gestión de usuarios, ventas y autenticación")
                        .version("1.0.0"));
    }
}
