package com.aarone.gol.core;

import java.util.Arrays;

/**
 * General class to define the rules of a standard "Life" game. New births are represented
 * seperatly from old "alive" cells to optionally differentiate between these 2 in a future interface.
 * @author aaron
 */
public class LifeRules implements IGameRule{

	private CellState[] validSeedStates = new CellState[]{CellState.Alive, CellState.Dead};
	private CellState[] validStates = new CellState[]{CellState.Birth, CellState.Alive, CellState.Dead};

	private CellState[] aliveTransitions;
	private CellState[] deadTransitions;
	
	public static final LifeRules ConwaysGameOfLifeRules = new LifeRules(new int[]{3}, new int[]{2,3});
	//public static final LifeRules HighLife = new LifeRules(new int[]{3,6}, new int[]{2,3});
	//public static final LifeRules Seeds = new LifeRules(new int[]{2}, new int[]{});
	
	public LifeRules(int[] birth, int[] stay){
		deadTransitions = parseRuleArray(birth, CellState.Birth, CellState.Dead);
		aliveTransitions = parseRuleArray(stay, CellState.Alive, CellState.Dead);
	}
	
	private CellState[] parseRuleArray(int[] array,
			CellState state1, CellState state2) {
		int max = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] > max){
				max = array[i];
			}
		}
		
		CellState[] state = new CellState[max+1];
		Arrays.fill(state, state2);
		
		for(int i = 0; i < array.length; i++){
			state[array[i]] = state1;
		}

		return state;
	}

	@Override
	public CellState[] getValidStates() {
		return validStates;
	}
	
	@Override
	public CellState[] getValidSeedStates() {
		return validSeedStates;
	}

	@Override
	public CellState getNextStateForCell(CellState cell, CellState[] neighbours) {
		int aliveCount = countAliveNeighbours(neighbours);
		
		if(cell == CellState.Dead){
			if(aliveCount >= deadTransitions.length){
				return CellState.Dead;
			}else{
				return deadTransitions[aliveCount];
			}
		}else{
			if(aliveCount >= aliveTransitions.length){
				return CellState.Dead;
			}else{
				return aliveTransitions[aliveCount];
			}
		}
	}
	
	@Override
	public boolean isPopulation(CellState state){
		return state != CellState.Dead;
	}
	
	public int countAliveNeighbours(CellState[] neighbours){
		int count = 0;
		for(CellState state: neighbours){
			if(state == CellState.Alive || state == CellState.Birth){
				count++;
			}
		}
		return count;
	}
	
	
}
