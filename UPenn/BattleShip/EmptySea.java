
public class EmptySea extends Ship{
	
	EmptySea(){
		int l = 1;
		super.setLength(l);
		for(int i = 0; i < this.getLength(); i++) {
			super.getHit()[i] = false;
		}
	}
	
	@Override
	public boolean shootAt(int row, int column) {
		return false;
	}
	
	@Override 
	public boolean isSunk() {
		return false;
	}
	
	@Override
	public String toString() {
		return "-";
	}
	
	@Override
	String getShipType() {
		return "empty";
	}

}
