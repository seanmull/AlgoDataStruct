import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags){
		Stack<HtmlTag> stackTags = new Stack<HtmlTag>();
		int numOfTags = tags.size();
		HtmlTag curTag;
		String TagStatus; 

		//System.out.println("Queue list");
		for(int i = 0; i < numOfTags; i++) {
			//System.out.print(tags.peek() + "\n");
			curTag = tags.element();
			if(curTag.isOpenTag()) {
				TagStatus = "Open";
			}else if(curTag.isSelfClosing()) {
				TagStatus = "Self-Close";
			}else {
				TagStatus = "Close";
			}
			if(TagStatus == "Close" && stackTags.isEmpty()) {
				stackTags = null;
				return null;
			}
			switch(TagStatus) {
			case "Open": stackTags.push(tags.remove()); continue;	
			case "Self-Close": tags.remove(); continue;
			case "Close":
				if(stackTags.peek().matches(curTag)) {
					stackTags.pop();
					tags.remove();
					continue;
				}
			}
		}
		//System.out.println("\nStack list");
		//if(stackTags == null) {
		//	System.out.println("null");
		//	return null;
		//}
		//while(stackTags.size() != 0) {
		//	System.out.print(stackTags.peek() + "\n");
		//	stackTags.pop();
		//}
		
		return stackTags;
	}
	
	public static void main(String[] args) throws IOException{
		Queue<HtmlTag> tags = HtmlReader.getTagsFromHtmlFile("ex3.html");
	
		HtmlValidator.isValidHtml(tags);
		
		//System.out.print("done");
	}
	
	

}

