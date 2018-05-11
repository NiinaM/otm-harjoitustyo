package com.mycompany.vaatekaapinhallintajarjestelma.test;


import com.mycompany.vaatekaapinhallintajarjestelma.dao.FileShelfDao;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Clothing;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ColorsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ConditionEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.IsItLaundryEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.MaterialsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Shelf;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.SizeEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.TypeEnum;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileShelfDaoTest {

    Clothing clothing;

    public FileShelfDaoTest() {
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
    public void loadsOneClothingCorrectly() {
        FileShelfDao dao = new FileShelfDao("sigleTest.txt");
        Clothing clothing2 = dao.getAll().get(0).getClothes().get(0);
        assertEquals("kiva paita", clothing2.getName());
    }

    @Test
    public void whenThereIsMoreThanOneClothingInFileThatAreOnDifferentShelves() {
        FileShelfDao dao = new FileShelfDao("sigleTest.txt");
        ArrayList<Shelf> shelves = dao.getAll();
        assertEquals(1, shelves.get(0).getClothes().size());
        assertEquals(0, shelves.get(1).getClothes().size());
        assertEquals(1, shelves.get(2).getClothes().size());
        assertEquals(0, shelves.get(3).getClothes().size());
        assertEquals(0, shelves.get(4).getClothes().size());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
