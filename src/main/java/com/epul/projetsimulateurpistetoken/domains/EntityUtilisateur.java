package com.epul.projetsimulateurpistetoken.domains;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "utilisateur", schema = "projetpermis1", catalog = "")
public class EntityUtilisateur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NumUtil")
    private int numUtil;
    @Basic
    @Column(name = "NomUtil")
    private String nomUtil;
    @Basic
    @Column(name = "MotPasse")
    private String motPasse;
    @Basic
    @Column(name = "salt")
    private String salt;
    @Basic
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "forename")
    private String forename;
    @OneToMany(mappedBy = "utilisateurByFkUser")
    private Collection<EntityInscription> inscriptionsByNumUtil;

    public int getNumUtil() {
        return numUtil;
    }

    public void setNumUtil(int numUtil) {
        this.numUtil = numUtil;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityUtilisateur that = (EntityUtilisateur) o;

        if (numUtil != that.numUtil) return false;
        if (nomUtil != null ? !nomUtil.equals(that.nomUtil) : that.nomUtil != null) return false;
        if (motPasse != null ? !motPasse.equals(that.motPasse) : that.motPasse != null) return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (forename != null ? !forename.equals(that.forename) : that.forename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numUtil;
        result = 31 * result + (nomUtil != null ? nomUtil.hashCode() : 0);
        result = 31 * result + (motPasse != null ? motPasse.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (forename != null ? forename.hashCode() : 0);
        return result;
    }

    public Collection<EntityInscription> getInscriptionsByNumUtil() {
        return inscriptionsByNumUtil;
    }

    public void setInscriptionsByNumUtil(Collection<EntityInscription> inscriptionsByNumUtil) {
        this.inscriptionsByNumUtil = inscriptionsByNumUtil;
    }
}
