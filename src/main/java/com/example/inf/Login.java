package com.example.inf;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.*;

public class Login {

    private static final String REMEMBER_FILE = "C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\Userss";

    @FXML
    private Button forgetPassord;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;


    @FXML
    private TextField userName;
    @FXML
    void initialize() {
        register.setOnMouseClicked(event -> {
            register.getScene().getWindow().hide();
            FXMLLoader forSignUp = new FXMLLoader(HelloApplication.class.getResource("regispage.fxml"));
            try {
                forSignUp.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = forSignUp.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root ,900 , 600));
            stage.show();
        });
        forgetPassord.setOnMouseClicked(event -> {
            forgetPassord.getScene().getWindow().hide();
            FXMLLoader Sign = new FXMLLoader(HelloApplication.class.getResource("FORGOT.fxml"));
            try {
                Sign.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = Sign.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Forget_Password");
            stage.setScene(new Scene(root ,900 , 600));
            stage.show();
        });
        login.setOnMouseClicked(event -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\Userss"))) {
                String line;
                String User = userName.getText().trim();
                String Password = password.getText().trim();
                if(!User.matches("[a-zA-Zа-яА-Я ]+" ) || Password.length()>9){
                    System.out.println("No");
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setHeaderText(null);
                    alert1.setContentText("Write field empty or\n" +"Name is only string and password is not longer than 9");
                    alert1.showAndWait();
                    return;
                }
                boolean loginSuccessful = false;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Username: ")) {
                        String savedUsername = line.substring("Username: ".length()).trim();
                        line = reader.readLine(); // skip the next line ("Email: ...")
                        line = reader.readLine(); // read the password line
                        String savedPassword = line.substring("Password: ".length()).trim();
                        // String savedPassword = line.substring("Password: ".length()).trim();
                        if (User.equals(savedUsername) && Password.equals(savedPassword)) {
                            System.out.println("Login Successful!");
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("Success");
                            alert.setContentText("Login Successful!");
                            alert.showAndWait();
                            loginSuccessful = true;

                        }
                    }
                }
                reader.close();
                if (loginSuccessful) {
                    Parent root = FXMLLoader.load(getClass().getResource("page_fxml.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                    Alert alert= new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Invalid username or password");
                    alert.showAndWait();
                }
            } catch (IOException e) {
                System.err.println("Error occurred while reading user data file.");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error occurred while logging in.");
                e.printStackTrace();
            }
        });
    }

}