package com.example.inf;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import java.io.IOException;

public class Visual {

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private ImageView image1;

    @FXML
    private MediaView mediaView;

    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    @FXML
    private MediaView mediaView2;



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

        try {
            String videoFileName = "C:\\Users\\Admin\\IdeaProjects\\inf\\Learn Turkish.mp4";
            File file = new File(videoFileName);
            String videoFile = file.toURI().toString();

            Media media = new Media(videoFile);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        b1.setOnMouseClicked(event -> {
            System.out.println("Start video");
            mediaPlayer.play();
        });

        b2.setOnMouseClicked(event -> {
            System.out.println("Stop video");
            mediaPlayer.stop();
        });

        try {
            String videoFileName2 = "C:\\Users\\Admin\\IdeaProjects\\inf\\Lesson1.mp4";
            File file = new File(videoFileName2);
            String videoFile2 = file.toURI().toString();

            Media media2 = new Media(videoFile2);
            mediaPlayer2 = new MediaPlayer(media2);

            mediaView2.setMediaPlayer(mediaPlayer2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        b3.setOnMouseClicked(event -> {
            System.out.println("Start video");
            mediaPlayer2.play();
        });

        b4.setOnMouseClicked(event -> {
            System.out.println("Stop video");
            mediaPlayer2.stop();
        });
        System.out.println("Current Directory: " + System.getProperty("user.dir"));

    }
}
