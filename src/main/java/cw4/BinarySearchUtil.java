package cw4;

import java.util.Comparator;
import java.util.List;

/**
 * Created by valdess on 29.10.16.
 */
public class BinarySearchUtil {

    private static int getMiddle(int start, int end){
        return (end - start) / 2 + start;
    }

    private static int compare(Comparable searchValue, Object value){
        return searchValue.compareTo(value);
    }

    private static int compare(Comparable searchValue, Object value, Comparator c){
        return c.compare(searchValue, value);
    }

    public static boolean binarySearch(List l, Comparable searchValue) {

        if (l == null){
            return false;
        }

        if (l.size() == 0){
            return false;
        }

        int start = 0;
        int end = l.size();
        int midle = getMiddle(start, end);

        while (start < end){
            Object value = l.get(midle);

            int resCompare = compare(searchValue, value);

            if (resCompare == 0){
                return true;
            } else if (resCompare > 0){
                start = midle;
                midle = getMiddle(start, end);
            } else {
                end = midle;
                midle = getMiddle(start, end);
            }

            if (start == midle){
                return compare(searchValue, l.get(end-1)) == 0;
            }

        }

        return false;
    }

    public static boolean binarySearch(List l, Comparable searchValue, Comparator comparator) {

        if (l == null){
            return false;
        }
        if (l.size() == 0){
            return false;
        }
        if (comparator == null){
            return false;
        }

        int start = 0;
        int end = l.size();
        int midle = getMiddle(start, end);

        while (start < end){
            Object value = l.get(midle);

            int resCompare = compare(searchValue, value, comparator);

            if (resCompare == 0){
                return true;
            } else if (resCompare > 0){
                start = midle;
                midle = getMiddle(start, end);
            } else {
                end = midle;
                midle = getMiddle(start, end);
            }

            if (start == midle){
                return compare(searchValue, l.get(end-1), comparator) == 0;
            }

        }

        return false;
    }

}
