package wordsearch.wordsearch;
import java.util.*;

public class WordSearch {
    private char[][] grid;
    private List<String> words;
    private Map<String, List<int[]>> locations;
    
    public WordSearch(List<String> words) {
        grid = new char[20][20];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = ' ';
            }
        }
        this.words = words;
        locations = new HashMap<>();
        generate();
    }
    
    private void generate() {
        for (String word : words) {
            List<int[]> wordLocations = new ArrayList<>();
            boolean wordPlaced = false;
            while (!wordPlaced) {
                int startRow = (int) (Math.random() * 20);
                int startCol = (int) (Math.random() * 20);
                int deltaRow = -1 + (int) (Math.random() * 3);
                int deltaCol = -1 + (int) (Math.random() * 3);
                if (deltaRow == 0 && deltaCol == 0) {
                    continue;
                }
                if (canPlaceWord(word, startRow, startCol, deltaRow, deltaCol)) {
                    for (int i = 0; i < word.length(); i++) {
                        int row = startRow + i * deltaRow;
                        int col = startCol + i * deltaCol;
                        grid[row][col] = word.charAt(i);
                    wordLocations.add(new int[] {row, col});
                }
                wordPlaced = true;
                locations.put(word, wordLocations);
            }
        }
    }
}

private boolean canPlaceWord(String word, int startRow, int startCol, int deltaRow, int deltaCol) {
    if (startRow + deltaRow * word.length() < 0 || startRow + deltaRow * word.length() >= grid.length) {
        return false;
    }
    if (startCol + deltaCol * word.length() < 0 || startCol + deltaCol * word.length() >= grid[0].length) {
        return false;
    }
    for (int i = 0; i < word.length(); i++) {
        int row = startRow + i * deltaRow;
        int col = startCol + i * deltaCol;
        if (grid[row][col] != ' ' && grid[row][col] != word.charAt(i)) {
            return false;
        }
    }
    return true;
}

public void print() {
    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
            System.out.print(grid[row][col] + " ");
        }
        System.out.println();
    }
}

public void printSolution() {
    char[][] solution = new char[20][20];
    for (int row = 0; row < solution.length; row++) {
        for (int col = 0; col < solution[row].length; col++) {
            solution[row][col] = ' ';
        }
    }
    for (String word : words) {
        List<int[]> wordLocations = locations.get(word);
        for (int[] location : wordLocations) {
            int row = location[0];
            int col = location[1];
            solution[row][col] = word.charAt(0);
        }
    }
    for (int row = 0; row < solution.length; row++) {
        for (int col = 0; col < solution[row].length; col++) {
            System.out.print(solution[row][col] + " ");
        }
        System.out.println();
    }
}}
