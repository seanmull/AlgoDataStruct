
public class LightCruiser extends Ship {

	LightCruiser(){
		int l = 5;
		super.setLength(l);
		for(int i = 0; i < this.getLength(); i++) {
			super.getHit()[i] = false;
		}
	}
	
	
	@Override
	String getShipType() {
		return "light cruiser";
	}

}
