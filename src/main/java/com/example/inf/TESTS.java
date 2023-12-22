package com.example.inf;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;


interface GamifiedLearningModule {
    void integrateModule();
}
interface Lesson1 {
    void study();
}
class BaseLesson implements Lesson1 {
    @Override
    public void study() {
        System.out.println("Studying the base lesson...");
    }
}
class QuizModule implements GamifiedLearningModule {
    private final Lesson1 lesson;

    public QuizModule(Lesson1 lesson) {
        this.lesson = lesson;
    }

    @Override
    public void integrateModule() {
        System.out.println("Adding quiz functionality...");
        lesson.study();
    }
}
class RewardModule implements GamifiedLearningModule, Lesson1 {
    private final Lesson1 lesson;

    public RewardModule(Lesson1 lesson) {
        this.lesson = lesson;
    }

    @Override
    public void integrateModule() {
        System.out.println("Adding reward functionality...");
        lesson.study();
    }
    @Override
    public void study() {
    }
}

public class TESTS {

    @FXML
    private Button back;

    @FXML
    private CheckBox chose;

    @FXML
    private CheckBox chose1;

    @FXML
    private CheckBox chose11;

    @FXML
    private CheckBox chose12;

    @FXML
    private CheckBox chose13;

    @FXML
    private CheckBox chose2;

    @FXML
    private Button saveing;

    @FXML
    private CheckBox tan1;

    @FXML
    private CheckBox tan10;

    @FXML
    private CheckBox tan11;

    @FXML
    private CheckBox tan12;

    @FXML
    private CheckBox tan13;

    @FXML
    private CheckBox tan14;

    @FXML
    private CheckBox tan16;

    @FXML
    private CheckBox tan17;

    @FXML
    private CheckBox tan18;

    @FXML
    private CheckBox tan19;

    @FXML
    private CheckBox tan2;

    @FXML
    private CheckBox tan20;

    @FXML
    private CheckBox tan21;

    @FXML
    private CheckBox tan22;

    @FXML
    private CheckBox tan23;

    @FXML
    private CheckBox tan24;

    @FXML
    private CheckBox tan25;

    @FXML
    private CheckBox tan3;

    @FXML
    private CheckBox tan4;

    @FXML
    private CheckBox tan5;

    @FXML
    private CheckBox tan6;

    @FXML
    private CheckBox tan7;

    @FXML
    private CheckBox tan8;

    @FXML
    private CheckBox tan9;

    @FXML
    private Label pointsLabel;

    private int points = 0;

    private GamifiedLearningModule gamifiedModule;

