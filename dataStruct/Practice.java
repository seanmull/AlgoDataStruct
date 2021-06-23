package dataStruct;

public class Practice extends Thread {
	/*You will often see Java programs that have either static or public 
	attributes and methods.

	In the example above, we created a static method, 
	which means that it can be accessed without creating an object of the class, 
	unlike public, which can only be accessed by objects:*/
	
	//attributes
	int x; //final says you cannot override values

	public Practice(int y) {
		x = y;
	}
	

	public static void main(String[] args) {
		Practice thread = new Practice(5); 
		thread.start();
		System.out.println("This code is outside of the thread");
		//Practice myObj = new Practice(5); //instantate obj
		//System.out.println(myObj.x);
		//myObj.x = 40;
		//System.out.println(myObj.x);
		//myObj.hello(); //must create obj public
		//hello2(); //can be called without obj (static)
		

	}
	
	public void hello() {
		System.out.println("Hello World");
	}
	
	static void hello2() {
		System.out.println("Hello World");
	}
	
	  public void run() {
		    System.out.println("This code is running in a thread");
	}
	
	

}
