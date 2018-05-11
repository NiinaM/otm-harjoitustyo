package com.mycompany.vaatekaapinhallintajarjestelma.domain;

import java.util.ArrayList;

/**
 * Class creates a shelf object and provides methods to maintain the clothes
 * that are on the shelf
 */
public class Shelf {

    private ArrayList<Clothing> clothes;
    private int shelfNumber;

    /**
     * Method that Constructs a shelf object
     */
    public Shelf(int shelfNumber) {
        this.clothes = new ArrayList<>();
        this.shelfNumber = shelfNumber;
    }
    
    public Shelf(int shelfNumber, ArrayList<Clothing> list) {
        this.clothes = list;
        this.shelfNumber = shelfNumber;
    }

    /**
     * Method that returns a ArrayList of all the clothes on the shelf
     * 
     * @return ArrayList that has all the clothes on the shelf
     */
    public ArrayList<Clothing> getClothes() {
        return clothes;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    /**
     * Method adds clothing on the shelf to the ArrayList clothes until it has 20 clothes
     * 
     * @param clothing
     * @return Boolean false if there are already 20 clothes on the shelf and true if there is still space
     */
    public Boolean addClothing(Clothing clothing) {
        if (this.clothes.size() < 20) {
            this.clothes.add(clothing);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Method removes the clothing that is given as parameter from the ArrayList clothes
     * 
     * @param clothing
     * @return Boolean true if the clothing was removed and false if it was not
     */
    public Boolean removeClothing(Clothing clothing) {
        for (int i = 0; i < this.clothes.size(); i++) {
            if (this.clothes.get(i).getName().equals(clothing.getName())) {
                this.clothes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Method empties the ArrayList chlothes 
     */
    public void emptyShelf() {
        this.clothes.removeAll(clothes);
    }

    /**
     * Method counts value of all the clothes on the shelf
     * 
     * @return Integer that is the value of all the clothes on shelf
     */
    public int valueOfAllTheItemsOnShelf() {
        int price = 0;
        for (int i = 0; i < this.clothes.size(); i++) {
            price += this.clothes.get(i).getPrice();
        }
        return price;
    }

    /**
     * Method counts the amount of broken items on the shelf
     * 
     * @return Integer that is the amount of broken items on the shelf
     */
    public int howManyBrokenItemsOnShelf() {
        int howMany = 0;

        for (int i = 0; i < this.clothes.size(); i++) {
            if (this.clothes.get(i).getCondition().equals(ConditionEnum.RIKKI)) {
                howMany++;
            }
        }
        return howMany;
    }

    /**
     * Method counts the amount of dirty items on the shelf
     * 
     * @return Integer that is the amount of dirty items on the shelf
     */
    public int howManyDirtyItemsOnShelf() {
        int howMany = 0;

        for (int i = 0; i < this.clothes.size(); i++) {
            if (this.clothes.get(i).getHowDirty().equals(IsItLaundryEnum.LIKAINEN)) {
                howMany++;
            }
        }
        return howMany;
    }
}
