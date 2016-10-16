package hw1.university;

/**
 * Created by valdess on 09.10.16.
 */
public class Main {

    public static void main(String[] args) {

        String s = new String();
        System.out.println(s);

        Student s1 = new ContractStudent("Petro", 3.5, 3);
        Student s2 = new ContractStudent("Ivan", 3.7, 3);
        Student s3 = new BudgetStudent("Vova", 3.4, 3);
        Student s4 = new BudgetStudent("Alex", 3.6, 3);

        Group group1 = new Group("ACO16", "Gorobec");
        group1.addStudent(s1);
        group1.addStudent(s2);
        group1.addStudent(s3);
        group1.addStudent(s4);

        Group group2 = new Group("ACO16", "Gorobec");
        group2.addStudent(s1);
        group2.addStudent(s2);
        //group2.addStudent(s3);
        //group2.addStudent(s4);

        System.out.println(group1.equals(group2));

        University u = University.getInstance();
        u.setName("ArtCode");
        u.addGroup(group1);

        System.out.println(group1);
        group1.sortByStudent();
        System.out.println(group1);

        group1.sortByAverageMark();
        System.out.println(group1);

        System.out.println(u);

    }

}
