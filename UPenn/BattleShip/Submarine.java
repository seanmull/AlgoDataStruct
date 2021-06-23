
public class Submarine extends Ship {

	Submarine(){
		int l = 3;
		super.setLength(l);
		for(int i = 0; i < this.getLength(); i++) {
			super.getHit()[i] = false;
		}
	}
	
	
	@Override
	String getShipType() {
		return "submarine";
	}

}
