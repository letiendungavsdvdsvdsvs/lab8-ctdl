package lab8_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File("data/fit.txt"));

		while (input.hasNext()) {
			String word = input.next();
			map.put(word, occurences(word));
			System.out.println(word);
		}
	}

	private int occurences(String word) {
		int occurences = 1;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			if(key == word) occurences++;
		}
		return occurences;
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		int count = 0;
		Set<String> set = map.keySet();
		for (String word : set) {
			count++;
		}
		return count;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key+"-"+val);
			
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() throws FileNotFoundException {
		TreeMap<String, Integer> m =  new TreeMap<String, Integer>(map);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key+"-"+val);
		}
		
	}
}
