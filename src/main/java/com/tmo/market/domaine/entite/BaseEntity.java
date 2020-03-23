package com.tmo.market.domaine.entite;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private final Integer id;

    public BaseEntity() {
        this.id = null;
    }
}
