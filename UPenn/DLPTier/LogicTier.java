
import java.util.HashSet;
import java.util.Set;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
		System.out.println(this.findBookTitlesByAuthor("Brown, Dan"));
		System.out.println(this.findNumberOfBooksInYear(2004));
	}
	
	public Set<String> findBookTitlesByAuthor (String author) {
		Set <String> TitleSet = new HashSet<String>();
		String inputAuthor = author.replaceAll("\"" , "").toLowerCase().trim();
		String compareAuthor;
		
		for(Book book: dataTier.getBooks()) {
			//System.out.println(book.author.replaceAll("\"" , ""));
			//System.out.println(author.trim());
			compareAuthor = book.getAuthor().replaceAll("\"" , "").toLowerCase().trim();
			if(compareAuthor.contains(inputAuthor)) {
				TitleSet.add(book.getTitle());
			}
		}
		return TitleSet;
	}
	
	public int findNumberOfBooksInYear (int year) {
		int numOfBooks = 0;
		
		for(Book book: dataTier.getBooks()) {
			if(book.getPublicationYear() == year) {
				numOfBooks++;
			}
		}
		return numOfBooks;
	}

}
