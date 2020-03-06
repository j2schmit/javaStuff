import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson5Concurrent {

    public static void main(String[] args) throws InterruptedException {

        if ((args.length < 2) || (args.length > 3)){
            displayHelpMessage();
            System.exit(1);
        }

        int NUM_THREADS = 8;
        boolean reentranLock = false;
        boolean atomicLong = false;
        for (int idx = 0; idx < args.length; idx++) {
            String cmd = args[idx];
            switch (cmd) {
                case "--num-threads":
                    NUM_THREADS = Integer.parseInt(args[++idx]);
                    break;
                case "--ReentrantLock":
                    reentranLock = true;
                    break;
                case "--AtomicLong":
                    atomicLong = true;
                    break;
                default:
                    displayHelpMessage();
            }
        }

        ReentrantLock threadLock = new ReentrantLock();

        ArrayList<String> files = getFiles();
        for (int idx = 0; idx < NUM_THREADS; idx++){
            CountCharacters counter = new CountCharacters(files, atomicLong, reentranLock, threadLock);
            counter.start();
        }
        Thread.sleep(1000);
        if (!atomicLong) System.out.println(CountCharacters.count);
        else System.out.println(CountCharacters.atomicCount);
    }

    private static ArrayList<String> getFiles() {
        File folder = new File(System.getProperty("user.dir"));
        String[] allFiles = folder.list();
        ArrayList<String> files = new ArrayList<>();
        for (String file : allFiles)
        {
            if (file.endsWith(".java") || file.endsWith(".class"))  files.add(file);
        }
        return files;
    }

    private static void displayHelpMessage() {
        String helpMsg = "";
        helpMsg += "--num-threads NUM_THREADS  (REQUIRED) integer argument for number of threads to be used\n\n";
        helpMsg += "At most ONE of the following may be provided:\n";
        helpMsg += "--ReentrantLock (OPTIONAL) if provided threads will utilize locking\n";
        helpMsg += "--AtomicLong (OPTIONAL) if provided an AtomicLong will be used for counting";
        System.out.println(helpMsg);
    }
}
