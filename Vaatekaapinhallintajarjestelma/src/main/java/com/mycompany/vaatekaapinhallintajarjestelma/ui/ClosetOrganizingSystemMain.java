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
import javafx.event.Event;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ClosetOrganizingSystemMain extends Application implements EventHandler<ActionEvent> {

    Closet closet;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    String clothingName;
    TextField textField;
    int shelfNumber;
    String clothing;
    ChoiceBox<Integer> choiceBox1;
    ChoiceBox<String> choiceBox2;

    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.window = primaryStage;
        this.window.setTitle("Vaatekaapinhallintajärjestelmä");
        scene1 = this.createStartScene();
        scene2 = this.creatClosetCreationScene();
        scene3 = this.creatClothingCreationScene();
        scene4 = this.createClosetScene();

        this.window.setScene(scene1);
        this.window.show();
    }

    public Scene createStartScene() {

        button1 = new Button();
        button1.setText("Luo kaappi");
        button1.setOnAction(this);

        button2 = new Button();
        button2.setText("Luo Vaate");
        button2.setOnAction(this);

        button5 = new Button();
        button5.setText("Kaappiin");
        button5.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(button1, button2, button5);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);

    }

    public Scene createClosetScene() {
        //puuttuu kaikenlaista vielä
        Label label = new Label("Kaappi");
        
        Label choices = new Label("Hyllyvalikko");
        choiceBox1 = new ChoiceBox<>();
        //kaapissa on aina 5 hyllyä
        choiceBox1.getItems().addAll(1, 2, 3, 4, 5);

        button7 = new Button();
        button7.setText("valitse hylly");
        button7.setOnAction(this);

        button6 = new Button();
        button6.setText("Siirry alkunäkymään");
        button6.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, choices, choiceBox1, button7, button6);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    public Scene createSheflScene() {
        //kesken
        Label label = new Label("Hylly " + this.shelfNumber);
        
        Label choices = new Label("Vaatevalikko");
        choiceBox2 = new ChoiceBox<>();
        ArrayList<Clothing> clothes = this.closet.getShelves().get(shelfNumber - 1).getClothes();
        for (int i = 0; i < clothes.size(); i++) {
            String clothingName = clothes.get(i).getName();
            choiceBox2.getItems().add(clothingName);
        }

        button8 = new Button();
        button8.setText("Valitse vaate");
        button8.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, choices, choiceBox2, button8);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    public Scene createClothingScene() {
        Label label = new Label("Vaate: " + this.clothing);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    public Scene creatClosetCreationScene() {
        Label label = new Label("Täällä voit luoda kaapin.");

        Label kaapinOmistaja = new Label("Omistajan nimi");
        textField = new TextField();

        button9 = new Button();
        button9.setText("Luo kaappi");
        button9.setOnAction(this);

        button3 = new Button();
        button3.setText("Siirry alkunäkymään");
        button3.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, kaapinOmistaja, textField, button9, button3);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    public Scene creatClothingCreationScene() {
        //puuttuu kaikenlaista vielä
        Label label = new Label("Täällä voit luoda vaatteen ja lisätä sen hyllyyn.");
        Label nameClothing = new Label("Vaate");
        TextField name = new TextField();
        clothingName = name.getText();
        
        
        
        
        button4 = new Button();
        button4.setText("Luo vaate");
        button4.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, nameClothing, name, button4);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == button1) {
            //siirtää kaapin luomis ruutuun
            window.setScene(scene2);
        }

        if (event.getSource() == button2) {
            //siirtää vaatteen luomisruutuun
            window.setScene(scene3);
        }

        if (event.getSource() == button3) {
            //palautus alkuruutuun
            window.setScene(scene1);
        }

        if (event.getSource() == button4) {
            //vaatteen luonti
            //palautus alkuruutuun
            window.setScene(this.createClothingScene());
        }

        if (event.getSource() == button5) {
            //siirtää kaappi ruutuun
            window.setScene(scene4);
        }

        if (event.getSource() == button6) {
            //siirtää takaisin alkuruutuun
            window.setScene(scene1);
        }

        if (event.getSource() == button7) {
            //hyllyjen pudotusvalikon nappi
            this.getShelf(choiceBox1);
        }

        if (event.getSource() == button8) {
            //vaatteiden pudotusvalikko
            this.getClothing(choiceBox2);
        }

        if (event.getSource() == button9) {
            //vaatteen valitseminen
            closet = new Closet(this.textField.getText());
            window.setScene(this.createClothingScene());
        }
    }

    private void getShelf(ChoiceBox<Integer> choiceBox) {
        this.shelfNumber = choiceBox.getValue();
        window.setScene(this.createSheflScene());
    }

    private void getClothing(ChoiceBox<String> choiceBox) {
        clothing = choiceBox.getValue();
        window.setScene(this.createClothingScene());

    }

}
