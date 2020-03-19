package com.tmo.market.domaine.entite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tarification")
@Getter
@Setter
public class Tarification extends BaseEntity {

    double coutRevientHt;
    double tauxMarge;
}
