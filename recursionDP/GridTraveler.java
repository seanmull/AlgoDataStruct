package recursionDP;



public class GridTraveler {

	public static void main(String[] args) {

		System.out.println(GridTraveler1(2,2));
		
		
		
	}
	
	public static int GridTraveler1(int x, int y) {
		System.out.println("(" + x + " , " + y + ")");
		if(x == 1 && y == 1) return 1;
		if(x == 0 || y == 0) return 0;
		System.out.println("Recursive case : GridTraveler1(" + (x-1) + " , " + y + ")"+ " + GridTraveler1(" + x + " , " +(y-1) + ")");
		return GridTraveler1(x-1,y) + GridTraveler1(x,y-1);
	}

}
