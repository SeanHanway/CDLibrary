package com.yahoo.seanhanway.CDLibraryFX;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;

public class SaveResultDialogueWindowController extends CDLibraryFXController implements Initializable {
    @FXML private Text popuptext;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        if (helper.saveCDLibrary()) {
            popuptext.setText("Library Successfully Saved");
        } else {
            popuptext.setText("Library Saving Failed");
        }
    }
}

