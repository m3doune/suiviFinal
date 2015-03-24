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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author medoune
 */
@Entity
@Table(name = "Compte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c"),
    @NamedQuery(name = "Compte.findByIdCompte", query = "SELECT c FROM Compte c WHERE c.idCompte = :idCompte"),
    @NamedQuery(name = "Compte.findByLogin", query = "SELECT c FROM Compte c WHERE c.login = :login"),
    @NamedQuery(name = "Compte.findByPassword", query = "SELECT c FROM Compte c WHERE c.password = :password"),
    @NamedQuery(name = "Compte.findByMedecin", query = "SELECT c FROM Compte c WHERE c.medecin = :medecin"),
    @NamedQuery(name = "Compte.findByNom", query = "SELECT c FROM Compte c WHERE c.nom = :nom"),
    @NamedQuery(name = "Compte.findByPrenom", query = "SELECT c FROM Compte c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Compte.findBySexe", query = "SELECT c FROM Compte c WHERE c.sexe = :sexe"),
    @NamedQuery(name = "Compte.findByAdresse", query = "SELECT c FROM Compte c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Compte.findByDatenaiss", query = "SELECT c FROM Compte c WHERE c.datenaiss = :datenaiss"),
    @NamedQuery(name = "Compte.findByTel", query = "SELECT c FROM Compte c WHERE c.tel = :tel"),
    @NamedQuery(name = "Compte.findByEmail", query = "SELECT c FROM Compte c WHERE c.email = :email")})
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompte")
    private Long idCompte;
    @Size(max = 254)
    @Column(name = "login")
    private String login;
    @Size(max = 254)
    @Column(name = "password")
    private String password;
    @Column(name = "medecin")
    private Boolean medecin;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "sexe")
    private Boolean sexe;
    @Size(max = 254)
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "datenaiss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datenaiss;
    @Column(name = "tel")
    private Integer tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "idLoc", referencedColumnName = "idLoc")
    @ManyToOne
    private Localite idLoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompte")
    private Collection<Medecin> medecinCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompte")
    private Collection<Patient> patientCollection;

    public Compte() {
    }

    public Compte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getMedecin() {
        return medecin;
    }

    public void setMedecin(Boolean medecin) {
        this.medecin = medecin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Boolean getSexe() {
        return sexe;
    }

    public void setSexe(Boolean sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Localite getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(Localite idLoc) {
        this.idLoc = idLoc;
    }

    @XmlTransient
    public Collection<Medecin> getMedecinCollection() {
        return medecinCollection;
    }

    public void setMedecinCollection(Collection<Medecin> medecinCollection) {
        this.medecinCollection = medecinCollection;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompte != null ? idCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.idCompte == null && other.idCompte != null) || (this.idCompte != null && !this.idCompte.equals(other.idCompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.suivifinal.Compte[ idCompte=" + idCompte + " ]";
    }
    
}
