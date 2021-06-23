
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	Ocean o;
	int row;
	int column;
	BattleShip b;
	

	@Before
	public void setUp() throws Exception {
		o = new Ocean();
		b = new BattleShip();
		o.printValue = new char[20][20];

	}

	@Test
	public void testPlaceAllShipsRandomly() {
		for(int k = 0; k < 200; k++) {
		o = new Ocean();
		b = new BattleShip();
		o.placeAllShipsRandomly();
		o.printShips();
		for(int i = 0; i < o.shipArray.size(); i++) {
			System.out.print("\nShip " + i + " is " + o.shipArray.get(i).getLength() + " length and at " + o.shipArray.get(i).getBowRow() + " row and " +  o.shipArray.get(i).getBowColumn() + " column");
		}
		System.out.print("\nSum of all the ships is " + o.sumOfShips);
		int sum = 0;
		int sum1 = 0;
		for(int i = 0; i < o.getShipArray()[0].length; i++) {
			for(int j = 0; j < o.getShipArray()[1].length; j++) {
				if(o.getShips()[i][j].toString() != "-") {
					assertTrue(o.isOccupied(i, j));
					sum++;
				}else {
					assertFalse(o.isOccupied(i, j));
					sum1++;
				}
			}
		}
		System.out.print("\nSum of all the occupied areas is " + sum);
		System.out.print("\nSum of all the unoccupied areas is " + sum1);
		
		int sum2 = 0;
		for(int i = 0; i < o.getShipArray()[0].length; i++) {
			for(int j = 0; j < o.getShipArray()[1].length; j++) {
				if(o.isOccupied(i, j)) {
					o.shootAt(i, j);
					sum2++;
				}
			}
		}
		System.out.print("\nSum of all the shot areas is " + sum2);
		assertTrue(o.isGameOver());
		}
	}

	@Test
	public void testIsOccupied() {
		o.placeAllShipsRandomly();

	}

	@Test
	public void testShootAt() {
		b.placeShipAt(12, 13, false, o);
		assertTrue(o.shootAt(12, 13));
		assertTrue(o.shootAt(13, 13));
		assertTrue(o.shootAt(14, 13));
		assertTrue(o.shootAt(15, 13));
		assertTrue(o.shootAt(16, 13));
		assertTrue(o.shootAt(17, 13));
		assertTrue(o.shootAt(18, 13));
		assertTrue(o.shootAt(19, 13));
		assertFalse(o.shootAt(19, 13));
		assertFalse(o.shootAt(12, 13));
		assertTrue(b.isSunk());
		assertFalse(o.shootAt(19, 13));
		assertFalse(o.shootAt(19, 14));
		assertFalse(o.shootAt(17, 14));
	}

	@Test
	public void testGetShotsFired() {
		b.placeShipAt(12, 13, false, o);
		assertTrue(o.shootAt(12, 13));
		assertTrue(o.shootAt(13, 13));
		assertTrue(o.shootAt(14, 13));
		assertTrue(o.shootAt(15, 13));
		assertTrue(o.shootAt(16, 13));
		assertTrue(o.shootAt(17, 13));
		assertTrue(o.shootAt(18, 13));
		assertEquals(o.getShotsFired(), 7);
	}

	@Test
	public void testGetHitCount() {
		b.placeShipAt(12, 13, false, o);
		assertFalse(o.shootAt(0, 0));
		assertTrue(o.shootAt(13, 13));
		assertTrue(o.shootAt(14, 13));
		assertTrue(o.shootAt(15, 13));
		assertTrue(o.shootAt(16, 13));
		assertFalse(o.shootAt(17, 11));
		assertEquals(o.getHitCount(), 4);
	}

	@Test
	public void testGetShipsSunk() {
		b.placeShipAt(12, 13, false, o);
		assertTrue(o.shootAt(12, 13));
		assertTrue(o.shootAt(13, 13));
		assertTrue(o.shootAt(14, 13));
		assertTrue(o.shootAt(15, 13));
		assertTrue(o.shootAt(16, 13));
		assertTrue(o.shootAt(17, 13));
		assertTrue(o.shootAt(18, 13));
		assertTrue(o.shootAt(19, 13));
		assertTrue(b.isSunk());
		
		
	}

	@Test
	public void testIsGameOver() {
		o.placeAllShipsRandomly();
		for(int i = 0; i < o.getShipArray()[0].length; i++) {
			for(int j = 0; j < o.getShipArray()[1].length; j++) {
				if(o.getShips()[i][j].getShipType() != "empty") {
					o.shootAt(i, j);
				}
			}
		}
		
		for(int i = 0; i < o.shipArray.size(); i++) {

				//System.out.println("Ship " + i + " is " + o.shipArray.get(i).getLength() + " length and at " + o.shipArray.get(i).getBowRow() + " row and " +  o.shipArray.get(i).getBowColumn() + " column");
			

		}
		//System.out.println("");
		//System.out.println("The number of ships sunk: " + o.getShipsSunk());
		//System.out.println("The number of hits: " + o.getHitCount());
		//System.out.println("Sum is: " + o.sumOfShips);
		//System.out.println("The number of shots fired: " + o.getShotsFired());
		//assertTrue(o.isGameOver());
	}

	@Test
	public void testPrint() {
		b.placeShipAt(12, 13, false, o);
		/*o.row = 12; o.column = 13; o.shootAt(o.row, o.column);
		o.print();
		o.row = 13; o.column = 13; o.shootAt(o.row, o.column);
		o.print();
		o.row = 14; o.column = 13; o.shootAt(o.row, o.column);
		o.print();
		o.row = 15; o.column = 13; o.shootAt(o.row, o.column);
		o.print();
		o.row = 16; o.column = 13; o.shootAt(o.row, o.column);
		o.print();
		o.row = 17; o.column = 13; o.shootAt(o.row, o.column);
		o.print();
		o.row = 18; o.column = 13; o.shootAt(o.row, o.column);
		o.print();
		o.row = 19; o.column = 13; o.shootAt(o.row, o.column);
		o.print();
		o.row = 19; o.column = 14; o.shootAt(o.row, o.column);
		o.print();
		o.row = 1; o.column = 1; o.shootAt(o.row, o.column);
		o.print();*/
	}

}
