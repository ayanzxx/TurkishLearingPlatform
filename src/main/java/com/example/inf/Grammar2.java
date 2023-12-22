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

public class Grammar2 {

    @FXML
    private ImageView Image_back;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    public void initialize() {
        Image image = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\degrees_of_comparison.jpg");
        image1.setImage(image);

        Image image5 = new Image("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\plurals.jpg");
        image2.setImage(image5);

        textArea1.setText("     We use Degrees of Comparison to compare people, places or things. " +
                        "An adjective can have one of three forms: Positive, Comparitive or Superlative. " +
                        "For example, for the adjective <big> the Positive form would be <big> itself, the Comparitive" +
                        "form would be <bigger> and the Superlative form would be <biggest>." +

                 " In Turkish, we express the Comparitive form using <daha> and the Superlative form using <en>."+
                        " For example, for the adjective <büyük> the Positive form would be <büyük> itself, the Comparitive " +
          " form would be <daha büyük> and the Superlative form would be <en büyük>");

        textArea1.setEditable(false);
        textArea1.setWrapText(true);


        textArea2.setText("The plural suffixes in Turkish are -lar and -ler. We use the rules of Major Vowel " +
                "Harmony to decide which suffix to use. Words whose last vowel is one of (a, ı, o, u) " +
                "will get -lar added to it, while those whose last vowel is one of (e, i, ö, ü) will be followed by -ler.");
        textArea2.setEditable(false);
        textArea2.setWrapText(true);


        Image image8 = new Image("file:C:/Users/Admin/IdeaProjects/inf/src/main/resources/com/example/inf/Снимок экрана 2023-12-16 234743.jpg");
        Image_back.setImage(image8);

        Image_back.setOnMouseClicked(event -> {
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
    }



}
