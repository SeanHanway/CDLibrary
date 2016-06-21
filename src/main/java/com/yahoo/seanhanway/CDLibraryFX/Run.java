package com.yahoo.seanhanway.CDLibraryFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Run extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CDLibraryFXBuild.fxml"));
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Welcome User");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
