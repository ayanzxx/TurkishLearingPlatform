package com.example.inf;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Book {

    @FXML
    private Button c1, c2, c3; // Complete buttons

    @FXML
    private Button s1, s2, s3; // Start buttons

    @FXML
    private ImageView i1; // Assuming this is for displaying book cover or status

    private LessonContext lessonContext; // Each book has its own LessonContext

    public Book() {
        lessonContext = new LessonContext();
    }

    @FXML
    void initialize() {

        Image image = new Image("file:C:/Users/Admin/IdeaProjects/inf/src/main/resources/com/example/inf/Снимок экрана 2023-12-16 234743.jpg");
        i1.setImage(image);

        i1.setOnMouseClicked(event -> {
            System.out.println("ImageView clicked! Switching scene...");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("page_fxml.fxml"));
                Parent root2 = loader.load();

                Stage currentStage = (Stage) i1.getScene().getWindow();
                currentStage.close();

                Stage newStage = new Stage();
                newStage.setScene(new Scene(root2));
                newStage.setTitle("main page");
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Bind start and complete buttons to their respective methods
        s1.setOnAction(e -> startLesson());
        s1.setOnAction(actionEvent1 -> {
            s1.getScene().getWindow().hide();
            FXMLLoader gram1 = new FXMLLoader(Grammar1.class.getResource("book1.fxml"));
            try {
                gram1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent parent = gram1.getRoot();
            Stage stage = new Stage();
            System.out.println("Lesson is started and in progress");

            stage.setScene(new Scene(parent));
            stage.show();
        });
        s2.setOnAction(e -> startLesson());
        s2.setOnAction(actionEvent1 -> {
            s2.getScene().getWindow().hide();
            FXMLLoader gram1 = new FXMLLoader(Grammar1.class.getResource("book2.fxml"));
            try {
                gram1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent parent = gram1.getRoot();
            Stage stage = new Stage();
            System.out.println("Lesson is started and in progress");
            stage.setScene(new Scene(parent));
            stage.show();
        });
        s3.setOnAction(e -> startLesson());
        s3.setOnAction(actionEvent1 -> {
            s2.getScene().getWindow().hide();
            FXMLLoader gram1 = new FXMLLoader(Grammar1.class.getResource("book3.fxml"));
            try {
                gram1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent parent = gram1.getRoot();
            Stage stage = new Stage();
            System.out.println("Lesson is started and in progress");
            stage.setScene(new Scene(parent));
            stage.show();
        });
        c1.setOnAction(e -> completeLesson());
        c2.setOnAction(e -> completeLesson());
        c3.setOnAction(e -> completeLesson());
    }

    private void startLesson() {
        lessonContext.startLesson();
        System.out.println("Lesson is started and in progress");
    }
    private void completeLesson() {
        lessonContext.completeLesson();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Lesson is completed.");
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}



interface LessonState {
    void startLesson(LessonContext context);

    void completeLesson(LessonContext context);

    void start(LessonContext context);

    void complete(LessonContext context);
}


class InProgressState implements LessonState {

    public void startLesson(LessonContext context) {
        System.out.println("The lesson is already in progress.");
    }


    public void completeLesson(LessonContext context) {
        System.out.println("Completing the lesson.");
        context.setState(new CompletedState());
    }

    @Override
    public void start(LessonContext context) {

    }

    @Override
    public void complete(LessonContext context) {

    }
}

class CompletedState implements LessonState {

    public void startLesson(LessonContext context) {
        System.out.println("Restarting the lesson.");
        context.setState(new InProgressState());
    }
    public void completeLesson(LessonContext context) {
        System.out.println("The lesson is already completed.");
    }
    @Override
    public void start(LessonContext context) {
    }
    @Override
    public void complete(LessonContext context) {

    }
}

class LessonContext {
    private LessonState state;
    public LessonContext() {
        state = new InProgressState();
    }
    public void setState(InProgressState state) {
        this.state = state;
    }
    public void startLesson() {
        state.startLesson(this);
    }
    public void completeLesson() {
        state.completeLesson(this);
    }

    public void setState(CompletedState completedState) {
    }
}
