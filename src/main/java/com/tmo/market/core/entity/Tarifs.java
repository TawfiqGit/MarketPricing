package com.tmo.market.core.entity;

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
