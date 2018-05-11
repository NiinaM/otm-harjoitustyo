package com.mycompany.vaatekaapinhallintajarjestelma.ui;

import com.mycompany.vaatekaapinhallintajarjestelma.dao.FileShelfDao;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Closet;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Clothing;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ColorsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ConditionEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.IsItLaundryEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.MaterialsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Shelf;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.SizeEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.TypeEnum;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ClosetOrganizingSystemMain extends Application implements EventHandler<ActionEvent> {

    Closet closet;
    Button buttonLeadsToCreateCloset;
    Button buttonLeadsToCreateClothing;
    Button buttonBringsBackToStart;
    Button buttonCreateClothing;
    Button buttonPicksTheShelfFromDropDown;
    Button buttonPicksTheClothingFromDropDown;
    Button buttonCreatesCloset;
    Button buttonIsThereAnyDirtyItems;
    Button buttonIsThereAnyBrokenItems;
    Button buttonTakesClothesOfTheShelf;
    Button buttonValueOfTheClothesInCloset;
    Button buttonRepair;
    Button buttonWash;
    Button buttonRemoveClothing;
    Label nameClothing;
    TextField textFieldTheOwnersName;
    TextField sizeInInceText;
    TextField clothingName;
    TextField priceOfClothing;

    int shelfNumber;
    String choocedClothingFromDropDownInShelf;
    ChoiceBox<Integer> choiceBoxShelves;
    ChoiceBox<String> choiceBoxClothes;
    ChoiceBox<String> choiceBoxColor;
    ChoiceBox<String> choiceBoxCondition;
    ChoiceBox<String> choiceBoxSize;
    ChoiceBox<String> choiceBoxType;
    ChoiceBox<String> choiceBoxIsItLaundry;
    ChoiceBox<String> choiceBoxMaterial;

    Stage window;
    Scene sceneStart, sceneClosetCreation, sceneClothingCreation, sceneCloset;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.window = primaryStage;
        this.window.setTitle("Vaatekaapinhallintajärjestelmä");
        sceneStart = this.createStartScene();
        sceneClosetCreation = this.createClosetCreationScene();
        sceneClothingCreation = this.creatClothingCreationScene();
        sceneCloset = this.createClosetScene();

        this.window.setScene(sceneStart);
        this.window.show();
    }

    public Scene createStartScene() {

        buttonLeadsToCreateCloset = new Button();
        buttonLeadsToCreateCloset.setText("Luo kaappi");
        buttonLeadsToCreateCloset.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(buttonLeadsToCreateCloset);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);

    }

    private Scene createClosetScene() {

        Label label = new Label(textFieldTheOwnersName.getText() + "n Kaappi");

        Label choices = new Label("Hyllyvalikko");
        choiceBoxShelves = new ChoiceBox<>();
        //kaapissa on aina 5 hyllyä
        choiceBoxShelves.getItems().addAll(1, 2, 3, 4, 5);

        buttonPicksTheShelfFromDropDown = new Button();
        buttonPicksTheShelfFromDropDown.setText("valitse hylly");
        buttonPicksTheShelfFromDropDown.setOnAction(this);

        buttonIsThereAnyDirtyItems = new Button();
        buttonIsThereAnyDirtyItems.setText("Onko yhtään likaista vaatetta");
        buttonIsThereAnyDirtyItems.setOnAction(this);

        buttonIsThereAnyBrokenItems = new Button();
        buttonIsThereAnyBrokenItems.setText("Onko yhtään rikkinäisiä vaatteita");
        buttonIsThereAnyBrokenItems.setOnAction(this);

        buttonValueOfTheClothesInCloset = new Button();
        buttonValueOfTheClothesInCloset.setText("Vaatteiden kokonaisarvo");
        buttonValueOfTheClothesInCloset.setOnAction(this);

        buttonBringsBackToStart = new Button();
        buttonBringsBackToStart.setText("Siirry alkunäkymään");
        buttonBringsBackToStart.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, choices, choiceBoxShelves, buttonPicksTheShelfFromDropDown, buttonIsThereAnyDirtyItems, buttonIsThereAnyBrokenItems, buttonBringsBackToStart);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 400);
    }

    private Scene createSheflScene() {

        Label label = new Label("Hylly " + this.shelfNumber);

        Label choices = new Label("Vaatevalikko");
        choiceBoxClothes = new ChoiceBox<>();
        ArrayList<Clothing> clothes = this.closet.getShelves().get(shelfNumber - 1).getClothes();
        for (int i = 0; i < clothes.size(); i++) {
            String clothingName = clothes.get(i).getName();
            choiceBoxClothes.getItems().add(clothingName);
        }

        buttonPicksTheClothingFromDropDown = new Button();
        buttonPicksTheClothingFromDropDown.setText("Valitse vaate");
        buttonPicksTheClothingFromDropDown.setOnAction(this);

        buttonRepair = new Button();
        buttonRepair.setText("Korjaa vaate");
        buttonRepair.setOnAction(this);

        buttonWash = new Button();
        buttonWash.setText("Pese vaate");
        buttonWash.setOnAction(this);

        buttonRemoveClothing = new Button();
        buttonRemoveClothing.setText("Poista vaate");
        buttonRemoveClothing.setOnAction(this);

        buttonLeadsToCreateClothing = new Button();
        buttonLeadsToCreateClothing.setText("Luo Vaate");
        buttonLeadsToCreateClothing.setOnAction(this);

        buttonTakesClothesOfTheShelf = new Button();
        buttonTakesClothesOfTheShelf.setText("Tyhjennä hylly");
        buttonTakesClothesOfTheShelf.setOnAction(this);

        buttonBringsBackToStart = new Button();
        buttonBringsBackToStart.setText("Siirry alkunäkymään");
        buttonBringsBackToStart.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, choices, choiceBoxClothes, buttonPicksTheClothingFromDropDown, buttonRepair, buttonWash, buttonRemoveClothing, buttonLeadsToCreateClothing, buttonTakesClothesOfTheShelf, buttonBringsBackToStart);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    private Scene createClothingScene() {
        Label label = new Label("Vaate: " + this.choocedClothingFromDropDownInShelf);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    private Scene createClosetCreationScene() {

        Label label = new Label("Täällä voit luoda kaapin.");

        Label kaapinOmistaja = new Label("Omistajan nimi");
        textFieldTheOwnersName = new TextField();

        buttonCreatesCloset = new Button();
        buttonCreatesCloset.setText("Luo kaappi ja siirry kaappiin");
        buttonCreatesCloset.setOnAction(this);

        buttonBringsBackToStart = new Button();
        buttonBringsBackToStart.setText("Siirry alkunäkymään");
        buttonBringsBackToStart.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, kaapinOmistaja, textFieldTheOwnersName, buttonCreatesCloset, buttonBringsBackToStart);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    private Scene creatClothingCreationScene() {
        //puuttuu kaikenlaista vielä
        Label label = new Label("Täällä voit luoda vaatteen ja lisätä sen hyllyyn.");
        nameClothing = new Label("Mikä vaate?");
        clothingName = new TextField();

        Label color = new Label("Väri");
        choiceBoxColor = new ChoiceBox<>();
        for (int i = 0; i < ColorsEnum.values().length; i++) {
            choiceBoxColor.getItems().add(ColorsEnum.values()[i].name());
        }

        Label condition = new Label("Kunto");
        choiceBoxCondition = new ChoiceBox<>();
        for (int i = 0; i < ConditionEnum.values().length; i++) {
            choiceBoxCondition.getItems().add(ConditionEnum.values()[i].name());
        }

        Label sizeInIncheses = new Label("Tuumakoko");
        sizeInInceText = new TextField();

        Label size = new Label("koko");
        choiceBoxSize = new ChoiceBox<>();
        for (int i = 0; i < SizeEnum.values().length; i++) {
            choiceBoxSize.getItems().add(SizeEnum.values()[i].name());
        }

        Label type = new Label("Mikä vaate?");
        choiceBoxType = new ChoiceBox<>();
        for (int i = 0; i < TypeEnum.values().length; i++) {
            choiceBoxType.getItems().add(TypeEnum.values()[i].name());
        }

        Label isItLaundry = new Label("Onko puhdas?");
        choiceBoxIsItLaundry = new ChoiceBox<>();
        for (int i = 0; i < IsItLaundryEnum.values().length; i++) {
            choiceBoxIsItLaundry.getItems().add(IsItLaundryEnum.values()[i].name());
        }

        Label price = new Label("Arvo");
        priceOfClothing = new TextField();

        Label material = new Label("Materiaali");
        choiceBoxMaterial = new ChoiceBox<>();
        for (int i = 0; i < MaterialsEnum.values().length; i++) {
            choiceBoxMaterial.getItems().add(MaterialsEnum.values()[i].name());
        }

        buttonCreateClothing = new Button();
        buttonCreateClothing.setText("Luo vaate ja lisää hyllyyn");
        buttonCreateClothing.setOnAction(this);

        buttonBringsBackToStart = new Button();
        buttonBringsBackToStart.setText("Siirry alkunäkymään");
        buttonBringsBackToStart.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label,
                nameClothing,
                clothingName,
                color,
                choiceBoxColor,
                condition,
                choiceBoxCondition,
                sizeInIncheses,
                sizeInInceText,
                size,
                choiceBoxSize,
                type,
                choiceBoxType,
                isItLaundry,
                choiceBoxIsItLaundry,
                price,
                priceOfClothing,
                material,
                choiceBoxMaterial,
                buttonCreateClothing, buttonBringsBackToStart);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 700);
    }

    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == buttonLeadsToCreateCloset) {
            //siirtää kaapin luomis ruutuun
            window.setScene(sceneClosetCreation);
        }

        if (event.getSource() == buttonLeadsToCreateClothing) {
            //siirtää vaatteen luomisruutuun
            window.setScene(sceneClothingCreation);
        }

        if (event.getSource() == buttonBringsBackToStart) {
            //palautus alkuruutuun
            window.setScene(sceneStart);
        }

        if (event.getSource() == buttonCreateClothing) {
            //vaatteen luonti
            this.createClothing();
            window.setScene(this.createClothingScene());
        }

        if (event.getSource() == buttonPicksTheShelfFromDropDown) {
            //hyllyjen pudotusvalikon nappi
            this.getShelf(choiceBoxShelves);
        }

        if (event.getSource() == buttonPicksTheClothingFromDropDown) {
            //vaatteiden pudotusvalikon nappi
            this.getClothingForCreatingClothing(choiceBoxClothes);
        }

        if (event.getSource() == buttonCreatesCloset) {
            closet = new Closet(textFieldTheOwnersName.getText(), new FileShelfDao("vaatteet.txt"));
            window.setScene(sceneCloset);
        }

        if (event.getSource() == buttonIsThereAnyDirtyItems) {
            if (closet.isThereAnyDirtyItems()) {
                System.out.println("On likaisia vaatteita.");
            } else {
                System.out.println("Ei ole likaisia vaatteita.");
            }
        }

        if (event.getSource() == buttonIsThereAnyBrokenItems) {
            if (closet.isThereAnyBrokenItems()) {
                System.out.println("On rikkinäisiä vaatteita.");
            } else {
                System.out.println("Ei ole rikkinäisiä vaatteita.");
            }
        }

        if (event.getSource() == buttonTakesClothesOfTheShelf) {
            closet.getShelves().get(shelfNumber).emptyShelf();
        }

        if (event.getSource() == buttonValueOfTheClothesInCloset) {
            System.out.println(Integer.toString(closet.valueOfAllTheItemsInCloset()));
        }

        if (event.getSource() == buttonRepair) {
            this.repairClothes(choiceBoxClothes);
        }

        if (event.getSource() == buttonWash) {
            this.washClothes(choiceBoxClothes);
        }

        if (event.getSource() == buttonRemoveClothing) {
            this.removeClothing(choiceBoxClothes);

        }
    }

    private String getColor(ChoiceBox<String> choiceBox1) {
        String color = choiceBox1.getValue();
        return color;
    }

    private String getCondition(ChoiceBox<String> choiceBox2) {
        String condition = choiceBox2.getValue();
        return condition;
    }

    private String getSize(ChoiceBox<String> choiceBox3) {
        String size = choiceBox3.getValue();
        return size;
    }

    private String getType(ChoiceBox<String> choiceBox4) {
        String type = choiceBox4.getValue();
        return type;
    }

    private String getIsItLaundry(ChoiceBox<String> choiceBox5) {
        String isItLaundry = choiceBox5.getValue();
        return isItLaundry;
    }

    private String getMaterial(ChoiceBox<String> choiceBox6) {
        String material = choiceBox6.getValue();
        return material;
    }

    private void createClothing() {
        Clothing clothing = new Clothing(
                clothingName.getText(),
                ColorsEnum.valueOf(this.getColor(choiceBoxColor)),
                ConditionEnum.valueOf(this.getCondition(choiceBoxCondition)),
                Integer.parseInt(sizeInInceText.getText()),
                SizeEnum.valueOf(this.getSize(choiceBoxSize)),
                TypeEnum.valueOf(this.getType(choiceBoxType)),
                IsItLaundryEnum.valueOf(this.getIsItLaundry(choiceBoxIsItLaundry)),
                Integer.parseInt(priceOfClothing.getText()),
                MaterialsEnum.valueOf(this.getMaterial(choiceBoxMaterial)));
        Shelf shelf = closet.getShelves().get(shelfNumber - 1);
        closet.addClothing(shelf, clothing);
    }

    private void getShelf(ChoiceBox<Integer> choiceBox) {
        this.shelfNumber = choiceBox.getValue();
        window.setScene(this.createSheflScene());
    }

    private void getClothingForCreatingClothing(ChoiceBox<String> choiceBox) {
        choocedClothingFromDropDownInShelf = choiceBox.getValue();
        window.setScene(this.createClothingScene());

    }

    private void repairClothes(ChoiceBox<String> choiceBox) {
        choocedClothingFromDropDownInShelf = choiceBox.getValue();
        ArrayList<Clothing> clothes = closet.getShelves().get(shelfNumber).getClothes();
        for (int i = 0; i < clothes.size(); i++) {
            Clothing item = closet.getShelves().get(shelfNumber).getClothes().get(i);
            if (clothes.get(i).getName().equals(choocedClothingFromDropDownInShelf)) {
                item.repair();
            }
        }
        closet.saveInformation();
    }

    private void washClothes(ChoiceBox<String> choiceBox) {
        choocedClothingFromDropDownInShelf = choiceBox.getValue();
        ArrayList<Clothing> clothes = closet.getShelves().get(shelfNumber).getClothes();
        for (int i = 0; i < clothes.size(); i++) {
            Clothing item = closet.getShelves().get(shelfNumber).getClothes().get(i);
            if (clothes.get(i).getName().equals(choocedClothingFromDropDownInShelf)) {
                item.wash();
            }
        }
        closet.saveInformation();
    }

    private void removeClothing(ChoiceBox<String> choiceBox) {
        choocedClothingFromDropDownInShelf = choiceBox.getValue();
        ArrayList<Clothing> clothes = closet.getShelves().get(shelfNumber).getClothes();
        for (int i = 0; i < clothes.size(); i++) {
            Clothing item = closet.getShelves().get(shelfNumber).getClothes().get(i);
            if (clothes.get(i).getName().equals(choocedClothingFromDropDownInShelf)) {
                closet.getShelves().get(shelfNumber).removeClothing(item);
            }
        }
        closet.saveInformation();

    }
}
