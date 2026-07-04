package org.microhumans.service.impl;


import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.microhumans.dto.MicroHumanDTO;
import org.microhumans.repository.MicroHumanRepository;
import org.microhumans.service.PlayerService;

import java.util.UUID;

@ApplicationScoped
public class PlayerServiceImpl implements PlayerService {

    private final MicroHumanRepository repository;

    @Inject
    public PlayerServiceImpl(MicroHumanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Uni<MicroHumanDTO> getPlayerById(UUID playerId){
        return repository.findById(playerId)
                .onItem().ifNull().failWith(()-> new NotFoundException("MicroHuman not found with ID: " + playerId))
                .onItem().transform(MicroHumanDTO::fromEntity);
    }

    @Override
    public Uni<MicroHumanDTO> hungerBalance(UUID playerId, int hungerLevels) {
        return repository.findById(playerId)
                .onItem().ifNull().failWith(() -> new NotFoundException("Human not found with ID: " + playerId))
                .onItem().transform(human -> {
                    int points = hungerLevels * 5;
                    human.hunger = Math.clamp(human.hunger + points, 0, 100);
                    return human;
                })
                .call(repository::persist)
                .onItem().transform(MicroHumanDTO::fromEntity);
    }

    @Override
    public Uni<MicroHumanDTO> energyBalance(UUID playerId, int energyLevels) {
        return repository.findById(playerId)
                .onItem().ifNull().failWith(() -> new NotFoundException("Human not found with ID: " + playerId))
                .onItem().transform(human -> {
                    int points = energyLevels * 5;
                    human.energy = Math.clamp(human.energy + points, 0, 100);
                    return human;
                })
                .call(repository::persist)
                .onItem().transform(MicroHumanDTO::fromEntity);
    }

    @Override
    public Uni<MicroHumanDTO> desireBalance(UUID playerId, int desireLevels) {
        return repository.findById(playerId)
                .onItem().ifNull().failWith(() -> new NotFoundException("Human not found with ID: " + playerId))
                .onItem().transform(human -> {
                    int points = desireLevels * 5;
                    human.desire = Math.clamp(human.desire + points, 0, 100);
                    return human;
                })
                .call(repository::persist)
                .onItem().transform(MicroHumanDTO::fromEntity);
    }

    @Override
    public Uni<MicroHumanDTO> getState(UUID playerId) {
        return getPlayerById(playerId);
    }
}
