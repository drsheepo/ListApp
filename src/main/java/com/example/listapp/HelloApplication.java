package com.example.listapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 860, 610);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public void stop() throws Exception {

        GradeChecker.saveData();
    }

    public static void main(String[] args) {
        launch();
    }
}