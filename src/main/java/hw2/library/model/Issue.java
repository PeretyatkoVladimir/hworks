package hw2.library.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by valdess on 16.10.16.
 */
public abstract class Issue {

    private String name;
    private LiteratureType litType;
    private int year;

    public static List<LiteratureType> getLiteratureTypeList(){
        return new ArrayList<LiteratureType>(Arrays.asList(LiteratureType.values()));
    }

    public Issue(String name, LiteratureType litType, int year) {
        this.name = name;
        this.litType = litType;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Issue() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LiteratureType getLitType() {
        return litType;
    }

    public void setLitType(LiteratureType litType) {
        this.litType = litType;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", litType=" + litType +
                ", year=" + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Issue)) return false;

        Issue issue = (Issue) o;

        if (year != issue.year) return false;
        if (name != null ? !name.equals(issue.name) : issue.name != null) return false;
        return litType == issue.litType;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (litType != null ? litType.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}
