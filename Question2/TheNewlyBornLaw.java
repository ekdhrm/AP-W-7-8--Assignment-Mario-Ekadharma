

import java.util.*;

public class TheNewlyBornLaw {

    static abstract class Stand {

        protected abstract Boolean expose(String name);

    }

    static class Josuke extends Stand {

        @Override
        protected Boolean expose(String name) {
            return name.toLowerCase().contains("k");
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

            Stand stand;

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
        Queue<String> queue = new LinkedList<>();
        String[] input = sc.nextLine().split(" ");
        for(String s : input){
            queue.offer(s);
        }
        
        Stack<String> stack = new Stack<>();

        while(!queue.isEmpty()){
            String n = queue.poll();

            // skip partner
            if(n.equalsIgnoreCase(partnerChoice)){
                continue;
            }

            if(stand.expose(n)){
                stack.push(n);
            }
        }

        // convert ke list (biar output enak)
        List<String> arrested = new ArrayList<>(stack);

        if (!arrested.isEmpty()){
            System.out.println(partnerChoice + " exposed someone!");
        }

        System.out.println("Arrested: " + arrested);
    }
}
}
