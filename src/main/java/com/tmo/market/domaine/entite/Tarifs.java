package com.tmo.market.domaine.entite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tarifs")
@Getter
@Setter
public class Tarifs {

    @Id
    long id;
    double coutRevientHt;
    double tauxMarge;
}
