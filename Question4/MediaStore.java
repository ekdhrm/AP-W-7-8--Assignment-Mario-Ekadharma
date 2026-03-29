package Question4;

public class MediaStore {

    static class Media {
        String title;
        int year;
        double price;

        Media(String t, int y, double p){
            title = t;
            year = y;
            price = p;
        }

        void getDescription(){
            System.out.println("Title: " + title);
            System.out.println("releaseYear: " + year);
            System.out.println("Price: " + price);
        }
    }

    static class Dvd extends Media {
        double runtime;

        Dvd(String t, int y, double p, double r){
            super(t,y,p);
            runtime = r;
        }

        @Override
        void getDescription(){
            super.getDescription();
            System.out.println("Runtime: " + runtime + " minutes\n");
        }
    }

    static class Magazine extends Media {
        String author;
        int pages;

        Magazine(String t, int y, double p, String a, int pg){
            super(t,y,p);
            author = a;
            pages = pg;
        }

        @Override
        void getDescription(){
            super.getDescription();
            System.out.println("Author: " + author);
            System.out.println("Number of Pages: " + pages + "\n");
        }
    }

    static class Vinyl extends Media {
        int size;

        Vinyl(String t, int y, double p, int s){
            super(t,y,p);
            size = s;
        }

        @Override
        void getDescription(){
            super.getDescription();
            System.out.println("Size in inches: " + size + "\n");
        }
    }

    public static void main(String[] args) {

        Media dvd = new Dvd("Baby be Mine",1982,50000,4);
        Media mag = new Magazine("Nintendo Power #82",1997,25000,"Nintendo",36);
        Media vin = new Vinyl("Song of The Wind",1967,350000,12);

        dvd.getDescription();
        mag.getDescription();
        vin.getDescription();
    }
}