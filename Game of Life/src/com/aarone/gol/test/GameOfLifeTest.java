package com.aarone.gol.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aarone.gol.core.GameOfLife;
import com.aarone.gol.core.LifePatterns;
import com.aarone.gol.core.LifeRules;
import com.aarone.gol.core.MooreNeighbourhoodStrategy;

public class GameOfLifeTest {

	@Test
	public void testGameOfLife() {
		GameOfLife gol = new GameOfLife(LifePatterns.blinker, LifeRules.ConwaysGameOfLifeRules, new MooreNeighbourhoodStrategy());

		assertEquals("-0-\n-0-\n-0-\n", gol.getBoardString());
		gol.tick();
		assertEquals("---\no0o\n---\n", gol.getBoardString());
		gol.tick();
		assertEquals("-o-\n-0-\n-o-\n", gol.getBoardString());
	}

}
