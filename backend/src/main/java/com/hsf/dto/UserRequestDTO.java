package com.hsf.dto;

public class UserRequestDTO {

    private String name;
    private String email;
    private String winUser;
    private String firma;
    private String adresse;
    private String telefon;
    private String fax;

    // Getters and setters
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getWinUser() {
        return winUser;
    }
    public void setWinUser(String winUser) {
        this.winUser = winUser;
    }
    public String getFirma() {
        return firma;
    }
    public void setFirma(String firma) {
        this.firma = firma;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
}