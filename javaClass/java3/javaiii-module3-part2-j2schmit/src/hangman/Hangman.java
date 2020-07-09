package hangman;

import javax.swing.SwingUtilities;
import java.io.IOException;

public class Hangman {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    HangmanView hangmanView = new HangmanView();
                    HangmanModel hangmanModel = new HangmanModel();
                    HangmanController hangmanController = new HangmanController(hangmanView, hangmanModel);
                    hangmanView.setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
