package com.mycompany.vaatekaapinhallintajarjestelma.domain;

import com.mycompany.vaatekaapinhallintajarjestelma.dao.FileShelfDao;
import com.mycompany.vaatekaapinhallintajarjestelma.dao.ShelfDao;
import java.util.ArrayList;

/**
 * Class creates a closet object and provides methods to get information about clothes
 * in closet
 */
public class Closet {

    private String owner;
    private ArrayList<Shelf> shelves;
    private ShelfDao dao;

    /**
     * Method that Constructs a closet object it takes String as parameter.
     *
     * @param name
     */
    public Closet(String name, ShelfDao dao) {
        this.dao = dao;
        this.owner = name;
        this.shelves = this.dao.getAll();
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
    
    public String addClothing(Shelf shelf, Clothing clothing) {
        if (shelf.addClothing(clothing)) {
            dao.saveAll();
            return "Vaate lisätty.";
        } else {
            return "Lisääminen epäonnistui.";
        }
    }
    
    public void saveInformation() {
        this.dao.saveAll();
    }

    /**
     * Method returns the owner of the closet
     *
     * @return String that is the name of the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Method returns the shelves of the closet as a ArrayList.
     *
     * @return ArrayList that has the shelves of the closet
     */
    public ArrayList<Shelf> getShelves() {
        return shelves;
    }

    /**
     * Method counts value of all the items in the closet.
     *
     * @return value of all items in closet
     */
    public int valueOfAllTheItemsInCloset() {
        int price = 0;

        for (int i = 0; i < this.shelves.size(); i++) {
            price += this.shelves.get(i).valueOfAllTheItemsOnShelf();
        }
        return price;
    }

    /**
     * Method checks if there are any broken items in closet
     *
     * @return Boolean false if there are none and true if there are any
     */
    public Boolean isThereAnyBrokenItems() {
        for (int i = 0; i < this.shelves.size(); i++) {
            if (this.shelves.get(i).howManyBrokenItemsOnShelf() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks if there are any Dirty items in closet
     *
     * @return Boolean false if there are none and true if there are any
     */
    public Boolean isThereAnyDirtyItems() {
        for (int i = 0; i < this.shelves.size(); i++) {
            if (this.shelves.get(i).howManyDirtyItemsOnShelf() != 0) {
                return true;
            }
        }
        return false;
    }
}
