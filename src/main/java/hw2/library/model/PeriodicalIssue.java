package hw2.library.model;

import hw2.library.model.Issue;

/**
 * Created by valdess on 16.10.16.
 */
public abstract class PeriodicalIssue extends Issue {

    private int periodicalNumber;

    public PeriodicalIssue(String name, LiteratureType litType, int periodicalNumber, int year) {
        super(name, litType, year);
        this.periodicalNumber = periodicalNumber;
    }

    public int getPeriodicalNumber() {
        return periodicalNumber;
    }

    public void setPeriodicalNumber(int periodicalNumber) {
        this.periodicalNumber = periodicalNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Issue)) return false;
        if (!super.equals(o)) return false;

        PeriodicalIssue that = (PeriodicalIssue) o;

        return periodicalNumber == that.periodicalNumber;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + periodicalNumber;
        return result;
    }
}
