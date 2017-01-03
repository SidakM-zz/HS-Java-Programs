
import java.util.Scanner;

public class anagramCreative {

		public static void main (String[] args){//get word from user
			String word;
			Scanner input = new Scanner(System.in);
			System.out.println("Enter word to find anagrams of: ");
			word = input.nextLine();
			findAnagrams(word, "");//call method to find anagrams
		}

		private static void findAnagrams(String word, String preWord) {//essentially finds and prints all the permutations of the set of characters
			if(word.length() < 2){// end point for recursion
				System.out.println(preWord + word);//once the preceding and following are less than 2 a distinct order is achieved and printed
			}else{
				for(int x =0;x<word.length();x++){//during the first occurrence full word  
					String current = word.substring(x , x+1);//take the first letter from word
					String preceding = word.substring(0, x);//set of letters preceding current
					String following = word.substring(x+1);//set of letters following current
					findAnagrams(preceding + following,current + preWord);/* 1) a set of character(s) become the preword and method calls itself 
																			 2) word now excludes the character(s) in the preword  */
				}		
				
			}
		}
}
