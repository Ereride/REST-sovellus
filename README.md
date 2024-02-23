# Visailu REST-palvelu

Tämä on yksinkertainen REST-palvelu, joka tarjoaa visailupelin toiminnallisuuden. Palvelua voi ohjata REST-endpointtien avulla, jolloin peliä voi pelata esimerkiksi Postman-ohjelmalla.

## Ominaisuudet

- **Kysymykset**: Palvelu tarjoaa mahdollisuuden hakea satunnaisia kysymyksiä tai ID:llä ja niiden tietoja.
- **Vastausten tarkistus**: Palvelun avulla voi lähettää vastauksen ja tarkistaa sen oikeellisuuden.
- **Ohjeet**: Palvelu tarjoaa ohjeet pelin pelaamiseen.

## REST-endpointit

- **GET /api/**: Näyttää pelin ohjeet.
- - **GET /api/kysymys?id=Nro**:Palauttaa Nro kohdalle kirjatun ID:n mukaisen kysymyksen. Kysymyksiä löytyy ID 1-30.
- **GET /api/kysymys/random**: Palauttaa satunnaisen kysymyksen.
- **POST /api/vastaus**: Tarkistaa vastauksen ja palauttaa oikeellisuuden.

## Teknologiat

- Java
- Spring Boot

## Käyttö

1. Kloonaa tai lataa projekti.
2. Käynnistä projekti.
3. Testaa endpointteja esimerkiksi Postmanilla.


