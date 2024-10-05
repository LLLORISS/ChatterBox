module org.example.chatterbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires ChatterServer;

    opens org.example.chatterbox to javafx.fxml;
    exports org.example.chatterbox;
    exports org.example.chatterbox.Controllers;
    opens org.example.chatterbox.Controllers to javafx.fxml;
}