package com.example.inf;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Grammar {
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private ImageView image1;



    @FXML
    public void initialize() {
        Image image = new Image("file:C:/Users/Admin/IdeaProjects/inf/src/main/resources/com/example/inf/Снимок экрана 2023-12-16 234743.jpg");
        image1.setImage(image);

        image1.setOnMouseClicked(event -> {
            System.out.println("ImageView clicked! Switching scene...");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("page_fxml.fxml"));
                Parent root2 = loader.load();

                Stage currentStage = (Stage) image1.getScene().getWindow();
                currentStage.close();

                Stage newStage = new Stage();
                newStage.setScene(new Scene(root2));
                newStage.setTitle("main page");
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        button1.setOnAction(actionEvent1 -> {
            button1.getScene().getWindow().hide();
            FXMLLoader gram1 = new FXMLLoader(Grammar1.class.getResource("grammar1.fxml"));
            try {
                gram1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent parent = gram1.getRoot();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();
        });

    button2.setOnAction(actionEvent1 -> {
        button1.getScene().getWindow().hide();
        FXMLLoader gram1 = new FXMLLoader(Grammar1.class.getResource("grammar2.fxml"));
        try {
            gram1.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = gram1.getRoot();
        Stage stage = new Stage();

        stage.setScene(new Scene(parent));
        stage.show();
    });

    button3.setOnAction(actionEvent1 -> {
        button1.getScene().getWindow().hide();
        FXMLLoader gram1 = new FXMLLoader(Grammar1.class.getResource("grammar3.fxml"));
        try {
            gram1.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = gram1.getRoot();
        Stage stage = new Stage();

        stage.setScene(new Scene(parent));
        stage.show();
    });

    button4.setOnAction(actionEvent1 -> {
        button1.getScene().getWindow().hide();
        FXMLLoader gram1 = new FXMLLoader(Grammar1.class.getResource("grammar4.fxml"));
        try {
            gram1.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = gram1.getRoot();
        Stage stage = new Stage();

        stage.setScene(new Scene(parent));
        stage.show();
    });
}
}






