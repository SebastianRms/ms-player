package org.microhumans.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.microhumans.entity.MicroHumanEntity;

import java.util.UUID;

@ApplicationScoped
public class MicroHumanRepository implements PanacheRepositoryBase <MicroHumanEntity, UUID> {

}
