package hw3.myLinkedList;


import java.util.*;

/**
 * Created by vperetyatko on 24.10.2016.
 */
public class MyLinkedList implements List, Deque {

    private int size;
    private Node first;
    private Node last;

    private class Node{

        Node prev;
        Object item;
        Node next;


        public Node(Node prev, Object item, Node next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

    }

    private void removeElement(Node node){

        Node nextN = node.next;
        Node prevN = node.prev;

        if(node == this.first){
            this.first = nextN;
        } else if (node == this.last) {
            this.last = prevN;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private void checkRange(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("You are looser!");
    }

    private Node node(int index){
        checkRange(index);

        if(index <= size / 2){
            Node x = first;
            for (int i = 0; i < index; i++) x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--) x = x.prev;
            return x;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Node x = first; x != null;){
            if((o == null && x.item == o)
                    || (o != null && x.item.equals(o))){
                return true;
            }
            x = x.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Iterator descendingIterator() {
        return null;
    }

    @Override
    public Object[] toArray() {

        Object[] objects = new Object[this.size];

        int i = 0;
        for (Node x = first; x != null;){
            objects[i++] = x.item;
            x = x.next;
        }

        return objects;
    }

    @Override
    public void addFirst(Object o) {
        if(size == 0){
            Node element = new Node(null, o, null);
            first = element;
            last = element;
        } else {
            Node element = new Node(null, o, first);
            first.prev = element;
            first = element;
        }
        size++;
    }

    @Override
    public void addLast(Object o) {
        if(last == null){
            Node element = new Node(null, o, null);
            first = element;
            last = element;
        } else {
            Node element = new Node(last, o, null);
            last.next = element;
            last = element;
        }
        size++;
    }

    @Override
    public boolean offerFirst(Object o) {
        return false;
    }

    @Override
    public boolean offerLast(Object o) {
        return false;
    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object removeLast() {
        return null;
    }

    @Override
    public Object pollFirst() {
        return null;
    }

    @Override
    public Object pollLast() {
        return null;
    }

    @Override
    public Object getFirst() {
        if (first == null){
            throw new NoSuchElementException();
        }
        return first.item;
    }

    @Override
    public Object getLast() {
        if (last == null){
            throw new NoSuchElementException();
        }
        return last.item;
    }

    @Override
    public Object peekFirst() {
        return null;
    }

    @Override
    public Object peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(Object o) {
        addLast(o);
        return true;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public void push(Object o) {

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        for (Node x = first; x != null;){
            if ((o != null && x.item.equals(o))
                        || (o == null && x.item == o)){
                removeElement(x);
                size--;
                return true;
            }
            x = x.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c){
            add(o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        return node(index).item;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Node x = first; x != null; ) {
            if ((o != null && x.item.equals(o))
                    || (o == null && x.item == o)){
                return index;
            }
            x = x.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        for (Node x = last; x != null; ) {
            if ((o != null && x.item.equals(o))
                    || (o == null && x.item == o)){
                return index;
            }
            x = x.prev;
            index--;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object o : c){
            remove(o);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
