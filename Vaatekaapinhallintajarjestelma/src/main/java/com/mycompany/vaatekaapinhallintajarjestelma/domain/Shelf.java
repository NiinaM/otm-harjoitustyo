package com.mycompany.vaatekaapinhallintajarjestelma.domain;

import java.util.ArrayList;

public class Shelf {

    private ArrayList<Clothing> clothes;

    public Shelf() {
        this.clothes = new ArrayList<>();
    }

    public ArrayList<Clothing> getClothes() {
        return clothes;
    }
    
    public String addClothing(Clothing clothing) {
        if (this.clothes.size() <= 20) {
            this.clothes.add(clothing);
            return "Vaatteen asetus onnistui!";
        } else {
            return "Hylly on täynnä aseta toiselle hyllylle!";
        }
        
    }

    public void removeClothing(Clothing clothing) {
        for (int i = 0; i < this.clothes.size(); i++) {
            if (this.clothes.get(i).getName().equals(clothing.getName())) {
                this.clothes.remove(i);
            }
        }
    }

    public void emptyShelf() {
        this.clothes.removeAll(clothes);
    }

    public int valueOfAllTheItemsOnShelf() {
        int price = 0;

        for (int i = 0; i < this.clothes.size(); i++) {
            price = +this.clothes.get(i).getPrice();
        }
        return price;
    }

    public int howManyBrokenItemsOnShelf() {
        int howMany = 0;

        for (int i = 0; i < this.clothes.size(); i++) {
            if (this.clothes.get(i).getCondition().equals(ConditionEnum.RIKKI)) {
                howMany++;
            }
        }
        return howMany;
    }

    public int howManyDirtyItemsOnShelf() {
        int howMany = 0;

        for (int i = 0; i < this.clothes.size(); i++) {
            if (this.clothes.get(i).getHowDirty().equals(IsItLaundryEnum.LIKAINEN)) {
                howMany++;
            }
        }
        return howMany;
    }

    public int howManyOfTheseItemsOnShelf(TypeEnum type) {
        int howMany = 0;

        for (int i = 0; i < this.clothes.size(); i++) {
            if (this.clothes.get(i).getType().equals(type)) {
                howMany++;
            }
        }
        return howMany;
    }
}
