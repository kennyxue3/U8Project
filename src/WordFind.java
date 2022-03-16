import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFind {
    private String answerWord;
    private ArrayList<String> answerList;
    private ArrayList<String> guessList;
    private LetterGrid grid;

    public WordFind() {
        answerList = new ArrayList<>();
        guessList = new ArrayList<>();
        loadAnswersIn();
        loadGuessesIn();
        answerWord = answerList.get((int) (Math.random() * answerList.size()));
        grid = new LetterGrid(answerWord);
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Wordle!");
        System.out.println("DEBUG: " + answerWord);
        System.out.println(grid);
        int runs = 0;
        boolean win = false;
        while (runs < 6 && !win) {
            System.out.print("Please enter your guess: ");
            String guess = scan.nextLine();
            if (guess.length() == 5) {
                if (guess.equalsIgnoreCase(answerWord)) {
                    grid.addWord(guess);
                    System.out.println("Correct!");
                    win = true;
                    break;
                } else if (guessList.contains(guess) || answerList.contains(guess)) {
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

    public void loadAnswersIn() {
        try {
            Scanner input = new Scanner(new File("src/answers.txt"));
            while (input.hasNext()) {
                String word = input.next();
                answerList.add(word);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void loadGuessesIn() {
        try {
            Scanner input = new Scanner(new File("src/guesses.txt"));
            while (input.hasNext()) {
                String word = input.next();
                guessList.add(word);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


}


