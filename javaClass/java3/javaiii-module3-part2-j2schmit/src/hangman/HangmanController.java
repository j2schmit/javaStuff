package hangman;

import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HangmanController {

    private HangmanView hangmanView;
    private HangmanModel hangmanModel;
    private String wordState = "_ _ _ _ _ _ _ _ _";
    private int counter = 1;

    public HangmanController(HangmanView hangmanView, HangmanModel hangmanModel) {
        this.hangmanView = hangmanView;
        this.hangmanModel = hangmanModel;

        this.hangmanView.addHangmanListener(new HangmanListener());
    }

    class HangmanListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            char letter = hangmanView.getLetter();
            String oldWordState = wordState;
            wordState = hangmanModel.getWordState(letter, wordState);
            if (oldWordState.equals(wordState)) {
                counter++;
            } else if (wordState.equals("g r a p h i c a l")) {
                counter = 8;
            }
            try {
                hangmanView.updateState(counter, wordState);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
