package hw1.university;

/**
 * Created by valdess on 09.10.16.
 */
public class ContractStudent extends Student {

    private int period;

    public ContractStudent(String name, double averageMark, int period) {
        super(name, averageMark);
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "ContractStudent{" + super.toString() +
                "period=" + period +
                '}';
    }
}
