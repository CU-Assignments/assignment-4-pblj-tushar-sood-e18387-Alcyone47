/* Medium Level: Card Collection System Problem Statement 📝 Create a program to collect and store all the cards (e.g., playing cards) and assist users in finding all the cards of a given symbol using the Collection interface.
Key Concepts Used HashMap: To store cards with their symbols as keys.
Collection Interface: To manage and manipulate the card data.
User Interaction: Allow users to search for cards by symbol.
How to Run Navigate to the Medium/ folder.
Compile and run the CardCollection.java file.
Enter the symbol (e.g., "Hearts", "Spades") to find all cards of that symbol. */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class A4medium {
  public static void main(String[] args) {
    Map<String, String[]> cardCollection = new HashMap<>();
    cardCollection.put("Hearts", new String[] {"Ace of Hearts", "2 of Hearts", "3 of Hearts", "4 of Hearts", "5 of Hearts", "6 of Hearts", "7 of Hearts", "8 of Hearts", "9 of Hearts", "10 of Hearts", "Jack of Hearts", "Queen of Hearts", "King of Hearts"});
    cardCollection.put("Spades", new String[] {"Ace of Spades", "2 of Spades", "3 of Spades", "4 of Spades", "5 of Spades", "6 of Spades", "7 of Spades", "8 of Spades", "9 of Spades", "10 of Spades", "Jack of Spades", "Queen of Spades", "King of Spades"});
    cardCollection.put("Diamonds", new String[] {"Ace of Diamonds", "2 of Diamonds", "3 of Diamonds", "4 of Diamonds", "5 of Diamonds", "6 of Diamonds", "7 of Diamonds", "8 of Diamonds", "9 of Diamonds", "10 of Diamonds", "Jack of Diamonds", "Queen of Diamonds", "King of Diamonds"});
    cardCollection.put("Clubs", new String[] {"Ace of Clubs", "2 of Clubs", "3 of Clubs", "4 of Clubs", "5 of Clubs", "6 of Clubs", "7 of Clubs", "8 of Clubs", "9 of Clubs", "10 of Clubs", "Jack of Clubs", "Queen of Clubs", "King of Clubs"});
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Enter the symbol (e.g., 'Hearts', 'Spades') to find all cards of that symbol, or 'exit' to quit:");
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("exit")) {
        break;
      }
      if (cardCollection.containsKey(input)) {
        System.out.println("Cards of " + input + ":");
        for (String card : cardCollection.get(input)) {
          System.out.println(card);
        }
      } else {
        System.out.println("No cards found for the symbol '" + input + "'.");
      }
    }
    scanner.close();
  }
}