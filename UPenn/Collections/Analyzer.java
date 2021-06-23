import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	static Map<String, Double> map = new HashMap<String, Double>();
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		List<Sentence> sentences = new ArrayList<Sentence>();
		String sentline[] = new String[2];
		Path path;
		try {
		path = Paths.get(filename);
		}catch(Exception e){
			return sentences;
    	}
		Charset charset = Charset.forName("US-ASCII");
		int value;
		float fvalue;
		String SentText;
		
		try {
			if(filename.isEmpty()) {
				return sentences;
			}
		}catch(Exception e){
			return sentences;
    	}
		
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	if(line.length() == 0) {
		    		continue;
		    	}
		    	sentline = line.split(" ", 2);
		    	try {
		    		Integer.parseInt(sentline[0]);
		    	}catch(Exception e){
		    		continue;
		    	}
		    	value = Integer.parseInt(sentline[0]);
		    	fvalue = Float.parseFloat(sentline[0]);
		    	try {
		    	if(sentline[1].isEmpty()) {
		    		continue;
		    	}
		    	}catch(Exception e){
		    		continue;
		    	}
		    	SentText = sentline[1];
		    	if(value > 2 || value < -2 || SentText.isEmpty() || SentText == null || value != fvalue) {
		    		continue;
		    	}
		    	Sentence sentence = new Sentence(Integer.parseInt(sentline[0]), sentline[1]);
		    	sentences.add(sentence);
		        //System.out.println(sentline[0]);
		    	//System.out.println(sentline[1]);
		    }
		} catch (IOException x) {
			return sentences;
		}
		return sentences;
	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		Set<Word> words = new HashSet<Word>();
		String wordText;
		String[] text;
		char firstChr;
		Word word;
		boolean inList;
		ArrayList <Word> wordList = new ArrayList <Word>();

		try {
			if(sentences.isEmpty()) {
				return words;
			}
		}catch(Exception e) {
			return words;
		}
		
		for(int i = 0; i < sentences.size(); i++) {
			if(sentences.get(i) == null || sentences.get(i).text.isEmpty()) {
				continue;
			}
			text = sentences.get(i).text.split(" ");
			for(int j = 0; j < text.length; j++) {
				inList = false;
				wordText = text[j].toLowerCase();
				firstChr = wordText.charAt(0);
				if(!Character.isLetter(firstChr)) {
					continue;
				}
				word = new Word(wordText);				
				for(Word wordInList : wordList) {
					if(wordInList.equals(word)) {
						wordInList.increaseTotal(sentences.get(i).score);
						inList = true;
						break;
					}
				}
				if(inList == false) {
					word.increaseTotal(sentences.get(i).score);
					//System.out.println(word.text);
					wordList.add(word);
				}
			}
			for(Word wordInList : wordList) {
				words.add(wordInList);
			}
		}
		return words; 
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		
		try {
			if(words.isEmpty()) {
				return map;
			}
		}catch(Exception e) {
			return map;
		}
		
		for(Word word: words) {
			if(word == null) {
				continue;
			}
			map.put(word.text, word.calculateScore());
		}
		return map;
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		double sumOfScores = 0;
		int numOfValidWords = 0;
		String[] wordStrings;
		String wordString;
		char firstChr;
		boolean noValidWords = true;
		
		try {
			if(sentence.isEmpty() || wordScores.isEmpty()) {
				return 0;
			}
		}catch(Exception e) {
			return 0;
		}
		
		wordStrings = sentence.split(" ");
		
		for (int i = 0; i < wordStrings.length; i++) {
			//noValidWords = true;
			wordString = wordStrings[i].toLowerCase();
			firstChr = wordStrings[i].charAt(0);
			if(!Character.isLetter(firstChr)) {
				continue;
			}
			if(!wordScores.containsKey(wordString)) {
				sumOfScores += 0;
			}else {
				sumOfScores += wordScores.get(wordString);
				noValidWords = false;
			}
			numOfValidWords++;
		}
		if(noValidWords) {
			return 0;
		}else {
			return sumOfScores / numOfValidWords; 
		}
	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
