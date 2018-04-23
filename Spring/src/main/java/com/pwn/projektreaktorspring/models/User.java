package com.pwn.projektreaktorspring.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @NotEmpty
    private String imie;

    @NotEmpty
    private String nazwisko;

    @Email
    private String mail;

    @NotEmpty
    private String haslo;

    @NotEmpty
    private String ghLogin;

    @NotEmpty
    private String telefon;


    private List<Integer> oceny = new ArrayList<>();


    private List<String> opisy = new ArrayList<>();

    @NotEmpty
    private String uprawnienia;

    public User(String imie, String nazwisko, String mail, String haslo, String ghLogin, String telefon, List<Integer> oceny, List<String> opisy, String uprawnienia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.haslo = haslo;
        this.ghLogin = ghLogin;
        this.telefon = telefon;
        this.oceny = oceny;
        this.opisy = opisy;
        this.uprawnienia = uprawnienia;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", mail='" + mail + '\'' +
                ", haslo='" + haslo + '\'' +
                ", ghLogin='" + ghLogin + '\'' +
                ", telefon='" + telefon + '\'' +
                ", oceny=" + oceny +
                ", opisy=" + opisy +
                ", uprawnienia='" + uprawnienia + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getGhLogin() {
        return ghLogin;
    }

    public void setGhLogin(String ghLogin) {
        this.ghLogin = ghLogin;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<Integer> getOceny() {
        return oceny;
    }

    public void setOceny(List<Integer> oceny) {
        this.oceny = oceny;
    }

    public List<String> getOpisy() {
        return opisy;
    }

    public void setOpisy(List<String> opisy) {
        this.opisy = opisy;
    }

    public String getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(String uprawnienia) {
        this.uprawnienia = uprawnienia;
    }
}
