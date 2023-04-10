module psa.app.psawindowapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens psaWindowApp to javafx.fxml;
    exports psaWindowApp;
    exports psaWindowApp.controllers;
    opens psaWindowApp.controllers to javafx.fxml;
}