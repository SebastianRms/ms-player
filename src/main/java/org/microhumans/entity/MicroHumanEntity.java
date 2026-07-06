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
    public String name;

    @Column(nullable = false)
    public String sex;

    @Column(nullable = true)
    public int hunger = 100;

    @Column(nullable = true)
    public int energy = 100;

    @Column(nullable = true)
    public int desire = 100;

}