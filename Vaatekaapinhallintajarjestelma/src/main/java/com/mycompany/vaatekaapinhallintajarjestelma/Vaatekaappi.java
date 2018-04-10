package com.mycompany.vaatekaapinhallintajarjestelma;

import java.util.ArrayList;

public class Vaatekaappi {

    private String omistaja;
    private ArrayList<Vaate> hyllyt;

    public Vaatekaappi(String nimi) {
        this.omistaja = nimi;
        this.hyllyt = new ArrayList<>();
    }
    
    public String getOmistaja() {
        return omistaja;
    }

    public ArrayList<Vaate> getHyllyt() {
        return hyllyt;
    }

    public void lisaaVaate(Vaate vaate) {
        this.hyllyt.add(vaate); //Puuttuu testaaminen vaatteen olemassa olosta.
    }

    public void poistaVaate(Vaate vaate) {
        for (int i = 0; i < this.hyllyt.size(); i++) {
            if (this.hyllyt.get(i).getNimi().equals(vaate.getNimi())) {
                this.hyllyt.remove(i);
            }
        }
    }

    public int vaatekaapinKokonaisArvo() {
        int arvo = 0;
        
        for (int i = 0; i < this.hyllyt.size(); i++) {
            arvo =+ this.hyllyt.get(i).getArvo();
        }
        return arvo;
    }
    
    public Boolean onkoRikkinaisia() {
        for (int i = 0; i < this.hyllyt.size(); i++) {
            if (this.hyllyt.get(i).getKunto().equals("rikkinäisiä")) {
                return true;
            }
        }
        return false;
    }
}
