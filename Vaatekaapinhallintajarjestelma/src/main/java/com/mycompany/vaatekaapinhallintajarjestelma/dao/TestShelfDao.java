package com.mycompany.vaatekaapinhallintajarjestelma.dao;

import com.mycompany.vaatekaapinhallintajarjestelma.domain.Shelf;
import java.util.ArrayList;

public class TestShelfDao implements ShelfDao {

    @Override
    public ArrayList<Shelf> getAll() {
        ArrayList<Shelf> shelves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Shelf shelf = new Shelf(i);
            shelves.add(shelf);
        }
        return shelves;
    }

    @Override
    public void saveAll() {
        //do nothing
    }

}
