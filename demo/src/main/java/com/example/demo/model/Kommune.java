package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kommune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idkommune;

    private String kommuneNavn;
    private int smittede;
    private int indbyggere;

    public Kommune(long idkommune, String kommuneNavn, int smittede, int indbyggere) {
        this.idkommune = idkommune;
        this.kommuneNavn = kommuneNavn;
        this.smittede = smittede;
        this.indbyggere = indbyggere;
    }

    public Kommune(){

    }

    public long getIdkommune() { return idkommune; }

    public void setIdkommune(long idkommune) { this.idkommune = idkommune; }

    public String getKommuneNavn() { return kommuneNavn; }

    public void setKommuneNavn(String kommuneNavn) { this.kommuneNavn = kommuneNavn; }

    public int getSmittede() { return smittede; }

    public void setSmittede(int smittede) { this.smittede = smittede; }

    public int getIndbyggere() { return indbyggere; }

    public void setIndbyggere(int indbyggere) { this.indbyggere = indbyggere; }
}
