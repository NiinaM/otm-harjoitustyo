package com.mycompany.vaatekaapinhallintajarjestelma.dao;

import com.mycompany.vaatekaapinhallintajarjestelma.domain.Shelf;
import java.util.ArrayList;

public interface ShelfDao {
    
    public ArrayList<Shelf> getAll();
    public void saveAll();
    
}
