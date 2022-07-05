package com.azure.containerapps.quarkus.workshop.superheroes.hero;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
    info = @Info(title = "Hero API", description = "This API returns a random hero.", version = "1.0"),
    servers = {
        @Server(url = "http://localhost:8702", description = "Local server")
    }
)
public class HeroApplication extends Application {
}
