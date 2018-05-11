package com.mycompany.vaatekaapinhallintajarjestelma.dao;

import com.mycompany.vaatekaapinhallintajarjestelma.domain.Clothing;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ColorsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ConditionEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.IsItLaundryEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.MaterialsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Shelf;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.SizeEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.TypeEnum;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileShelfDao implements ShelfDao {

    private ArrayList<Shelf> shelves;
    private String fileName;

    public FileShelfDao(String file) {
        this.shelves = new ArrayList<>();
        this.fileName = file;
        load();
    }

    private void load() {
        this.shelves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Shelf shelf = new Shelf(i);
            this.shelves.add(shelf);
        }
        File file = new File(fileName);
        if (file.isFile()) {
            try {
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {

                    String[] parts = reader.nextLine().split(",");
                    Shelf shelf = shelves.get(Integer.parseInt(parts[0]));
                    Clothing clothing = new Clothing(parts[1],
                            ColorsEnum.valueOf(parts[2]),
                            ConditionEnum.valueOf(parts[3]),
                            Integer.parseInt(parts[4]),
                            SizeEnum.valueOf(parts[5]),
                            TypeEnum.valueOf(parts[6]),
                            IsItLaundryEnum.valueOf(parts[7]),
                            Integer.parseInt(parts[8]),
                            MaterialsEnum.valueOf(parts[9])
                    );
                    shelf.addClothing(clothing);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Shelf> getAll() {
        return shelves;
    }

    @Override
    public void saveAll() {
        try {
            FileWriter writer = new FileWriter(new File(fileName));
            for (Shelf shelf : shelves) {
                for (Clothing clothing : shelf.getClothes()) {

                    writer.write(shelf.getShelfNumber() + ","
                            + clothing.getName() + ","
                            + clothing.getColor() + ","
                            + clothing.getCondition() + ","
                            + clothing.getSizeInInches() + ","
                            + clothing.getSize() + ","
                            + clothing.getType() + ","
                            + clothing.getHowDirty() + ","
                            + clothing.getPrice() + ","
                            + clothing.getMaterial() + "\n");
                }

            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
