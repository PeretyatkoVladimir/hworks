package hw1.university;

/**
 * Created by valdess on 09.10.16.
 */
public class Student implements Comparable<Student> {

    private String name;
    private double averageMark;

    public Student(String name, double averageMark) {
        this.name = name;
        this.averageMark = averageMark;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name.equals(student.name);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", averageMark=" + averageMark +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public int compareTo(Student other) {
//todo + next operation will also return 0 if obj are equal, and will do it faster better check on null
      /*  if (this.equals(other)){
            return 0;
        }
*/
        return name.compareTo(other.name);

    }
}
