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
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Closet;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.MaterialsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ColorsEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.Clothing;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.ConditionEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.IsItLaundryEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.SizeEnum;
import com.mycompany.vaatekaapinhallintajarjestelma.domain.TypeEnum;
import javafx.scene.layout.VBox;

public class ClosetOrganizingSystemMain extends Application implements EventHandler<ActionEvent> {

    Button button1;
    Button button2;
    Button button3;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Vaatekaapinhallintajärjestelmä");
        Scene scene1 = this.createStartScene();
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

        button3 = new Button();
        button3.setText("Listaa kaapit");
        button3.setOnAction(this);

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        //en ole varma miten nämä toteutetaan oikein, niin etteivät mene päällekäin
        vbox.getChildren().addAll(button1, button2, button3);
        StackPane layout = new StackPane(vbox);

        return new Scene(layout, 150, 150);

    }

    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == button1) {
            //siirtää kaapin luomis ruutuun
        }

        if (event.getSource() == button2) {
            //siirtää vaatteen luomisruutuun
        }

        if (event.getSource() == button3) {
            //en ole varma miten toteutan, koska tässä pitäisi listata vaatekaapit ja ne ovat tiedossa tietokannassa, jos liian vaikeaa, niin jätetään pois
        }
    }

}
