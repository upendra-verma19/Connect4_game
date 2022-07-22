module com.connectfour_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.connectfour_game to javafx.fxml;
    exports com.connectfour_game;
}