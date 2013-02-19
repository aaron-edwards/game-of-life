package com.aarone.gol.ui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameOfLifeApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		Button button = new Button();
		button.setText("Test");
		pane.setPrefSize(200, 200);
		pane.setCenter(button);
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
