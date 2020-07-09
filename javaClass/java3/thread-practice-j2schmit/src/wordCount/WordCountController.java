package wordCount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class WordCountController {

    private WordCountView wordCountView;
    private ArrayList<String> files = new ArrayList<>();
    private int numberOfFiles;

    public WordCountController(WordCountView wordCountView) {
        this.wordCountView = wordCountView;

        this.wordCountView.addNumberOfFilesListener(new NumberOfFilesListener());
    }

    class NumberOfFilesListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            numberOfFiles = wordCountView.getNumberOfFiles();
            wordCountView.addFilesPanels();
            wordCountView.addFilesListener(new FilesListener());
        }
    }

    class FilesListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            String file = wordCountView.getFile();
            files.add(file);
            if ( numberOfFiles == files.size() ) {
                try {
                    wordCountView.getFilesCounts(files);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
