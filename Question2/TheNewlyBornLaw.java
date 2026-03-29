

import java.util.*;

public class TheNewlyBornLaw {

    static class Stand {

        protected Boolean expose(String name) {
            return false;
        }
        
    }

    static class Josuke extends Stand {

        @Override
        protected Boolean expose(String name) {
            return name.matches(name);
        }
    }

    static class Jotaro extends Stand {

        @Override
        protected Boolean expose(String name) {
            return name.length() <= 3;
        }
    }

    static class Okuyasu extends Stand {

        @Override
        protected Boolean expose(String name) {
            return name.matches(".*([a-zA-Z])\\1.*");
        }
    }

    static class Koichi extends Stand {

        @Override
        protected Boolean expose(String name) {
            int vowels = name.replaceAll("[^aeiouAEIOU]", "").length();
            return vowels >= 3;
        }
    }

    static class Rohan extends Stand {

        @Override
        protected Boolean expose(String name) {
            return new StringBuilder(name).reverse().toString().equalsIgnoreCase(name);
        }
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            // System.out.println("Select Partner:");
            // System.out.println("1. Josuke");
            // System.out.println("2. Jotaro");
            // System.out.println("3. Okuyasu");
            // System.out.println("4. Koichi");
            // System.out.println("5. Rohan");
            // System.out.print("Select your partner(1-5): ");
            String partnerChoice = sc.nextLine();

            Stand stand = null;

            switch (partnerChoice) {
                case "Josuke" -> stand = new Josuke();
                case "Jotaro" -> stand = new Jotaro();
                case "Okuyasu" -> stand = new Okuyasu();
                case "Koichi" -> stand = new Koichi();
                case "Rohan" -> stand = new Rohan();
                default -> {
                    System.out.println("Invalid partner choice.");
                    return;
                }
            }

            List<String> arrested = new ArrayList<>();

            for (String n : names) {
                if (stand.expose(n)) {
                    arrested.add(n);
                }
            }

            System.out.println("Arrested: " + arrested);
        }
    }
}
