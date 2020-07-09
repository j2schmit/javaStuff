package hangman;

public class HangmanModel {

    private StringBuilder wordState;
    private String word = "g r a p h i c a l";

    public HangmanModel() {
    }

    public void updateWordState(char letter, String wordState) {
        this.wordState = new StringBuilder(wordState);
        int index = word.indexOf(letter);
        while (index >= 0) {
            this.wordState.setCharAt(index, letter);
            index = word.indexOf(letter, index+1);
        }
    }
    public String getWordState(char letter, String wordState) {
        updateWordState(letter, wordState);
        return this.wordState.toString();
    }
}
