import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; 
	private Set<Book> Books = new HashSet<Book>(); 
	
	public Set<Book> getBooks() {
		return Books;
	}

	public DataTier(String inputSource) {
		fileName = inputSource;
		this.getAllBooks();
	}
	
	public Set<Book> getAllBooks() {
		String sentline[] = new String[3];
		Path path;
		Charset charset = Charset.forName("US-ASCII");
		Book book;
		
		path = Paths.get(fileName);
		
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	if(line.length() == 0) {
		    		continue;
		    	}
		    	sentline = line.split("\t", 3);
		    	book = new Book(sentline[0], sentline[1], Integer.parseInt(sentline[2]));
		        //System.out.println(sentline[0]);
		    	//System.out.println(sentline[1]);
		    	//System.out.println(sentline[2]);
		    	Books.add(book);
		    }
		} catch (IOException x) {
			return null;
		}		
		return Books;
		
	}
	


}
