package hw2.library.dao;

import hw2.library.config.ApplicationContext;
import hw2.library.db.IDataBase;
import hw2.library.model.Book;
import hw2.library.model.Issue;
import hw2.library.model.LiteratureType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valdess on 23.10.16.
 */
public class IssueDao {

    private static IDataBase db = ApplicationContext.DATA_BASE;
    private static IssueDao uniqueInstance;

    public static synchronized IssueDao getInstance() {
        if (uniqueInstance == null){
            uniqueInstance = new IssueDao();
        }
        return uniqueInstance;
    }

    public void create(String name, LiteratureType litType, int year, String isdn){
        db.addIssue(new Book(name, litType, year, isdn));
    }

    public List<Book> getAll(){
        return db.getAllIssues();
    }

    public List<Book> getIssuesByYear(int year){
        ArrayList<Book> books = new ArrayList<>();
        for (Book b : getAll()){
            if (b.getYear() == year){
                books.add(b);
            }
        }
        return books;
    }

    public List<Book> getIssuesByKeyWord(String keyWords){
        ArrayList<Book> books = new ArrayList<>();
        for (Book b : getAll()){
            if (b.getName().contains(keyWords)){
                books.add(b);
            }
        }
        return books;
    }

}
