# Puutteet

## Siirtojen generointi
Siirtojen generoinnin toimintaan saaminen omaan bottiin ei onnistunut aikarajojen
puitteissa. Teoriassa nykyisellään pseudo-sallitut siirrot generoidaan ja nappuloiden
blokkaus huomioidaan, mutta siirron tekemiseen käytetyt "makeMove" ja "unmakeMove" 
metodit on ilmeisesti rikki ja tekee mitä sattuu. Aika loppui kesken debugaamisen.

## Säännöt (puutteet vain omaa moottoria käyttävässä Botissa)
 - Ohestalyönti
 - Tornitus
 - Kuninkaan shakin tarkistus
 
 Ohestalyönti ja tornitus olisi ollut helppoja toteuttaa, mutta 
 prioriteettina oli siirtojen generoinnin toimimaan saaminen edes jollain
 tasolla ja lähteä toteuttamaan siirtoja siitä. Shakin tarkistukseen olisi todennäköisesti
 kannattanut hyödyntää jonkin näköisiä bittilautoja, ja -maskeja, joiden avulla olisi
 ollut tehokasta katsoa onko kuningas uhattuna. Tämän toteuttamiseen olisi kuitenkin
 tarvinnut laajempaa refaktorintia, jolle ei työtuntien raameissa ollut mahdollisuutta.
 
 ## Evaluaatio
 Nappuloiden evaluutio on hieman puutteellinen, tätä yritin laajentaa tuomalla nappuloille
 ruutukohtaisen evaluution, mutta lopullisesta versiosta tämän poistin, koska siinä esiintyi
 mystisiä ongelmia joita en ehtinyt ratkaista.
 
 ## Pelin lopettaminen
 Tämä on valitettavan iso puute, mutta nykyisellään botti ei tunnu osaavan tehdä mattia,
 todennäköisesti tämä on negaMax algoritmin toteutukseen liittyvä ajatusvirhe jossain kohti
 jonka vuoksi (nähdäkseni) botti välttelee matittamista. Tämän ratkaiseminen on ensisijalla
 mikäli projektin pariin palaan. Puutetta paikkaamaan käytin Lichessin tarjoaman APIn kautta
 saatavia Syzygy endgame tauluja joiden avulla teoriassa saataisiin paras mahdollinen siirto
 missä tahansa max. 7 nappulan tilanteessa. Kuitenkaan Lichess ei ilmeisesti tykkää tavasta
 jolla APIa käytän ja palvelin saattaa vastata tilakoodilla "429 (Too Many Requests)" jolloin
 palataan takaisin normaaliin tapaan luoda siirtoja.