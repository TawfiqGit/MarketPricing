package com.tmo.market.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "options")
@Getter
@Setter
public class Options extends BaseEntity {

    String nomOption;
    double resultat;
}
