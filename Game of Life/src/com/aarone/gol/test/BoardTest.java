package com.aarone.gol.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aarone.gol.core.Board;
import com.aarone.gol.core.CellState;

public class BoardTest {

	@Test
	public void test() {
		Board board = new Board(3, 3);
		for(int i = 0; i < board.getMaxIndex(); i++){
			board.setCell(i, CellState.Dead);
		}
		String expected = "---\n---\n---\n";
		
		assertEquals(expected, board.getBoardString());
	}

}
