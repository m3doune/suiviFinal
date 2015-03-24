/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.suivifinal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author medoune
 */
@Entity
@Table(name = "Ordonnance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordonnance.findAll", query = "SELECT o FROM Ordonnance o"),
    @NamedQuery(name = "Ordonnance.findByIdOrdonnance", query = "SELECT o FROM Ordonnance o WHERE o.idOrdonnance = :idOrdonnance"),
    @NamedQuery(name = "Ordonnance.findByDatedebut", query = "SELECT o FROM Ordonnance o WHERE o.datedebut = :datedebut"),
    @NamedQuery(name = "Ordonnance.findByDatefin", query = "SELECT o FROM Ordonnance o WHERE o.datefin = :datefin"),
    @NamedQuery(name = "Ordonnance.findByAssister", query = "SELECT o FROM Ordonnance o WHERE o.assister = :assister")})
public class Ordonnance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdonnance")
    private Integer idOrdonnance;
    @Column(name = "datedebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Column(name = "datefin")
    private Integer datefin;
    @Column(name = "assister")
    private Boolean assister;
    @JoinColumn(name = "idConsultation", referencedColumnName = "idConsultation")
    @ManyToOne(optional = false)
    private Consultation idConsultation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdonnance")
    private Collection<ModeEmplois> modeEmploisCollection;

    public Ordonnance() {
    }

    public Ordonnance(Integer idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    public Integer getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(Integer idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Integer getDatefin() {
        return datefin;
    }

    public void setDatefin(Integer datefin) {
        this.datefin = datefin;
    }

    public Boolean getAssister() {
        return assister;
    }

    public void setAssister(Boolean assister) {
        this.assister = assister;
    }

    public Consultation getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Consultation idConsultation) {
        this.idConsultation = idConsultation;
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
        hash += (idOrdonnance != null ? idOrdonnance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordonnance)) {
            return false;
        }
        Ordonnance other = (Ordonnance) object;
        if ((this.idOrdonnance == null && other.idOrdonnance != null) || (this.idOrdonnance != null && !this.idOrdonnance.equals(other.idOrdonnance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Ordonnance[ idOrdonnance=" + idOrdonnance + " ]";
    }
    
}
