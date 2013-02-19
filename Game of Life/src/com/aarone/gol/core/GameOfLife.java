package com.aarone.gol.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.sun.javafx.geom.BaseBounds.BoundsType;

/**
 * Driver class for the cellular autonima. The class requires the user to define the dimentions
 * of the board as well as the game rules (rules to change cell states) and the neighbourhood 
 * strategy (rules to define the index of neighbours). This implementation was chosen to provide
 * the maximum amount of flexibility to design "games" with new rules.
 * @author aaron
 */
public class GameOfLife {

	
	private IGameRule gameRule;
	private INeighbourhoodStrategy neighbourhoodStrategy;
	private Board board;
	private boolean[] shouldUpdate;
	private int generation;
	private int population;
	private ArrayList<IGolCommand> commands;
	
	public GameOfLife(int width, int height, IGameRule gameRule, INeighbourhoodStrategy neighbourhoodStrategy){
		this.board = new Board(width, height);
		this.gameRule = gameRule;
		this.neighbourhoodStrategy = neighbourhoodStrategy;
		
		initialiseBoard(true);
		generation = 0;
		population = countPop();
		commands = new ArrayList<>(width*height);
	}
	
	public void tick(){
		commands.clear();
		int nextPop = 0;
		//this will default to false in every cell
		boolean[] shouldUpdateNext = new boolean[shouldUpdate.length];
		
		for(int i = 0; i < board.getMaxIndex(); i++){
			if(gameRule.isPopulation(board.getCell(i))){
				nextPop++;
			}
			
			if(shouldUpdate[i]){
				int[] neghbourIndices = neighbourhoodStrategy.getNeighbourhoodIndicies(i, board);
				CellState[] neighbours = board.getCells(neghbourIndices);
				CellState nextState = gameRule.getNextStateForCell(board.getCell(i), neighbours);
				
				if(board.getCell(i) != nextState){
					commands.add(new StateChangeCommand(i, nextState, board));
					shouldUpdateNext[i] = true;
					for (int index : neghbourIndices) {
						shouldUpdateNext[index] = true;
					}
				}
				
			}
		}
		for (IGolCommand command : commands) {
			command.execute();
		}
		
		generation++;
		population = nextPop;
		this.shouldUpdate = shouldUpdateNext;
	}

	private int countPop() {
		int count = 0;
		for(int i = 0; i < board.getMaxIndex(); i++){
			if(gameRule.isPopulation(board.getCell(i))){
				count++;
			}
		}
		return count;
	}



	private void initialiseBoard(boolean randomSeed) {
		CellState[] validStates = gameRule.getValidSeedStates();
		shouldUpdate = new boolean[board.getMaxIndex()];
		Random rand = new Random();
		for(int i = 0; i < board.getMaxIndex(); i++){
			if(randomSeed){
				board.setCell(i, validStates[rand.nextInt(validStates.length)]);
			}
			shouldUpdate[i] = true;
		}
	}
	
	private String getBoardString(){
		return board.getBoardString();
	}
	
	
	public static void main(String[] args){
		GameOfLife gol = new GameOfLife(25, 25, LifeRules.ConwaysGameOfLifeRules, new MooreNeighbourhoodStrategy());
		
		System.out.println(gol.getBoardString());
		System.out.println("Generation: "+gol.generation);
		System.out.println("Population: "+gol.population);
		for(int i = 0; i < 10; i++){
			gol.tick();
			System.out.println(gol.getBoardString());
			System.out.println("Generation: "+gol.generation);
			System.out.println("Population: "+gol.population);
		}
	}
}
