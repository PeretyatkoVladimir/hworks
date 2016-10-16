package hw1.university;

import hw1.myArrayList.MyArrayList;

import java.util.Arrays;

/**
 * Created by valdess on 09.10.16.
 */
public class University {

    private static University uniqueInstance;

    private String name;
    private MyArrayList groups;

    public static synchronized University getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new University();
        }
        return uniqueInstance;
    }

    private University() {
        this.groups = new MyArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addGroup(Group group){

        if(group == null){
            return false;
        }

        return groups.add(group);
    }

    public boolean delGroup(Group group){

        if(group == null){
            return false;
        }

        return groups.remove(group);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", groups=" + Arrays.toString(groups.toArray()) +
                '}';
    }
}
