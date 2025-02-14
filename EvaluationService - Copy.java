package com.revature.eval.java.core;

import java.beans.Expression;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {

		/*
		 * TODO Write an implementation for this method declaration
		 * 
		 * need select first non empty character in array, then itereate through string
		 * selecting first character proceeded by an empty character (space) select it
		 * then combine them into a virable and return it
		 * 
		 * int counter = 0 char [] compare = phrase.toCharArray(); //this converts the
		 * string into a char array
		 * 
		 * while ( counter <= compare.length()) { if (compare[0] == ' ') {counter ++;}
		 * if (compare[0] ! ' ') {compare[counter] } return null; } String acronym = "";
		 * String basic() { acronym += phrase.toUpperCase().charAt(0); for (int i = 1; i
		 * <= phrase.length() - 1; i++) { if (phrase.charAt(i - 1) == ' ' ||
		 * phrase.charAt(i - 1) == '-') { acronym += phrase.toUpperCase().charAt(i); } }
		 * return acronym; } }
		 */

		String result = phrase.replaceAll("\\B.|\\P{L}", "").toUpperCase(); // regex \\B sets the word boundary to the
																			// left and selects
																			// and \\\P{L}all the characters from a
																			// whitespace to the boundary
		return result;

	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		/*
		 * need to determine what kind of triangle compare the sides to one another to
		 * determie if any of them are equal
		 * 
		 */

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			boolean lateral;
			if (sideOne == sideTwo & sideTwo == sideThree & sideOne == sideThree) {
				boolean Lateral = true;
			}
			return lateral;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			boolean iso;
			if (sideOne == sideTwo | sideTwo == sideThree | sideOne == sideThree) {
				boolean Lateral = true;
			}

			return false;
		}

		public boolean isScalene() {
			boolean scalene;
			if(sideOne != sideTwo &  sideOne !== sideThree !== sideOne | sideTwo != sideThree)
			// TODO Write an implementation for this method declaration
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		/*
		 * Map<Integer, String> scrabble; //char [] scabArray = string.toCharArray();
		 * 
		 * int sum = 0; for(int i = 0; i < string.length(); i++) { char[] inputstring =
		 * string.toCharArray(); //converts the input string to a CharArray to be
		 * comparable char[] value1 ="abioulrst".toCharArray(); // char arrays that
		 * contain all the potentional value groups char[] value2 = "g".toCharArray();
		 * char[] value3 = "bcmp".toCharArray(); char[] value4 = "fhvwy".toCharArray();
		 * char[] value5 = "k".toCharArray(); char[] value8 = "jx".toCharArray(); char[]
		 * value10 = "z".toCharArray(); // have to run against these values to add up
		 * score
		 * 
		 * /*boolean hasSameChar(string){ for(value1 : string.toCharArray()){
		 * if(string.indexOf(i) < 0 ) return false; //checking to see if string has any
		 * of the letters in the value1 array int value = 0; if(value1. ) { value = 1;
		 * sum = sum + value; } if(string.contains('g') //(i).contains("g")) { value =
		 * 2; sum = sum +value; } if(string.contains("b","c","m","p")){ value = 3; sum =
		 * sum + value; } if(string.contains("f","h","v","w","y")){ value = 4; sum = sum
		 * + value; } if(string.contains("k")){ value = 5; sum = sum + value; }
		 * if(string.contains("j", "X")){ value = 8; sum = sum + value; }
		 * if(string.contains("z"){ value = 10; sum = sum + value; } return sum; }
		 */

		int score = 0;
		for (int i = 0; i < string.length(); i++) {
			char calculatedLetter = string.charAt(i);
			switch (calculatedLetter) {
			case 'A':
			case 'E':
			case 'I':
			case 'L':
			case 'N':
			case 'O':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
				score += 1;
				break;
			case 'D':
			case 'G':
				score += 2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				score += 3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				score += 4;
				break;
			case 'K':
				score += 5;
				break;
			case 'J':
			case 'X':
				score += 8;
				break;
			case 'Q':
			case 'Z':
				score += 10;
				break;
			default:
				break;
			}
		}
		return score;

		// exmaples from
		// Matt from SOvF
		// https://stackoverflow.com/questions/18983883/how-to-calculate-scrabble-score-of-a-word

	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	final String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		boolean countryCodeSearch = false;
		char[] number = new char[10];
		int numLoc = 0;
		char[] originalNumber = string.toCharArray();
		char placeHolder = ' ';

		for (int i = 0; i < originalNumber.length; i++) {
			placeHolder = originalNumber[i];
			switch (placeHolder) {
			case '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' | '0': {
				if (countryCodeSearch == false & originalNumber[i] == '1') {
				}

				else {
					number[numLoc] = originalNumber[i];
					numLoc++;
				}
				countryCodeSearch = true;

			}
			default:
				break;
			}

		}

		if (number[9] != ' ')
			return "Not a valid Number";
		else
			return new String(number.toString());

	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		/* TODO Write an implementation for this method declaration
	    List<String> output = new ArrayList<>();
	    List<Integer> count = new ArrayList<>();
	    findWords(string, output, count);
	    System.out.println(output);
	    System.out.println(count);
	}
*/
		  String[] stringArrays = string.split(" ");
		    Map<String, Integer> map = new HashMap<String, Integer>(); 
		    Set<String> words = new HashSet<String>(Arrays.asList(stringArrays)); //sets the String portion of the Map pair
		    int count = 0;
		    for (String word : words)                   //iteraters through the list of strings			
		        for (String temp : stringArrays) {  
		            if (word.equals(temp)) {
		                ++count;
		            }
		        }
		        map.put(words, count); 					// this sets the format of the key pairs from the virables above
		        count = 0;
		    }

	return map;

}

