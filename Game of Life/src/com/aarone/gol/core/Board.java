package com.aarone.gol.core;

import java.util.Arrays;
import java.util.List;

/**
 * Class representing a game of life board/Universe. It is implemented using
 * a 1 dimensional array. The size of the board is fixed at when the board object
 * is initialised. The class also provides methods to translate the
 * 1 dimensional index to a row and column.
 * @author Aaron Edwards
 */
public class Board {

	private CellState[] cells;
	
	private int width;
	private int height;
	
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		cells = new CellState[width * height];
	}

	public CellState getCell(int index){
		return cells[index];
	}
	
	public int getIndex(int x, int y){
		return x + y * width;
	}
	
	public int getRow(int index){
		return index / width;
	}
	
	public int getColumn(int index){
		return index % width;
	}
	
	public List<CellState> getCellStatesAsList(){
		return Arrays.asList(cells);
	}
	
	public String getBoardString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < cells.length; i++){
			sb.append(cells[i].getSymbol());
			if(i % width == (width-1)){
				sb.append('\n');
			}
		}
		return sb.toString();
	}
	
	/* Getters & Setters */
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getMaxIndex() {
		return cells.length;
	}

	public void setCell(int index, CellState cellState) {
		cells[index] = cellState;
	}

	/**
	 * Returns an array of CellStates corisponding to the array of
	 * Indicies provided.
	 * @param neighbourIndices
	 * @return
	 */
	public CellState[] getCells(int[] neighbourIndices) {
		CellState[] cellSubset = new CellState[neighbourIndices.length];
		for(int i = 0; i < neighbourIndices.length; i++){
			cellSubset[i] = getCell(neighbourIndices[i]);
		}
		return cellSubset;
		
	}
	
	
}
