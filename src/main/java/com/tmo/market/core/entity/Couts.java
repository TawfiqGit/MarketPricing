package com.tmo.market.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "couts")
@Getter
@Setter
public class Couts extends BaseEntity {

    //Couts revient
    double achat;
    double production;
    double distribution;
    double promotion;
    double administratif;

    //Service
    double horaire;
    double frais_prospections;
    double charges_courantes;
    double frais_de_production;
}
