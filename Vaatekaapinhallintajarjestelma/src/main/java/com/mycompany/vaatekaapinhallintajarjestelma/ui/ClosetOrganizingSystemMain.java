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
        Scene scene = this.createStartScene();
        primaryStage.setScene(scene);
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

        StackPane layout = new StackPane();
        //en ole varma miten nämä toteutetaan oikein, niin etteivät mene päällekäin
        layout.getChildren().add(button1);
        layout.getChildren().add(button2);
        layout.getChildren().add(button3);

        return new Scene(layout, 400, 400);

    }

    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == button1) {
            //testi vielä, oikeasti käyttäjältä pyydetään kaapin omistaja sekä kaapin nimi
            Closet newCloset = new Closet("Niina");
        }

        if (event.getSource() == button2) {
            //testi vielä oikeasti käyttäjältä pyydetään tiedot(enumit voisivat olla pudotusvalikoissa)
            Clothing newClothing = new Clothing("Punainen paita", ColorsEnum.PUNAINEN, ConditionEnum.EHJA, 32, SizeEnum.XSMALL, TypeEnum.TPAITA, IsItLaundryEnum.KAYTETTY, 10, MaterialsEnum.LYKRA);
        }

        if (event.getSource() == button3) {
            //en ole varma miten toteutan, koska tässä pitäisi listata vaatekaapit ja ne ovat tiedossa tietokannassa, jos liian vaikeaa, niin jätetään pois
        }
    }

}
