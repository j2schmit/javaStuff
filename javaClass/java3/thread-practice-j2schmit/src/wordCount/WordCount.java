package wordCount;

import java.io.IOException;

public class WordCount {

    public static void main(String[] args) throws IOException {
        WordCountController wordCountController = new WordCountController(new WordCountView());

    }
}