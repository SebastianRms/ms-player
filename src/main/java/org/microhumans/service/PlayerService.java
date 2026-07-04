package org.microhumans.service;

import io.smallrye.mutiny.Uni;
import org.microhumans.dto.MicroHumanDTO;

import java.util.UUID;

public interface PlayerService {

    Uni<MicroHumanDTO> getPlayerById(UUID playerId);

    Uni<MicroHumanDTO> hungerBalance(UUID playerId, int hunger);

    Uni<MicroHumanDTO> energyBalance(UUID playerId, int energy);

    Uni<MicroHumanDTO> desireBalance(UUID playerId, int desire);

    Uni<MicroHumanDTO> getState(UUID playerId);
}
