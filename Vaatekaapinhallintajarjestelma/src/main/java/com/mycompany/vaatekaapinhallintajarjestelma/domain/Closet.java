package com.mycompany.vaatekaapinhallintajarjestelma.domain;

import java.util.ArrayList;

public class Closet {

    private String owner;
    private ArrayList<Shelf> shelves;

    public Closet(String name) {
        this.owner = name;
        this.shelves = new ArrayList<>();
    }
    
    public void makeShelves() {
        for (int i = 0; i <= 20; i++) {
            Shelf shelf = new Shelf();
            this.shelves.add(shelf);
        }
    }
    
    public String getOwner() {
        return owner;
    }

    public ArrayList<Shelf> getShelves() {
        return shelves;
    }

    public int valueOfAllTheItemsInCloset() {
        int price = 0;

        for (int i = 0; i < this.shelves.size(); i++) {
            price = +this.shelves.get(i).valueOfAllTheItemsOnShelf();
        }
        return price;
    }

    public Boolean isThereAnyBrokenItems() {
        for (int i = 0; i < this.shelves.size(); i++) {
            if (this.shelves.get(i).howManyBrokenItemsOnShelf() != 0) {
                return true;
            }
        }
        return false;
    }

    public Boolean isThereAnyDirtyItems() {
        for (int i = 0; i < this.shelves.size(); i++) {
            if (this.shelves.get(i).howManyDirtyItemsOnShelf() != 0) {
                return true;
            }
        }
        return false;
    }

    public int howManyOfTheseItemsInCloset(TypeEnum type) {
        int howMany = 0;

        for (int i = 0; i < this.shelves.size(); i++) {
            howMany += this.shelves.get(i).howManyOfTheseItemsOnShelf(type);
        }
        return howMany;
    }
}
