package com.yahoo.seanhanway.CDLibraryFX;

import com.yahoo.seanhanway.CDLibrary.FXHelper;
import com.yahoo.seanhanway.CDLibrary.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class CDLibraryFXController {
    private static Stage popupWindow;
    FXHelper helper = new FXHelper();
    private static String CDLibraryName;
    @FXML protected ListView<String> cdlist = new ListView<>();
    @FXML protected TableView<Track> cdtable;
    @FXML protected TableColumn<Track, String> songnamecolumn;
    @FXML protected TableColumn<Track, String> releaseyearcolumn;
    @FXML protected TableColumn<Track, String> albumnamecolumn;

    /**
     * Closes any stages opened by a method within this class.
     */
    @FXML protected void closeStage(){
        ((Stage)popupWindow.getScene().getWindow()).close();
    }

    /**
     * Handles pressing the "New" button in the toolbar under the "File" heading.
     * @throws Exception if the FXML class can't be loaded.
     */
    @FXML protected void handleSubmitNewMenuAction() throws Exception{
        Stage newMenuStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("NewLibraryDialogueWindow.fxml"));
        Scene scene = new Scene(root, 350, 150);
        newMenuStage.setTitle("Create new Library");
        newMenuStage.setScene(scene);
        newMenuStage.show();
        popupWindow = newMenuStage;
    }

    /**
     * Handles pressing the "Open" button in the toolbar under the "File" heading.
     * @throws Exception if the FXML class can't be loaded.
     */
    @FXML protected void handleSubmitOpenMenuAction() throws Exception{
        Stage newMenuStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("OpenLibraryDialogueWindow.fxml"));
        Scene scene = new Scene(root, 350, 220);
        newMenuStage.setTitle("Open Library");
        newMenuStage.setScene(scene);
        newMenuStage.show();
        popupWindow = newMenuStage;
    }

    /**
     * Handles pressing the "Save" button in the toolbar under the "File" heading.
     * @throws Exception if the FXML class can't be loaded.
     */
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

    /**
     * Populates the main window with information regarding each CD stored in the selected CDLibrary.
     */
    @FXML protected void populateCDLibraryWindow(){
        if(!(CDLibraryName == null)) {
            ObservableList<String> names = FXCollections.observableArrayList(helper.getCDLibraryAsString(CDLibraryName));
            cdlist.setItems(names);
        }
    }

    /**
     * Populates the main window with information regarding each track within a CD when that CD is selected.
     */
    @FXML protected void populateCDWindow(){
        ObservableList<Track> data = FXCollections.observableArrayList(
                helper.getCDTracks(
                        CDLibraryName, cdlist.getSelectionModel().getSelectedItem())
        );

        songnamecolumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        cdtable.setItems(data);
    }

    /**
     * Sets the CDLibrary name as chosen parameter.
     * This is required to be run every time the user selects a new CDLibrary for the main window to be populated properly.
     * @param name String - name of newly selected CDLibrary.
     */
    static void setCDLibraryName(String name){
        CDLibraryName = name;
    }
}