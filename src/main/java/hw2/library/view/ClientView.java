package hw2.library.view;

import hw2.library.controller.Library;
import hw2.library.exeptions.ReaderAlreadyExistException;
import hw2.library.exeptions.ReaderMaxIssuesCapacityException;
import hw2.library.exeptions.UserInBlackListException;
import hw2.library.exeptions.WrongInputChooseException;
import hw2.library.model.Book;
import hw2.library.model.Issue;
import hw2.library.model.LiteratureType;
import hw2.library.model.Reader;
import hw2.library.utils.DataInOutUtils;
import hw2.library.utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vperetyatko on 27.10.2016.
 */
public class ClientView {

    public static void start() {

        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        int select = 0;

        while (!exit){

            String[] menu = FileUtils.readFromFile(".//src/main/java/hw2/library/view/main_menu.txt").split("\r\n");;
            try {
                select = DataInOutUtils.getChoiceFromList(sc, Arrays.asList(menu));
            } catch (WrongInputChooseException e){
                System.out.println("Wrong input try again!");
                continue;
            }

            switch (select){
                case 1 : submenu1action();
                    break;
                case 2 : submenu2action(sc);
                    break;
                case 3 : submenu3action(sc);
                    break;
                case 4 : submenu4action(sc);
                    break;
                case 5 : submenu5action(sc);
                    break;
                case 6 : submenu6action();
                    break;
                case 7 : submenu7action(sc);
                    break;
                case 8 : submenu8action(sc);
                    break;

                case 11 : submenu11action(sc);
                    break;
                case 12 : submenu12action(sc);
                    break;
            }

            if (select == 13) {
                exit = true;
                sc.close();
            }

        }


    }

    private static void submenu1action() {
        DataInOutUtils.prntList(Library.getAllReaders());
    }

    private static void submenu2action(Scanner sc) {
        DataInOutUtils.prntList(Library.getAllIssues());
    }

    private static void submenu3action(Scanner sc) {

        String name; LiteratureType litType; int year; String isdn;

        try {
            name = DataInOutUtils.nextStr(sc, "Enter name, please!");
            litType = (LiteratureType) DataInOutUtils.chooseObjectFromList(sc, Issue.getLiteratureTypeList(), "Chose literature type:");
            year = DataInOutUtils.nextOnlyInt(sc, "Enter year please!");
            isdn = DataInOutUtils.nextStr(sc, "Enter isdn, please!");
        } catch (WrongInputChooseException e){
            System.out.println("Wrong type try again!");
            return;
        }
        Library.addIssue(name, litType, year, isdn);
    }

    private static void submenu4action(Scanner sc) {
        String readerName = DataInOutUtils.nextStr(sc, "Enter name, please!");
        try {
            Library.addUser(readerName);
        } catch (ReaderAlreadyExistException e){
            System.out.println("Reader allready exist!");;
        }
    }

    private static void submenu5action(Scanner sc) {

        Reader reader; Issue book;

        try {
            reader = (Reader) DataInOutUtils.chooseObjectFromList(sc, Library.getAllReaders(), "Choose reader:");
            book = (Book) DataInOutUtils.chooseObjectFromList(sc, Library.getAllIssues(), "Chose book:");
        } catch (WrongInputChooseException e){
            System.out.println("Wrong input try again");
            return;
        }

        try {
            Library.addIssueToReader(book, reader);
        } catch (UserInBlackListException e){
            System.out.println("Reader in black list");
        } catch (ReaderMaxIssuesCapacityException e){
            System.out.println("Reader full");
        }

    }

    private static void submenu6action() {
        ArrayList<Issue> issuesOnReader = new ArrayList<>();
        for(Reader r : Library.getAllReaders()){
            issuesOnReader.addAll(r.getIssues());
        }
        DataInOutUtils.prntList(issuesOnReader);
    }

    private static void submenu7action(Scanner sc) {

        Reader reader;
        try {
            reader = (Reader) DataInOutUtils.chooseObjectFromList(sc, Library.getAllReaders(), "Choose reader:");
        } catch (WrongInputChooseException e){
            System.out.println("Wrong input try again");
            return;
        }

        DataInOutUtils.prntList(reader.getIssues());

    }

    private static void submenu8action(Scanner sc) {
        Reader reader;
        try {
            reader = (Reader) DataInOutUtils.chooseObjectFromList(sc, Library.getAllReaders(), "Choose reader:");
        } catch (WrongInputChooseException e){
            System.out.println("Wrong input try again");
            return;
        }
        Library.addDelBlackList(reader);
    }

    private static void submenu11action(Scanner sc) {
        int year = DataInOutUtils.nextOnlyInt(sc, "Enter year for search!");
        DataInOutUtils.prntList(Library.getIssuesByYear(year));
    }

    private static void submenu12action(Scanner sc) {
        String keyWords = DataInOutUtils.nextStr(sc, "Enter key words for search!");
        DataInOutUtils.prntList(Library.getIssuesByKeyWord(keyWords));
    }



}
