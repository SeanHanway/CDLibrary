package com.yahoo.seanhanway.CDLibraryFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class NewLibraryDialogueWindowController extends CDLibraryFXController{
    @FXML private TextField libraryname;
    @FXML private Text warning;

    @FXML protected void handleSubmitOKButton(ActionEvent event){
        if(helper.addCDLibrary(libraryname.getCharacters().toString())){
            closeStage();
        }
        else{
            warning.setText("Library already exists.");
        }
    }

}
