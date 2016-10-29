package cw4;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by valdess on 29.10.16.
 */
public class BinarySearchUtilTest {

    private List list;

    @Before
    public void init(){

        list = new ArrayList();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("10");

    }

    @Test
    public void binarySearch_test(){

        boolean result = BinarySearchUtil.binarySearch(list, "2");
        assertEquals(true, result);

        result = BinarySearchUtil.binarySearch(list, "6");
        assertEquals(true, result);

        result = BinarySearchUtil.binarySearch(list, "9");
        assertEquals(false, result);

        result = BinarySearchUtil.binarySearch(list, "7");
        assertEquals(true, result);

        result = BinarySearchUtil.binarySearch(list, "5");
        assertEquals(true, result);

        result = BinarySearchUtil.binarySearch(list, "2");
        assertEquals(true, result);

    }

    @Test
    public void binarySearch_comparator_test(){

        Comparator c = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                String str = (String) o;
                return str.compareTo((String) t1);
            }
        };

        boolean result = BinarySearchUtil.binarySearch(list, "2", c);
        assertEquals(true, result);

        result = BinarySearchUtil.binarySearch(list, "6");
        assertEquals(true, result);

        result = BinarySearchUtil.binarySearch(list, "9");
        assertEquals(false, result);

        result = BinarySearchUtil.binarySearch(list, "7");
        assertEquals(true, result);

        result = BinarySearchUtil.binarySearch(list, "5");
        assertEquals(true, result);

        result = BinarySearchUtil.binarySearch(list, "2");
        assertEquals(true, result);

    }



}
