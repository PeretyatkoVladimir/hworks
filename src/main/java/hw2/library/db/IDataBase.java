package hw2.library.db;

import hw2.library.model.Book;
import hw2.library.model.Issue;
import hw2.library.model.Reader;

import java.util.List;

/**
 * Created by valdess on 22.10.16.
 */
public interface IDataBase {

    boolean save();

    boolean addReader(Reader reader);
    boolean delReader(Reader reader);
    Reader getReaderByName(String name);
    Reader getReader(Reader reader);
    List<Reader> getAllReaders();

    boolean addIssue(Issue issue);
    boolean delIssue(Issue issue);
    Issue getIssueByName(String name);
    Issue getIssue(Issue issue);
    List<Book> getAllIssues();

}
