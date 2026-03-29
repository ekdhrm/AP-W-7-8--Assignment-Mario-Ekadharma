package Question5;

import java.util.*;

public class LibrarySystem {

    static class Book {
        String title;
        String author;
        int year;

        Book(String t, String a, int y){
            title = t;
            author = a;
            year = y;
        }

        void getInfo(){
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Year of Publication: " + year);
        }
    }

    static class GeneralBook extends Book {
        String genre;

        GeneralBook(String t, String a, int y, String g){
            super(t,a,y);
            genre = g;
        }

        @Override
        void getInfo(){
            super.getInfo();
            System.out.println("Genre: " + genre);
        }
    }

    static class ChildrenBook extends Book {
        int minAge;
        boolean visual;

        ChildrenBook(String t, String a, int y, int m, boolean v){
            super(t,a,y);
            minAge = m;
            visual = v;
        }

        @Override
        void getInfo(){
            super.getInfo();
            System.out.println("Minimum Age: " + minAge);
            System.out.println("Has Visualisation: " + (visual ? "Yes" : "No"));
        }
    }

    static Stack<Book> books = new Stack<>();

    static void add(Book b){
        books.push(b);
    }

    static void view(){
        for(Book b : books){
            b.getInfo();
            System.out.println();
        }
    }

    static void delete(String t){
        if(!books.isEmpty()){
            books.pop();
        }
    }

    public static void main(String[] args) {

        add(new Book("Why Black Moves First","Wesley So",2025));
        add(new GeneralBook("Inside Black Mesa","Dr. Isaac Kleiner",1997,"Documentary"));
        add(new ChildrenBook("Got Science?","Rachel Dawes",2015,5,true));
        // add(new GeneralBook("Inside White Mesa","Dr. Isaac Newthrone",1987,"Documentary"));
        // delete("Got Science?");
        view();
    }
}
