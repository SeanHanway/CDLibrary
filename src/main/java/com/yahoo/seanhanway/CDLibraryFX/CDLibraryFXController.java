package com.yahoo.seanhanway.CDLibraryFX;

import com.yahoo.seanhanway.CDLibrary.FXHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class CDLibraryFXController {
    @FXML private Text actiontarget;
    private static Stage popupWindow;
    FXHelper helper = new FXHelper();

    @FXML protected void handleSubmitButtonAction() {
        actiontarget.setText("Sign in button pressed");
    }

    @FXML protected void handleSubmitNewMenuAction() throws Exception{
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

    @FXML protected void handleSubmitOpenMenuAction(){

    }

    @FXML protected void handleSubmitSaveMenuAction() throws Exception{
        Stage newMenuStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SaveResultDialogueWindow.fxml"));
        Scene scene = new Scene(root, 325, 85);
        newMenuStage.setTitle("Saving");
        newMenuStage.setScene(scene);
        newMenuStage.show();
        popupWindow = newMenuStage;
    }

    @FXML protected void handleSubmitCloseMenuAction(){

    }

    @FXML protected void handleSubmitQuitMenuAction(){

    }

    @FXML protected void handleSubmitNewCDMenuAction(){

    }
}