package com.mycompany.vaatekaapinhallintajarjestelma.ui;

import com.mycompany.vaatekaapinhallintajarjestelma.domain.Closet;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Clothing;
import java.util.ArrayList;
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
    Button buttonBringsToCloset;
    Button buttonPicksTheShelfFromDropDown;
    Button buttonPicksTheClothingFromDropDown;
    Button buttonCreatesCloset;
    Button buttonIsThereAnyDirtyItems;
    Button buttonIsThereAnyBrokenItems;
    TextField textFieldTheOwnersName;
    int shelfNumber;
    String choocedClothingFromDropDownInShelf;
    ChoiceBox<Integer> choiceBoxShelves;
    ChoiceBox<String> choiceBoxClothes;
    Label answer;

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

        buttonLeadsToCreateClothing = new Button();
        buttonLeadsToCreateClothing.setText("Luo Vaate");
        buttonLeadsToCreateClothing.setOnAction(this);

        buttonBringsToCloset = new Button();
        buttonBringsToCloset.setText("Kaappiin");
        buttonBringsToCloset.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(buttonLeadsToCreateCloset, buttonLeadsToCreateClothing, buttonBringsToCloset);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);

    }

    public Scene createClosetScene() {
        //puuttuu kaikenlaista vielä
        Label label = new Label("Kaappi");

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

        buttonBringsBackToStart = new Button();
        buttonBringsBackToStart.setText("Siirry alkunäkymään");
        buttonBringsBackToStart.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, choices, choiceBoxShelves, buttonPicksTheShelfFromDropDown, buttonIsThereAnyDirtyItems, buttonIsThereAnyBrokenItems, buttonBringsBackToStart);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 400);
    }

    public Scene createSheflScene() {
        //kesken
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

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, choices, choiceBoxClothes, buttonPicksTheClothingFromDropDown);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    public Scene createClothingScene() {
        Label label = new Label("Vaate: " + this.choocedClothingFromDropDownInShelf);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    public Scene createClosetCreationScene() {

        Label label = new Label("Täällä voit luoda kaapin.");

        Label kaapinOmistaja = new Label("Omistajan nimi");
        textFieldTheOwnersName = new TextField();

        buttonCreatesCloset = new Button();
        buttonCreatesCloset.setText("Luo kaappi");
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

    public Scene creatClothingCreationScene() {
        //puuttuu kaikenlaista vielä
        Label label = new Label("Täällä voit luoda vaatteen ja lisätä sen hyllyyn.");
        Label nameClothing = new Label("Vaate");
        TextField name = new TextField();

        buttonCreateClothing = new Button();
        buttonCreateClothing.setText("Luo vaate");
        buttonCreateClothing.setOnAction(this);

        buttonBringsBackToStart = new Button();
        buttonBringsBackToStart.setText("Siirry alkunäkymään");
        buttonBringsBackToStart.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, nameClothing, name, buttonCreateClothing, buttonBringsBackToStart);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
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
            window.setScene(this.createClothingScene());
        }

        if (event.getSource() == buttonBringsToCloset) {
            //siirtää kaappi ruutuun
            window.setScene(sceneCloset);
        }

        if (event.getSource() == buttonPicksTheShelfFromDropDown) {
            //hyllyjen pudotusvalikon nappi
            this.getShelf(choiceBoxShelves);
        }

        if (event.getSource() == buttonPicksTheClothingFromDropDown) {
            //vaatteiden pudotusvalikon nappi
            this.getClothing(choiceBoxClothes);
        }

        if (event.getSource() == buttonCreatesCloset) {
            //kaapin luominen jokin ongelma valittaa null pointer exception?
            closet = new Closet(textFieldTheOwnersName.getText());
            //En ole nyt varma toimiiko nämä oikein?
            window.setScene(sceneCloset);
        }

        if (event.getSource() == buttonIsThereAnyDirtyItems) {
            if (closet.isThereAnyDirtyItems()) {
                answer = new Label("On likaisia vaatteita.");
            } else {
                answer = new Label("Ei ole likaisia vaatteita.");
            }
        }

        if (event.getSource() == buttonIsThereAnyBrokenItems) {
            if (closet.isThereAnyBrokenItems()) {
                answer = new Label("On rikkinäisiä vaatteita.");
            } else {
                answer = new Label("Ei ole rikkinäisiä vaatteita.");
            }
        }

    }

    private void getShelf(ChoiceBox<Integer> choiceBox) {
        this.shelfNumber = choiceBox.getValue();
        window.setScene(this.createSheflScene());
    }

    private void getClothing(ChoiceBox<String> choiceBox) {
        choocedClothingFromDropDownInShelf = choiceBox.getValue();
        window.setScene(this.createClothingScene());

    }

}
