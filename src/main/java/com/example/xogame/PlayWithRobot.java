package com.example.xogame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void homepage(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Pane pane=new Pane();
        pane.getChildren().add(fxmlLoader.load());
        Button b=new Button("Play with friend");
        b.setFont(Font.font("Snap ITC"));
        Button pRopot=new Button("Play with Robot");
        pRopot.setFont(Font.font("Snap ITC"));

        b.setOnAction(e->{
            FXMLLoader fxx = new FXMLLoader(HelloApplication.class.getResource("playWithFriendScene.fxml"));
            Pane pn =new Pane();
            Button closB=new Button("Close");
            closB.setFont(Font.font("Snap ITC"));
            closB.setOnAction(e2->{
                try {
                    homepage(stage);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            closB.setLayoutX(30);
            closB.setLayoutY(30);
            closB.setFont(Font.font("Snap ITC"));
            closB.setBackground(Background.fill(Color.valueOf("FEFBF6")));

            try {
                pn.getChildren().add(fxx.load());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            pn.getChildren().add(closB);
            Scene s=new Scene(pn,500,630);
            stage.setScene(s);

        });

        pRopot.setOnAction(pr->{
            FXMLLoader fx = new FXMLLoader(HelloApplication.class.getResource("playWithRobot.fxml"));
            Pane pn2 =new Pane();
            Button closC=new Button("Close");
            closC.setFont(Font.font("Snap ITC"));
            closC.setOnAction(e3->{
                try {
                    homepage(stage);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            closC.setLayoutX(30);
            closC.setLayoutY(30);
            closC.setFont(Font.font("Snap ITC"));
            closC.setBackground(Background.fill(Color.valueOf("FEFBF6")));

            try {
                pn2.getChildren().add(fx.load());
                pn2.getChildren().add(closC);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Scene s1=new Scene(pn2,500,630);
            stage.setScene(s1);

        });

        pRopot.setLayoutX(275);
        pRopot.setLayoutY(80);
        pRopot.setMinHeight(40);
        pRopot.setMinWidth(180);


        b.setLayoutX(40);
        b.setLayoutY(80);
        b.setMinHeight(40);
        b.setMinWidth(180);
        pRopot.setBackground(Background.fill(Color.valueOf("FEFBF6")));
        b.setBackground(Background.fill(Color.valueOf("FEFBF6")));
        pane.getChildren().add(b);
        pane.getChildren().add(pRopot);
        Scene scene = new Scene(pane, 500, 630);

        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);

    }
    @Override
    public void start(Stage stage) throws IOException {
       homepage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
