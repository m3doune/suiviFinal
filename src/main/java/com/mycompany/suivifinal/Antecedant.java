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
@Table(name = "Antecedant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedant.findAll", query = "SELECT a FROM Antecedant a"),
    @NamedQuery(name = "Antecedant.findByIdDiagnostique", query = "SELECT a FROM Antecedant a WHERE a.idDiagnostique = :idDiagnostique"),
    @NamedQuery(name = "Antecedant.findByAntecedentComptel", query = "SELECT a FROM Antecedant a WHERE a.antecedentComptel = :antecedentComptel"),
    @NamedQuery(name = "Antecedant.findByAnecedentFamiliaux", query = "SELECT a FROM Antecedant a WHERE a.anecedentFamiliaux = :anecedentFamiliaux"),
    @NamedQuery(name = "Antecedant.findByFacteursRisque", query = "SELECT a FROM Antecedant a WHERE a.facteursRisque = :facteursRisque")})
public class Antecedant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiagnostique")
    private Integer idDiagnostique;
    @Size(max = 254)
    @Column(name = "antecedentComptel")
    private String antecedentComptel;
    @Size(max = 254)
    @Column(name = "anecedentFamiliaux")
    private String anecedentFamiliaux;
    @Size(max = 254)
    @Column(name = "facteursRisque")
    private String facteursRisque;
    @JoinColumn(name = "idPatient", referencedColumnName = "idPatient")
    @ManyToOne
    private Patient idPatient;

    public Antecedant() {
    }

    public Antecedant(Integer idDiagnostique) {
        this.idDiagnostique = idDiagnostique;
    }

    public Integer getIdDiagnostique() {
        return idDiagnostique;
    }

    public void setIdDiagnostique(Integer idDiagnostique) {
        this.idDiagnostique = idDiagnostique;
    }

    public String getAntecedentComptel() {
        return antecedentComptel;
    }

    public void setAntecedentComptel(String antecedentComptel) {
        this.antecedentComptel = antecedentComptel;
    }

    public String getAnecedentFamiliaux() {
        return anecedentFamiliaux;
    }

    public void setAnecedentFamiliaux(String anecedentFamiliaux) {
        this.anecedentFamiliaux = anecedentFamiliaux;
    }

    public String getFacteursRisque() {
        return facteursRisque;
    }

    public void setFacteursRisque(String facteursRisque) {
        this.facteursRisque = facteursRisque;
    }

    public Patient getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patient idPatient) {
        this.idPatient = idPatient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiagnostique != null ? idDiagnostique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedant)) {
            return false;
        }
        Antecedant other = (Antecedant) object;
        if ((this.idDiagnostique == null && other.idDiagnostique != null) || (this.idDiagnostique != null && !this.idDiagnostique.equals(other.idDiagnostique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Antecedant[ idDiagnostique=" + idDiagnostique + " ]";
    }
    
}
