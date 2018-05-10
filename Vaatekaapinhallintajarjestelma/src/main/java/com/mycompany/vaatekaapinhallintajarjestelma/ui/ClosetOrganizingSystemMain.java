package com.mycompany.vaatekaapinhallintajarjestelma.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ClosetOrganizingSystemMain extends Application implements EventHandler<ActionEvent> {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    Stage window;
    Scene scene1, scene2, scene3, scene4;

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
        scene4 = this.creatClosetScene();

        primaryStage.setScene(scene1);
        primaryStage.show();
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

    public Scene creatClosetScene() {
        //puuttuu kaikenlaista vielä
        Label label = new Label("Kaappi");

        button6 = new Button();
        button6.setText("Takaisin alkuun");
        button6.setOnAction(this);
        
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    public Scene creatClosetCreationScene() {
        //puuttuu kaikenlaista vielä
        Label label = new Label("Täällä voit luoda kaapin.");

        button3 = new Button();
        button3.setText("Luo kaappi");
        button3.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, button3);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 400, 150);
    }

    public Scene creatClothingCreationScene() {
        //puuttuu kaikenlaista vielä
        Label label = new Label("Täällä voit luoda vaatteen ja lisätä sen hyllyyn.");

        button4 = new Button();
        button4.setText("Luo vaate");
        button4.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        vbox.getChildren().addAll(label, button4);
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
            //kaapin luonti
            //palautus alkuruutuun
            window.setScene(scene1);
        }

        if (event.getSource() == button4) {
            //vaatteen luonti
            //palautus alkuruutuun
            window.setScene(scene1);
        }
        
        if (event.getSource() == button5) {
            //siirtää kaappi ruutuun
            window.setScene(scene4);
        }
        
        if (event.getSource() == button6) {
            //siirtää takaisin alkuruutuun
            window.setScene(scene1);
        }
    }

}
