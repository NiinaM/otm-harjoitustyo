package com.mycompany.vaatekaapinhallintajarjestelma.domain;

/**
 * Class creates a clothing object and provides methods to repair and wash
 */
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

    /**
     * Method that Constructs a clothing object.
     *
     * @param name
     * @param color
     * @param condition
     * @param sizeInInches
     * @param size
     * @param type
     * @param howDirty
     * @param price
     * @param material
     */
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

    /**
     * Method returns name of the clothing
     *
     * @return String that is the name of the clothing
     */
    public String getName() {
        return name;
    }

    /**
     * Method returns colour of the clothing
     *
     * @return ColorEnum that is the colour of the clothing
     */
    public ColorsEnum getColor() {
        return color;
    }

    /**
     * Method returns condition of the clothing
     *
     * @return ConditionEnum that is the condition of the clothing
     */
    public ConditionEnum getCondition() {
        return condition;
    }

    /**
     * Method returns clothing size in inches
     *
     * @return Integer that is the size of the clothing in inches
     */
    public int getSizeInInches() {
        return sizeInInches;
    }

    /**
     * Method returns clothing size
     *
     * @return SizeEnum that is the size of the clothing
     */
    public SizeEnum getSize() {
        return size;
    }

    /**
     * Method returns type of the clothing
     *
     * @return TypeEnum that is the type of the clothing
     */
    public TypeEnum getType() {
        return type;
    }

    /**
     * Method returns the dirtiness of the clothing
     *
     * @return IsItLaundryEnum that tells the dirtiness of the clothing
     */
    public IsItLaundryEnum getHowDirty() {
        return howDirty;
    }

    /**
     * Method returns the price of the clothing
     *
     * @return Integer that is the price of the clothing
     */
    public int getPrice() {
        return price;
    }

    /**
     * Method returns material of the clothing
     *
     * @return MaterialEnum that tells the material of the clothing
     */
    public MaterialsEnum getMaterial() {
        return material;
    }

    /**
     * Methods sets a new condition that is given as a parameter to the clothing
     *
     * @param condition
     */
    public void setCondition(ConditionEnum condition) {
        this.condition = condition;
    }

    /**
     * Method sets a new dirtiness that is given as a parameter to the clothing
     *
     * @param howDirty
     */
    public void setHowDirty(IsItLaundryEnum howDirty) {
        this.howDirty = howDirty;
    }

    /**
     * Method sets new condition ConditionEnum.EHJÄ to the clothing that had the
     * condition ConditionEnum.RIKKI
     *
     */
    public void repair() {
        if (this.getCondition().equals(ConditionEnum.RIKKI)) {
            this.setCondition(ConditionEnum.EHJA);
        }
    }

    /**
     * Method sets new dirtiness IsItLaundryEnum.PUHDAS to the clothing that had
     * the dirtiness IsItLaundry.LIKAINEN
     *
     */
    public void wash() {
        if (this.getHowDirty().equals(IsItLaundryEnum.LIKAINEN)) {
            this.setHowDirty(IsItLaundryEnum.PUHDAS);
        }
    }
}
