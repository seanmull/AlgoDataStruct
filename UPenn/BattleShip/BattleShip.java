
public class BattleShip extends Ship {

	BattleShip(){
		int l = 8;
		super.setLength(l);
		for(int i = 0; i < this.getLength(); i++) {
			super.getHit()[i] = false;
		}
		
	}
	
	
	@Override
	String getShipType() {
		return "battleship";
	}
}
