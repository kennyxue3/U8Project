/**
 * Represents a Word
 * @author Kenny Xue
 */
public class Word {

    String word;

    /**
     * Initializes a Word object with a String it represents
     * @param word THe String to be stored in the Word objet
     */
    public Word(String word) {
        this.word = word;
    }

    /**
     * Returns the String stored in this object
     * @return the stored String
     */
    public String getWord() {
        return word;
    }

    /**
     * Helper method to check if other Word stored String matches
     * @param o Other Word object to check
     * @return true if stored String matches, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Word toCompare) {
            return this.word.equals(toCompare.word);
        }
        return false;
    }
}
