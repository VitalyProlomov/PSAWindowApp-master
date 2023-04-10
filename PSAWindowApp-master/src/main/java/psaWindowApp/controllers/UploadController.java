package psaWindowApp.controllers;

import javafx.scene.control.Alert;
import models.Game;
import parsers.gg.GGPokerokRushNCashParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UploadController {
    private final String UPLOADED_GAMES_LIST_PATH = "";
    public void uploadFiles(List<File> files) {
        ArrayList<Game> allGames = new ArrayList<>();
        ArrayList<Exception> allExceptions = new ArrayList<>();
        GGPokerokRushNCashParser parser = new GGPokerokRushNCashParser();
        for (File f : files) {
            try {
                allGames.addAll(parser.parseFile(f.toString()));
            } catch (Exception ex) {
                allExceptions.add(ex);
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("You have uploaded " + (files.size() - allExceptions.size()) + ", containing " +
                allGames.size() + " games.");
        if (allExceptions.size() != 0) {
            alert.setContentText(alert.getContentText() + "\n" + allExceptions.size() + " files were in incorrect format or could not be read.");
        }
        alert.show();
    }


}
