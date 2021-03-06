package com.azure.containerapps.quarkus.workshop.superheroes.hero;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/heroes")
@Tag(name = "hero")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class HeroResource {

    Logger logger;

    @Inject
    public HeroResource(Logger logger) {
        this.logger = logger;
    }

    @GET
    @Path("/random")
    @Operation(operationId = "getRandomHero", summary = "Returns a random hero")
    @APIResponse(
        responseCode = "200",
        content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Hero.class, required = true))
    )
    public Response getRandomHero() {
        logger.info("Getting a random hero");
        Hero hero = Hero.findRandom();
        logger.debug("Found random hero : " + hero);
        return Response.ok(hero).build();
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(operationId = "hello", summary = "Returns hello from the hero resource")
    public String hello() {
        logger.info("Hello from Hero Resource");
        return "Hello from Hero Resource";
    }
}
