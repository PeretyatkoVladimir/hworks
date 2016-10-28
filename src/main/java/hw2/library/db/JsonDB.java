package hw2.library.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hw2.library.model.Book;
import hw2.library.model.Issue;
import hw2.library.model.Reader;
import hw2.library.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valdess on 23.10.16.
 */
public class JsonDB implements IDataBase {

    private static final String DB_DIR = ".//src/main/java/hw2/library/db/library.db";

    private static IDataBase uniqueInstance;

    private static Gson gson = new GsonBuilder().create();

    private ArrayList<Reader> readers;
    private ArrayList<Book> issues;

    private JsonDB() {
        this.readers = new ArrayList<>();
        this.issues = new ArrayList<>();
    }

    public static synchronized IDataBase getInstance() {
        if (uniqueInstance == null){
            if (connectDB()) {
                return uniqueInstance;
            }
        }
        return null;
    }

    private static boolean connectDB() {

        uniqueInstance = gson.fromJson(FileUtils.readFromFile(DB_DIR), JsonDB.class);

        //first start app
        if (uniqueInstance == null) {
            uniqueInstance = new JsonDB();
        }
        return true;

    }

    public synchronized boolean save(){
        return FileUtils.saveToFile(DB_DIR, gson.toJson(this, JsonDB.class));
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
        for(Reader r : readers){
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Reader getReader(Reader reader) {
        return null;
    }

    @Override
    public List<Book> getAllIssues() {
        return issues;
    }

    @Override
    public List<Reader> getAllReaders() {
        return readers;
    }

    @Override
    public boolean addIssue(Issue issue) {
        if (issues.add((Book) issue)) {
            if (save()){
                return true;
            } else {
                issues.remove(issue);
            }
        }
        return false;
    }

    @Override
    public boolean delIssue(Issue issue) {

        if (issues.remove(issue)) {
            if (save()){
                return true;
            } else {
                issues.add((Book) issue);
            }
        }
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
