import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class CountCharacters extends Thread{

    public static long count = 0;
    public static AtomicLong atomicCount = new AtomicLong(0);
    private ArrayList<String> files;
    private boolean atomic = false;
    private boolean lock = false;
    private ReentrantLock threadLock;

    public CountCharacters(ArrayList<String> files, boolean atomic, boolean lock, ReentrantLock threadLock) {
        this.files = files;
        this.atomic = atomic;
        this.lock = lock;
        this.threadLock = threadLock;
    }

    public void counter() throws IOException {
        for (String file: files) {
            if (file.endsWith(".java")) countJavaFile(file);
            else if (file.endsWith(".class")) countClassFile(file);
        }
    }

    public void countJavaFile(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        for (String line: lines) {
            if (!atomic) {
                count += line.length();
            } else {
                atomicCount.getAndAdd(line.length());
            }
        }
    }

    public void countClassFile(String file) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get(file));
        for (byte dat: data) {
            count ++;
            if (!atomic) {
                count ++;
            } else {
                atomicCount.getAndIncrement();
            }
        }
    }

    @Override
    public void run() {
        if (!lock) {
            try {
                counter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            threadLock.lock();
            try {
                counter();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                threadLock.unlock();
            }
        }
    }

}
