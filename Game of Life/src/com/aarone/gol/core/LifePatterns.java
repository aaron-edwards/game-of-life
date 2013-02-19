package com.aarone.gol.core;

public class LifePatterns {

	
	public static final CellState[][] blinker = parsePattern(new String[]{
			"-O-", 
			"-O-", 
			"-O-"}, LifeRules.ConwaysGameOfLifeRules);

	private static CellState[][] parsePattern(String[] strings, IGameRule rules) {
		
		CellState[] validStates = rules.getValidStates();
		CellState[][] states = new CellState[strings[0].length()][strings.length];
	
		for(int y = 0; y < strings.length; y++){
			for(int x = 0; x < strings[y].length(); x++){
				CellState state = CellState.Dead;
				char character = strings[y].charAt(x);
				
				for(int i = 0; i < validStates.length; i++){
					if(character == validStates[i].getSymbol()){
						state = validStates[i];
					}
				}
				states[x][y] = state;
			}
		}

		return states;
	}
}
