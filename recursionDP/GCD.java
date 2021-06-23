package recursionDP;

public class GCD {

	public static void main(String[] args) {
		System.out.println(GrtComDiv(18, 48));
	}
	

	public static int GrtComDiv(int x, int y) {
		int a; int b;
		if(x > y) {
			a = x; b = y;
		}else if (y > x) {
			a = y; b = x;
		}else {
			return x;
		}
		System.out.println("GrtComDiv(" + (a-b) + "," + b + ")");
		return GrtComDiv(a-b,b);
	}

}
