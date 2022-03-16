import java.util.Arrays;

public class LetterGrid {
    private String[][] letterGrid;
    private int currentRow;
    public static final String RESET = "\u001B[0m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String GREY_BACKGROUND = "\u001B[100m";
    private String answerWord;

    public LetterGrid(String answerWord) {
        currentRow = 0;
        letterGrid = new String[6][5];
        this.answerWord = answerWord;
    }

    public String[][] getLetterGrid() {
        return letterGrid;
    }

    public void addWord(String word) {
        for (int i = 0; i < letterGrid[0].length; i++) {
            String character = word.substring(i, i + 1);
            if (answerWord.contains(character) && character.equals(answerWord.substring(i, i + 1))) {
                letterGrid[currentRow][i] = GREEN_BACKGROUND + character + RESET;
            } else if (answerWord.contains(character)) {
                letterGrid[currentRow][i] = YELLOW_BACKGROUND + character + RESET;
            } else {
                letterGrid[currentRow][i] = GREY_BACKGROUND + character + RESET;
            }
        }
        System.out.println(this);
        currentRow++;
    }

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
