package hw2.library.controller;

import hw2.library.config.ApplicationContext;
import hw2.library.dao.IssueDao;
import hw2.library.dao.ReaderDao;
import hw2.library.exeptions.ReaderAlreadyExistException;
import hw2.library.exeptions.ReaderMaxIssuesCapacityException;
import hw2.library.exeptions.UserInBlackListException;
import hw2.library.model.Book;
import hw2.library.model.Issue;
import hw2.library.model.LiteratureType;
import hw2.library.model.Reader;

import java.util.List;

/**
 * Created by valdess on 16.10.16.
 */
public class Library {

    static ReaderDao readerDao = ApplicationContext.READER_DAO;
    static IssueDao issueDao = ApplicationContext.ISSUE_DAO;

    public static void addUser(String name) throws ReaderAlreadyExistException {
        readerDao.create(name);
    }

    public static void addIssue(String name, LiteratureType litType, int year, String isdn){
        issueDao.create(name, litType, year, isdn);
    }

    public static List<Reader> getAllReaders(){
        return readerDao.getAll();
    }

    public static List<Book> getAllIssues() {
        return issueDao.getAll();
    }

    public static void addIssueToReader(Issue issue, Reader reader) throws UserInBlackListException, ReaderMaxIssuesCapacityException {
        readerDao.addIssueToReader(issue, reader);
    }

    public static void addDelBlackList(Reader r){
        r.setBlack(! r.isBlack());
        readerDao.update();
    }

    public static List<Book> getIssuesByYear(int year){
        return issueDao.getIssuesByYear(year);
    }

    public static List<Book> getIssuesByKeyWord(String keyWord){
        return issueDao.getIssuesByKeyWord(keyWord);
    }
}
