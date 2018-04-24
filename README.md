# Vaatekaapin hallintajärjestelmä
Sovellus, jolla voi hallita vaatekaapin sisältöä.

## [Dokumentointi](https://github.com/NiinaM/otm-harjoitustyo/tree/master/dokumentointi)
[Vaatimusmäärittely](https://github.com/NiinaM/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/NiinaM/otm-harjoitustyo/blob/master/dokumentointi/ty%C3%B6aikakirjanpito.md)

[Testausdokumentti](https://github.com/NiinaM/otm-harjoitustyo/blob/master/dokumentointi/testausdokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/NiinaM/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)


## Releaset

[Viikko 5](https://github.com/NiinaM/otm-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _OtmTodoApp-1.0-SNAPSHOT.jar_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mluukkai/OtmTodoApp/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
