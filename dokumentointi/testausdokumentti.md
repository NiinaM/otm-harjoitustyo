# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla sekä manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka


Automatisoitujen testien ytimen moudostavat sovelluslogiikkaa, eli pakkauksen [com.mycompany.vaatekaapinhallintajarjestelma.domain](https://github.com/NiinaM/otm-harjoitustyo/tree/master/Vaatekaapinhallintajarjestelma/src/main/java/com/mycompany/vaatekaapinhallintajarjestelma/domain) luokkia testaavat integraatiotestit [ClosetTest](https://github.com/NiinaM/otm-harjoitustyo/blob/master/Vaatekaapinhallintajarjestelma/src/test/java/ClosetTest.java), [ShelfTest](https://github.com/NiinaM/otm-harjoitustyo/blob/master/Vaatekaapinhallintajarjestelma/src/test/java/ShelfTest.java) ja [ClothingTest](https://github.com/NiinaM/otm-harjoitustyo/blob/master/Vaatekaapinhallintajarjestelma/src/test/java/ClothingTest.java) joiden määrittelevät testitapaukset simuloivat käyttöliittymän [ClosetOrganizingSystemMain](https://github.com/NiinaM/otm-harjoitustyo/blob/master/Vaatekaapinhallintajarjestelma/src/main/java/com/mycompany/vaatekaapinhallintajarjestelma/ui/ClosetOrganizingSystemMain.java)-in avulla suorittamia toiminnallisuuksia.

## Sovellukseen jääneet laatuongelmat
Sovellus kaatuu, kun yrittää tarkastella vaatetta.
