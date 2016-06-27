package com.yahoo.seanhanway.CDLibraryFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class OpenLibraryDialogueWindowController extends CDLibraryFXController implements Initializable {
    @FXML protected ListView<String> cdlibrarylist;

    /**
     * Populates the list within the OpenLibraryDialogueWindow with the name of CDLibrary objects found on the disk and created during the current user session.
     * @param location N/A
     * @param resources N/A
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> names = FXCollections.observableArrayList(helper.getLibraryAsString());
        cdlibrarylist.setItems(names);
    }

    /**
     * Sets the String CDLibraryName in the CDLibraryFXController as the name of the selected CDLibrary and closes the stage.
     */
    @FXML protected void handleSubmitOKButton(){
        if(cdlibrarylist.getSelectionModel().getSelectedItem()!=null) {
            setCDLibraryName(cdlibrarylist.getSelectionModel().getSelectedItem());
            closeStage();
        }
    }
}