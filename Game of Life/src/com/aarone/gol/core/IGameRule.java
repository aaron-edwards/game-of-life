package com.aarone.gol.core;

public interface IGameRule {
	
	public CellState[] getValidStates();
	
	public CellState getNextStateForCell(CellState cell, CellState[] neighbours);

	public CellState[] getValidSeedStates();
	
	public boolean isPopulation(CellState state);
}
