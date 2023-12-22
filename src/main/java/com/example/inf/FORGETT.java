package com.example.inf;


import java.io.*;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FORGETT {
    @FXML
    private TextField emailField;
    @FXML
    private Button entersms;
    @FXML
    private Button goback;
    @FXML
    private Button send;

    @FXML
    private TextField smslField1;
    String num;
    String s;
    String f;
    @FXML
    void initialize() {
        send.setOnMouseClicked(event -> {
            String email = emailField.getText().trim();
            Random random = new Random();
            int a = random.nextInt(10);
            int b = random.nextInt(10);
            int c = random.nextInt(10);
            int d = random.nextInt(10);
            num = a + "" + b +"" + c+""+d;
            if (email.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter your email address.");
                alert.showAndWait();
                return;
            }

            try

                    (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\Userss"))) {
                String line ;
                String emaill = emailField.getText().trim();
                boolean loginSuccessful = false;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Username: ")) {
                        line = reader.readLine();
                        String savedEmail = line.substring("Email: ".length()).trim();
                        line = reader.readLine(); // read the password line
                        if (emaill.equals(savedEmail)) {
                            System.out.println("In this Email have code "+ savedEmail);
                            Alert alertt = new Alert(Alert.AlertType.INFORMATION);
                            alertt.setTitle("Success");
                            alertt.setHeaderText(null);
                            alertt.setContentText("SMS:"+num+"\nIn this Email have password "+"\nPlease dont show this sms to everyone" +
                                    "\nand write this sms after you can show your password");
                            alertt.showAndWait();
                            System.out.println(num);
                            loginSuccessful = true;
                            entersms.setOnMouseClicked(event1 -> {
                                String sms = smslField1.getText().trim();
                                if (Objects.equals(sms, num)) {
                                    try {
                                        Scanner scanner = new Scanner(new File("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\Userss"));
                                        while (scanner.hasNextLine()) {
                                            f = scanner.nextLine();
                                            if (f.equals("Email: " + emaill)) {
                                                s = scanner.nextLine();
                                                System.out.println(s);
                                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                alert.setTitle("Success");
                                                alert.setHeaderText(null);
                                                alert.setContentText("SMS is right. Your password is " + s);
                                                // System.out.println(savedPassword);
                                                alert.showAndWait();
                                                System.out.println("Everything is ok");

                                            }
                                        }
                                    } catch(FileNotFoundException e){
                                        throw new RuntimeException(e);
                                    }
                                    entersms.getScene().getWindow().hide();
                                    FXMLLoader SignUp = new FXMLLoader(FORGETT.class.getResource("page_fxml.fxml"));
                                    try {
                                        SignUp.load();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Parent root = SignUp.getRoot();
                                    Stage stage = new Stage();
                                    stage.setTitle("Forget_Password");
                                    stage.setScene(new Scene(root ,900 , 600));
                                    stage.show();
                                }
                                if (!sms.equals(num)) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Error");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Wrong sms code!");
                                    alert.showAndWait();
                                }

                            });

                        }
                    }
                }reader.close();
                boolean loginSuccessfull = loginSuccessful;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("An error occurred while resetting your password.");
                alert.showAndWait();
                System.err.println("Error occurred while logging in.");
                e.printStackTrace();

            }
        });
        goback.setOnMouseClicked(event2 -> {
            goback.getScene().getWindow().hide();
            FXMLLoader back = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            try {
                back.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = back.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root, 900, 600));
            stage.show();
        });
    }

}