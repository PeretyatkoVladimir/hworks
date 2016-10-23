package hw2.library.config;

import hw2.library.db.IDataBase;
import hw2.library.db.IssueDao;
import hw2.library.db.JSONDB;
import hw2.library.db.ReaderDao;

import java.io.IOException;

/**
 * Created by valdess on 23.10.16.
 */
public class ApplicationContext {

    public final static IDataBase DATA_BASE = JSONDB.getInstance();
    public final static ReaderDao READER_DAO = ReaderDao.getInstance();
    public final static IssueDao ISSUE_DAO = new IssueDao();

    private ApplicationContext() {
    }
}
