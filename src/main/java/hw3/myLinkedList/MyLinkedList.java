package hw3.myLinkedList;


import hw1.myArrayList.MyArrayList;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by vperetyatko on 24.10.2016.
 */
public class MyLinkedList<E> implements List<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E>{

        private Node<E> prev;
        private E item;
        private Node<E> next;

        public Node(E item){
            this.item = item;
        }

        public Node(Node prev, E item, Node next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

    }

    private class myListIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

    private void removeNode(Node<E> node){

        Node nextN = node.next;
        Node prevN = node.prev;

        if(node == this.first){
            this.first = nextN;
            nextN.prev = null;
        } else if (node == this.last) {
            this.last = prevN;
            prevN.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("You are looser!");
    }

    private Node<E> node(int index) {

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

    private void insert(Node<E> target, Node<E> newNode) {
        if (target == this.first) {
            newNode.next = this.first;
            this.first = newNode;
            target.prev = newNode;
        } else if(target == this.last){
            newNode.next = last;
            newNode.prev = last.prev;
            last.prev.next = newNode;
        } else {
            newNode.next = target;
            newNode.prev = target.prev;
            target.prev.next = newNode;
            target.prev = newNode;
        }
        size++;
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
    public java.util.Iterator<E> iterator() {
        return null;// TODO 1.
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
    public boolean add(E o) {
        addLast(o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (Node x = first; x != null;){
            if ((o != null && x.item.equals(o))
                    || (o == null && x.item == o)){
                removeNode(x);
                return true;
            }
            x = x.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E o : c){
            add(o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {

        checkRange(index);

        if (c.size() == 0){
            return false;
        }

        Node newChainFirst = null;
        Node newChainLast = null;

        for (E o : c){
            if(newChainFirst == null){
                newChainFirst = new Node<E>(o);
                newChainLast = newChainFirst;
            } else {
                newChainLast.next = new Node<E>(newChainLast, o, null);
                newChainLast = newChainLast.next;
            }
            size++;
        }
        Node<E> nodeByIndex = node(index);


        nodeByIndex.prev.next = newChainFirst;
        newChainFirst.prev = nodeByIndex.prev;

        nodeByIndex.prev = newChainLast;
        newChainLast.next = nodeByIndex;

        return true;
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
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public Object set(int index, Object element) {
        checkRange(index);
        Node node = node(index);
        Object oldItem = node.item;
        node.item = element;
        return oldItem;
    }

    @Override
    public void add(int index, E element) {
        insert(node(index), new Node<E>(element));
    }

    @Override
    public E remove(int index) {

        checkRange(index);
        Node<E> node = node(index);
        E item = node.item;
        removeNode(node);
        return item;
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
        return null; // TODO 2.
    }

    @Override
    public ListIterator listIterator(int index) {
        return null; // TODO 3.
    }

    @Override
    public List subList(int fromIndex, int toIndex) {

        if (fromIndex > toIndex) throw new ArrayIndexOutOfBoundsException();

        MyLinkedList newList = new MyLinkedList();

        newList.first = node(fromIndex);
        newList.last = node(toIndex);
        newList.size = toIndex - fromIndex;

        return newList;
    }

    @Override
    public boolean retainAll(Collection c) {
        for (Node x = first; x != null; ) {
            if (! c.contains(x.item)) {
                Node forDel = x;
                x = x.next;
                removeNode(forDel);
            } else {
                x = x.next;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Node x = first; x != null; ) {
            if (c.contains(x.item)) {
                Node forDel = x;
                x = x.next;
                removeNode(forDel);
            } else {
                x = x.next;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c){
            if(! contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    //Deque @Override
    public void addFirst(E o) {
        if(size == 0){
            Node element = new Node<E>(null, o, null);
            first = element;
            last = element;
        } else {
            Node element = new Node<E>(null, o, first);
            first.prev = element;
            first = element;
        }
        size++;
    }

    //Deque @Override
    public void addLast(E o) {
        if(last == null){
            Node element = new Node<E>(null, o, null);
            first = element;
            last = element;
        } else {
            Node element = new Node<E>(last, o, null);

            last.next = element;
            last = element;
        }
        size++;
    }

    //Deque @Override
    public E getFirst() {

        if (first == null){
            throw new NoSuchElementException();
        }
        return first.item;
    }

    //Deque @Override
    public E getLast() {
        if (last == null){
            throw new NoSuchElementException();
        }
        return last.item;
    }

}
