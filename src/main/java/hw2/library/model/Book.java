package hw2.library.model;

/**
 * Created by valdess on 16.10.16.
 */
public class Book extends Issue {

    private String isdn;

    public Book(String name, LiteratureType litType, int year, String isdn) {
        super(name, litType, year);
        this.isdn = isdn;
    }

    public String getIsdn() {
        return isdn;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Issue)) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        return isdn != null ? isdn.equals(book.isdn) : book.isdn == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isdn != null ? isdn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", isdn='" + isdn + '\'' +
                '}';
    }
}
