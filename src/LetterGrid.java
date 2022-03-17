/**
 * Represents a grid of letters
 * @author Kenny Xue
 */
public class LetterGrid {
    private String[][] letterGrid;
    private int currentRow;
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GRAY = "\u001B[37m";
    private String answerWord;

    /**
     * Initializes a LetterGrid object with the correct answer
     * @param answerWord The correct answer
     */
    public LetterGrid(String answerWord) {
        currentRow = 0;
        letterGrid = new String[6][5];
        this.answerWord = answerWord;
    }

    /**
     * Adds a guess to the LetterGrid, checks what letters are found in the answer
     * @param word Guess to add
     */
    public void addWord(String word) {
        for (int i = 0; i < letterGrid[0].length; i++) {
            String character = word.substring(i, i + 1);
            if (answerWord.contains(character) && character.equals(answerWord.substring(i, i + 1))) {
                letterGrid[currentRow][i] = GREEN + character + RESET;
            } else if (answerWord.contains(character)) {
                letterGrid[currentRow][i] = YELLOW + character + RESET;
            } else {
                letterGrid[currentRow][i] = GRAY + character + RESET;
            }
        }
        System.out.println(this);
        currentRow++;
    }

    /**
     * Returns the LetterGrid stylized
     * @return The grid of letters stylized
     */
    public String toString() {
        String returnString = "";
        for (String[] row : letterGrid) {
            for (String column : row) {
                if (column == null) {
                    returnString += "_ ";
                } else {
                    returnString += column + " ";
                }
            }
            returnString += "\n";
        }
        return returnString;
    }
}
