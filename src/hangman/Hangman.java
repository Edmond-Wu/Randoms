package hangman;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Code for non-visual Hangman game. Player is given 10 guesses to guess a single word.
 * Guess count does not decrease for correct letter guesses.
 */

public class Hangman 
{
	//Checks if there are still letters to be guessed
	public static boolean has_blanks(char[] word)
	{
		for (int i = 0; i < word.length; i++)
		{
			if (word[i] == '_')
			{
				return true;
			}
		}
		return false;
	}
	
	//Runs Hangman game
	public static void play_hangman(String word)
	{
		word = word.toLowerCase();
		for (int spaces = 100; spaces > 0; spaces--)
		{
			System.out.println();
		}
		char[] blank_arr = new char[word.length() * 2];
		for (int j = 0; j < blank_arr.length; j++)
		{
			if (j % 2 == 0)
			{
				blank_arr[j] = '_';
			}
			else
			{
				blank_arr[j] = ' ';
			}
		}
		System.out.println("You have 10 guesses.");
		int num_guesses = 10;
		for (int x = 0; x < blank_arr.length; x++)
		{
			System.out.print(blank_arr[x]);
		}
		System.out.println();
		ArrayList<Character> missed_letters = new ArrayList<Character>();

		while (num_guesses > 0 && has_blanks(blank_arr))
		{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.print("Guess a letter: ");
			String guess = scan.next();
			while (guess.length() > 1)
			{
				System.out.println("Error. Only 1 letter per guess. Try again: ");
				guess = scan.next();
			}
			guess = guess.toLowerCase();
			if (word.contains(guess))
			{
				int count = 0;
				for (int i = 0; i < blank_arr.length; i += 2)
				{
					String comparison = "";
					comparison += word.charAt(i/2);
					if (comparison.equals(guess))
					{
						blank_arr[i] = guess.charAt(0);
						count++;
					}	
				}
				for (int k = 0; k < blank_arr.length; k++)
				{
					System.out.print(blank_arr[k]);
				}
				System.out.println();
				System.out.println("Your guess shows up " + count + " time(s)!");
				System.out.print("Missed letters: ");
				for (int n = 0; n < missed_letters.size(); n++)
				{
					System.out.print(missed_letters.get(n) + " ");
				}
				System.out.println();
			}
			else
			{
				System.out.println("Your guess didn't match any letters.");
				missed_letters.add(guess.charAt(0));
				System.out.print("Missed letters: ");
				for (int n = 0; n < missed_letters.size(); n++)
				{
					System.out.print(missed_letters.get(n) + " ");
				}
				System.out.println();
				for (int k = 0; k < blank_arr.length; k++)
				{
					System.out.print(blank_arr[k]);
				}
				System.out.println();
				num_guesses--;
			}
			System.out.println("You have " + num_guesses + " guesses left!");
		}
		if (has_blanks(blank_arr) && num_guesses == 0)
		{
			System.out.println("Sorry, you lose.");
			System.out.println("The word was \"" + word + "\".");
		}
		if (!has_blanks(blank_arr))
		{
			System.out.println("Congratulations you guessed the word!");
		}
	}
	
	//Main method
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = scan.next();
		play_hangman(word);
		System.out.println();
		System.out.print("Do you wish to play again? (Y/N): ");
		String play_again = scan.next();
		while (play_again.equalsIgnoreCase("y") || play_again.equalsIgnoreCase("yes"))
		{
			System.out.print("Enter a new word: ");
			String new_word = scan.next();
			play_hangman(new_word);
			System.out.println();
			System.out.print("Do you wish to play again? (Y/N): ");
			play_again = scan.next();
		}
	}
}
