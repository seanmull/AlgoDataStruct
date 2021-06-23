
public class Cruiser extends Ship {
	
	Cruiser(){
		int l = 6;
		super.setLength(l);
		for(int i = 0; i < this.getLength(); i++) {
			super.getHit()[i] = false;
		}
	}
	
	
	@Override
	String getShipType() {
		return "cruiser";
	}

}
