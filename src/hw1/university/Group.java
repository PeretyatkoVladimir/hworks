package hw1.university;

import java.util.Arrays;

/**
 * Created by valdess on 09.10.16.
 */
public class Group {

    private static final int MAX_GROUP_SIZE = 30;

    private String name;
    private String teacher;
    private Student[] students;

    public Student[] getStudents() {
        return students.clone();
    }

    public Group(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
        this.students = new Student[MAX_GROUP_SIZE];
    }

    public boolean addStudent(Student student){

        if(student == null){
            return false;
        }

        for (int i = 0; i < students.length; i++){
            if (students[i] == null) {
                students[i] = student;
                return true;
            }
        }

        return false;
    }

    public boolean delStudent(Student student){
        for (int i = 0; i < students.length; i++){
            if (students[i].equals(student)) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
