package hw2.library.utils;

import hw2.library.exeptions.WrongInputChooseException;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vperetyatko on 27.10.2016.
 */
public class DataInOutUtils {

    public static int nextOnlyInt(Scanner sc) {

        boolean cantExit = true;
        int number = 0;

        while (cantExit) {
            try {
                number = sc.nextInt();
                cantExit = false;
            } catch (Exception e) {
                System.err.println("Wrong input! Input only 'integer' numbers dummy!");
                sc.nextLine();
            }
        }
        return number;
    }

    public static int nextOnlyInt(Scanner sc, String message) {
        System.out.println(message);
        return nextOnlyInt(sc);
    }

    public static double nextOnlyDouble(Scanner sc) {

        boolean cantExit = true;
        double number = 0;

        while (cantExit) {
            try {
                number = sc.nextDouble();
                cantExit = false;
            } catch (Exception e) {
                System.err.println("Wrong input! Input only 'double' numbers dummy!");
                sc.nextLine();
            }
        }
        return number;
    }

    public static double nextOnlyDouble(Scanner sc, String message) {
        System.out.println(message);
        return nextOnlyDouble(sc);
    }

    public static String nextStr(Scanner sc, String message) {
        System.out.println(message);
        return sc.next();
    }

    private static HashMap<Integer, Object> getMapByList(List list){

        Integer i = 0;
        HashMap<Integer, Object> buffer = new HashMap();
        for (Object o : list) {
            buffer.put(++i, o);
        }
        return buffer;
    }

    private static void printMap(HashMap<Integer, Object> map){
       for (Integer i = 1; i <= map.size(); i++) {
           System.out.println(i + ". " + map.get(i));
       }
    }

    public static Object chooseObjectFromList(Scanner sc, List list, String msg) throws WrongInputChooseException {
        System.out.println(msg);
        return chooseObjectFromList(sc, list);
    }

    public static Object chooseObjectFromList(Scanner sc, List list) throws WrongInputChooseException {

        HashMap<Integer, Object> buffer = getMapByList(list);
        printMap(buffer);

        int select = nextOnlyInt(sc);

        if(buffer.containsKey(select)){
            return buffer.get(select);
        } else {
            throw new WrongInputChooseException();
        }
    }

    public static int getChoiceFromList(Scanner sc, List list) throws WrongInputChooseException {

        HashMap<Integer, Object> buffer = getMapByList(list);
        printMap(buffer);

        int select = nextOnlyInt(sc);

        if(buffer.containsKey(select)){
            return select;
        } else {
            throw new WrongInputChooseException();
        }
    }

    public static void prntList(List l){
        if (l.size() == 0){
            System.out.println("<empty>");
        }
        for(Object o : l){
            System.out.println(o);
        }
    }

}
