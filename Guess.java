// Rhea Toves
// 2/9/2021
// TA: Jeremy Chen
// Assignment #5: Guess.java
//
// This program will generate a simple guessing game that allows the user to make guesses
// until they get it right. This version includes if/else statements, while loops and
// pseudorandom numbers. For each incorrect guess, this program will tell the user whether
// the right answer is higher or lower. Quoted from the Assignment #5 PDF.

import java.util.*;

public class Guess {
   public static final int RANGE = 100;
   
   // Offers the user the opportunity to play again or end game.
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      giveIntro();
      String response = "y";
      int totalGames = 1;
      int numGuesses = playOneGame(console);
      int totalGuesses = numGuesses;
      int min = numGuesses;
      System.out.print("Do you want to play again? ");
      response = console.next();
      while (response.startsWith("y") || response.startsWith("Y")) {
         numGuesses = playOneGame(console);
         System.out.print("Do you want to play again? ");
         response = console.next();
         totalGames++;
         totalGuesses += numGuesses;
         if (numGuesses < min) {
            min = numGuesses;
            
         }
         
      }
      report(totalGames, totalGuesses, min);
   }
   
   // Generates the introduction.
   public static void giveIntro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      
   }
   
   // Plays one round of the guessing game and states how many guesses in one game.
   // The Scanner Console takes in user input.
   public static int playOneGame(Scanner console) {
      System.out.println();
      System.out.println("I'm thinking of a number between 1 and 100...");
      Random r = new Random();
      int answer = r.nextInt(RANGE) + 1;
      int guess = 0;
      int numGuesses = 0;
      while (guess != answer) {
         System.out.print("Your guess? ");
         guess = console.nextInt();
         higherLower(guess, answer);
         numGuesses++;
         
      }
      if (numGuesses == 1) {
         System.out.println("You got it right in 1 guess");
      } else { // if user inputs any other number than 1
         System.out.println("You got it right in " + numGuesses + " guesses");
      }
      return numGuesses;
      
   }
   
   // Reports the overall results. This method has parameters of totalGames, totalGuesses,
   // and the min. These three variables are then reported to the user at the end of the game.
   public static void report(int totalGames, int totalGuesses, int min) {
      System.out.println();
      System.out.println("Overall results:");
      System.out.println("    total games   = " + totalGames);
      System.out.println("    total guesses = " + totalGuesses);
      System.out.println("    guesses/game  = " + round1((double)totalGuesses / (double)totalGames));
      System.out.println("    best game     = " + min);
      
   }
   
   // Informs the user if their guess is higher/lower than the answer. This method has
   // parameters of guess and answer and compares the two in order to report higher/lower.
   public static void higherLower(int guess, int answer) {
      if (guess > answer) {
         System.out.println("It's lower.");
      } else if (guess < answer) {
         System.out.println("It's higher.");
      } else { // if guess = answer
         
      }
   }
   
   // Returns the result of rounding n to 1 digit after the decimal point.
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}