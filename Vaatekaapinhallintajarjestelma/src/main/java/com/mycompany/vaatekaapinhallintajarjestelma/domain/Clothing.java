package com.mycompany.vaatekaapinhallintajarjestelma.domain;

public class Clothing {

    private String name;
    private ColorsEnum color;
    private ConditionEnum condition;
    private int sizeInInches;
    private SizeEnum size;
    private TypeEnum type;
    private IsItLaundryEnum howDirty;
    private int price;
    private MaterialsEnum material;

    public Clothing(String name, ColorsEnum color, ConditionEnum condition, int sizeInInches, SizeEnum size, TypeEnum type, IsItLaundryEnum howDirty, int price, MaterialsEnum material) {
        this.name = name;
        this.color = color;
        this.condition = condition;
        this.sizeInInches = sizeInInches;
        this.size = size;
        this.type = type;
        this.howDirty = howDirty;
        this.price = price;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public ColorsEnum getColor() {
        return color;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public int getSizeInInches() {
        return sizeInInches;
    }

    public SizeEnum getSize() {
        return size;
    }

    public TypeEnum getType() {
        return type;
    }

    public IsItLaundryEnum getHowDirty() {
        return howDirty;
    }

    public int getPrice() {
        return price;
    }

    public MaterialsEnum getMaterial() {
        return material;
    }

    public void setCondition(ConditionEnum condition) {
        this.condition = condition;
    }

    public void setHowDirty(IsItLaundryEnum howDirty) {
        this.howDirty = howDirty;
    }

    public void setColor(ColorsEnum color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vaate " + this.name + " on " + this.size + "-kokoinen ja " + this.sizeInInches + "-kokoinen. Sen väri on " + this.color + " ja se on " + this.type;
    }
}
