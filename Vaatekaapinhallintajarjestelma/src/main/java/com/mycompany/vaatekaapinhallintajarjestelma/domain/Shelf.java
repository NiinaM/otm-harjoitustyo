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
    
    public Boolean addClothing(Clothing clothing) {
        if (this.clothes.size() < 20) {
            this.clothes.add(clothing);
            return true;
        } else {
            return false;
        }
        
    }

    public Boolean removeClothing(Clothing clothing) {
        for (int i = 0; i < this.clothes.size(); i++) {
            if (this.clothes.get(i).getName().equals(clothing.getName())) {
                this.clothes.remove(i);
                return true;
            }
        }
        return false;
    }
    public void emptyShelf() {
        this.clothes.removeAll(clothes);
    }

    public int valueOfAllTheItemsOnShelf() {
        int price = 0;
        for (int i = 0; i < this.clothes.size(); i++) {
            price += this.clothes.get(i).getPrice();
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
    
    public void repair(Clothing clothing) {
        if (clothing.getCondition().equals(ConditionEnum.RIKKI)) {
            clothing.setCondition(ConditionEnum.EHJA);
        }
    }
    
    public void wash(Clothing clothing) {
        if (clothing.getCondition().equals(IsItLaundryEnum.LIKAINEN)) {
            clothing.setHowDirty(IsItLaundryEnum.PUHDAS);
        }
    }
}
