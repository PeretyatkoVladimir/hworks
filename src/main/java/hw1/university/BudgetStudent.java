package hw1.university;

/**
 * Created by valdess on 09.10.16.
 */
public class BudgetStudent extends Student {

    private long scolarship;

    public BudgetStudent(String name, double averageMark, long scolarship) {
        super(name, averageMark);
        this.scolarship = scolarship;
    }

    @Override
    public String toString() {
        return "BudgetStudent{" + super.toString() +
                "scolarship=" + scolarship +
                '}';
    }

    public long getScolarship() {
        return scolarship;
    }

    public void setScolarship(long scolarship) {
        this.scolarship = scolarship;
    }
}
