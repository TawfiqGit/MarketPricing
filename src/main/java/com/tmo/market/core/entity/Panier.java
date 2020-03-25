package com.tmo.market.core.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "panier")
@Getter
@Setter
public class Panier extends BaseEntity{

    long idProduit;
    int quantite;
}
