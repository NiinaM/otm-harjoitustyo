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
    Closet niinasCloset;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Testidatan syöttämisen kutsuminen
        this.testData();
        primaryStage.setTitle("Vaattekaappi");
        Scene scene = this.createStartScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Scene createStartScene() {

        button1 = new Button();
        button1.setText("Vaatteiden yhteisarvo");
        button1.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button1);

        return new Scene(layout, 400, 400);

    }

    //Testidatan syöttäminen
    private void testData() {
        Clothing redTrousers = new Clothing("punaiset housut", ColorsEnum.PUNAINEN, ConditionEnum.UUSI, 32, SizeEnum.XSMALL, TypeEnum.HOUSUT, IsItLaundryEnum.PUHDAS, 30, MaterialsEnum.AKRYYLI);
        System.out.println(redTrousers.toString());

        niinasCloset = new Closet("Niina");
        niinasCloset.addClothing(redTrousers);
        System.out.println(niinasCloset.valueOfAllTheItemsInCloset());

        redTrousers.setCondition(ConditionEnum.RIKKI);
        System.out.println(redTrousers.getCondition());

        niinasCloset.addClothing(new Clothing("siniset housut", ColorsEnum.SININEN, ConditionEnum.EHJA, 34, SizeEnum.SMALL, TypeEnum.HOUSUT, IsItLaundryEnum.KAYTETTY, 50, MaterialsEnum.AKRYYLI));
        System.out.println("Kaapissa on housuja " + niinasCloset.howManyOfTheseItemsInCloset(TypeEnum.HOUSUT) + " kappaletta.");
    }

    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == button1) {
            System.out.println(niinasCloset.valueOfAllTheItemsInCloset());
        }
    }

}
