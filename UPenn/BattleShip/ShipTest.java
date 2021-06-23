
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
	Ocean o;
	int row;
	int column;
	boolean horizontal;
	BattleShip b;

	@Before
	public void setUp() throws Exception {
		o = new Ocean();
		b = new BattleShip();
	}

	@Test
	public void testOkToPlaceShipAt() {
		assertTrue(b.okToPlaceShipAt(12, 10, false, o)); // test vertical
		assertTrue(b.okToPlaceShipAt(12, 19, false, o));
		assertFalse(b.okToPlaceShipAt(19, 19, false, o));  // comes out true
		assertTrue(b.okToPlaceShipAt(0, 12, true, o)); // test horizontal
		assertTrue(b.okToPlaceShipAt(0, 0, true, o)); // test horizontal
		assertTrue(b.okToPlaceShipAt(19, 12, true, o));
		assertFalse(b.okToPlaceShipAt(200, 13, true, o)); // if you provide out of boundry it will skip
		assertFalse(b.okToPlaceShipAt(13, 19, false, o));
		assertTrue(b.okToPlaceShipAt(19, 12, true, o));
		assertFalse(b.okToPlaceShipAt(13, 19, false, o));
		assertTrue(b.okToPlaceShipAt(0, 8, false, o));
		b.placeShipAt(19, 5, true, o);
		//assertTrue(b.okToPlaceShipAt(19,11, true, o)); //this shouldn't pass
		/*Ship 11 is 8 length and at 19 row and 5 column
		Ship 12 is 8 length and at 19 row and 11 column*/
		//o.printShips();
		
		
	}
	
	@Test
	public void testcheckBound() {
		assertTrue(b.checkBound(12, 12, true, o)); 
		assertFalse(b.checkBound(12, 13, true, o));
	}
	
	
	
	@Test
	public void testcheckProx() {
		assertTrue(b.checkProx(12, 13, false, o));
		//assertFalse(b.checkProx(13, 13, false, o));
		assertTrue(b.checkProx(0, 10, false, o)); 
		assertTrue(b.checkProx(19, 12, true, o));
		assertTrue(b.checkProx(0, 0, true, o));
		//assertFalse(b.checkProx(19, 19, false, o));
		//assertFalse(b.checkProx(21, 20, true, o));
		//assertFalse(b.checkProx(20, 21, true, o));
		assertTrue(b.checkProx(0, 12, true, o));
		//assertFalse(b.checkProx(20, 13, true, o)); 
	}

	@Test
	public void testPlaceShipAt() {
		b.placeShipAt(12, 13, false, o);
		//o.printShips();
		assertNotEquals(o.getShips()[11][13].getShipType(), "battleship");
		assertEquals(o.getShips()[13][13].getShipType(), "battleship");
		assertEquals(o.getShips()[19][13].getShipType(), "battleship");
	}

	@Test
	public void testShootAt() {
		b.placeShipAt(12, 13, false, o);
		b.shootAt(12, 13);
		assertEquals(b.getHit()[0], true);
		assertEquals(b.getHit()[1], false);
		assertEquals(b.getHit()[7], false);
		b.shootAt(13, 13);
		assertEquals(b.getHit()[1], true);
		assertEquals(b.getHit()[2], false);
		assertTrue(b.shootAt(12, 13));
		assertFalse(b.shootAt(11, 13));
		assertTrue(b.shootAt(19, 13));
		assertFalse(b.shootAt(19, 14));
	}

	@Test
	public void testIsSunk() {
		b.placeShipAt(12, 13, false, o);
		b.shootAt(12, 13);
		b.shootAt(13, 13);
		b.shootAt(14, 13);
		b.shootAt(15, 13);
		b.shootAt(16, 13);
		b.shootAt(17, 13);
		b.shootAt(18, 13);
		assertFalse(b.isSunk());
		b.shootAt(19, 13);
		assertTrue(b.isSunk());
	}

	@Test
	public void testToString() {
		b.placeShipAt(12, 13, false, o);
		b.shootAt(12, 13);
		b.shootAt(13, 13);
		b.shootAt(14, 13);
		b.shootAt(15, 13);
		b.shootAt(16, 13);
		b.shootAt(17, 13);
		b.shootAt(18, 13);
		assertEquals(b.toString(), "S");
		b.shootAt(19, 13);
		assertEquals(b.toString(), "x");
	}

}
