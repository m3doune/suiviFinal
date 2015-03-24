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
@Table(name = "Medicament")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicament.findAll", query = "SELECT m FROM Medicament m"),
    @NamedQuery(name = "Medicament.findByIdMed", query = "SELECT m FROM Medicament m WHERE m.idMed = :idMed"),
    @NamedQuery(name = "Medicament.findByLibelle", query = "SELECT m FROM Medicament m WHERE m.libelle = :libelle")})
public class Medicament implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMed")
    private Integer idMed;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMed")
    private Collection<ModeEmplois> modeEmploisCollection;

    public Medicament() {
    }

    public Medicament(Integer idMed) {
        this.idMed = idMed;
    }

    public Integer getIdMed() {
        return idMed;
    }

    public void setIdMed(Integer idMed) {
        this.idMed = idMed;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public Collection<ModeEmplois> getModeEmploisCollection() {
        return modeEmploisCollection;
    }

    public void setModeEmploisCollection(Collection<ModeEmplois> modeEmploisCollection) {
        this.modeEmploisCollection = modeEmploisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMed != null ? idMed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicament)) {
            return false;
        }
        Medicament other = (Medicament) object;
        if ((this.idMed == null && other.idMed != null) || (this.idMed != null && !this.idMed.equals(other.idMed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Medicament[ idMed=" + idMed + " ]";
    }
    
}
