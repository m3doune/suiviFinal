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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author medoune
 */
@Entity
@Table(name = "Suivi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suivi.findAll", query = "SELECT s FROM Suivi s"),
    @NamedQuery(name = "Suivi.findByIdPatient", query = "SELECT s FROM Suivi s WHERE s.suiviPK.idPatient = :idPatient"),
    @NamedQuery(name = "Suivi.findByIdMaladie", query = "SELECT s FROM Suivi s WHERE s.suiviPK.idMaladie = :idMaladie"),
    @NamedQuery(name = "Suivi.findByIdMedecin", query = "SELECT s FROM Suivi s WHERE s.suiviPK.idMedecin = :idMedecin"),
    @NamedQuery(name = "Suivi.findByDatedebut", query = "SELECT s FROM Suivi s WHERE s.datedebut = :datedebut"),
    @NamedQuery(name = "Suivi.findByDatefin", query = "SELECT s FROM Suivi s WHERE s.datefin = :datefin")})
public class Suivi implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SuiviPK suiviPK;
    @Column(name = "datedebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefin;
    @JoinColumn(name = "idMaladie", referencedColumnName = "idMaladie", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Maladie maladie;
    @JoinColumn(name = "idMedecin", referencedColumnName = "idMedecin", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medecin medecin;
    @JoinColumn(name = "idPatient", referencedColumnName = "idPatient", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patient patient;

    public Suivi() {
    }

    public Suivi(SuiviPK suiviPK) {
        this.suiviPK = suiviPK;
    }

    public Suivi(long idPatient, int idMaladie, int idMedecin) {
        this.suiviPK = new SuiviPK(idPatient, idMaladie, idMedecin);
    }

    public SuiviPK getSuiviPK() {
        return suiviPK;
    }

    public void setSuiviPK(SuiviPK suiviPK) {
        this.suiviPK = suiviPK;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Maladie getMaladie() {
        return maladie;
    }

    public void setMaladie(Maladie maladie) {
        this.maladie = maladie;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
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
        hash += (suiviPK != null ? suiviPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suivi)) {
            return false;
        }
        Suivi other = (Suivi) object;
        if ((this.suiviPK == null && other.suiviPK != null) || (this.suiviPK != null && !this.suiviPK.equals(other.suiviPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Suivi[ suiviPK=" + suiviPK + " ]";
    }
    
}
