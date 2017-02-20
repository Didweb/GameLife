package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cell.Cell;


public class CellTest {
	boolean statCell;


	@Test
	public void testGetStateCell() {
		statCell = Cell.getStateCell();
		assertEquals(statCell, false);
	}

	@Test
	public void testSetStateCell() {
		Cell.setStateCell(true);
		statCell = Cell.getStateCell();
		assertEquals(statCell, true);
	}

	
	@Test
	public void testcheckLifeNoBorn() {
		Cell.setStateCell(false);
		Cell.checkLife(2);
		statCell = Cell.getStateCell();
		assertEquals(statCell, false);
	}
	
	@Test
	public void testcheckLifeBorn() {
		Cell.setStateCell(false);
		Cell.checkLife(3);
		statCell = Cell.getStateCell();
		assertEquals(statCell, true);
	}
	
	@Test
	public void testcheckLifeDeadSolitude() {
		Cell.setStateCell(true);
		Cell.checkLife(1);
		statCell = Cell.getStateCell();
		assertEquals(statCell, false);
	}
	
	@Test
	public void testcheckLifeDeadOverpopulation() {
		Cell.setStateCell(true);
		Cell.checkLife(5);
		statCell = Cell.getStateCell();
		assertEquals(statCell, false);
	}
	
	
	@Test
	public void countNeighbors() {
		int nNeighbors = Cell.nNeighbors(2);
		assertEquals(nNeighbors, 2);
	}
	
}
