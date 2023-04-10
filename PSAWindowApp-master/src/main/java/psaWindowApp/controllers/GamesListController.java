package psaWindowApp.controllers;


import exceptions.IncorrectCardException;
import exceptions.IncorrectHandException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.*;
import psaWindowApp.Person;

import java.io.File;
import java.net.URL;
import java.util.*;

public class GamesListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane gamesListBorderPane;

    @FXML
    private Button uploadButton;

    @FXML
    private TableView<Game> gamesTableView;

    @FXML
    private Scene scene;

    @FXML
    private Stage stage;

    @FXML
    void onUploadButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Files");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TextFiles", "*.txt"));
//            fileChooser.setSelectedExtensionFilter();
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(uploadButton.getParent().getScene().getWindow());
        if (selectedFiles != null) {
            UploadController uploadController = new UploadController();
            uploadController.uploadFiles(selectedFiles);

        }
    }

    @FXML
    void initialize() throws IncorrectHandException, IncorrectCardException {
        uploadButton.setOnAction(actionEvent -> {
            onUploadButtonClick();
        });
//        Game game = new Game("", 0);

        TableView table = new TableView<Person>();
        TableColumn firstNameColumn = new TableColumn<Person, String>("firstName");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

        TableColumn lastNameColumn = new TableColumn<Person, String>("lastName");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        table.getColumns().addAll(firstNameColumn, lastNameColumn);

        table.getItems().addAll(new Person("Johj", "Aa", 13), new Person("Jj", "a", 100000));
        ((BorderPane)gamesTableView.getParent()).setCenter(table);



//        TableColumn<Game, Date> tb = gamesTableView.getColumns().get(1).set;
//        tb.setCellFactory(new PropertyValueFactory<Game, String>("gameId"));

//        gamesTableView.getColumns().get(0).setCellFactory(new PropertyValueFactory("date"));
//        ((TableColumn)(gamesTableView.getColumns().get(1))).setCellFactory(new PropertyValueFactory<Game, String>("gameId"));
//        ((TableColumn)(gamesTableView.getColumns().get(2))).setCellFactory(new PropertyValueFactory<Game, Double>("BigBlindSize$"));
//        ((TableColumn)(gamesTableView.getColumns().get(3))).setCellFactory(new PropertyValueFactory<Game, Double>("finalPot"));
//        try {
//            gamesTableView.getItems().add(new Game("game1", 15));

    }

}
