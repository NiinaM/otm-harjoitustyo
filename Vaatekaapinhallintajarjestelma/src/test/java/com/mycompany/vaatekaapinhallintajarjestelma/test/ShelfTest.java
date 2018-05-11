package com.mycompany.vaatekaapinhallintajarjestelma.test;


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
        shelf = new Shelf(1);
        clothing = new Clothing("kiva", ColorsEnum.PUNAINEN, ConditionEnum.EHJA, 32, SizeEnum.XSMALL, TypeEnum.HOUSUT, IsItLaundryEnum.PUHDAS, 50, MaterialsEnum.AKRYYLI);
        shelf.addClothing(clothing);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addClothingAddsClothingWhenThereIsSpace() {
        assertEquals("kiva", shelf.getClothes().get(0).getName());
    }

    @Test
    public void addClothingDoesntAddWhenShelfIsFull() {
        for (int i = 0; i < 19; i++) {
            shelf.addClothing(clothing);
        }
        assertFalse(shelf.addClothing(clothing));
    }

    @Test
    public void removesClothingThatIsThere() {
        assertTrue(shelf.removeClothing(clothing));
    }

    @Test
    public void doesntRemoveClothingWhenThereIsNoClothes() {
        Shelf shelf2 = new Shelf(1);
        assertFalse(shelf2.removeClothing(clothing));
    }
    
    @Test
    public void removeClothingWhenThereIsNoClothes() {
        Clothing clothing2 = new Clothing("Hulli", ColorsEnum.PUNAINEN, ConditionEnum.EHJA, 32, SizeEnum.XSMALL, TypeEnum.HOUSUT, IsItLaundryEnum.PUHDAS, 50, MaterialsEnum.AKRYYLI);
        assertFalse(shelf.removeClothing(clothing2));
        
    }

    @Test
    public void emptiesTheShelf() {
        shelf.emptyShelf();
        assertTrue(shelf.getClothes().isEmpty());
    }

    @Test
    public void valueOfTheClothesInShelftIsRight() {
        assertEquals(50, shelf.valueOfAllTheItemsOnShelf());
    }

    @Test
    public void valueOfTheClothesInShelftIsRightWhenMoreItems() {
        shelf.addClothing(clothing);
        assertEquals(100, shelf.valueOfAllTheItemsOnShelf());
    }

    @Test
    public void howManyBrokenItemsOnTheShelfWorksWhenThereIsOne() {
        clothing.setCondition(ConditionEnum.RIKKI);
        assertEquals(1, shelf.howManyBrokenItemsOnShelf());
    }

    @Test
    public void howManyBrokenItemsOnTheShelfWorksWhenThereIsNone() {
        clothing.setCondition(ConditionEnum.EHJA);
        assertEquals(0, shelf.howManyBrokenItemsOnShelf());
    }

    @Test
    public void howManyDirtyItemsOnShelfWorksWhenThereIsOne() {
        clothing.setHowDirty(IsItLaundryEnum.LIKAINEN);
        assertEquals(1, shelf.howManyDirtyItemsOnShelf());
    }

    @Test
    public void howManyDirtyItemsOnShelfWorksWhenThereIsNone() {
        clothing.setHowDirty(IsItLaundryEnum.PUHDAS);
        assertEquals(0, shelf.howManyDirtyItemsOnShelf());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
