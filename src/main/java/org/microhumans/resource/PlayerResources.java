package org.microhumans.resource;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.microhumans.dto.CreateHumanRequest;
import org.microhumans.dto.LevelModifierRequest;
import org.microhumans.dto.MicroHumanDTO;
import org.microhumans.service.PlayerService;

import java.util.UUID;

@Path("/api/v1/players")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PlayerResources {

    private final PlayerService playerService;

    @Inject
    public PlayerResources(PlayerService playerService) {
        this.playerService = playerService;
    }

    @POST
    public Uni<MicroHumanDTO> createPlayer(CreateHumanRequest request) {
        return playerService.createHuman(request);
    }

    @GET
    @Path("/{id}")
    public Uni<MicroHumanDTO> getPlayerById(@PathParam("id") UUID id) {
        return playerService.getPlayerById(id);
    }

    @PUT
    @Path("/{id}/hunger")
    public Uni<MicroHumanDTO> hungerBalance(@PathParam("id") UUID id, LevelModifierRequest request) {
        return playerService.hungerBalance(id, request.levels());
    }

    @PUT
    @Path("/{id}/energy")
    public Uni<MicroHumanDTO> energyBalance(@PathParam("id") UUID id, LevelModifierRequest request) {
        return playerService.energyBalance(id, request.levels());
    }

    @PUT
    @Path("/{id}/desire")
    public Uni<MicroHumanDTO> desireBalance(@PathParam("id") UUID id, LevelModifierRequest request) {
        return playerService.desireBalance(id, request.levels());
    }
}