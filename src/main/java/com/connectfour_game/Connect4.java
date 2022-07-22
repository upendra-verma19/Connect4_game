package com.connectfour_game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Connect4 extends Application {
    private HelloController controller;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Connect4.fxml"));
        GridPane rootGridPane= fxmlLoader.load();
        controller=fxmlLoader.getController();
        controller.createPlayground();

        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        Pane menuPane= (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        Scene scene = new Scene(rootGridPane);
        stage.setScene(scene);
        stage.setTitle("Connect Four");
        stage.setResizable(false);
        stage.show();
    }
    private MenuBar createMenu(){
        Menu fileMenu=new Menu("File");
        MenuItem newGame=new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> controller.resetGame());
        MenuItem resetGame=new MenuItem("Reset Game");
        resetGame.setOnAction(actionEvent -> controller.resetGame());
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem exitGame=new MenuItem("Exit Game");
        exitGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                exitGame();
            }
        });
        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

        Menu helpMenu=new Menu("Help");
        MenuItem aboutGame=new MenuItem("About");
        aboutGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                aboutGame();
            }
        });
        SeparatorMenuItem separatorMenuItem1=new SeparatorMenuItem();
        MenuItem aboutCommunity=new MenuItem("About Community");
        aboutCommunity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                aboutUs();
            }
        });
        helpMenu.getItems().addAll(aboutGame,separatorMenuItem1,aboutCommunity);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutUs() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Upendra Verma");
        alert.setContentText("This is Upendra here, sometimes i love to code,My Journey started for coding from almost 1 year ago." +
                " I have developed this game for enjoyment of the user." +
                "Thank You! ");
        alert.show();
    }

    private void aboutGame() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to play!");
        alert.setContentText("Connect-Four is a tic-tac-toe-like two-player game in which players alternately place " +
                "pieces on a vertical board 7 columns across and 6 rows high. Each player uses pieces of a particular " +
                "color (commonly black and red, or sometimes yellow and red), and the object is to be the first to obtain " +
                "four pieces in a horizontal, vertical, or diagonal line. Because the board is vertical, " +
                "pieces inserted in a given column always drop to the lowest unoccupied row of that column. " +
                "As soon as a column contains 6 pieces, it is full and no other piece can be placed in the column.\n" +
                "Both players begin with 21 identical pieces, and the first player to achieve a line of four connected pieces wins the game. " +
                "If all 42 men are played and no player has places four pieces in a row, the game is drawn.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }


    public static void main(String[] args) {
        launch();
    }
}