package tests;

import hw1.myArrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by valdess on 14.10.16.
 */
public class RunTests {

    private MyArrayList myArrayList;

    @Before
    public void init(){
        myArrayList = new MyArrayList();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");
    }

    @Test
    public void test_remove_when_list_is_full(){
        myArrayList.add("9");

        myArrayList.remove(5);

        assertEquals(9, myArrayList.size());
        assertEquals("6", myArrayList.get(5));
    }

    @Test
    public void test_insert_when_list_is_full(){

        myArrayList.add(6, "5");

        assertEquals(11, myArrayList.size());
        assertEquals("5", myArrayList.get(6));
    }
    @Test
    public void test_sublist_when_list_is_full(){

        myArrayList.add("9");
        List subList = myArrayList.subList(5, 9);

        assertEquals(5, subList.size());
    }

    @Test
    public void testMyArrayList_toArray(){

        String[] expected = {"cab", "abc", "cab", "cab", "bac", "bac"};

        MyArrayList actual = new MyArrayList();
        actual.add("cab");
        actual.add("abc");
        actual.add("cab");
        actual.add("cab");
        actual.add("bac");
        actual.add("bac");

        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void testMyArrayList_add(){

        String[] initExpected = {"cab", "abc", "cab", "cab", "bac", "bac"};
        MyArrayList expected = new MyArrayList(initExpected);

        MyArrayList actual = new MyArrayList();
        actual.add("cab");
        actual.add("abc");
        actual.add("cab");
        actual.add("cab");
        actual.add("bac");
        actual.add("bac");

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testMyArrayList_addIndex(){

        String[] initExpected = {"cab", "abc", "cab", "xxx", "bac", "bac"};
        MyArrayList expected = new MyArrayList(initExpected);

        MyArrayList actual = new MyArrayList();
        actual.add("cab");
        actual.add("abc");
        actual.add("cab");
        actual.add("bac");
        actual.add("bac");

        actual.add(3, "xxx");

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testMyArrayList_addAll(){

        String[] initExpected = {"cab", "abc", "cab", "cab", "bac", "bac"};
        MyArrayList expected = new MyArrayList(initExpected);

        MyArrayList actual = new MyArrayList();
        actual.add("cab");
        actual.add("abc");
        actual.add("cab");

        MyArrayList listForAdd = new MyArrayList();
        listForAdd.add("cab");
        listForAdd.add("bac");
        listForAdd.add("bac");

        actual.addAll(listForAdd);

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testMyArrayList_addAllIndex(){

        String[] initExpected = {"cab", "abc", "cab", "bac", "bac", "dab"};
        MyArrayList expected = new MyArrayList(initExpected);

        MyArrayList actual = new MyArrayList();
        actual.add("cab");
        actual.add("abc");
        actual.add("dab");

        MyArrayList listForAdd = new MyArrayList();
        listForAdd.add("cab");
        listForAdd.add("bac");
        listForAdd.add("bac");

        actual.addAll(2, listForAdd);

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testMyArrayList_set(){

        String[] initExpected = {"cab", "abc", "cab", "xxx", "bac", "bac"};
        MyArrayList expected = new MyArrayList(initExpected);

        String expectedElement = "bab";

        MyArrayList actual = new MyArrayList();
        actual.add("cab");
        actual.add("abc");
        actual.add("cab");
        actual.add("bab");
        actual.add("bac");
        actual.add("bac");

        String actualElement = (String) actual.set(3, "xxx");

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        assertEquals(expectedElement, actualElement);

    }

    @Test
    public void testMyArrayList_remove(){

        String[] initExpected = {"cab", "abc", "cab", "cab", "bac"};
        MyArrayList expected = new MyArrayList(initExpected);

        MyArrayList actual = new MyArrayList();
        actual.add("cab");
        actual.add("abc");
        actual.add("cab");
        actual.add("cab");
        actual.add("bac");
        actual.add("bac");

        actual.remove("bac");

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testMyArrayList_removeIndex(){

        String[] initExpected = {"cab", "abc", "cab", "bac", "bac"};
        MyArrayList expected = new MyArrayList(initExpected);

        MyArrayList actual = new MyArrayList();
        actual.add("cab");
        actual.add("abc");
        actual.add("cab");
        actual.add("cab");
        actual.add("bac");
        actual.add("bac");

        actual.remove(2);

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testMyArrayList_size(){

        MyArrayList myAL = new MyArrayList();
        myAL.add("cab");
        myAL.add("abc");
        myAL.add("cab");
        myAL.add("cab");
        myAL.add("bac");
        myAL.add("bac");

        int expected = 6;
        int actual = myAL.size();

        assertEquals(expected, actual);
    }

    @Test
    public void testMyArrayList_isEmpty(){

        MyArrayList myAL = new MyArrayList();
        myAL.add("cab");

        boolean expected = false;
        boolean actual = myAL.isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    public void testMyArrayList_clear(){

        MyArrayList expected = new MyArrayList();

        MyArrayList actual = new MyArrayList();
        actual.add("cab");
        actual.add("abc");
        actual.add("cab");
        actual.add("cab");
        actual.add("bac");
        actual.add("bac");

        actual.clear();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testMyArrayList_contains(){

        MyArrayList myAL = new MyArrayList();
        myAL.add("cab");
        myAL.add("abc");
        myAL.add("cab");
        myAL.add("cab");
        myAL.add("bac");
        myAL.add("bac");

        boolean expected = true;
        boolean actual = myAL.contains("cab");

        assertEquals(expected, actual);
    }

    @Test
    public void testMyArrayList_indexOf(){

        MyArrayList myAL = new MyArrayList();
        myAL.add("dab");
        myAL.add("abc");
        myAL.add("cab");
        myAL.add("cab");
        myAL.add("bac");
        myAL.add("bac");

        int expected = 2;
        int actual = myAL.indexOf("cab");

        assertEquals(expected, actual);
    }

    @Test
    public void testMyArrayList_lastIndexOf(){

        MyArrayList myAL = new MyArrayList();
        myAL.add("cab");
        myAL.add("abc");
        myAL.add("cab");
        myAL.add("cab");
        myAL.add("bac");
        myAL.add("bac");

        int expected = 3;
        int actual = myAL.lastIndexOf("cab");

        assertEquals(expected, actual);
    }

    @Test
    public void testMyArrayList_retainAll(){

        String[] initExpected = {"xxx", "aaa", "ccc"};
        MyArrayList expected = new MyArrayList(initExpected);

        MyArrayList actual = new MyArrayList();
        actual.add("aab");
        actual.add("xxx");
        actual.add("cab");
        actual.add("aaa");
        actual.add("cab");
        actual.add("ccc");

        MyArrayList listForRetain = new MyArrayList();
        listForRetain.add("aaa");
        listForRetain.add("ccc");
        listForRetain.add("xxx");

        actual.retainAll(listForRetain);

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testMyArrayList_removeAll(){

        String[] initExpected = {"xxx", "aaa", "ccc"};
        MyArrayList expected = new MyArrayList(initExpected);

        MyArrayList actual = new MyArrayList();
        actual.add("aab");
        actual.add("xxx");
        actual.add("cab");
        actual.add("aaa");
        actual.add("xab");
        actual.add("ccc");

        MyArrayList listForRemove = new MyArrayList();
        listForRemove.add("aab");
        listForRemove.add("cab");
        listForRemove.add("xab");

        actual.removeAll(listForRemove);

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }


}
