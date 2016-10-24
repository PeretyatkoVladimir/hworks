package hw2.library.config;

import hw2.library.db.IDataBase;
import hw2.library.dao.IssueDao;
import hw2.library.db.JsonDB;
import hw2.library.dao.ReaderDao;

/**
 * Created by valdess on 23.10.16.
 */
public class ApplicationContext {

    public final static IDataBase DATA_BASE = JsonDB.getInstance();
    public final static ReaderDao READER_DAO = ReaderDao.getInstance();
    public final static IssueDao ISSUE_DAO = new IssueDao();

    private ApplicationContext() {
    }
}
