package com.pwn.projektreaktorspring.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private String opisSql;

    private String opisPython;

    private String opisJava;

    private String opisSpring;


    private int ocenaSql;

    private int ocenaPython;

    private int ocenaJava;

    private int ocenaSpring;
//    private List<Integer> oceny = new ArrayList<>();
//
//
//    private List<String> opisy = new ArrayList<>();
//
//    @NotEmpty
    private String uprawnienia;

    public User(String imie, String nazwisko, String mail, String haslo, String ghLogin, String telefon, String opisSql, String opisPython, String opisJava, String opisSpring, int ocenaSql, int ocenaPython, int ocenaJava, int ocenaSpring, String uprawnienia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.haslo = haslo;
        this.ghLogin = ghLogin;
        this.telefon = telefon;
        this.opisSql = opisSql;
        this.opisPython = opisPython;
        this.opisJava = opisJava;
        this.opisSpring = opisSpring;
        this.ocenaSql = ocenaSql;
        this.ocenaPython = ocenaPython;
        this.ocenaJava = ocenaJava;
        this.ocenaSpring = ocenaSpring;
        this.uprawnienia = uprawnienia;
    }

    public User() {
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

    public String getOpisSql() {
        return opisSql;
    }

    public void setOpisSql(String opisSql) {
        this.opisSql = opisSql;
    }

    public String getOpisPython() {
        return opisPython;
    }

    public void setOpisPython(String opisPython) {
        this.opisPython = opisPython;
    }

    public String getOpisJava() {
        return opisJava;
    }

    public void setOpisJava(String opisJava) {
        this.opisJava = opisJava;
    }

    public String getOpisSpring() {
        return opisSpring;
    }

    public void setOpisSpring(String opisSpring) {
        this.opisSpring = opisSpring;
    }

    public int getOcenaSql() {
        return ocenaSql;
    }

    public void setOcenaSql(int ocenaSql) {
        this.ocenaSql = ocenaSql;
    }

    public int getOcenaPython() {
        return ocenaPython;
    }

    public void setOcenaPython(int ocenaPython) {
        this.ocenaPython = ocenaPython;
    }

    public int getOcenaJava() {
        return ocenaJava;
    }

    public void setOcenaJava(int ocenaJava) {
        this.ocenaJava = ocenaJava;
    }

    public int getOcenaSpring() {
        return ocenaSpring;
    }

    public void setOcenaSpring(int ocenaSpring) {
        this.ocenaSpring = ocenaSpring;
    }

    public String getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(String uprawnienia) {
        this.uprawnienia = uprawnienia;
    }
}
