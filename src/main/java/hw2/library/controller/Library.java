package hw2.library.controller;

import hw2.library.db.IDataBase;
import hw2.library.model.Issue;
import hw2.library.model.Reader;

import java.util.ArrayList;

/**
 * Created by valdess on 16.10.16.
 */
public class Library {

    IDataBase db;

    private ArrayList<Issue> books = new ArrayList<>();
    private ArrayList<Reader> readers = new ArrayList<>();



}
