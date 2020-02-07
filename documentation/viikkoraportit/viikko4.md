# Viikko 4
Toteutettiin NegaMax algoritmi hyödyntäen (toistaiseksi) valmiita kirjastoja siirtojen luomiseen
ja laudan tilan ylläpitoon sekä alkeellinen evaluaatioalgoritmi NegaMax algoritmin avuksi.
Lisäksi lisättiin myöhemmin tarvittavia apumetodeja ja taulukoita evaluaatioalgoritmin parannuksia ja
itse toteutettua siirtojen validointia varten.

Tällä hetkellä tekoäly kykenee suhteellisen luotettavasti pelaamaan tavoitteena nappuloiden syönti ja potentiaalisesti matti.
Matittaminen ei vielä toimi luotettavasti, eikä tekoälyllä ole varsinaista ymmärrystä taktiikoiden päälle 
(siirtojen vahvuus lasketaan toistaiseksi laudalla olevien nappuloiden vahvuutena).

Viikon suurin ongelma oli algoritmin toimimaan saaminen, lopulta muutaman tunnin itse mietittyjen rekursioiden jälkeen
lauloi Google, jota hyödyntäen löytyi sopivan luettava algoritmi josta oman muovaamalla tuli toimivaa jälkeä. 
Debuggaaminen on haastavaa, koska en toistaiseksi ole keksinyt miten XBoardiin saisi logituksia tekoälyn toiminnasta.
Tämän vuoksi runsas testaaminen ja testimetodien debuggaaminen on ollut erittäin hyödyllistä. 

Ensi viikolla aloittelen siirtojen evaluaatioalgoritmin vahvistamista ja siinä vaiheessa,
kun tekoäly pelaa riittävän luotettavasti shakkia voitto mielessä alkaa kirjastojen korvaaminen omilla toteutuksilla.
Tätä varten jo aiemmilla viikoilla olen tehnyt pohjatyötä. Tulen jatkamaan myös SonarCloudin sääntöjen hiomista projektiin
sopivammiksi.