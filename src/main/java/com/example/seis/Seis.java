package com.example.seis;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Seis extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StackPane paneeli = new StackPane();

        Polygon monikulmio = new Polygon();     //Ensimmäinen 6-kulmio
        paneeli.getChildren().add(monikulmio);
        monikulmio.setFill(Color.WHITE);
        monikulmio.setStroke(Color.BLACK);
        monikulmio.setRotate(30);
        ObservableList lista = monikulmio.getPoints();
        StackPane.setAlignment(monikulmio, Pos.CENTER);

        final double Leveys = 250, Korkeus = 250;
        double keskusX = Leveys/2, keskusY = Korkeus/2;
        double sade = Math.min(Leveys, Korkeus) * 0.4;

        for (int i = 0; i<6; i++) {
            lista.add(keskusX - sade*Math.cos(2*i*Math.PI/6));
            lista.add(keskusY - sade*Math.sin(2*i*Math.PI/6));
        }
        Polygon monikulmio1 = new Polygon();    //Toinen 6-kulmio
        paneeli.getChildren().add(monikulmio1);
        monikulmio1.setFill(Color.RED);
        monikulmio1.setStroke(Color.BLACK);
        monikulmio1.setRotate(30);
        ObservableList lista1 = monikulmio1.getPoints();
        StackPane.setAlignment(monikulmio1, Pos.CENTER);

        final double Leveys1 = 200, Korkeus1 = 200;
        double keskusX1 = Leveys/2, keskusY1 = Korkeus/2;
        double sade1 = Math.min(Leveys1, Korkeus1) * 0.4;

        for (int i = 0; i<6; i++) {
            lista1.add(keskusX1 - sade1*Math.cos(2*i*Math.PI/6));
            lista1.add(keskusY1 - sade1*Math.sin(2*i*Math.PI/6));
        }

        Text seis = new Text("SEIS");      //Lisätään teksti
        seis.setFont(Font.font("Calibri", FontWeight.BOLD, 55));
        seis.setFill(Color.WHITE);
        paneeli.getChildren().add(seis);

        Scene kehys = new Scene(paneeli, 400, 400);
        stage.setTitle("SEIS!");
        stage.setScene(kehys);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}