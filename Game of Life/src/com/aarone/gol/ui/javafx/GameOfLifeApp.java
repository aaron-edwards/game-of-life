package com.aarone.gol.ui.javafx;

import com.aarone.gol.core.GameOfLife;
import com.aarone.gol.core.LifeRules;
import com.aarone.gol.core.MooreNeighbourhoodStrategy;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameOfLifeApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		GameOfLife gol = new GameOfLife(750, 750, LifeRules.ConwaysGameOfLifeRules, new MooreNeighbourhoodStrategy());
		
		GameOfLifeScene s = new GameOfLifeScene(new Group(), gol);
		
		primaryStage.setScene(s);

		s.setButtonLoc();
		
        primaryStage.show();
        
        
        
	}

	public static void main(String[] args) {
		launch(args);
	}
}
