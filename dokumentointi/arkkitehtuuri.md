# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria.

<img src="https://github.com/NiinaM/otm-harjoitustyo/blob/master/dokumentointi/kuvat/rakenne.jpg" width="400">

Pakkaus todoapp.ui sisältää JavaFX:llä toteutetun käyttöliittymän todoapp.domain sovelluslogiikan ja todoapp.dao tietojen pysyväistallennuksesta vastaavan koodin.

## Käyttöliittymä
Käyttöliittymä sisältää kuusi erillistä näkymää

* Aloitusnäkymä
* Kaappi
* Hylly
* Vaate
* Kaapinluonti-ikkuna
* Vaatteenluonti-ikkuna

Jokainen näistä on toteutettu omana Scene-oliona. Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksen stageen. Käyttöliittymä on rakennettu ohjelmallisesti luokassa todoapp.ui.TodoUi.

Käyttöliittymä on pyritty eristämään täysin sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavien luokkien metodeja.

## Sovelluslogiikka

Sovellusten loogisen datamallin muodostavat luokat Closet, Clothing ja Shelf.

Yksinkertainen luokkakaavio:
<img src="https://github.com/NiinaM/otm-harjoitustyo/blob/master/dokumentointi/kuvat/Luokkakaavion%20aloitus%20versio.jpg" width="700">

Ensimmäinen versioni luokka/pakkauskaaviosta, jossa on myös mukana luokka Shelf, vaikken olekaan sellaista vielä tehnyt. Kaaviossa ei ole dao:ssa mitään koska en ole vielä tehnyt daoluokkia. En ole aiemmin tehnyt tällaista kaaviota, niin voi olla että se on puutteellinen myös sen vuoksi.

<img src="https://github.com/NiinaM/otm-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkausluokkakaavio%20ekaversio.jpg" width="500">

## Tietojen pysyväistallennus

## Tiedostot

### Päätoiminnallisuudet

Kuvataan seuraavaksi sovelluksen toimintalogiikkaa yhden päätoiminnallisuuden osalta sekvenssikaaviona.

#### Vaatteen lisääminen vaatekaappiin
<img src="https://github.com/NiinaM/otm-harjoitustyo/blob/master/dokumentointi/kuvat/Sekvenssikaavio%20vaate%20vaatekaappiin.jpg" width="700">

## Ohjelman rakenteeseen jääneet heikkoudet
(Tekstiä)



