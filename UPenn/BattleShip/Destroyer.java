
public class Destroyer extends Ship{
	
	Destroyer(){
		int l = 4;
		super.setLength(l);
		for(int i = 0; i < this.getLength(); i++) {
			super.getHit()[i] = false;
		}
	}
	
	
	@Override
	String getShipType() {
		return "destroyer";
	}

}
