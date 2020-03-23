package com.tmo.market.domaine.entite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "options")
@Getter
@Setter
public class Options extends BaseEntity {
    String nomOption;
    double resultat;
}
