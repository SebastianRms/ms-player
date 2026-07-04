package org.microhumans.dto;

import org.microhumans.entity.MicroHumanEntity;

import java.util.UUID;

public record MicroHumanDTO(
        UUID id,
        String nombre,
        String sexo,
        int hambre,
        int energia,
        int deseo
) {
    public static MicroHumanDTO fromEntity(MicroHumanEntity entity){
        return new MicroHumanDTO(
                entity.id,
                entity.nombre,
                entity.sexo,
                entity.hambre,
                entity.energia,
                entity.deseo
        );
    }
}