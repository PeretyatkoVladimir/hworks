package hw2.library.dao;

import hw2.library.config.ApplicationContext;
import hw2.library.db.IDataBase;

/**
 * Created by valdess on 23.10.16.
 */
public class ReaderDao {

    IDataBase dataBase = ApplicationContext.DATA_BASE;

    public static ReaderDao getInstance() {
        return new ReaderDao();
    }
}
