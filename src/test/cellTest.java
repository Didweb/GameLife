package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cell.cell;


public class cellTest {
	boolean statCell;


	@Test
	public void testGetStateCell() {
		statCell = cell.getStateCell();
		assertEquals(statCell, false);
	}

	@Test
	public void testSetStateCell() {
		cell.setStateCell(true);
		statCell = cell.getStateCell();
		assertEquals(statCell, true);
	}

	
	@Test
	public void testcheckLifeNoBorn() {
		cell.setStateCell(false);
		cell.checkLife(2);
		statCell = cell.getStateCell();
		assertEquals(statCell, false);
	}
	
	@Test
	public void testcheckLifeBorn() {
		cell.setStateCell(false);
		cell.checkLife(3);
		statCell = cell.getStateCell();
		assertEquals(statCell, true);
	}
	
	@Test
	public void testcheckLifeDeadSolitude() {
		cell.setStateCell(true);
		cell.checkLife(1);
		statCell = cell.getStateCell();
		assertEquals(statCell, false);
	}
	
	@Test
	public void testcheckLifeDeadOverpopulation() {
		cell.setStateCell(true);
		cell.checkLife(5);
		statCell = cell.getStateCell();
		assertEquals(statCell, false);
	}
	
}
