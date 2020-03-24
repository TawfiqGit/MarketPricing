package com.tmo.market.domaine.entite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tarifs")
@Getter
@Setter
public class Tarifs extends BaseEntity {

    double coutRevientHt;
    double tauxMarge;
}
