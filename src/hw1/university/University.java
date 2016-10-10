package hw1.university;

import java.util.Arrays;

/**
 * Created by valdess on 09.10.16.
 */
public class University {

    private static final int MAX_SIZE = 5;

    private String name;
    private Group[] groups;

    public University(String name) {
        this.name = name;
        this.groups = new Group[MAX_SIZE];
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

        for (int i = 0; i < groups.length; i++){
            if (groups[i] == null) {
                groups[i] = group;
                return true;
            }

        }

        return false;
    }

    public boolean delGroup(Group group){
        for (int i = 0; i < groups.length; i++){
            if (groups[i].equals(group)) {
                groups[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
