package com.aarone.gol.core;

/**
 * Enum describing the state of a Cell.
 * @author aaron
 */
public enum CellState {
	Alive('0'),
	Dead('-'),
	Birth('o');
	
	private char symbol;
	
	private CellState(char symbol){
		this.symbol = symbol;
	}
	
	public char getSymbol(){
		return symbol;
	}
}
