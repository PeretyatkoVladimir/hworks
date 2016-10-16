package hw1.university;

import hw1.myArrayList.MyArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by valdess on 09.10.16.
 */
public class Group {

    private String name;
    private String teacher;
    public MyArrayList students;

    public Student[] getStudents() {
        return (Student[]) students.toArray();
    }

    public Group(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
        this.students = new MyArrayList();
    }

    public boolean addStudent(Student student){

        if(student == null){
            return false;
        }
        if(!students.contains(student)){
            return students.add(student);
        }
        return false;
    }

    public boolean delStudent(Student student){

        if(student == null){
            return false;
        }

        return students.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!name.equals(group.name)) return false;
        if (!teacher.equals(group.teacher)) return false;
        return students.equals(group.students);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + teacher.hashCode();
        result = 31 * result + students.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", students=" + Arrays.toString(students.toArray()) +
                '}';
    }

    public void sortByStudent(){
        Collections.sort(students);
    }

    public void sortByAverageMark(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int)((o1.getAverageMark() - o2.getAverageMark()) * 1000);
            }
        });
    }

}
