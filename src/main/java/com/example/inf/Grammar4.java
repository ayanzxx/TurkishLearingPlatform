package com.example.inf;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Grammar4 {
    @FXML
    private ImageView Image_back;

    @FXML
    private ImageView image3;
@FXML
TextArea textArea;
    @FXML
    void initialize() {
        textArea.setEditable(false);

        Image i = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\7946029dc1b92a98796c00c37bce7378.jpg");
        image3.setImage(i);

        Image image8 = new Image("file:C:/Users/Admin/IdeaProjects/inf/src/main/resources/com/example/inf/Снимок экрана 2023-12-16 234743.jpg");
        Image_back.setImage(image8);

        Image_back.setOnMouseClicked(event -> {
            System.out.println("ImageView clicked! Switching scene...");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("grammar.fxml"));
                Parent root2 = loader.load();
                Stage currentStage = (Stage) Image_back.getScene().getWindow();
                currentStage.close();
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root2));
                newStage.setTitle("main page");
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
