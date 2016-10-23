package hw1.myArrayList;


//import java.hw1.myArrayList.MyArrayList;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by valdess on 14.10.16.
 */
public class MyArrayListTest {

    private List list;
    private static List testDataReadOnly;

    @BeforeClass
    public static void initTestData(){

        testDataReadOnly = new ArrayList();
        testDataReadOnly.add("0");
        testDataReadOnly.add("1");
        testDataReadOnly.add("2");
        testDataReadOnly.add("3");

    }

    @AfterClass
    public static void clearTestData(){
        testDataReadOnly = null;
    }

    @Before
    public void init(){

        list = new MyArrayList();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");

    }

    @Test
    public void test_remove_when_list_is_full(){

        list.add("9");

        list.remove(5);

        assertEquals(9, list.size());
        assertEquals("6", list.get(5));
    }

    @Test
    public void test_insert_when_list_is_full(){

        list.add(9);
        list.add(6, "5");

        assertEquals(11, list.size());
        assertEquals("5", list.get(6));
    }

    @Test
    public void test_sublist_when_list_is_full(){

        list.add("9");
        List subList = list.subList(5, 9);

        assertEquals(4, subList.size());

    }

    @Test
    public void test_sublist_when_list_is_full_(){

        list.add("9");
        List subList = list.subList(5, 9);

        assertEquals(4, subList.size());
    }

    @Test
    public void testList_toArray(){

        String[] expected = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        Assert.assertArrayEquals(expected, list.toArray());

    }

    @Test
    public void testList_add(){

        String[] expected = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        list.add("9");
        list.add("10");

        Assert.assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testList_add_null(){

        String[] expected = {"0", "1", "2", "3", "4", "5", "6", "7", "8", null, null};

        list.add(null);
        list.add(null);

        Assert.assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testList_get(){

        String[] expected = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};

        Assert.assertEquals("7", list.get(7));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMyArrayList_get_exeption(){

        String[] expected = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};

        Assert.assertEquals("7", list.get(20));
    }

    @Test
    public void testList_addIndex(){

        String[] expected = {"0", "1", "2", "X", "3", "4", "5", "6", "7", "8"};

        list.add(3, "X");

        Assert.assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testList_addAll(){

        String[] expected = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "0", "1", "2", "3"};

        list.addAll(testDataReadOnly);

        Assert.assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testList_addAllIndex(){

        String[] expected = {"0", "1", "2", "0", "1", "2", "3", "3", "4", "5", "6", "7", "8"};

        list.addAll(3, testDataReadOnly);

        System.out.println(Arrays.toString(list.toArray()));

        Assert.assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testList_set(){

        String[] expected = {"0", "1", "2", "3", "X", "5", "6", "7", "8"};

        String expectedElement = "4";
        String actualElement = (String) list.set(4, "X");

        Assert.assertArrayEquals(expected, list.toArray());
        assertEquals(expectedElement, actualElement);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMyArrayList_set_Exeption(){
        list.set(44, "X");
    }

    @Test
    public void testList_remove(){

        String[] expected = {"0", "1", "2", "3", "4", "5", "6", "8"};

        list.remove("7");

        Assert.assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testList_removeIndex(){

        String[] expected = {"0", "1", "2", "3", "4", "5", "6", "8"};

        list.remove(7);

        Assert.assertArrayEquals(expected, list.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMyArrayList_removeIndex_exeption(){

        list.remove(77);

    }

    @Test
    public void testList_size(){

        int expected = 9;
        int actual = list.size();

        assertEquals(expected, actual);
    }

    @Test
    public void testList_isEmpty(){

        boolean expected = false;
        boolean actual = list.isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    public void testList_clear(){

        String[] expected = {};

        list.clear();

        Assert.assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testList_contains(){

        boolean expected = true;
        boolean actual = list.contains("7");

        assertEquals(expected, actual);

        expected = false;
        actual = list.contains("77");

        assertEquals(expected, actual);

        //null check
        expected = false;
        actual = list.contains(null);

        assertEquals(expected, actual);

        list.add(null);

        expected = true;
        actual = list.contains(null);

        assertEquals(expected, actual);
    }

    @Test
    public void testList_indexOf(){

        int expected = 7;
        int actual = list.indexOf("7");

        assertEquals(expected, actual);

        expected = -1;
        actual = list.indexOf("44");

        assertEquals(expected, actual);
    }

    @Test
    public void testList_lastIndexOf(){

        list.add("7");
        int expected = 9;
        int actual = list.lastIndexOf("7");

        assertEquals(expected, actual);
    }

    @Test
    public void testList_retainAll(){

        String[] expected = {"0", "1", "2", "3"};

        list.retainAll(testDataReadOnly);

        System.out.println(Arrays.toString(list.toArray()));

        Assert.assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testList_removeAll(){

        String[] expected = {"4", "5", "6", "7", "8"};

        list.removeAll(testDataReadOnly);

        Assert.assertArrayEquals(expected, list.toArray());
    }

}
