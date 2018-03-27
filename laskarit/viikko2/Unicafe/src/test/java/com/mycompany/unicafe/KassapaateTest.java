package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassapaate;
    Maksukortti koyhaKortti;
    Maksukortti rikasKortti;

    public KassapaateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        koyhaKortti = new Maksukortti(100);
        rikasKortti = new Maksukortti(1000);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luodunKassapaatteenRahaMaaraOnOikea() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void luodunKassapaatteenMyytyjenLounaidenMaaraOnOikea() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty() + kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiEdullisillaJosMaksuOnRiittavaKassanRahamaaraKasvaa() {
        kassapaate.syoEdullisesti(240);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }

    @Test
    public void kateisostoToimiiEdullisillaJosMaksuOnRiittavaVaihtorahaOnOikea() {
        int vaihtoraha = kassapaate.syoEdullisesti(240);
        assertEquals(0, vaihtoraha);
    }

    @Test
    public void kateisostoToimiiMaukkailleJosMaksuOnRiittavaKassanRahamaaraKasvaa() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }

    @Test
    public void kateisostoToimiiMaukkailleJosMaksuOnRiittavaVaihtorahaOnOikea() {
        int vaihtoraha = kassapaate.syoMaukkaasti(400);
        assertEquals(0, vaihtoraha);
    }

    @Test
    public void kateisostoToimiiJosMaksuOnRiittavaMyytyjenEdullistenLounaidenMaaraKasvaa() {
        kassapaate.syoEdullisesti(240);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiJosMaksuOnRiittavaMyytyjenMaukkaidenLounaidenMaaraKasvaa() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiEdullisillaJosMaksuEiOleRiittavaKassanRahamaaraEiMuutu() {
        kassapaate.syoEdullisesti(239);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kateisostoToimiiMaukkaillaJosMaksuEiOleRiittavaKassanRahamaaraEiMuutu() {
        kassapaate.syoMaukkaasti(399);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kateisostoToimiiEdullisillaJosMaksuEiOleRiittavaKaikkiRahatPalautetaan() {
        int vaihtoraha = kassapaate.syoEdullisesti(239);
        assertEquals(239, vaihtoraha);
    }

    @Test
    public void kateisostoToimiiMaukkaillaJosMaksuEiOleRiittavaKaikkiRahatPalautetaan() {
        int vaihtoraha = kassapaate.syoMaukkaasti(399);
        assertEquals(399, vaihtoraha);
    }

    @Test
    public void kateisostoToimiiEdullisillaJosMaksuEiOleRiittavaMyytyjenLounaidenMaaraEiMuutu() {
        kassapaate.syoEdullisesti(239);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiMaukkaillaJosMaksuEiOleRiittavaMyytyjenLounaidenMaaraEiMuutu() {
        kassapaate.syoMaukkaasti(399);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiostoToimiiEdullisillaJosKortillaOnTarpeeksiPalautetaanTrue() {
        assertTrue(kassapaate.syoEdullisesti(rikasKortti));
    }

    @Test
    public void korttiostoToimiiMaukkaillaJosKortillaOnTarpeeksiPalautetaanTrue() {
        assertTrue(kassapaate.syoMaukkaasti(rikasKortti));
    }

    @Test
    public void korttiostoToimiiEdullisillaJosKortillaOnTarpeeksiVeloitetaanSummaKortilta() {
        kassapaate.syoEdullisesti(rikasKortti);
        assertEquals(760, rikasKortti.saldo());
    }

    @Test
    public void korttiostoToimiiMaukkaillaJosKortillaOnTarpeeksiVeloitetaanSummaKortilta() {
        kassapaate.syoMaukkaasti(rikasKortti);
        assertEquals(600, rikasKortti.saldo());
    }

    @Test
    public void korttiostoToimiiEdullisillaJosKortillaOnTarpeeksiMyytyjenLounaidenMaaraKasvaa() {
        kassapaate.syoEdullisesti(rikasKortti);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttiostoToimiiMaukkaillaJosKortillaOnTarpeeksiMyytyjenLounaidenMaaraKasvaa() {
        kassapaate.syoMaukkaasti(rikasKortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiostoToimiiEdullisillaJosKortillaEiOleTarpeeksiKortinRahamaaraEiMuutu() {
        kassapaate.syoEdullisesti(koyhaKortti);
        assertEquals(100, koyhaKortti.saldo());
    }

    @Test
    public void korttiostoToimiiMaukkaillaJosKortillaEiOleTarpeeksiKortinRahamaaraEiMuutu() {
        kassapaate.syoMaukkaasti(koyhaKortti);
        assertEquals(100, koyhaKortti.saldo());
    }

    @Test
    public void korttiostoToimiiEdullisillaJosKortillaEiOleTarpeeksiMyytyjenLounaidenMaaraEiMuutu() {
        kassapaate.syoEdullisesti(koyhaKortti);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttiostoToimiiMaukkaillaJosKortillaEiOleTarpeeksiMyytyjenLounaidenMaaraEiMuutu() {
        kassapaate.syoMaukkaasti(koyhaKortti);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiostoToimiiEdullisillaJosKortillaEiOleTarpeeksiPalautetaanFalse() {
        assertFalse(kassapaate.syoEdullisesti(koyhaKortti));
    }

    @Test
    public void korttiostoToimiiMaukkaillaJosKortillaEiOleTarpeeksiPalautetaanFalse() {
        assertFalse(kassapaate.syoMaukkaasti(koyhaKortti));
    }

    @Test
    public void korttiostoToimiiEdullisillaJosKortillaEiOleTarpeeksiKassanRahamaaraEiMuutu() {
        kassapaate.syoEdullisesti(koyhaKortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void korttiostoToimiiMaukkaillaJosKortillaEiOleTarpeeksiKassanRahamaaraEiMuutu() {
        kassapaate.syoMaukkaasti(koyhaKortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortilleRahaaLadattaessaKortinSaldoMuuttuu() {
        kassapaate.lataaRahaaKortille(koyhaKortti, 1000);
        assertEquals(1100, koyhaKortti.saldo());
    }
    
    @Test
    public void kortilleRahaaLadattaessaKassassaOlevaRahamaaraKasvaaLadatullaSummalla() {
        kassapaate.lataaRahaaKortille(koyhaKortti, 1000);
        assertEquals(101000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortilleRahaaLadattaessaKunSummaOnNegatiivinenKortinSaldoPysyySamana() {
        kassapaate.lataaRahaaKortille(koyhaKortti, -1);
        assertEquals(100, koyhaKortti.saldo());
    }
    
    @Test
    public void kortilleRahaaLadattaessaKunSummaOnNegatiivinenKassanRahamaaraPysyySamana() {
        kassapaate.lataaRahaaKortille(koyhaKortti, -1);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    public void hello() {
    }
}
