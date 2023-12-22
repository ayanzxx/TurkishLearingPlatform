package com.example.inf;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Audio {

    @FXML
    private ImageView i1;

    @FXML
    private ImageView i2;

    @FXML
    private ImageView i3;

    @FXML
    private ImageView i4;

    @FXML
    private ImageView i5;

    @FXML
    private ImageView i6;

    @FXML
    private ImageView i7;

    @FXML
    private ImageView i8;

    @FXML
    private ImageView i9;

    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;


    @FXML
    private ImageView image1;

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

        Image image2 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\playcircle_113957.png");
        i1.setImage(image2);
        Image image3 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\stop.png");
        i2.setImage(image3);
        Image image4 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\finish.png");
        i3.setImage(image4);


        String audioFile = getClass().getResource("etme.mp3").toString();
        Media media = new Media(audioFile);
        mediaPlayer = new MediaPlayer(media);

            i1.setOnMouseClicked(event -> {
                System.out.println("Start audio");
                mediaPlayer.play();
            });

            i2.setOnMouseClicked(event -> {
                System.out.println("Stop audio");
                mediaPlayer.stop();
            });

            i3.setOnMouseClicked(event -> {
                System.out.println("Finish audio");
                mediaPlayer.stop();
            });


        Image image5 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\playcircle_113957.png");
        i4.setImage(image5);
        Image image6 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\stop.png");
        i5.setImage(image6);
        Image image7 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\finish.png");
        i6.setImage(image7);


        String audioFile2 = getClass().getResource("turkish_birhazinhurriyet_hikmet_eb.mp3").toString();
        Media media2 = new Media(audioFile2);
        mediaPlayer2 = new MediaPlayer(media2);

        i4.setOnMouseClicked(event -> {
            System.out.println("Start audio");
            mediaPlayer2.play();
        });

        i5.setOnMouseClicked(event -> {
            System.out.println("Stop audio");
            mediaPlayer2.stop();
        });

        i6.setOnMouseClicked(event -> {
            System.out.println("Finish audio");
            mediaPlayer2.stop();
        });

        Image image8 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\playcircle_113957.png");
        i7.setImage(image8);
        Image image9 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\stop.png");
        i8.setImage(image9);
        Image image10 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\finish.png");
        i9.setImage(image10);


        String audioFile3 = getClass().getResource("turkish_gitmeistemem_rumi_ck.mp3").toString();
        Media media3 = new Media(audioFile3);
        mediaPlayer3 = new MediaPlayer(media3);

        i7.setOnMouseClicked(event -> {
            System.out.println("Start audio");
            mediaPlayer3.play();
        });

        i8.setOnMouseClicked(event -> {
            System.out.println("Stop audio");
            mediaPlayer3.stop();
        });

        i9.setOnMouseClicked(event -> {
            System.out.println("Finish audio");
            mediaPlayer3.stop();
        });










    }
}
