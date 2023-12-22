package com.example.inf;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class Main {
    @FXML
    private ImageView view3;
    @FXML
    private ImageView view4;
    @FXML
    private ImageView view1;
    @FXML
    private ImageView view5;
    @FXML
    private ImageView view6;
    @FXML
    private ImageView view7;
    @FXML
    private ImageView view8;
    @FXML
    private ImageView view00;
    @FXML
    private Button night;
    @FXML
    private Button b1;

    public void initialize() {


        Image image1 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\photo_2023-12-22_09-16-24 (2).jpg");
        view3.setImage(image1);
        Image image2 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\photo_2023-12-22_09-18-14.jpg");
        view4.setImage(image2);
        Image image3 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\photo_2023-12-22_09-16-24.jpg");
        view1.setImage(image3);
        Image image4 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\photo_2023-12-22_09-18-25.jpg");
        view5.setImage(image4);
        Image image5 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\photo_2023-12-22_09-18-21.jpg");
        view6.setImage(image5);
        Image image6 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\photo_2023-12-22_09-18-31.jpg");
        view7.setImage(image6);
        Image image7 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\photo_2023-12-22_09-18-36.jpg");
        view8.setImage(image7);
        Image image8 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\photo_2023-12-22_09-25-18.jpg");
        view00.setImage(image8);





        night.setOnAction(actionEvent1 -> {
            night.getScene().getWindow().hide();
            FXMLLoader gram1 = new FXMLLoader(Night.class.getResource("night.fxml"));
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

        b1.setOnAction(actionEvent1 -> {
            night.getScene().getWindow().hide();
            FXMLLoader gram1 = new FXMLLoader(Login.class.getResource("login.fxml"));
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

        view8.setOnMouseClicked(event -> {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("regispage.fxml"));
                Parent root2 = loader.load();

                Stage currentStage = (Stage) view8.getScene().getWindow();
                currentStage.close();

                Stage newStage = new Stage();
                newStage.setScene(new Scene(root2));
                newStage.setTitle("regis page");
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}