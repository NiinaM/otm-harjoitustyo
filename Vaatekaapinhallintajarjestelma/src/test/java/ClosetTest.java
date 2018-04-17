
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Clothing;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Closet;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ColorsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ConditionEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.IsItLaundryEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.MaterialsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.SizeEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.TypeEnum;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClosetTest {

    Closet closet;
    Clothing clothing;

    public ClosetTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        closet = new Closet("Niina");
        clothing = new Clothing("kiva", ColorsEnum.PUNAINEN, ConditionEnum.EHJA, 32, SizeEnum.XSMALL, TypeEnum.HOUSUT, IsItLaundryEnum.PUHDAS, 50, MaterialsEnum.AKRYYLI);
        closet.addClothing(clothing);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void nameOfTheNewClosetIsRight() {
        assertEquals("Niina", closet.getOwner());
    }

    @Test
    public void valueOfTheClothesInClosetIsRight() {
        assertEquals(50, closet.valueOfAllTheItemsInCloset());
    }

    @Test
    public void removeClothingFromShelvesWorks() {
        closet.removeClothing(clothing);
        assertTrue(closet.getShelves().isEmpty());
    }

    @Test
    public void isThereAnyBrokenItemsWhenThereIsNone() {
        assertEquals(false, closet.isThereAnyBrokenItems());
    }
    
    @Test
    public void isThereAnyBrokenItemsWhenThereIsOne() {
        clothing.setCondition(ConditionEnum.RIKKI);
        assertEquals(true, closet.isThereAnyBrokenItems());
    }

    @Test
    public void isThereAnyDirtyItemsWhenThereIsNone() {
        assertEquals(false, closet.isThereAnyDirtyItems());
    }

    @Test
    public void isThereAnyDirtyItemsWhenThereIsOne() {
        clothing.setHowDirty(IsItLaundryEnum.LIKAINEN);
        assertEquals(true, closet.isThereAnyDirtyItems());
    }
    
    @Test
    public void howManyOfTheseItemsInClosetReturnsRightNumber() {
        assertEquals(1, closet.howManyOfTheseItemsInCloset(TypeEnum.HOUSUT));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
