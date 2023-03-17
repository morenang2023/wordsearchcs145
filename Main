package wordsearch.wordsearch;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my word search generator");
        System.out.println("This program will allow you to generate your own word search puzzle");
        System.out.println("Please select an option:");
        System.out.println("Generate a new word search (g)");
        System.out.println("Print out your word search (p)");
        System.out.println("Show the solution to your word search (s)");
        System.out.println("Quit the program (q)");
        String option = scanner.nextLine();
        WordSearch wordSearch = null;
        while (!option.equals("q")) {
            if (option.equals("g")) {
                System.out.println("How many words would you like to include in your word search?");
                int numWords = Integer.parseInt(scanner.nextLine());
                List<String> words = new ArrayList<>();
                for (int i = 0; i < numWords; i++) {
                    System.out.println("Enter word " + (i + 1) + ":");
                    String word = scanner.nextLine();
                    words.add(word);
                }
                wordSearch = new WordSearch(words);
            } else if (option.equals("p")) {
                if (wordSearch != null) {
                    wordSearch.print();
                } else {
                    System.out.println("Please generate a word search first.");
                }
            } else if (option.equals("s")) {
                if (wordSearch != null) {
                    wordSearch.printSolution();
                } else {
                    System.out.println("Please generate a word search first.");
                }
            } else {
                System.out.println("Invalid option.");
            }
            System.out.println("Please select an option:");
            System.out.println("Generate a new word search (g)");
            System.out.println("Print out your word search (p)");
            System.out.println("Show the solution to your word search (s)");
            System.out.println("Quit the program (q)");
            option = scanner.nextLine();
        }
    }
}
