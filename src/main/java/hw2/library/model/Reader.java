package hw2.library.model;

import hw2.library.exeptions.ReaderMaxIssuesCapacityException;
import hw2.library.exeptions.UserInBlackListException;

import java.util.ArrayList;

/**
 * Created by valdess on 16.10.16.
 */
public class Reader {

    private static final int MAX_ISSUES = 3;

    private String name;
    private boolean black;
    private ArrayList<Book> issues;

    public Reader(String name) {
        this.name = name;
        this.issues = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        return name != null ? name.equals(reader.name) : reader.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (issues != null ? issues.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", black=" + black +
                ", issues=" + issues +
                '}';
    }

    public boolean addIssue(Book issue) throws UserInBlackListException, ReaderMaxIssuesCapacityException {
        if(isBlack()){
            throw new UserInBlackListException();
        }
        if(this.issues.size() >= MAX_ISSUES){
            throw new ReaderMaxIssuesCapacityException();
        }
        return this.issues.add(issue);
    }

    public ArrayList<Book> getIssues() {
        return issues;
    }
}
