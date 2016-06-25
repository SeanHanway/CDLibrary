package com.yahoo.seanhanway.CDLibraryFX;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class NewLibraryDialogueWindowController extends CDLibraryFXController{
    @FXML private TextField libraryname;
    @FXML private Text warning;

    /**
     * Handles pressing the "OK" button within the popup dialogue window.
     */
    @FXML protected void handleSubmitOKButton(){
        if(helper.addCDLibrary(libraryname.getCharacters().toString())){
            CDLibraryFXController.setCDLibraryName(libraryname.getCharacters().toString());
            closeStage();
        }
        else{
            warning.setText("Library already exists.");
        }
    }
}
