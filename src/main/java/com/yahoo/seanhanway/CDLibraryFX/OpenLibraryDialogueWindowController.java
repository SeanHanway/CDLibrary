package com.yahoo.seanhanway.CDLibraryFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class OpenLibraryDialogueWindowController extends CDLibraryFXController {
    @FXML protected ListView<String> cdlibrarylist = new ListView<>();

    /**
     * Constructor - Initialises and populates the ListView.
     */
    public OpenLibraryDialogueWindowController(){
        ObservableList<String> names = FXCollections.observableArrayList(helper.getLibraryAsString());
        cdlibrarylist.setItems(names);
    }
}
