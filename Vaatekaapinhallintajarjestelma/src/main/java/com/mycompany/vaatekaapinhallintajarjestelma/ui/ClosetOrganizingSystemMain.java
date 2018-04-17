package com.mycompany.vaatekaapinhallintajarjestelma.ui;

import com.mycompany.vaatekaapinhallintajarjestelma.domain.Closet;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.MaterialsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ColorsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Clothing;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ConditionEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.IsItLaundryEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.SizeEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.TypeEnum;

public class ClosetOrganizingSystemMain {

    public static void main(String[] args) {
        Clothing redTrousers = new Clothing("punaiset housut", ColorsEnum.PUNAINEN, ConditionEnum.UUSI, 32, SizeEnum.XSMALL, TypeEnum.HOUSUT, IsItLaundryEnum.PUHDAS, 30, MaterialsEnum.AKRYYLI);
        System.out.println(redTrousers.toString());

        Closet niinasCloset = new Closet("Niina");
        niinasCloset.addClothing(redTrousers);
        System.out.println(niinasCloset.valueOfAllTheItemsInCloset());

        redTrousers.setCondition(ConditionEnum.RIKKI);
        System.out.println(redTrousers.getCondition());

        niinasCloset.addClothing(new Clothing("siniset housut", ColorsEnum.SININEN, ConditionEnum.EHJA, 34, SizeEnum.SMALL, TypeEnum.HOUSUT, IsItLaundryEnum.KAYTETTY, 50, MaterialsEnum.AKRYYLI));
        System.out.println("Kaapissa on housuja " + niinasCloset.howManyOfTheseItemsInCloset(TypeEnum.HOUSUT) + " kappaletta.");
    }
}
