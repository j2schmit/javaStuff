package wordCount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class WordCountView extends JFrame {

    private JFrame mainFrame;
    private JPanel numFilesPanel;
    private JPanel submitPanel;
    private JPanel scrollPanel;
    private JPanel filesPanel;
    private JPanel filesButtonPanel;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JTextField numFiles;
    private JTextField filesField;
    private int numberOfFiles;
    private JButton submitButton;
    private JButton filesButton;
    private String countText = "";

    public WordCountView () throws IOException {
        prepareGUI();
        showTextField();
    }

    private void prepareGUI(){

        mainFrame = new JFrame();
        mainFrame.setSize(800,400);
        mainFrame.setLayout(new GridLayout(0, 2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        numFilesPanel = new JPanel();
        numFilesPanel.setLayout(new GridLayout( 4, 2));

        submitPanel = new JPanel();
        scrollPanel = new JPanel();

        filesPanel = new JPanel();
        filesButtonPanel = new JPanel();

        mainFrame.add(numFilesPanel);
        mainFrame.add(scrollPanel);
        mainFrame.add(submitPanel);

        mainFrame.setVisible(true);
    }

    private void showTextField() throws IOException {

        final JLabel numFilesLabel = new JLabel("Enter the # of files: ", JLabel.CENTER);
        final JLabel filesLabel = new JLabel(" Enter a file: ", JLabel.CENTER);
        numFiles = new JTextField(6);
        filesField = new JTextField(6);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(textArea);
        scrollPane.setPreferredSize(new Dimension(350,200));

        submitButton = new JButton("Submit");
        filesButton = new JButton ("Enter");

        numFilesPanel.add(numFiles);
        numFilesPanel.add(numFilesLabel);
        filesPanel.add(filesField);
        filesPanel.add(filesLabel);
        filesPanel.add(filesButton);

        submitPanel.add(submitButton);
        scrollPanel.add(scrollPane);

        mainFrame.setVisible(true);
    }

    public int getNumberOfFiles() {
        numberOfFiles = Integer.parseInt(numFiles.getText());
        numFilesPanel.setVisible(false);
        submitPanel.setVisible(false);
        return numberOfFiles;
    }

    public String getFile() {
        String file = filesField.getText();
        filesField.setText("");
        return file;
    }

    public void addFilesPanels() {
        mainFrame.add(filesPanel);
        mainFrame.add(filesButtonPanel);
    }

    void addNumberOfFilesListener(ActionListener actionListener) {
        submitButton.addActionListener(actionListener);
    }
    void addFilesListener(ActionListener actionListener) {
        filesButton.addActionListener(actionListener);
    }

    public void getFilesCounts(ArrayList<String> files) throws IOException {
        for (String file: files) {
            this.startThread(file);
        }
    }

    private void startThread(String file) {
        SwingWorker swingWorker = new SwingWorker() {
            int count;
            @Override
            protected Object doInBackground() throws Exception {
                WordCounter wordCounter = new WordCounter(file);
                count = wordCounter.count();
                return count;
            }

            @Override
            protected void done() {
                countText += file + " " + String.valueOf(count) + "\n";
                textArea.setText(countText);
            }
        };
        swingWorker.execute();
    }



}

