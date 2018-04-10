package com.mycompany.vaatekaapinhallintajarjestelma;

public class VaatekaapinHallintajarjestelma {
    public static void main(String[] args){
        Vaate punaisetHousut = new Vaate("punaiset housut", "punainen", "kuin uusi", 32, "xs", "housut", "puhtaat", 30);
        System.out.println(punaisetHousut.toString());
        
        Vaatekaappi niinanKaappi = new Vaatekaappi("Niina");
        niinanKaappi.lisaaVaate(punaisetHousut);
        System.out.println(niinanKaappi.vaatekaapinKokonaisArvo());
        
        punaisetHousut.setKunto("rikkinäiset");
        System.out.println(punaisetHousut.getKunto());
    }
}
