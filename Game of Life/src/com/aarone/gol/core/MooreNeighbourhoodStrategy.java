package com.aarone.gol.core;

/**
 * Neighbourhood Strategy representing a Moore Neighbourhood. Currently the class will only
 * return cells that are touching the provided cell in all 8 directions. In the future I intend to
 * allow the size parameter to be provided then the class is initialised, allowing the user to
 * define a larger neighbourhood.
 * 
 * @author aaron
 */
public class MooreNeighbourhoodStrategy implements INeighbourhoodStrategy{
	
	private int size = 1;

	@Override
	public int[] getNeighbourhoodIndicies(int cellIndex, Board board) {
		
		int cellRow = board.getRow(cellIndex);
		int cellCol = board.getColumn(cellIndex);
		
		int xMin = Math.max(cellCol - size, 0);
		int xMax = Math.min(cellCol + size, (board.getWidth()-1));
		
		int yMin = Math.max(cellRow - size, 0);
		int yMax = Math.min(cellRow + size, (board.getHeight()-1));

		
		int counter = 0;
		int[] neighbours = new int[((1+xMax-xMin) * (1+yMax-yMin) - 1)];
		
		for(int y = yMin; y <= yMax;y++){
			for(int x = xMin; x <= xMax; x++){
				int index = board.getIndex(x, y);
				if(index != cellIndex){
					neighbours[counter] = index;
					counter++;
				}
			}
		}
		
		return neighbours;
		
	}
	
	

}
