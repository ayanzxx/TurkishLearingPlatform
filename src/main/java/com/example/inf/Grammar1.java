package com.example.inf;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Grammar1 {
@FXML
private TextArea textArea1;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    public void initialize() {
        Image image = new Image("file:C:/Users/Admin/IdeaProjects/inf/src/main/resources/com/example/inf/Снимок экрана 2023-12-16 234743.jpg");
        image1.setImage(image);

        textArea1.setText("     The Turkish alphabet consists of 29 letters. It follows the order of" +
                " the Latin alphabet with some additions. The English alphabet does not have the six of" +
                " the 29 letters (Ü, İ, Ö, Ç, Ğ, Ş) in the Turkish alphabet. The Turkish Alphabet, conversely," +
                " does not have the three letters (Q, X, W) that are present in the English alphabet");

        textArea1.setEditable(false);


        image1.setOnMouseClicked(event -> {
            System.out.println("ImageView clicked! Switching scene...");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("grammar.fxml"));
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

        Image imageM= new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\turkish-alphabet.jpg");
            image2.setImage(imageM);
    }

}
