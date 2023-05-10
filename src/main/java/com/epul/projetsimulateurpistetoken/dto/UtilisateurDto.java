package com.epul.projetsimulateurpistetoken.dto;

public class UtilisateurDto {
    private Integer NumUtil;
    private String NomUtil;
    private String MotPasse;
    private String salt;
    private String role;
    private String email;
    private String surname;
    private String forename;

    public Integer getNumUtil() {
        return NumUtil;
    }

    public void setNumUtil(Integer numUtil) {
        NumUtil = numUtil;
    }

    public String getNomUtil() {
        return NomUtil;
    }

    public void setNomUtil(String nomUtil) {
        NomUtil = nomUtil;
    }

    public String getMotPasse() {
        return MotPasse;
    }

    public void setMotPasse(String motPasse) {
        MotPasse = motPasse;
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

}
