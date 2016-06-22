package com.yahoo.seanhanway.CDLibraryFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class CDLibraryFXController {
    @FXML private Text actiontarget;
    private static Stage popupWindow;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }

    @FXML protected void handleSubmitNewMenuAction(ActionEvent event) throws Exception{
        Stage newMenuStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LibraryCreationDialogueWindow.fxml"));
        Scene scene = new Scene(root, 350, 150);
        newMenuStage.setTitle("Create new Library");
        newMenuStage.setScene(scene);
        newMenuStage.show();
        popupWindow = newMenuStage;
    }

    @FXML protected void closeStage(){
        ((Stage)popupWindow.getScene().getWindow()).close();
    }

    @FXML protected void closeStage(ActionEvent event){
        ((Stage)popupWindow.getScene().getWindow()).close();
    }

    @FXML protected void handleSubmitOpenMenuAction(ActionEvent event){

    }

    @FXML protected void handleSubmitSaveMenuAction(ActionEvent event){

    }

    @FXML protected void handleSubmitCloseMenuAction(ActionEvent event){

    }

    @FXML protected void handleSubmitQuitMenuAction(ActionEvent event){

    }

    @FXML protected void handleSubmitNewCDMenuAction(ActionEvent event){

    }
}