package com.sanvalero.api.vuelos.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Flights API")
                        .description("Ejemplo de API REST de vuelos")
                        .contact(new Contact()
                                .name("Alberto Miguel")
                                .email("prueba@gmail.com")
                                .url("https://github.com/AMiguelNavarro/API_Vuelos"))
                        .version("1.0"));
    }

}
