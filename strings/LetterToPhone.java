package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LetterToPhone {
	public static ArrayList<String> results;
	public static HashMap<String,String[]> map;

	public static void main(String[] args) {
		/*Given a string containing digits from 2-9 inclusive, 
		 * return all possible letter combinations that the number could represent. 
		 * Return the answer in any order.

		A mapping of digit to letters (just like on the telephone buttons) 
		is given below. Note that 1 does not map to any letters.		 


		2 = abc  3 = def....
		
		2379877 = 3^8
		
			""
		 /   |  \
		0a   1 b  2c
	   /     |   \
	def     def   def
	
	"23" 
	
	create map {"2" : [a,b,c]....
	
	
	base case digits = ""
		add letcomb to results
		return
	
	num = digit[0]  //2,3
	take first digit off //3,""
	arr = get array value from num //[a,b,c],[d,e,f]
	loop index from 0 to 2
		letcome += arr[index] //a
		recusive case f(index,digits,letcomb) //(0,"3","a")	
	return
		
		{n} = 3^n
		ad ae af bd be bf cd ce cf
		
		Example 1:

		Input: digits = "23"
		Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
		Example 2:

		Input: digits = ""
		Output: []
		Example 3:

		Input: digits = "2"
		Output: ["a","b","c"]
				 

		Constraints:

		0 <= digits.length <= 4
		digits[i] is a digit in the range ['2', '9'].*/
		
		map = new HashMap<String,String[]>();
		map.put("2", new String[]{"a","b","c"});
		map.put("3", new String[]{"d","e","f"});
		map.put("4", new String[]{"g","h","i"});
		map.put("5", new String[]{"j","k","l"});
		map.put("6", new String[]{"m","n","o"});
		map.put("7", new String[]{"p","q","r"});
		map.put("8", new String[]{"s","t","u"});
		map.put("9", new String[]{"v","x","y","z"});  
		
		
		String digits = "23";
		results = new ArrayList<String>();
		
		LetterToPhones(0,digits,"");
		System.out.println(results);
	}
	
	public static void LetterToPhones(int index, String digits, String letcomb) {
		if(digits.isEmpty()) {
			results.add(letcomb);
			return;
		}
		String[] arr = map.get(digits.substring(0, 1));
		digits = digits.substring(1);
		for(int i = 0; i < arr.length; i++) {
			letcomb += arr[i];
			LetterToPhones(i,digits,letcomb);
			letcomb = letcomb.substring(0,letcomb.length() - 1);
		}
		return;	
	}

}
