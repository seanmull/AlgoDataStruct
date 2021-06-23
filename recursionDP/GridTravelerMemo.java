package recursionDP;

import java.util.HashMap;

public class GridTravelerMemo {

	public static void main(String[] args) {
		HashMap<String, Integer> memo = new HashMap<String, Integer>();
		System.out.println(GridTraveler1(10,10, memo));
	}
	
	public static int GridTraveler1(int x, int y, HashMap<String, Integer> m) {
		String s = (y > x) ? x + " , " + y : y + " , " + x;
		System.out.println("s = " + s);
		if(m.containsKey(s)) return m.get(s);
		if(x == 1 && y == 1) return 1;
		if(x == 0 || y == 0) return 0;
		System.out.println("Recursive case " + s + " :  " + "GridTraveler1(" + (x-1) + " , " + y + ")"+ " + GridTraveler1(" + x + " , " +(y-1) + ")");
		m.put(s, (int) GridTraveler1(x-1,y,m) + GridTraveler1(x,y-1,m));
		return m.get(s);
	}

}
