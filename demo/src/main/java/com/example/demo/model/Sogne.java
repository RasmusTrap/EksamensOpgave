package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sogne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int sognekode;
    private String navn;
    private String kommune;
    private int smittetryk;
    private String nedlukning;




    public Sogne(long id, int sognekode, String navn, String kommune, int smittetryk, String nedlukning) {
        this.id = id;
        this.sognekode = sognekode;
        this.navn = navn;
        this.kommune = kommune;
        this.smittetryk = smittetryk;
        this.nedlukning = nedlukning;
    }

    public Sogne() {

    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNavn() { return navn; }

    public void setNavn(String navn) { this.navn = navn; }

    public String getKommune() { return kommune; }

    public void setKommune(String kommune) { this.kommune = kommune; }

    public int getSmittetryk() { return smittetryk; }

    public void setSmittetryk(int smittetryk) { this.smittetryk = smittetryk; }

    public String getNedlukning() { return nedlukning; }

    public void setNedlukning(String nedlukning) { this.nedlukning = nedlukning; }

    public int getSognekode() { return sognekode; }

    public void setSognekode(int sognekode) { this.sognekode = sognekode; }
}
