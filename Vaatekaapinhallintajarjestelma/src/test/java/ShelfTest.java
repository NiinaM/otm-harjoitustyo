
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Clothing;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ColorsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ConditionEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.IsItLaundryEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.MaterialsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Shelf;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.SizeEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.TypeEnum;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShelfTest {

    Shelf shelf;
    Clothing clothing;

    public ShelfTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        shelf = new Shelf();
        clothing = new Clothing("kiva", ColorsEnum.PUNAINEN, ConditionEnum.EHJA, 32, SizeEnum.XSMALL, TypeEnum.HOUSUT, IsItLaundryEnum.PUHDAS, 50, MaterialsEnum.AKRYYLI);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addClothingAddsClothingWhenThereIsSpace() {
        shelf.addClothing(clothing);
        assertEquals("kiva", shelf.getClothes().get(0).getName());
    }

    @Test
    public void addClothingDoesntAddWhenShelfIsFull() {
        for (int i = 0; i < 20; i++) {
            shelf.addClothing(clothing);
        }
        assertFalse(shelf.addClothing(clothing));
    }

    @Test
    public void removesClothingThatIsThere() {
        shelf.addClothing(clothing);
        assertTrue(shelf.removeClothing(clothing));
    }

    @Test
    public void doesntRemoveClothingWhenThereIsNotTheClothing() {
        assertFalse(shelf.removeClothing(clothing));
    }

    @Test
    public void emptiesTheShelf() {
        shelf.addClothing(clothing);
        shelf.emptyShelf();
        assertTrue(shelf.getClothes().isEmpty());
    }

    @Test
    public void valueOfTheClothesInShelftIsRight() {
        shelf.addClothing(clothing);
        assertEquals(50, shelf.valueOfAllTheItemsOnShelf());
    }

    @Test
    public void valueOfTheClothesInShelftIsRightWhenMoreItems() {
        shelf.addClothing(clothing);
        shelf.addClothing(clothing);
        assertEquals(100, shelf.valueOfAllTheItemsOnShelf());
    }

    @Test
    public void howManyBrokenItemsOnTheShelfWorksWhenThereIsOne() {
        clothing.setCondition(ConditionEnum.RIKKI);
        shelf.addClothing(clothing);
        assertEquals(1, shelf.howManyBrokenItemsOnShelf());
    }

    @Test
    public void howManyBrokenItemsOnTheShelfWorksWhenThereIsNone() {
        clothing.setCondition(ConditionEnum.EHJA);
        shelf.addClothing(clothing);
        assertEquals(0, shelf.howManyBrokenItemsOnShelf());
    }

    @Test
    public void howManyDirtyItemsOnShelfWorksWhenThereIsOne() {
        clothing.setHowDirty(IsItLaundryEnum.LIKAINEN);
        shelf.addClothing(clothing);
        assertEquals(1, shelf.howManyDirtyItemsOnShelf());
    }

    @Test
    public void howManyDirtyItemsOnShelfWorksWhenThereIsNone() {
        clothing.setHowDirty(IsItLaundryEnum.PUHDAS);
        shelf.addClothing(clothing);
        assertEquals(0, shelf.howManyDirtyItemsOnShelf());
    }

    @Test
    public void howManyOfTheseItemsOnTheShelfWhenThereIsTrousers() {
        shelf.addClothing(clothing);
        assertEquals(1, shelf.howManyOfTheseItemsOnShelf(TypeEnum.HOUSUT));
    }

    @Test
    public void howManyOfTheseItemsOnTheShelfWhenThereIsNoneOfThisItem() {
        shelf.addClothing(clothing);
        assertEquals(0, shelf.howManyOfTheseItemsOnShelf(TypeEnum.HAME));
    }

    @Test
    public void doesRepairRepairWhenBroken() {
        clothing.setCondition(ConditionEnum.RIKKI);
        shelf.addClothing(clothing);
        shelf.repair(clothing);
        assertEquals(ConditionEnum.EHJA, clothing.getCondition());
    }

    @Test
    public void doesRepairNotRepairWhenIsNotBroken() {
        clothing.setCondition(ConditionEnum.KULUNUT);
        shelf.addClothing(clothing);
        shelf.repair(clothing);
        assertEquals(ConditionEnum.KULUNUT, clothing.getCondition());
    }
    
    @Test
    public void doesWashWashWhenDirty() {
        clothing.setHowDirty(IsItLaundryEnum.LIKAINEN);
        shelf.addClothing(clothing);
        shelf.wash(clothing);
        assertEquals(IsItLaundryEnum.PUHDAS, clothing.getHowDirty());
    }
    
    @Test
    public void doesWashNotWashWhenNotDirty() {
        clothing.setHowDirty(IsItLaundryEnum.KAYTETTY);
        shelf.addClothing(clothing);
        shelf.wash(clothing);
        assertEquals(IsItLaundryEnum.KAYTETTY, clothing.getHowDirty());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
