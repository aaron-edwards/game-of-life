package com.aarone.gol.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aarone.gol.core.Board;
import com.aarone.gol.core.MooreNeighbourhoodStrategy;

public class MooreNeighbourhoodTest {

	@Test
	public void testGetNeighbourhoodIndicies() {
		int[] expected = new int[]{
				0,1,2,
				3,  5,
				6,7,8};
		
		MooreNeighbourhoodStrategy moore = new MooreNeighbourhoodStrategy();
		
		int[] expected2 = new int[]{
				0,1,2,
				4,  6,
				8,9,10};
		
		int[] expected3 = new int[]{
				0,1,
				  4,
				6,7};
		
		int[] expected4 = new int[]{
				4,5,
				7, };
		
		assertArrayEquals(expected, moore.getNeighbourhoodIndicies(4, new Board(3, 3)));
		assertArrayEquals(expected2, moore.getNeighbourhoodIndicies(5, new Board(4, 4)));
		assertArrayEquals(expected3, moore.getNeighbourhoodIndicies(3, new Board(3, 3)));
		assertArrayEquals(expected4, moore.getNeighbourhoodIndicies(8, new Board(3, 3)));
	}

}
