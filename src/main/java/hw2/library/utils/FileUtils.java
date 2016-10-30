package hw2.library.utils;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by vperetyatko on 27.10.2016.
 */
public class FileUtils {

    public static String readFromFile(String dir){
        RandomAccessFile f = null;
        byte[] buf = null;
        try {
            f = new RandomAccessFile(dir, "r");
            buf = new byte[(int) f.length()];
            f.read(buf);
            f.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return new String(buf);
    }

    public static boolean saveToFile(String dir, String content){
        RandomAccessFile f = null;
        try {
            f = new RandomAccessFile(dir, "rw");
            f.write(content.getBytes());
            f.close();
            return true;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

}
