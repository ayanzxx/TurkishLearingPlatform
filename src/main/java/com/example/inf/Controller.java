package com.example.inf;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.IOException;

 interface Lesson {
    void createLesson();
    void switchToNewPage(Stage currentStage, String fxmlPath);
}

 class VocabularyLesson implements Lesson {
    @Override
    public void createLesson() {
        System.out.println("Creating Vocabulary Lesson");
    }
    @Override
    public void switchToNewPage(Stage currentStage, String fxmlPath) {
        switchToNewPageInController(currentStage, fxmlPath);
    }
     private void switchToNewPageInController(Stage currentStage, String fxmlPath) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
             Parent root = loader.load();

             currentStage.close();

             Stage newStage = new Stage();
             newStage.setScene(new Scene(root));
             newStage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }

     }
 }
 class GrammarLesson implements Lesson {
    @Override
    public void createLesson() {
        System.out.println("Creating Grammar Lesson");
    }

    @Override
    public void switchToNewPage(Stage currentStage, String fxmlPath) {
        switchToNewPageInController(currentStage, fxmlPath);
    }

     private void switchToNewPageInController(Stage currentStage, String fxmlPath) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
             Parent root = loader.load();

             currentStage.close();

             Stage newStage = new Stage();
             newStage.setScene(new Scene(root));
             newStage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     }
 interface LessonFactory {
        Lesson createLesson();
}
 class VocabularyLessonFactory implements LessonFactory {
        @Override
        public Lesson createLesson() {
                return new VocabularyLesson();
        }
}
 class GrammarLessonFactory implements LessonFactory {
        @Override
        public Lesson createLesson() {
                return new GrammarLesson();
        }

}
interface LearningStrategy {
    void initializeStrategy(String learningStyle);
    void switchToNewPage(Stage currentStage, String fxmlPath);
}
class AudioLearningStrategy implements LearningStrategy {
    @Override
    public void initializeStrategy(String learningStyle) {
    }
    @Override
    public void switchToNewPage(Stage currentStage, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            currentStage.close();

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class VisualLearningStrategy implements LearningStrategy {
    @Override
    public void initializeStrategy(String learningStyle) {
    }
    @Override
    public void switchToNewPage(Stage currentStage, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            currentStage.close();

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Controller {

    @FXML
    private MediaView mV;

    private MediaPlayer mediaPlayer;
    private MediaView mediaView;

    private LessonFactory lessonFactory;

    @FXML
    private ComboBox<String> ComboBox1;

    @FXML
    private ComboBox<String> ComboBox2;

    @FXML
    private ComboBox<String> ComboBox3;

    @FXML
    private ComboBox<String> ComboBox4;
    @FXML
    private Button b5;

    public void setLessonFactory(LessonFactory lessonFactory) {
        this.lessonFactory = lessonFactory;
    }

    @FXML
    void select3() {

        String selectedStyle = ComboBox3.getValue();
        if ("Books".equals(selectedStyle)) {
            ComboBox3.getScene().getWindow().hide();
            FXMLLoader back = new FXMLLoader(HelloApplication.class.getResource("book.fxml"));
            try {
                back.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = back.getRoot();
            Stage stage = new Stage();
            stage.setTitle("QUIZ");
            stage.setScene(new Scene(root, 900, 600));
            stage.show();
        }}

    @FXML
    void select4() {

        String selectedStyle = ComboBox4.getValue();

        if ("Quizzes".equals(selectedStyle)) {
            ComboBox4.getScene().getWindow().hide();
            FXMLLoader back = new FXMLLoader(HelloApplication.class.getResource("testts.fxml"));
            try {
                back.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = back.getRoot();
            Stage stage = new Stage();
            stage.setTitle("QUIZ");
            stage.setScene(new Scene(root, 900, 600));
            stage.show();
        }
    }

    @FXML
    private void initialize() {
        ComboBox1.getItems().addAll("Audio", "Visual");
        ComboBox2.getItems().addAll("Grammar", "Vocabulary");
        ComboBox3.getItems().addAll("Books");
        ComboBox4.getItems().addAll("Quizzes");

        lessonFactory = new VocabularyLessonFactory();

        mediaView = new MediaView();

        Platform.runLater(() -> {
            try {
                String videoFileName = "C:\\Users\\Admin\\IdeaProjects\\inf\\Istanbul. Love of the continents __ İstanbul. Kıtaların aşkı. Drone aerial video.mp4";
                File file = new File(videoFileName);
                String videoFile = file.toURI().toString();

                Media media = new Media(videoFile);
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);

                mV.setMediaPlayer(mediaPlayer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        mV.setOnMouseClicked(event -> {
            System.out.println("Start video");
            mediaPlayer.play();
        });
        b5.setOnMouseClicked(event -> {
            System.out.println("Stop video");
            mediaPlayer.stop();
        });

        if (mediaPlayer != null) {
            mediaPlayer.setOnError(() -> {
                System.out.println("Error: " + mediaPlayer.getError());
            });
        }
    }

    @FXML
    void select2() {
        String selectedStyle = ComboBox2.getValue();
        Lesson lesson = lessonFactory.createLesson();
        lesson.createLesson();

        if ("Grammar".equals(selectedStyle)) {
            lessonFactory = new GrammarLessonFactory();
            lesson.switchToNewPage((Stage) ComboBox2.getScene().getWindow(), "/com/example/inf/grammar.fxml");

        } else if ("Vocabulary".equals(selectedStyle)) {
            lessonFactory = new VocabularyLessonFactory();
            lesson.switchToNewPage((Stage) ComboBox2.getScene().getWindow(), "/com/example/inf/vocabulary.fxml");
        }
    }

    private void switchToNewPage(Stage currentStage, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            currentStage.close();

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LearningStrategy currentStrategy;

    @FXML
    void select1() {
        String selectedStyle = ComboBox1.getValue();

        if ("Audio".equals(selectedStyle)) {
            currentStrategy = new AudioLearningStrategy();
            currentStrategy.switchToNewPage((Stage) ComboBox1.getScene().getWindow(), "/com/example/inf/audio.fxml");
        } else if ("Visual".equals(selectedStyle)) {
            currentStrategy = new VisualLearningStrategy();
            currentStrategy.switchToNewPage((Stage) ComboBox1.getScene().getWindow(), "/com/example/inf/visual.fxml");
        }

    }
 }




