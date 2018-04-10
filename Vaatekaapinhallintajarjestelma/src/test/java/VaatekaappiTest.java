
import com.mycompany.vaatekaapinhallintajarjestelma.Vaate;
import com.mycompany.vaatekaapinhallintajarjestelma.Vaatekaappi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VaatekaappiTest {

    Vaatekaappi vaatekaappi;
    Vaate vaate;

    public VaatekaappiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        vaatekaappi = new Vaatekaappi("Niina");
        vaate = new Vaate("kiva", "punainen", "ehjä", 32, "xs", "housut", "puhdas", 50);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luodunVaatekaapinNimiOnOikein() {
        assertEquals("Niina", vaatekaappi.getOmistaja());
    }
    
    @Test
    public void vaatekaapissaOlevienVaatteidenArvoOnOikea() {
        vaatekaappi.lisaaVaate(vaate);
        assertEquals(50, vaatekaappi.vaatekaapinKokonaisArvo());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
