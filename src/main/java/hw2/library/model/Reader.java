package hw2.library.model;

import java.util.ArrayList;

/**
 * Created by valdess on 16.10.16.
 */
public class Reader {

    private String name;
    private ArrayList<Issue> issues;

    public Reader(String name) {
        this.name = name;
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

}
