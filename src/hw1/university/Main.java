package hw1.university;

/**
 * Created by valdess on 09.10.16.
 */
public class Main {

    public static void main(String[] args) {

        Student s1 = new ContractStudent("Petro", 45, 3);
        Student s2 = new ContractStudent("Ivan", 45, 3);
        Student s3 = new BudgetStudent("Vova", 45, 3);
        Student s4 = new BudgetStudent("Alex", 45, 3);

        Group g = new Group("ACO77", "Evgen");
        g.addStudent(s1);
        g.addStudent(s2);
        g.addStudent(s3);
        g.addStudent(s4);

        University u = new University("ArtCode");
        u.addGroup(g);

        System.out.println(u);


    }

}
