package com.example.inf;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Vocabulary2 {

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;

    @FXML
    void initialize() {
        Image o = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\Снимок экрана 2023-12-19 143313.jpg");
        image1.setImage(o);



        Image image = new Image("file:C:/Users/Admin/IdeaProjects/inf/src/main/resources/com/example/inf/Снимок экрана 2023-12-16 234743.jpg");
        image2.setImage(image);

        image2.setOnMouseClicked(event -> {
            System.out.println("ImageView clicked! Switching scene...");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("vocabulary.fxml"));
                Parent root2 = loader.load();

                Stage currentStage = (Stage) image1.getScene().getWindow();
                currentStage.close();

                Stage newStage = new Stage();
                newStage.setScene(new Scene(root2));
                newStage.setTitle("main page");
                newStage.show();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }
}
