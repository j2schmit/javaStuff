package hangman;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HangmanView extends JFrame {

    private char letter;
    private BufferedImage myPicture;
    private JLabel picLabel;

    private JPanel fieldPanel;
    private JPanel imagePanel;
    private JPanel submitPanel;
    private  JPanel wordPanel;

    private JButton submitButton;
    private JTextField guess;
    private JLabel wordState;

    public HangmanView () throws IOException {
        prepareGUI();
        showTextField();
    }

    private void prepareGUI(){

        this.setSize(800,400);
        this.setLayout(new GridLayout(1, 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fieldPanel = new JPanel();

        imagePanel = new JPanel();

        submitPanel = new JPanel();

        wordPanel = new JPanel();

        this.add(fieldPanel);
        this.add(submitPanel);
        this.add(wordPanel);
        this.add(imagePanel);
    }

    private void showTextField() throws IOException {

        myPicture = ImageIO.read(new File("resources/h1.png"));
        picLabel = new JLabel(new ImageIcon(myPicture));
        imagePanel.add(picLabel);
        final JLabel  guessLabel= new JLabel("Guess a letter: ", JLabel.CENTER);
        guess = new JTextField(1);

        submitButton = new JButton("Submit");

        wordState = new JLabel( "_ _ _ _ _ _",JLabel.CENTER);

        fieldPanel.add(guessLabel);
        fieldPanel.add(guess);
        submitPanel.add(submitButton);
        wordPanel.add(wordState);
    }

    public char getLetter() {
        return guess.getText().charAt(0);
    }

    void addHangmanListener(ActionListener actionListener) {
        submitButton.addActionListener(actionListener);
    }

    public void updateState(int counter, String wordStateStr) throws IOException, InterruptedException {
        wordState.setText(wordStateStr);
        if (counter<=7) {
            myPicture = ImageIO.read(new File("resources/h" + counter + ".png"));
            picLabel.setIcon(new ImageIcon(myPicture));
        }
        guess.setText("");
        if (counter >= 7) {
            Timer timer = new Timer(1500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            timer.start();
            //this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        }
    }

}

