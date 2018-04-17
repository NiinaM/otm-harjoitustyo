package com.mycompany.vaatekaapinhallintajarjestelma.domain;

import java.util.ArrayList;

public class Closet {

    private String owner;
    private ArrayList<Clothing> shelves;

    public Closet(String name) {
        this.owner = name;
        this.shelves = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
    }

    public ArrayList<Clothing> getShelves() {
        return shelves;
    }

    public void addClothing(Clothing clothing) {
        this.shelves.add(clothing);
    }

    public void removeClothing(Clothing clothing) {
        for (int i = 0; i < this.shelves.size(); i++) {
            if (this.shelves.get(i).getName().equals(clothing.getName())) {
                this.shelves.remove(i);
            }
        }
    }

    public int valueOfAllTheItemsInCloset() {
        int price = 0;

        for (int i = 0; i < this.shelves.size(); i++) {
            price = +this.shelves.get(i).getPrice();
        }
        return price;
    }

    public Boolean isThereAnyBrokenItems() {
        for (int i = 0; i < this.shelves.size(); i++) {
            if (this.shelves.get(i).getCondition().equals(ConditionEnum.RIKKI)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isThereAnyDirtyItems() {
        for (int i = 0; i < this.shelves.size(); i++) {
            if (this.shelves.get(i).getHowDirty().equals(IsItLaundryEnum.LIKAINEN)) {
                return true;
            }
        }
        return false;
    }

    public int howManyOfTheseItemsInCloset(TypeEnum type) {
        int howMany = 0;
        
        for (int i = 0; i < this.shelves.size(); i++) {
            if (this.shelves.get(i).getType().equals(type)) {
                howMany++;
            }
        }
        return howMany;
    }
}
