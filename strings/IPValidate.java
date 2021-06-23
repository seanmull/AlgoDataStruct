package strings;

public class IPValidate {

	public static void main(String[] args) {
		String str = "133.133.133.-1";
        String[] arrOfStr = str.split("\\.");
        
        if(arrOfStr.length != 4) {
        	System.out.println("Not the right amount of IP numbers");
        	System.exit(0);
        }
  
        for (String a : arrOfStr) {
        	try {
        		Integer.parseInt(a);
        	}catch(Exception e){
        		System.out.println("Cannot convert");
        		System.exit(0);
        	}
        	if((Integer.parseInt(a) < 0 || Integer.parseInt(a) > 255) ||
        	   (a.length() > 1 && Integer.parseInt(String.valueOf(a.charAt(0))) == 0)) {
        		System.out.println("Out of Range or Leading Zeros");
        		System.exit(0);
        	} 	
        }
	}
}
