package org.microhumans.entity;


import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "micro-humans")
public class MicroHumanEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(nullable = false)
    public String nombre;

    @Column(nullable = false)
    public String sexo;

    @Column(nullable = true)
    public int hambre = 100;

    @Column(nullable = true)
    public int energia = 100;

    @Column(nullable = true)
    public int deseo = 100;

}