package com.mycompany.vaatekaapinhallintajarjestelma.test;

import com.mycompany.vaatekaapinhallintajarjestelma.domain.Clothing;
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

public class ClothingTest {

    Clothing clothing;

    public ClothingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        clothing = new Clothing("kiva paita", ColorsEnum.KELTAINEN, ConditionEnum.EHJA, 32, SizeEnum.XSMALL, TypeEnum.TPAITA, IsItLaundryEnum.KAYTETTY, 100, MaterialsEnum.LYKRA);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getNameWorks() {
        assertEquals("kiva paita", clothing.getName());
    }

    @Test
    public void getColorWorks() {
        assertEquals(ColorsEnum.KELTAINEN, clothing.getColor());
    }

    @Test
    public void getConditionWorks() {
        assertEquals(ConditionEnum.EHJA, clothing.getCondition());
    }

    @Test
    public void getSizeInInchesWorks() {
        assertEquals(32, clothing.getSizeInInches());
    }

    @Test
    public void getSizeWorks() {
        assertEquals(SizeEnum.XSMALL, clothing.getSize());
    }

    @Test
    public void getTypeWorks() {
        assertEquals(TypeEnum.TPAITA, clothing.getType());
    }

    @Test
    public void getHowDirtyWorks() {
        assertEquals(IsItLaundryEnum.KAYTETTY, clothing.getHowDirty());
    }

    @Test
    public void getMaterialWorks() {
        assertEquals(MaterialsEnum.LYKRA, clothing.getMaterial());
    }

    @Test
    public void setConditionWorks() {
        clothing.setCondition(ConditionEnum.KULUNUT);
        assertEquals(ConditionEnum.KULUNUT, clothing.getCondition());
    }

    @Test
    public void setHowDirtyWorks() {
        clothing.setHowDirty(IsItLaundryEnum.LIKAINEN);
        assertEquals(IsItLaundryEnum.LIKAINEN, clothing.getHowDirty());
    }

    @Test
    public void doesRepairRepairWhenBroken() {
        clothing.setCondition(ConditionEnum.RIKKI);
        clothing.repair();
        assertEquals(ConditionEnum.EHJA, clothing.getCondition());
    }

    @Test
    public void doesRepairNotRepairWhenIsNotBroken() {
        clothing.setCondition(ConditionEnum.KULUNUT);
        clothing.repair();
        assertEquals(ConditionEnum.KULUNUT, clothing.getCondition());
    }

    @Test
    public void doesWashWashWhenDirty() {
        clothing.setHowDirty(IsItLaundryEnum.LIKAINEN);
        clothing.wash();
        assertEquals(IsItLaundryEnum.PUHDAS, clothing.getHowDirty());
    }

    @Test
    public void doesWashNotWashWhenNotDirty() {
        clothing.setHowDirty(IsItLaundryEnum.KAYTETTY);
        clothing.wash();
        assertEquals(IsItLaundryEnum.KAYTETTY, clothing.getHowDirty());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
