package com.mycompany.vaatekaapinhallintajarjestelma;

public class Vaate {

    private String nimi;
    private String vari;
    private String kunto;
    private int tuumaKoko;
    private String koko;
    private String tyyppi;
    private String likaisuus;
    private int arvo;

    public Vaate(String nimi, String vari, String kunto, int tuumaKoko, String koko, String tyyppi, String likaisuus, int arvo) {
        this.nimi = nimi;
        this.vari = vari;
        this.kunto = kunto;
        this.tuumaKoko = tuumaKoko;
        this.koko = koko;
        this.tyyppi = tyyppi;
        this.likaisuus = likaisuus;
        this.arvo = arvo;
    }

    public String getNimi() {
        return nimi;
    }
    
    public String getVari() {
        return vari;
    }

    public String getKunto() {
        return kunto;
    }

    public int getTuumaKoko() {
        return tuumaKoko;
    }

    public String getKoko() {
        return koko;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public String getLikaisuus() {
        return likaisuus;
    }

    public int getArvo() {
        return arvo;
    }
    
    

    public void setKunto(String kunto) {
        this.kunto = kunto;
    }

    public void setLikaisuus(String likaisuus) {
        this.likaisuus = likaisuus;
    }

    public void setVari(String vari) {
        this.vari = vari;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    
    
    @Override
    public String toString() {
        return "Vaate " + this.nimi + " on " + this.koko + "-kokoinen ja " + this.tuumaKoko + "-kokoinen. Sen väri on " + this.vari + " ja se on " + this.tyyppi;
    }
}
