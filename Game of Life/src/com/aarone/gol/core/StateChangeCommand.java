package com.aarone.gol.core;

public class StateChangeCommand implements IGolCommand {

	private int index;
	private CellState newState;
	private Board board;
	
	
	public StateChangeCommand(int index, CellState newState, Board board) {
		super();
		this.index = index;
		this.newState = newState;
		this.board = board;
	}


	@Override
	public void execute() {
		board.setCell(index, newState);
	}

}
