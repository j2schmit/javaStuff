import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson3Stream {

    final static String regex = "[0]{8}[0-9a-f]{8}";
    final static Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) {
        String fileName = args[0];
        List<String> stringList;
        double startTime;
        double endTime;
        double elapsedTime;
        double elapsedTimeParallel;
        double difference = 1.0;

        String contents = getStringList(fileName);

        while (difference > 0) {
            System.out.println("String Size: " + contents.length());

            stringList = Stream.of(contents.split(",")).collect(Collectors.toList());

            startTime = System.currentTimeMillis();
            findMatches(stringList);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            System.out.println("Millisecs using stream: " + elapsedTime);

            startTime = System.currentTimeMillis();
            findMatchesParallel(stringList);
            endTime = System.currentTimeMillis();
            elapsedTimeParallel = endTime - startTime;
            System.out.println("Millisecs using parallel stream: " + elapsedTimeParallel);

            difference = elapsedTimeParallel - elapsedTime;
            if (difference > 0) {
                System.out.println("Results: Stream was " + difference + " millisecs faster than parallelStream");
                System.out.println("Doubling String size and trying again");
                contents += contents;
            }
        }
    }

    public static String getStringList(String fileName) {
        String contents = null;
        try {
            contents = new String(Files.readString(Paths.get(fileName), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }



    public static void findMatches(List<String> stringList) {
        long count = stringList.stream().filter(str -> pattern.matcher(str).find()).count();
    }

    public static void findMatchesParallel(List<String> stringList) {
        long count = stringList.parallelStream().filter(str -> pattern.matcher(str).find()).count();
    }

}
