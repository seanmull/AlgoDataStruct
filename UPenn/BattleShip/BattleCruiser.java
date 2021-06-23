
public class BattleCruiser extends Ship {

	BattleCruiser(){
		int l = 7;
		super.setLength(l);
		for(int i = 0; i < this.getLength(); i++) {
			super.getHit()[i] = false;
		}
	}
	
	
	@Override
	String getShipType() {
		return "battlecruiser";
	}
}
