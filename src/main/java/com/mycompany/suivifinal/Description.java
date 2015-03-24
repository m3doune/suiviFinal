/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.suivifinal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author medoune
 */
@Entity
@Table(name = "description")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Description.findAll", query = "SELECT d FROM Description d"),
    @NamedQuery(name = "Description.findByIdMaladie", query = "SELECT d FROM Description d WHERE d.descriptionPK.idMaladie = :idMaladie"),
    @NamedQuery(name = "Description.findByIdIndicateur", query = "SELECT d FROM Description d WHERE d.descriptionPK.idIndicateur = :idIndicateur"),
    @NamedQuery(name = "Description.findByIdPatient", query = "SELECT d FROM Description d WHERE d.descriptionPK.idPatient = :idPatient"),
    @NamedQuery(name = "Description.findByDate", query = "SELECT d FROM Description d WHERE d.date = :date"),
    @NamedQuery(name = "Description.findByValeur", query = "SELECT d FROM Description d WHERE d.valeur = :valeur")})
public class Description implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DescriptionPK descriptionPK;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 254)
    @Column(name = "valeur")
    private String valeur;
    @JoinColumn(name = "idIndicateur", referencedColumnName = "idIndicateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Indicateur indicateur;
    @JoinColumn(name = "idMaladie", referencedColumnName = "idMaladie", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Maladie maladie;
    @JoinColumn(name = "idPatient", referencedColumnName = "idPatient", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patient patient;

    public Description() {
    }

    public Description(DescriptionPK descriptionPK) {
        this.descriptionPK = descriptionPK;
    }

    public Description(int idMaladie, int idIndicateur, long idPatient) {
        this.descriptionPK = new DescriptionPK(idMaladie, idIndicateur, idPatient);
    }

    public DescriptionPK getDescriptionPK() {
        return descriptionPK;
    }

    public void setDescriptionPK(DescriptionPK descriptionPK) {
        this.descriptionPK = descriptionPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Indicateur getIndicateur() {
        return indicateur;
    }

    public void setIndicateur(Indicateur indicateur) {
        this.indicateur = indicateur;
    }

    public Maladie getMaladie() {
        return maladie;
    }

    public void setMaladie(Maladie maladie) {
        this.maladie = maladie;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descriptionPK != null ? descriptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Description)) {
            return false;
        }
        Description other = (Description) object;
        if ((this.descriptionPK == null && other.descriptionPK != null) || (this.descriptionPK != null && !this.descriptionPK.equals(other.descriptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Description[ descriptionPK=" + descriptionPK + " ]";
    }
    
}