return null;}

/**
 * 7. Implement a binary search algorithm.
 * 
 * Searching a sorted collection is a common task. A dictionary is a sorted list
 * of word definitions. Given a word, one can find its definition. A telephone
 * book is a sorted list of people's names, addresses, and telephone numbers.
 * Knowing someone's name allows one to quickly find their telephone number and
 * address.
 * 
 * If the list to be searched contains more than a few items (a dozen, say) a
 * binary search will require far fewer comparisons than a linear search, but it
 * imposes the requirement that the list be sorted.
 * 
 * In computer science, a binary search or half-interval search algorithm finds
 * the position of a specified input value (the search "key") within an array
 * sorted by key value.
 * 
 * In each step, the algorithm compares the search key value with the key value
 * of the middle element of the array.
 * 
 * If the keys match, then a matching element has been found and its index, or
 * position, is returned.
 * 
 * Otherwise, if the search key is less than the middle element's key, then the
 * algorithm repeats its action on the sub-array to the left of the middle
 * element or, if the search key is greater, on the sub-array to the right.
 * 
 * If the remaining array to be searched is empty, then the key cannot be found
 * in the array and a special "not found" indication is returned.
 * 
 * A binary search halves the number of items to check with each iteration, so
 * locating an item (or determining its absence) takes logarithmic time. A
 * binary search is a dichotomic divide and conquer search algorithm.
 * 
 */
static class BinarySearch<T> {
	private List<T> sortedList;

	public int indexOf(T t) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	public BinarySearch(List<T> sortedList) {
		super();
		this.sortedList = sortedList;
	}

	public List<T> getSortedList() {
		return sortedList;
	}

	public void setSortedList(List<T> sortedList) {
		this.sortedList = sortedList;
	}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		if(string.contains("a","e"))
		
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		// abcd... = pow(a,n) + pow(b,n) + pow(c,n) + pow(d,n) input string length
		// amount of Integers and raise them whatever number they are 5 to the fifth
		// etc.

		// gotta grab each number

		// String temp = Integer.toString(input);

		// now i have the word 153 as a string

		int c = 0, a, temp;
		temp = input;

		while (temp > 0) {
			a = temp % 10;
			temp = temp / 10;
			c = c + (a * a * a);
		}
		if (temp == c)
			return true;
		else
			return false;

	}
	/*
	 * with help examples from https://www.javatpoint.com/armstrong-number-in-java
	 */

	/*
	 * int[] newGuess = new int[temp.length()]; for (int i = 0; i < temp.length();
	 * i++) { newGuess[i] = temp.charAt(i) - '0'; //now i have the number passed in
	 * a Integer[] array. newGuess.toString(input); } Jon Skeet of SOvF at
	 * https://stackoverflow.com/questions/8033550/convert-integer-to-array-of-
	 * digits
	 */
