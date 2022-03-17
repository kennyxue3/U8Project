import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a game of Wordle/WordFind
 * @author Kenny Xue
 */
public class WordFind {
    private String answerWord;
    private ArrayList<Word> answerList;
    private ArrayList<Word> guessList;
    private LetterGrid grid;

    /**
     * Initializes an object of WordFind the game
     */
    public WordFind() {
        answerList = new ArrayList<>();
        guessList = new ArrayList<>();
        loadAnswersIn();
        loadGuessesIn();
        answerWord = answerList.get((int) (Math.random() * answerList.size())).getWord();
        grid = new LetterGrid(answerWord);
    }

    /**
     * Plays a game of Wordle/WordFind until the winner succeeds/fails
     */
    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Wordle!");
        System.out.println("DEBUG: " + answerWord);
        System.out.println(grid);
        int runs = 0;
        boolean win = false;
        while (runs < 6) {
            System.out.print("Please enter your guess: ");
            String guess = scan.nextLine();
            if (guess.length() == 5) {
                if (guess.equalsIgnoreCase(answerWord)) {
                    grid.addWord(guess);
                    System.out.println("Correct!");
                    win = true;
                    break;
                } else if (guessList.contains(new Word(guess)) || answerList.contains(new Word(guess))) {
                    grid.addWord(guess);
                    runs++;
                } else {
                    System.out.println("Invalid guess!");
                }
            } else {
                System.out.println("Invalid guess!");
            }
        }
        if (!win) {
            System.out.println("GAME OVER! CORRECT WORD: " + answerWord);
        }
    }

    /**
     * Helper method to initialize ArrayList of Words that are possible answers for Wordle to generate.
     */
    public void loadAnswersIn() {
        try {
            Scanner input = new Scanner(new File("src/answers.txt"));
            while (input.hasNext()) {
                String word = input.next();
                answerList.add(new Word(word));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Helper method to initialize ArrayList of Words that are possible guesses for Wordle to accept.
     */
    public void loadGuessesIn() {
        try {
            Scanner input = new Scanner(new File("src/guesses.txt"));
            while (input.hasNext()) {
                String word = input.next();
                guessList.add(new Word(word));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}


