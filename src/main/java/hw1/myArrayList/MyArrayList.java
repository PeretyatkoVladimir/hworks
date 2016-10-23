package hw1.myArrayList;

import java.util.*;

/**
 * Created by vperetyatko on 10.10.2016.
 */
public class MyArrayList implements List {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Object[] elementData;


    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(Object[] objects){

        this.elementData = new Object[DEFAULT_CAPACITY];

        for (Object object : objects) {
            this.add(object);
        }

    }

    public MyArrayList(int initialCapacity) {
//todo + why do you limit user on init method?

        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        
        this.elementData = new Object[initialCapacity];
    }

    public MyArrayList(Collection c) {
//todo + I think elementData.length should == c.size()

        this.elementData = new Object[Math.max(DEFAULT_CAPACITY, c.size())];

        for(Object o : c){
            this.add(o);
        }
    }

    private void checkAndGrow(int newSize){
        if (elementData.length <= newSize){
            elementData = Arrays.copyOf(elementData, getNewCapacity());
        }
    }

    private int getNewCapacity(){
        return elementData.length + DEFAULT_CAPACITY;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("You are looser!");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList that = (MyArrayList) o;

        if (size != that.size) return false;
        return this.containsAll(that) && that.containsAll(this);

    }

    @Override
    public int hashCode() {
        int result = size;
        for (Object o : elementData){
            result = 31 * result + o.hashCode();
        }

        return result;
    }

    @Override
    public String toString() {
        return '{' + Arrays.toString(elementData) + '}';
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
//todo + o could be null

        if (o == null){
            for (int i = 0; i < size; i++) {
                if (o == elementData[i]) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Object[] toArray() {

        Object[] result = new Object[size];
        System.arraycopy(elementData, 0, result, 0, size);

        return result;
    }

    @Override
    public boolean add(Object o) {
//todo + think how to let null adding

        checkAndGrow(size + 1);
        elementData[size++] = o;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1){
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {

        if(c == null){
            return false;
        }

        for(Object o : c){
            add(o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {

        if (c == null){
            return false;
        }

        checkRange(index);
        int newCapacity = size + c.size();
        checkAndGrow(newCapacity);

        System.arraycopy(elementData, index, elementData, index + c.size(), this.size - index);
        System.arraycopy(c.toArray(), 0, elementData, index, c.size());

        size = newCapacity;

        return true;
    }

    @Override
    public void clear() {
//todo + make each cell == null
        for (int i = 0; i < size; i++){
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkRange(index);
        return elementData[index];
    }

    @Override
    public Object set(int index, Object element) {
        checkRange(index);
        Object oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, Object element) {

        if (element == null){
            return;
        }

        checkRange(index);
        int newCapacity = size + 1;
        checkAndGrow(newCapacity);

        System.arraycopy(this.elementData, index, this.elementData, index + 1, newCapacity - index -1);
        this.elementData[index] = element;
        this.size++;
    }

    @Override
    public Object remove(int index) {
        checkRange(index);
        Object oldValue = elementData[index];
        elementData[index] = null;
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        size--;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if (o == null){
                if (elementData[i] == o) {
                    return i;
                }
            } else {
                if (elementData[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--){
            if (o.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {

        checkRange(fromIndex);
        checkRange(toIndex);
        if (fromIndex > toIndex) throw new ArrayIndexOutOfBoundsException();

        int listCapacity = toIndex - fromIndex + 1;
        MyArrayList result = new MyArrayList(listCapacity);
        System.arraycopy(this.elementData, fromIndex, result.elementData, 0, listCapacity);
        result.size = toIndex - fromIndex;

        return result;
    }

    @Override
    public boolean retainAll(Collection c) {

        if (c == null){
            return false;
        }

        for (int i = 0; i < size;){
            if(! c.contains(elementData[i])){
                remove(i);
            } else {
                i++;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {

        if (c == null){
            return false;
        }

        for (int i = 0; i < size;){
            if(c.contains(elementData[i])){
                remove(i);
            } else {
                i++;
            }
        }
        return true;
    }


    @Override
    public boolean containsAll(Collection c) {
        if (c == null){
            return false;
        }

        for (Object element : c){
            if (! contains(element)){
                return false;
            }
        }

        return true;
    }

    private class Itr implements Iterator {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        //int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public Object next() {
            //checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = MyArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                MyArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

    }

    private class ListItr extends Itr implements ListIterator {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        @SuppressWarnings("unchecked")
        public Object previous() {
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = MyArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return elementData[lastRet = i];
        }

        public void set(Object e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                MyArrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(Object e) {
            try {
                int i = cursor;
                MyArrayList.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0]; // TODO 1. I don't understand what is this :(
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    @Override
    public ListIterator listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator listIterator(int index) {
        return new ListItr(index);
    }


}
