package com.tmo.market.domaine.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class PanierEntity extends BaseEntity{

    @XmlElement
    int quantite;

    @XmlElement
    double prixTotal;



}
