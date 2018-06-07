/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamata;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
/**
 *
 * @author Ilove
 */
public class Kamata extends Application {
 
    //tekstualna polja za levi panel
    TextField txtgodina = new TextField();
    TextField txtperiod = new TextField();
    TextField txtEks = new TextField();
    TextField txtGlavnica = new TextField();
    TextField txtRezultat1 = new TextField();
 
    //tekstualna polja za desni panel
    TextField txtperiod1 = new TextField();
    TextField txtgodina1 = new TextField();
    TextField txtEks1 = new TextField();
    TextField txtGlavnica1 = new TextField();
    TextField txtRezultat = new TextField();
 
    public static void main(String[] args) throws Exception {
        launch(args);
    }
 
    @Override
    public void start(final Stage stage) throws Exception {
 
        //levi panel
        StackPane r1 = new StackPane();
        r1.setPrefSize(300, 250);
        r1.setStyle("-fx-background-color: palegreen;");
 
        GridPane gridlevi = new GridPane();
        r1.getChildren().addAll(gridlevi);
 
        Text scenetitle1 = new Text("KOMFORNA METODA ");
        scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
 
        gridlevi.add(scenetitle1, 0, 0, 2, 1);
 
        Label lblperiod = new Label("Unesite period:");
        gridlevi.add(lblperiod, 0, 1);
 
        // TextField txtperiod = new TextField();
        gridlevi.add(txtperiod, 1, 1);
 
        Label lblgodina = new Label("Unesite godinu:");
        gridlevi.add(lblgodina, 0, 2);
 
        // TextField txtgodina = new TextField();
        gridlevi.add(txtgodina, 1, 2);
 
        Label lbleks = new Label("EKS :");
        gridlevi.add(lbleks, 0, 3);
 
        //TextField txtEks = new TextField();
        gridlevi.add(txtEks, 1, 3);
 
        Label lblGlavnica = new Label("Glavnica duga :");
        gridlevi.add(lblGlavnica, 0, 4);
 
        //TextField txtGlavnica = new TextField();
        gridlevi.add(txtGlavnica, 1, 4);
 
        Button btn1 = new Button("Izracunaj");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        gridlevi.add(hbBtn1, 1, 5);
 
        Label lblprazna = new Label("");
        gridlevi.add(lblprazna, 0, 6);
 
        Label lblprazna1 = new Label("");
        gridlevi.add(lblprazna1, 0, 7);
 
        Label lblRezultat1 = new Label("Trazeni rezultat je :");
        gridlevi.add(lblRezultat1, 0, 8);
 
        //TextField txtRezultat1 = new TextField();
        gridlevi.add(txtRezultat1, 1, 8);
 
        btn1.setOnAction(e -> {
            double rezultat1 = ProporcionalnaMetoda();
            txtRezultat1.setText(String.format("%.2f", rezultat1));
        });
 
        // desni panel
        StackPane r2 = new StackPane();
        r2.setPrefSize(300, 250);
        r2.setStyle("-fx-background-color: coral;");
 
        GridPane grid = new GridPane();
        r2.getChildren().addAll(grid);
 
        Text scenetitle2 = new Text("PROPORCIONALNA METODA ");
        scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
 
        grid.add(scenetitle2, 0, 0, 2, 1);
 
        Label lblperiod1 = new Label("Unesite period:");
        grid.add(lblperiod1, 0, 1);
 
        //TextField txtperiod1 = new TextField();
        grid.add(txtperiod1, 1, 1);
 
        Label lblgodina1 = new Label("Unesite godinu:");
        grid.add(lblgodina1, 0, 2);
 
        //TextField txtgodina1 = new TextField();
        grid.add(txtgodina1, 1, 2);
 
        Label lbleks1 = new Label("EKS :");
        grid.add(lbleks1, 0, 3);
 
        //TextField txtEks1 = new TextField();
        grid.add(txtEks1, 1, 3);
 
        Label lblGlavnica1 = new Label("Glavnica duga :");
        grid.add(lblGlavnica1, 0, 4);
 
        //TextField txtGlavnica1 = new TextField();
        grid.add(txtGlavnica1, 1, 4);
 
        Button btn = new Button("Izracunaj");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);
 
        Label lblRazmak = new Label("");
        grid.add(lblRazmak, 0, 6);
 
        Label lblRazmak1 = new Label("");
        grid.add(lblRazmak1, 0, 7);
 
        Label lblRezultat = new Label("Trazeni rezultat je :");
        grid.add(lblRezultat, 0, 8);
 
        //TextField txtRezultat = new TextField();
        grid.add(txtRezultat, 1, 8);
 
        btn.setOnAction(e -> {
            double rezultat = KomfornaMetoda();
            txtRezultat.setText(String.format("%.2f", rezultat));
        });
 
        // glavni panel
        SplitPane split = new SplitPane();
        split.getItems().setAll(
                r1, r2
        );
        split.setStyle("-fx-box-border: transparent;");
 
        StackPane layout = new StackPane();
        layout.getChildren().setAll(split);
        layout.setStyle("-fx-padding: 20px; -fx-background-color: cornsilk");
 
        stage.setScene(new Scene(layout));
        stage.show();
    }
 
    private double ProporcionalnaMetoda() {
 
        double godina = Double.parseDouble(txtgodina.getText());
        double period = Double.parseDouble(txtperiod.getText());
        double Eks = Double.parseDouble(txtEks.getText());
        double Glavnica = Double.parseDouble(txtGlavnica.getText());
 
        double kamata;
        kamata = (Math.pow(1 + Eks, (period / godina)) - 1) * Glavnica;
 
        return kamata;
 
        //throw new UnsupportedOperationException("Not supported yet.");
    }
 
    private double KomfornaMetoda() {
 
        double godina = Double.parseDouble(txtgodina1.getText());
        double period = Double.parseDouble(txtperiod1.getText());
        double Eks = Double.parseDouble(txtEks1.getText());
        double Glavnica = Double.parseDouble(txtGlavnica1.getText());
 
        double kamata;
        
       
        
        kamata = Eks * (period / godina) * Glavnica;
 
        return kamata;
 
    }
 
    
}