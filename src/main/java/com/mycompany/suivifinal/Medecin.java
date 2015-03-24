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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Medecin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medecin.findAll", query = "SELECT m FROM Medecin m"),
    @NamedQuery(name = "Medecin.findByIdMedecin", query = "SELECT m FROM Medecin m WHERE m.idMedecin = :idMedecin"),
    @NamedQuery(name = "Medecin.findByFonction", query = "SELECT m FROM Medecin m WHERE m.fonction = :fonction"),
    @NamedQuery(name = "Medecin.findByGrade", query = "SELECT m FROM Medecin m WHERE m.grade = :grade")})
public class Medecin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedecin")
    private Integer idMedecin;
    @Size(max = 254)
    @Column(name = "fonction")
    private String fonction;
    @Size(max = 254)
    @Column(name = "grade")
    private String grade;
    @JoinColumn(name = "idCompte", referencedColumnName = "idCompte")
    @ManyToOne(optional = false)
    private Compte idCompte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medecin")
    private Collection<Suivi> suiviCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedecin")
    private Collection<Specialite> specialiteCollection;
    @OneToMany(mappedBy = "idMedecin")
    private Collection<RendezVous> rendezVousCollection;

    public Medecin() {
    }

    public Medecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }

    public Integer getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Compte getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Compte idCompte) {
        this.idCompte = idCompte;
    }

    @XmlTransient
    public Collection<Suivi> getSuiviCollection() {
        return suiviCollection;
    }

    public void setSuiviCollection(Collection<Suivi> suiviCollection) {
        this.suiviCollection = suiviCollection;
    }

    @XmlTransient
    public Collection<Specialite> getSpecialiteCollection() {
        return specialiteCollection;
    }

    public void setSpecialiteCollection(Collection<Specialite> specialiteCollection) {
        this.specialiteCollection = specialiteCollection;
    }

    @XmlTransient
    public Collection<RendezVous> getRendezVousCollection() {
        return rendezVousCollection;
    }

    public void setRendezVousCollection(Collection<RendezVous> rendezVousCollection) {
        this.rendezVousCollection = rendezVousCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedecin != null ? idMedecin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medecin)) {
            return false;
        }
        Medecin other = (Medecin) object;
        if ((this.idMedecin == null && other.idMedecin != null) || (this.idMedecin != null && !this.idMedecin.equals(other.idMedecin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Medecin[ idMedecin=" + idMedecin + " ]";
    }
    
}
