import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void showBookTitlesByAuthor() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter an Author Name: ");
		String authorName = reader.nextLine();
		System.out.println("Here are the Book Titles for " + authorName + " :");
		try {
			for(String Title: this.logicTier.findBookTitlesByAuthor(authorName)) {
				System.out.println(Title);
			}
		}catch(Exception e) {
			System.out.println("No Book found");
		}

		reader.close();
	}
	
	public void showNumberOfBooksInYear() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a year: ");
		int year = reader.nextInt();
		System.out.println("The number of books in " + year + " is:");
		System.out.println(this.logicTier.findNumberOfBooksInYear(year));
		reader.close();
	}
	
	public void start() {
		this.showBookTitlesByAuthor();
		//this.showNumberOfBooksInYear();
	}
	

}
