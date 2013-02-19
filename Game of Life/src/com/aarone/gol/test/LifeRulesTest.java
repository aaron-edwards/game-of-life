package com.aarone.gol.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.aarone.gol.core.CellState;
import com.aarone.gol.core.LifeRules;

public class LifeRulesTest {

	@Test
	public void testCountAliveNeighbours() {
		CellState[] neighbours = new CellState[8];
		Arrays.fill(neighbours, CellState.Dead);
		LifeRules conway = LifeRules.ConwaysGameOfLifeRules;
		
		assertEquals(0, conway.countAliveNeighbours(neighbours));
		assertEquals(CellState.Dead, conway.getNextStateForCell(CellState.Alive, neighbours));
		assertEquals(CellState.Dead, conway.getNextStateForCell(CellState.Dead, neighbours));
		
		neighbours[0] = CellState.Alive;
		assertEquals(1, conway.countAliveNeighbours(neighbours));
		assertEquals(CellState.Dead, conway.getNextStateForCell(CellState.Alive, neighbours));
		assertEquals(CellState.Dead, conway.getNextStateForCell(CellState.Dead, neighbours));
		
		neighbours[2] = CellState.Alive;
		assertEquals(2, conway.countAliveNeighbours(neighbours));
		assertEquals(CellState.Alive, conway.getNextStateForCell(CellState.Alive, neighbours));
		assertEquals(CellState.Dead, conway.getNextStateForCell(CellState.Dead, neighbours));
		
		neighbours[3] = CellState.Alive;
		assertEquals(3, conway.countAliveNeighbours(neighbours));
		assertEquals(CellState.Alive, conway.getNextStateForCell(CellState.Alive, neighbours));
		assertEquals(CellState.Birth, conway.getNextStateForCell(CellState.Dead, neighbours));
		
		neighbours[4] = CellState.Alive;
		assertEquals(4, conway.countAliveNeighbours(neighbours));
		assertEquals(CellState.Dead, conway.getNextStateForCell(CellState.Alive, neighbours));
		assertEquals(CellState.Dead, conway.getNextStateForCell(CellState.Dead, neighbours));
	}

}