//Math.pow(x, y)

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		List tester = new ArrayList;
	
		long temp = l;
		
		while (l % 2 ==0)				//this gives us only odd numbers
		temp = l /  2;
		
		  for (int i = 3; i <= Math.sqrt((double)l); i = i + 2)  //starting at 3 //prepare for funky long and double 
			  													//		problems if the number is too big
		    {  
		        // While i divides n, print i and divide n  
		        while (n % i == 0)  
		        {  
		            cout << i << " ";  
		            n = n/i;  
		        }  
		    }
		  
		  
		
		
		
		
		
		
		// TODO Write an implementation for this method declaration
		
		
		
		
		
		return null;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int n) {
		// TODO Write an implementation for this method declaration
		int result;  
		for(int i = 2, int x = 2; i <= n; i++) {
	            for(x = 2; x < i; x++) {				
	                if(i % x == 0) {
	                    break;
	                }
	            }
	            if(x == i) {
	                System.out.printf("\n%d is prime", x); //\n makes new lines and %d formats Integaers
	            }
		  }
		
		
		
		return x;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {

//String alphabit [Interger] = new String();

			/*
			 * char [] cypher =
			 * {'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','h','g','f',
			 * 'e','d','c','b','a'} for(int i = 0; i < cypher.length(); i++ ) { //a needs to
			 * be index of cypher array
			 * 
			 * if (s2.indexOf(s1.charAt(i)) ==
			 * 
			 * byte [] strAsByteArray = new string.getBytes();
			 * 
			 * byte [] result = new byte [strAsByteArray.length];
			 * 
			 * for (int i = 0; i<strAsByteArray.length; i++) result[i] =
			 * strAsByteArray[strAsByteArray.length-i-1];
			 * 
			 * System.out.println(new String(result));
			 * 
			 * 
			 * for(int i = string.length() - 1; i >= 0; i--) { string reverse = reverse +
			 * string.charAt(i); }
			 * 
			 * return string; }
			 * 
			 * StringBuilder sb = new StringBuilder();
			 * 
			 * for(int i = string.length() - 1; i >= 0; i--) //-1 so no out of bounds
			 * exception??? { sb.append(string.charAt(i)); } return string;
			 */

			char[] temparray = string.toCharArray();
			int left, right = 0;
			right = temparray.length - 1;

			for (left = 0; left < right; left++, right--) {
				// Swap values of left and right
				char temp = temparray[left];
				temparray[left] = temparray[right];
				temparray[right] = temp;
			}

			return temp;

		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		//regex expression for removing hyphens "(?<=\\w)-(?=\\w)"
		// if the last digit is a X replace it with 10
		
		int [] numsToBeMath; 
		int temp; //= new ArrayList<Integer>();
		
		for(int i = 0; i< string.length(); i ++) {
			
			if(Character.isAlphabetic(string.charAt(string.length()))) {
				if(string.charAt(string.length()) == 'X')   //checking to see if there is an X at the last index and replacing it with 10
				string.replace(string.charAt(string.length()), (char) 10);  //replaces the last index with 10 if a letter is found
				
			}				
		if(Character.isDigit(string.charAt(i))){         //if the character at each index is a digit
			numsToBeMath[i] = string.charAt(i); 		// numsToBeMath.add((int) string.charAt(i));     //this will yield an ArrayList with the numbers to be Mathed
		}
		//we should have a properly formated int array to be mathed
		}
		
		
		 //List<int[]> list = Arrays.asList(numsToBeMath);   //converting the int array into a list to iterate over
		for(int i = 0; i<numsToBeMath.length; i++) {
			temp = numsToBeMath[i] * numsToBeMath[numsToBeMath.length - i] + numsToBeMath[i+1];		
			
		}
	if(temp % 11 ==0)
	{
		return true;		
	}
	else return false;
	
		/*	String expression = ("(?<=\\w)-(?=\\w)");
		string.//replaceAll((?<=\\w)-(?=\\w)) = expression; //why can I not do this
		 int result = Integer.parseInt(string);	 //converting a string into an INT madness
		 for(int i = 0; i < string.length(); i++){
			 
			 if(string.indexOf(i).character.isDigit)
			 	 
		 
		 }
		 */
			 
		
		
		
		
		
	}

	}
	// TODO Write an implementation for this method declaration
	return false;

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γ�άμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
	// TODO Write an implementation for this method declaration

	/*
	 * for(int i = 0; i < string.length()); i++){ string.charAt(i)
	 */

	/*
	 * int count = 0;
	 * 
	 * for(int i=0; i < string.length(); i++) { if(string.charAt(i) ==
	 * string.charAt(i)) //only works if each letter appears only one count++; }
	 * 
	 * if(count == 26) { return true;
	 * 
	 * else return false; } return false;
	 */

	public static boolean isPangramWithStreams(String s tr) {
		    if (str == null) { //if nothing is passed
		        return false;
		    }
		    String strUpper = str.toLowerCase();             //the input string is capitalized
		 
		    Stream<Character> filteredCharStream = str.chars()      
		      .filter(item -> ((item >= 'A' && item <= 'Z'))) //scans from range A to Z
		      .mapToObj(c -> (char) c);
		 
		    Map<Character, Boolean> alphabetMap =  //if a character appears in
		      filteredCharStream.collect(Collectors.toMap(item -> item, k -> Boolean.TRUE, (p1, p2) -> p1));
		 
		    if(alphabetMap.size() == 26) //checks to see if there are 26 numbers
		    	return true;
		}

	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		// passing as LocalDataTime 
		double live = Math.pow(10,9); //the gigasecond
				
		LocalDate localDate = LocalDate.of(2017, 07, 8);
	    TemporalAdjuster temporalAdjuster = t -> t.plus(Period.ofDays(14));
	    LocalDate result = localDate.with(temporalAdjuster);
	    
				
				
				
				
				
				
				/*if(seconds == live) {
					
				}
				while(live <= temporal. )
		return null;*/
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
	int sum[];
	for(int c = 0; c<set.length; c++)
	{
		
		int a = i / set[i]; //
		int b = a*(a+1) / 2; 
		
	}
	
	
	}

	/*
	 * int MAX = set[0]; static int answer[]; for (int c = 1; c < i; c++) //finds
	 * the leagest num in the array MAX = Math.max(set[c], MAX);
	 * 
	 * for(int d = 0; d<MAX.length; d++ ) { // we have the length of however large
	 * the array is passed in
	 * 
	 * }
	 * 
	 * int count[] = new int[MAX + 1]; //gives an int arr that is of the size of the
	 * passed in set answer = new Int[MAX +1]; //makes an array of same size to put
	 * answer in
	 */

	/*
	 * int a,b,c,sum,sum1, totalsum;
	 * 
	 * for(int c = 0; i < set.length; c++ ) a = i / set[0]; //finding multples b = i
	 * / set[1]; sum = a * (a+1) / 2; //sum of multples of first digit sum1 =b
	 * *(b+1) / 2; totalsum = sum + sum1; return totalsum;
	 * 
	 * //if the length of the passed in set is unknown hw //only works with sets of
	 * 2
	 */

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		
		int size = string.length();
		/*char [] strArray = string.toCharArray();
		 * char c = string.charAt(i)
		 * turn  Character.getNumericValue(the char);
		 * convert that into an 
		 * */
		int [] array = new int [size];
		Character.
		for (int i =0; i<size; i++)
			array[i] = Integer.parseInt(strArray[i]); //so array should now be an int array
		
													//need to take array and multiple by two every other index
		for(int i = 0; i < array.length; i= i + 2) 		// this iterates every second element
			{int temp = 0;
			temp = array[i] *2;   
					if(temp > 9)
						temp = temp - 9;       //need to replace the value of temp into the array
				
			array[i] = temp; 				//this sets every second element to temp 
			}
										// need to add up the elements of the array
		int sum = Arrays.stream(array).sum();
		if(sum % 10 ==0) 				   //if the sum of the array is divisable by 10 return true
			return true;
		else
			return false;
		
	}
	// TODO Write an implementation for this method declaration
	return false;

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?      //have to translate a key String into a math operation
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		//have to check to see which String operator the word problem needs to implement
		/*if(string.contains ("plus"))  		//checks if string contrains various keywords
											//needs somehow grab the numbers from the string and add them together
		
			 String parts = string.split("\\D+");    //is string containing integers
		int[] a;
		a = new int[parts.length]; 					//this array contrains all the digits of the string
		for(int i=0; i<parts.length; i++){
		a[i]= Integer.parseInt(parts[i]);
			
			
		if(string.contains("multiplied"))
			
		if(string.contains("divided"))
		if(string.contains("minus")) */    
		 String numberOnly= str.replaceAll("[^0-9]", ""); // takes only the numbers from the string
		 string.
			
		
		return 0;
	}

}