    @FXML
    void initialize() {

        Lesson1 baseLesson = new BaseLesson();
        gamifiedModule = new QuizModule(new RewardModule(baseLesson));
        saveing.setOnAction(event -> handleSaveButtonClick());

        back.setOnMouseClicked(event2 -> {
            back.getScene().getWindow().hide();
            FXMLLoader back = new FXMLLoader(Controller.class.getResource("page_fxml.fxml"));
            try {
                back.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = back.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 900, 600));
            stage.show();
        });
    }

    private void handleSaveButtonClick() {

        gamifiedModule.integrateModule();
        pointsLabel.setText("Points: " + points);
        boolean isChose2Selected = chose2.isSelected();
        boolean isChose13Selected = chose13.isSelected();
        boolean isChoseSelected = chose.isSelected();
        boolean isChose1Selected = chose1.isSelected();
        boolean isChose11Selected = chose11.isSelected();
        boolean isChose12Selected = chose12.isSelected();
        boolean istan1 = tan1.isSelected();
        boolean istan2 = tan2.isSelected();
        boolean istan3 = tan3.isSelected();
        boolean istan4 = tan4.isSelected();
        boolean istan5 = tan5.isSelected();
        boolean istan6 = tan6.isSelected();
        boolean istan7 = tan7.isSelected();
        boolean istan8 = tan8.isSelected();
        boolean istan9 = tan9.isSelected();
        boolean istan10 = tan10.isSelected();
        boolean istan11 = tan11.isSelected();
        boolean istan12 = tan12.isSelected();
        boolean istan14 = tan13.isSelected();
        boolean istan16 = tan16.isSelected();
        boolean istan17 = tan17.isSelected();
        boolean istan18 = tan18.isSelected();
        boolean istan19 = tan19.isSelected();
        boolean istan20 = tan20.isSelected();
        boolean istan21 = tan21.isSelected();
        boolean istan22 = tan22.isSelected();
        boolean istan23 = tan23.isSelected();
        boolean istan24 = tan24.isSelected();
        boolean istan25 = tan25.isSelected();

        boolean areAnswersCorrect = isChose2Selected && isChose13Selected;
        boolean areAnswersMistake = isChoseSelected && isChose1Selected && isChose11Selected && isChose12Selected;

        if(isChose2Selected){
            chose2.setStyle("-fx-background-color: green;");
            points+=10;

            pointsLabel.setText("Points: " + points);
        }
        if(isChose13Selected){
            chose13.setStyle("-fx-background-color: green;");
            points+=10;
            pointsLabel.setText("Points: " + points);
        }if(istan3){
            tan3.setStyle("-fx-background-color: green;");
            points+=10;
            pointsLabel.setText("Points: " + points);
        }if(istan5){
            tan5.setStyle("-fx-background-color: green;");
            points+=10;
            pointsLabel.setText("Points: " + points);
        }if(istan7){
            tan7.setStyle("-fx-background-color: green;");
            points+=10;
            pointsLabel.setText("Points: " + points);
        }if(istan11){
            tan11.setStyle("-fx-background-color: green;");
            points+=10;
            pointsLabel.setText("Points: " + points);
        }if(istan16){
            tan16.setStyle("-fx-background-color: green;");
            points+=10;
            pointsLabel.setText("Points: " + points);
        }if(istan18){
            tan18.setStyle("-fx-background-color: green;");
            points+=10;
            pointsLabel.setText("Points: " + points);
        }if(istan20){
            tan20.setStyle("-fx-background-color: green;");
            points+=10;
            pointsLabel.setText("Points: " + points);
        }if(istan25){
            tan25.setStyle("-fx-background-color: green;");
            points+=10;
            pointsLabel.setText("Points: " + points);
        }


        if(istan1){
            tan1.setStyle("-fx-background-color: red;");
        }if(istan2){
            tan2.setStyle("-fx-background-color: red;");
        }if(istan4){
            tan4.setStyle("-fx-background-color: red;");
        }if(istan6){
            tan6.setStyle("-fx-background-color: red;");
        }if(istan8){
            tan8.setStyle("-fx-background-color: red;");
        }if(istan9){
            tan9.setStyle("-fx-background-color: red;");
        }if(istan10){
            tan10.setStyle("-fx-background-color: red;");
        }if(istan12){
            tan12.setStyle("-fx-background-color: red;");
        }if(istan14){
            tan14.setStyle("-fx-background-color: red;");
        }if(istan17){
            tan17.setStyle("-fx-background-color: red;");
        }if(istan19){
            tan19.setStyle("-fx-background-color: red;");
        }if(istan21){
            tan21.setStyle("-fx-background-color: red;");
        }if(istan22){
            tan22.setStyle("-fx-background-color: red;");
        }if(istan23){
            tan23.setStyle("-fx-background-color: red;");
        }if(istan24){
            tan24.setStyle("-fx-background-color: red;");
        }


        if(isChoseSelected){
            chose.setStyle("-fx-background-color: red;");
        }if(isChose1Selected){
            chose1.setStyle("-fx-background-color: red;");
        }if(isChose11Selected){
            chose11.setStyle("-fx-background-color: red;");
        }if(isChose12Selected){
            chose12.setStyle("-fx-background-color: red;");
        }
        if (areAnswersCorrect) {
            chose2.setStyle("-fx-background-color: green;");
            chose13.setStyle("-fx-background-color: green;");
        }
    }

}