package wordCount;

import java.io.*;

public class WordCounter {

   private String fileName;
   private File file;
   private int count = 0;

   public WordCounter(String fileName) {
      this.fileName = fileName;
      this.file = new File(fileName);
   }

   public int count() throws IOException {
      FileReader fileReader = new FileReader(file);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line;
      while((line=bufferedReader.readLine())!=null)
         count+=line.split("\\s").length;
      fileReader.close();
      return count;
   }

}
