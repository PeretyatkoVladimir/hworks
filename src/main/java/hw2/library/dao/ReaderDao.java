package hw2.library.dao;

import hw2.library.config.ApplicationContext;
import hw2.library.db.IDataBase;
import hw2.library.exeptions.ReaderAlreadyExistException;
import hw2.library.exeptions.ReaderMaxIssuesCapacityException;
import hw2.library.exeptions.UserInBlackListException;
import hw2.library.model.Book;
import hw2.library.model.Issue;
import hw2.library.model.Reader;

import java.util.List;

/**
 * Created by valdess on 23.10.16.
 */
public class ReaderDao {

    private static ReaderDao uniqueInstance;

    IDataBase db = ApplicationContext.DATA_BASE;

    public static synchronized ReaderDao getInstance() {
        if (uniqueInstance == null){
            uniqueInstance = new ReaderDao();
        }
        return uniqueInstance;
    }

    public void create(String name)throws ReaderAlreadyExistException {

        if (db.getReaderByName(name) != null){
            throw new ReaderAlreadyExistException();
        }

        db.addReader(new Reader(name));

    }

    public List<Reader> getAll(){
        return db.getAllReaders();
    }

    public void addIssueToReader(Issue issue, Reader reader) throws UserInBlackListException, ReaderMaxIssuesCapacityException {
        reader.addIssue((Book) issue);
        db.delIssue(issue);
    }

    public void update() {
        db.save();
    }
}
