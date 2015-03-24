/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.suivifinal;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author medoune
 */
@Embeddable
public class DescriptionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMaladie")
    private int idMaladie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idIndicateur")
    private int idIndicateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPatient")
    private long idPatient;

    public DescriptionPK() {
    }

    public DescriptionPK(int idMaladie, int idIndicateur, long idPatient) {
        this.idMaladie = idMaladie;
        this.idIndicateur = idIndicateur;
        this.idPatient = idPatient;
    }

    public int getIdMaladie() {
        return idMaladie;
    }

    public void setIdMaladie(int idMaladie) {
        this.idMaladie = idMaladie;
    }

    public int getIdIndicateur() {
        return idIndicateur;
    }

    public void setIdIndicateur(int idIndicateur) {
        this.idIndicateur = idIndicateur;
    }

    public long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(long idPatient) {
        this.idPatient = idPatient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMaladie;
        hash += (int) idIndicateur;
        hash += (int) idPatient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescriptionPK)) {
            return false;
        }
        DescriptionPK other = (DescriptionPK) object;
        if (this.idMaladie != other.idMaladie) {
            return false;
        }
        if (this.idIndicateur != other.idIndicateur) {
            return false;
        }
        if (this.idPatient != other.idPatient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.DescriptionPK[ idMaladie=" + idMaladie + ", idIndicateur=" + idIndicateur + ", idPatient=" + idPatient + " ]";
    }
    
}
