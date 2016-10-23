package hw2.library.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hw2.library.model.Issue;
import hw2.library.model.Reader;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by valdess on 23.10.16.
 */
public class JSONDB implements IDataBase {

    private static IDataBase uniqueInstance;

    private static Gson gson = new GsonBuilder().create();

    private ArrayList<Reader> readers;
    private ArrayList<Issue> books;

    private JSONDB() {
        this.readers = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    private static String readFileDB(){
        byte[] buf = new byte[0];
        RandomAccessFile f = null;

        try {
            f = new RandomAccessFile("/home/valdess/Develop/source/artcode/w1/hworks/src/main/java/hw2/library/db/library.db", "r");
            buf = new byte[(int) f.length()];
            f.read(buf);
            f.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return new String(buf);
    }

    private static boolean writeFileDB(String json){

        RandomAccessFile f = null;

        try {
            f = new RandomAccessFile("/home/valdess/Develop/source/artcode/w1/hworks/src/main/java/hw2/library/db/library.db", "rw");
            f.write(json.getBytes());
            f.close();
            return true;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }

    }

    private static boolean connectDB() {

        uniqueInstance = gson.fromJson(readFileDB(), JSONDB.class);

        //first start app
        if (uniqueInstance == null) {
            uniqueInstance = new JSONDB();
        }
        return true;

    }

    private synchronized boolean save(){

        return writeFileDB(gson.toJson(this, JSONDB.class));

    }

    public static synchronized IDataBase getInstance() {
        if (uniqueInstance == null){
            if (connectDB()) {
                return uniqueInstance;
            }
        }
        return null;
    }

    @Override
    public boolean addReader(Reader reader) {

        if (readers.add(reader)) {
            if (save()){
                return true;
            } else {
                readers.remove(reader);
            }
        }

        return false;
    }

    @Override
    public boolean delReader(Reader reader) {

        if (readers.remove(reader)) {
            if (save()){
                return true;
            } else {
                readers.add(reader);
            }
        }

        return false;
    }

    @Override
    public Reader getReaderByName(String name) {
        return null;
    }

    @Override
    public Reader getReader(Reader reader) {
        return null;
    }

    @Override
    public boolean addIssue(Issue issue) {
        return false;
    }

    @Override
    public boolean delIssue(Issue issue) {
        return false;
    }

    @Override
    public Issue getIssueByName(String name) {
        return null;
    }

    @Override
    public Issue getIssue(Issue issue) {
        return null;
    }
}
