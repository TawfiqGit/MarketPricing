package com.tmo.market.domaine.entite;

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

}
