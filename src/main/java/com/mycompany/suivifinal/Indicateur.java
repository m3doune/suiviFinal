/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.suivifinal;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author medoune
 */
@Entity
@Table(name = "Indicateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicateur.findAll", query = "SELECT i FROM Indicateur i"),
    @NamedQuery(name = "Indicateur.findByIdIndicateur", query = "SELECT i FROM Indicateur i WHERE i.idIndicateur = :idIndicateur"),
    @NamedQuery(name = "Indicateur.findByNom", query = "SELECT i FROM Indicateur i WHERE i.nom = :nom")})
public class Indicateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIndicateur")
    private Integer idIndicateur;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicateur")
    private Collection<Description> descriptionCollection;

    public Indicateur() {
    }

    public Indicateur(Integer idIndicateur) {
        this.idIndicateur = idIndicateur;
    }

    public Integer getIdIndicateur() {
        return idIndicateur;
    }

    public void setIdIndicateur(Integer idIndicateur) {
        this.idIndicateur = idIndicateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Description> getDescriptionCollection() {
        return descriptionCollection;
    }

    public void setDescriptionCollection(Collection<Description> descriptionCollection) {
        this.descriptionCollection = descriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIndicateur != null ? idIndicateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicateur)) {
            return false;
        }
        Indicateur other = (Indicateur) object;
        if ((this.idIndicateur == null && other.idIndicateur != null) || (this.idIndicateur != null && !this.idIndicateur.equals(other.idIndicateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Indicateur[ idIndicateur=" + idIndicateur + " ]";
    }
    
}
