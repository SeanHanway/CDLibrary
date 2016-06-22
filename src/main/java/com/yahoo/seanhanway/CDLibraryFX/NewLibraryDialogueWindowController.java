package com.yahoo.seanhanway.CDLibraryFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import com.yahoo.seanhanway.CDLibrary.FXHelper;

public class NewLibraryDialogueWindowController extends CDLibraryFXController{
    @FXML private TextField libraryname;
    private FXHelper helper = new FXHelper();
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
