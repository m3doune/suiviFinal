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
@Table(name = "Patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByIdPatient", query = "SELECT p FROM Patient p WHERE p.idPatient = :idPatient"),
    @NamedQuery(name = "Patient.findByProfession", query = "SELECT p FROM Patient p WHERE p.profession = :profession"),
    @NamedQuery(name = "Patient.findByCss", query = "SELECT p FROM Patient p WHERE p.css = :css"),
    @NamedQuery(name = "Patient.findByMutuel", query = "SELECT p FROM Patient p WHERE p.mutuel = :mutuel")})
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatient")
    private Long idPatient;
    @Size(max = 254)
    @Column(name = "profession")
    private String profession;
    @Size(max = 254)
    @Column(name = "css")
    private String css;
    @Size(max = 254)
    @Column(name = "mutuel")
    private String mutuel;
    @JoinColumn(name = "idCompte", referencedColumnName = "idCompte")
    @ManyToOne(optional = false)
    private Compte idCompte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Collection<Description> descriptionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Collection<Suivi> suiviCollection;
    @OneToMany(mappedBy = "idPatient")
    private Collection<Antecedant> antecedantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatient")
    private Collection<RendezVous> rendezVousCollection;

    public Patient() {
    }

    public Patient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getMutuel() {
        return mutuel;
    }

    public void setMutuel(String mutuel) {
        this.mutuel = mutuel;
    }

    public Compte getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Compte idCompte) {
        this.idCompte = idCompte;
    }

    @XmlTransient
    public Collection<Description> getDescriptionCollection() {
        return descriptionCollection;
    }

    public void setDescriptionCollection(Collection<Description> descriptionCollection) {
        this.descriptionCollection = descriptionCollection;
    }

    @XmlTransient
    public Collection<Suivi> getSuiviCollection() {
        return suiviCollection;
    }

    public void setSuiviCollection(Collection<Suivi> suiviCollection) {
        this.suiviCollection = suiviCollection;
    }

    @XmlTransient
    public Collection<Antecedant> getAntecedantCollection() {
        return antecedantCollection;
    }

    public void setAntecedantCollection(Collection<Antecedant> antecedantCollection) {
        this.antecedantCollection = antecedantCollection;
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
        hash += (idPatient != null ? idPatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idPatient == null && other.idPatient != null) || (this.idPatient != null && !this.idPatient.equals(other.idPatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Patient[ idPatient=" + idPatient + " ]";
    }
    
}
