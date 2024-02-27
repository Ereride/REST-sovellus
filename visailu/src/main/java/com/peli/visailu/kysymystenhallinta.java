package com.peli.visailu;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@RestController
@RequestMapping ("/api")
public class kysymystenhallinta {

    private Map<Integer, visailu> kysymykset = new HashMap<>();

    // Tässä on kysymykset
    public kysymystenhallinta () {
        kysymykset.put(1, new visailu(1, "Mikä on Suomen pääkaupunki?", "Helsinki" ));
        kysymykset.put(2, new visailu(2, "Mikä on maailman suurin valtameri?", "Tyyni valtameri" ));
        kysymykset.put(3, new visailu(3, "Kuinka monta raitaa Yhdysvaltain lipussa on?", "13" ));
        kysymykset.put(4, new visailu(4, "Mikä on maailman suurin lintu?", "Strutsi" ));
        kysymykset.put(5, new visailu(5, "Kuinka monta kosketinta pianossa on yleensä?", "88" ));
        kysymykset.put(6, new visailu(6, "Mikä on maailman korkein vuori?", "Mount Everest" ));
        kysymykset.put(7, new visailu(7, "Mikä on maailman suurin nisäkäs?", "Sinivalas" ));
        kysymykset.put(8, new visailu(8, "Mikä on kemiallinen merkki vedyllä?", "H" ));
        kysymykset.put(9, new visailu(9, "Mikä on Suomen kansallislintu?", "Laulujoutsen" ));
        kysymykset.put(10, new visailu(10, "Kuka kirjoitti näytelmän \"Romeo ja Julia\"?", "William Shakespeare" ));
        kysymykset.put(11, new visailu(11, "Mikä on maailman suurin saari?", "Grönlanti" ));
        kysymykset.put(12, new visailu(12, "Millä slanginimellä paikalliset kutsuvat New York Cityä?", "Gotham" ));
        kysymykset.put(13, new visailu(13, "Mikä on maailman suurin manner?", "Aasia" ));
        kysymykset.put(14, new visailu(14, "Kuka keksi painokoneen?", "Johannes Gutenberg" ));
        kysymykset.put(15, new visailu(15, "Kuka kirjoitti teoksen \"Kalevala\"", "Elias Lönnrot" ));
        kysymykset.put(16, new visailu(16, "Missä Euroopan maassa sijaitsee Eiffel-torni?", "Ranskassa" ));
        kysymykset.put(17, new visailu(17, "Mikä on suurin planeetta?", "Jupiter" ));
        kysymykset.put(18, new visailu(18, "Kuka on kirjoittanut teoksen \"Harry Potter\" -kirjasarjan?", "J.K. Rowling" ));
        kysymykset.put(19, new visailu(19, "Mikä on suurin valtio pinta-alaltaan?", "Venäjä" ));
        kysymykset.put(20, new visailu(20, "Missä maanosassa sijaitsee Meksiko?", "Pohjois-Amerikassa" ));
        kysymykset.put(21, new visailu(21, "Mikä on maailman suurin kaupunki väkiluvultaan?", "Tokio, Japani" ));
        kysymykset.put(22, new visailu(22, "Mikä on maailman korkein rakennus?", "Burj Khalifa" ));
        kysymykset.put(23, new visailu(23, "Kuka oli Suomen presidenttinä ennen Sauli Niinistöä?", "Tarja Halonen" ));
        kysymykset.put(24, new visailu(24, "Mikä on Suomen suurin järvi pinta-alaltaan?", "Saimaa" ));
        kysymykset.put(25, new visailu(25, "Kuka on ensimmäinen ihminen, joka astui kuun pinnalle?", "Neil Armstrong" ));
        kysymykset.put(26, new visailu(26, "Mikä on maailman suurin matelija?", "Suistokrokotiili" ));
        kysymykset.put(27, new visailu(27, "Kuka kirjoitti teoksen \"Sota ja rauha\"?", "Leo Tolstoi" ));
        kysymykset.put(28, new visailu(28, "Kuka maalasi kuuluisan taideteoksen \"Mona Lisa\"?", "Leonardo da Vinci" ));
        kysymykset.put(29, new visailu(29, "Missä maanosassa sijaitsee Sahara-aavikko?", "Afrikassa" ));
        kysymykset.put(30, new visailu(30, "Mikä on maailman suurin valtio väkiluvultaan?", "Kiina" ));
    }

    // Tämä näyttää pelin ohjeet
    @GetMapping("/")
    public String index () {
        return "Tervetuloa visailupeliin! Voit pelata Postmanilla GET-pyynnöllä kahdella eri tapaa. 1. GET tapa /api/kysymys?id=Nro: Nro kohdalle laitetaan numero 1-30, jolloin saadaan sen ID:n kysymys. 2. GET tapa /api/kysymys/random: Palauttaa satunnaisen kysymyksen. Vastauksen antaminen tapahtuu POST-pyynnöllä antamalla vastaus ID:n perusteella. Sen jälkeen kerrotaan, onko vastaus oikein vai väärin.";
    }

    // Tällä voit pyytää kysymyksen ID:n mukaan 1-30 väliltä
    @GetMapping ("/kysymys")
    public String getKysymys(@RequestParam(defaultValue = "1")int id){
        visailu q = kysymykset.get(id);
        return q != null ? "ID: " + q.getId() + ", Kysymys: " + q.getKysymys() : "Kysymystä ei löytynyt.";
    }

    // Tämä arpoo yhden 30 kysymyksestä ja näyttää sen   
    @GetMapping("/kysymys/random")
    public String getRandomKysymys() {
        Random random = new Random();
        int randomId = random.nextInt(30) + 1;
        visailu q = kysymykset.get(randomId);
        return q != null ? "ID: " + q.getId() + ", Kysymys: " + q.getKysymys() : "Kysymystä ei löytynyt.";
    }
        
    // Tämän pyynnön avulla voidaan antaa vastaus ja tarkistaa onko se oikein vai väärin
    @PostMapping("/vastaus")
    public String checkVastaus(@RequestBody Map<String, String> data) {
        int id = Integer.parseInt(data.get("id"));
        String kayttajaVastaus =  data.get("vastaus").toLowerCase().trim();

        visailu q = kysymykset.get(id);
        if (q == null) {
            return "Virheellinen kysymyksen ID.";
        }

        String oikeaVastaus = q.getVastaus().toLowerCase();
        if (kayttajaVastaus.equals(oikeaVastaus)) {
            return "Vastaus oikein!";
        } else {
            return "Väärä vastaus. Yritä uudelleen.";
        }
    }

}
