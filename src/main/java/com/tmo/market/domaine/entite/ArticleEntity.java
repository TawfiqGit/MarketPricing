package com.tmo.market.domaine.entite;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "article")
@Getter
@Setter
public class ArticleEntity extends BaseEntity {

    String nom;
    String description;
    double prix;

}
