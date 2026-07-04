package org.microhumans.dto;

import org.microhumans.entity.MicroHumanEntity;

import java.util.UUID;

public record MicroHumanDTO(
        UUID id,
        String name,
        String sex,
        int hunger,
        int energy,
        int desire
) {
    public static MicroHumanDTO fromEntity(MicroHumanEntity entity){
        return new MicroHumanDTO(
                entity.id,
                entity.name,
                entity.sex,
                entity.hunger,
                entity.energy,
                entity.desire
        );
    }
}