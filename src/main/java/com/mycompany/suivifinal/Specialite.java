/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.suivifinal;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author medoune
 */
@Entity
@Table(name = "Specialite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialite.findAll", query = "SELECT s FROM Specialite s"),
    @NamedQuery(name = "Specialite.findByIdSpec", query = "SELECT s FROM Specialite s WHERE s.idSpec = :idSpec"),
    @NamedQuery(name = "Specialite.findByNom", query = "SELECT s FROM Specialite s WHERE s.nom = :nom")})
public class Specialite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSpec")
    private Integer idSpec;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "idMaladie", referencedColumnName = "idMaladie")
    @ManyToOne
    private Maladie idMaladie;
    @JoinColumn(name = "idMedecin", referencedColumnName = "idMedecin")
    @ManyToOne(optional = false)
    private Medecin idMedecin;

    public Specialite() {
    }

    public Specialite(Integer idSpec) {
        this.idSpec = idSpec;
    }

    public Integer getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(Integer idSpec) {
        this.idSpec = idSpec;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Maladie getIdMaladie() {
        return idMaladie;
    }

    public void setIdMaladie(Maladie idMaladie) {
        this.idMaladie = idMaladie;
    }

    public Medecin getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Medecin idMedecin) {
        this.idMedecin = idMedecin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpec != null ? idSpec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialite)) {
            return false;
        }
        Specialite other = (Specialite) object;
        if ((this.idSpec == null && other.idSpec != null) || (this.idSpec != null && !this.idSpec.equals(other.idSpec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Specialite[ idSpec=" + idSpec + " ]";
    }
    
}
