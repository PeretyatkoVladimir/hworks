package hw1.myArrayList;

import java.util.*;

public class MyArrayList implements List {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Object[] elementData;


    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[Math.max(initialCapacity, DEFAULT_CAPACITY)];
    }


    private void checkAndGrow(int newSize){
        if (elementData.length < newSize){
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
        return this.containsAll(new ArrayList(that)); //new ArrayList because i haven't iterator and without it, it is not work :(

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

        for (int i = 0; i < size; i++){
            if (o.equals(elementData[i])){
                return true;
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

        if (o == null) {
            return false;
        }

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
        elementData = new Object[DEFAULT_CAPACITY];
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

        System.arraycopy(this.elementData, index, this.elementData, index + 1, newCapacity - index);
        this.elementData[index] = element;
        this.size = newCapacity;
    }

    @Override
    public Object remove(int index) {
        checkRange(index);
        Object oldValue = elementData[index];
        elementData[index] = null;
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        size--;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if (o.equals(elementData[i])){
                return i;
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

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0]; // TODO 1. I don't understand what is this :(
    }

    @Override
    public Iterator iterator() {
        return null; // TODO 2. I don't understand what is this :(
    }

    @Override
    public ListIterator listIterator() {
        return null; // TODO 3. I don't understand what is this :(
    }

    @Override
    public ListIterator listIterator(int index) {
        return null; // TODO 4. I don't understand what is this :(
    }


}