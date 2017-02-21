package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cell.Cell;


public class CellTest {
	int statCell;


	@Test
	public void testGetStateCell() {
		statCell = Cell.getStateCell();
		assertEquals(statCell, 0);
	}

	@Test
	public void testSetStateCell() {
		Cell.setStateCell(1);
		statCell = Cell.getStateCell();
		assertEquals(statCell, 1);
	}

	
	@Test
	public void testcheckLifeNoBorn() {
		Cell.setStateCell(0);
		Cell.checkLife(2,1);
		statCell = Cell.getStateCell();
		assertEquals(statCell, 0);
	}
	
	@Test
	public void testcheckLifeBorn() {
		Cell.setStateCell(0);
		Cell.checkLife(3,1);
		statCell = Cell.getStateCell();
		assertEquals(statCell, 1);
	}
	
	@Test
	public void testcheckLifeDeadSolitude() {
		Cell.setStateCell(1);
		Cell.checkLife(1,1);
		statCell = Cell.getStateCell();
		assertEquals(statCell, 0);
	}
	
	@Test
	public void testcheckLifeDeadOverpopulation() {
		Cell.setStateCell(1);
		Cell.checkLife(5,1);
		statCell = Cell.getStateCell();
		assertEquals(statCell, 0);
	}
	
	
	@Test
	public void countNeighbors() {
		int nNeighbors = Cell.nNeighbors(2);
		assertEquals(nNeighbors, 2);
	}
	
}
