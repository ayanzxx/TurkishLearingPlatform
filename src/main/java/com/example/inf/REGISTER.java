package com.example.inf;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Observer {
    void update(String username);
}
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String username);
}

class UserRegistrationObservable implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String username) {
        for (Observer observer : observers) {
            observer.update(username);
        }
    }
}
public class REGISTER extends UserRegistrationObservable implements Observer {

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button confirmPasswordField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button goback;

    @FXML
    private TextField usernameField;

    public void   createFolder(){
        File folder = new File("Userss.txt");
        if (!folder.exists()) {
            folder.mkdir();
            System.out.println("Folder created at " + "Userss.txt");
        } else {
            System.out.println("Folder already exists at " + "Userss.txt");
        }
    }

    @FXML
    void initialize() {
        createFolder();
        confirmPasswordField.setOnMouseClicked(event -> {
            String User = usernameField.getText().trim();
            String Password = PasswordField.getText().trim();
            try {
                File file = new File("Userss.txt");

                if (file.exists()) {
                    System.out.println("File exists");
                } else {
                    file.createNewFile();
                    System.out.println("File Created");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            Alert alertt = new Alert(Alert.AlertType.INFORMATION);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\IdeaProjects\\inf\\src\\main\\resources\\com\\example\\inf\\Userss", true))) {
                if(!User.matches("[a-zA-Zа-яА-Я ]+" ) || Password.length()>9||User.length()>9||emailTextField.getText().length()>9 || usernameField.getText().equals(PasswordField.getText())){
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setHeaderText(null);
                    alert1.setContentText("Write field empty or\n"+"Name is only string and password is not longer than 9\n"+"“Password Matched”);");
                    alert1.showAndWait();
                    return;
                }
                writer.write( "Username"+": "+usernameField.getText()+"\nEmail" +": "+ emailTextField.getText() +"\nPassword" +": "+ PasswordField.getText());
                writer.newLine();
                writer.newLine();
                writer.close();
                alertt.setTitle("Success");
                alertt.setHeaderText(null);
                alertt.setContentText("Registration successful!");
                alertt.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Error saving user information!");
                alert.showAndWait();
            }
            String username = usernameField.getText();
            String password = PasswordField.getText();
            if (username.equals(password)) {
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Passwords do not match!");
                alert.showAndWait();
            } else {
                alertt.setTitle("Success");
                alertt.setHeaderText(null);
                alertt.setContentText("Password matched!");
                alertt.showAndWait();
            }
            if (username.length() > 9) {
                username = username.substring(0, 9);
            }
            if (password.length() > 9) {
                password = password.substring(0, 9);
            }
            try {
                File file = new File("Userss.txt");
                Scanner scanner = new Scanner(file);
                int lineCount = 0;
                while (scanner.hasNextLine()) {
                    lineCount++;
                    scanner.nextLine();
                }
                System.out.println("Number of lines: " + lineCount);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                File file = new File("Userss.txt");
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] splitLine = line.split(": ");
                    String key = splitLine[0];
                    String value = splitLine[1];
                    if (key.equals(username) && value.equals(password)) {
                        alertt.setTitle("Success");
                        alertt.setHeaderText(null);
                        alertt.setContentText("Password matched!");
                        alertt.showAndWait();
                        break;
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            confirmPasswordField.getScene().getWindow().hide();
            FXMLLoader forSignUp = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
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

    @Override
    public void update(String username) {

    }
}