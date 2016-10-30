package cw4.iterator;

import cw4.shop.Product;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by valdess on 30.10.16.
 */
public class Rozetka implements Iterator {
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
