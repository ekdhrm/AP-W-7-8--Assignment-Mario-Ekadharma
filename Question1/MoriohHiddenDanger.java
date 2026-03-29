import java.util.*;

public class MoriohHiddenDanger {

    public static List<String> process(String input){
        String[] arr = input.split(" ");

        Stack<String> inputStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();

        // push semua ke input stack
        for(String s : arr){
            inputStack.push(s);
        }

        // karena pasangan (key-value), kita ambil 2-2
        while(!inputStack.isEmpty()){
            String value = inputStack.pop();
            if(!inputStack.isEmpty()){
                String key = inputStack.pop();

                // push ke result stack
                resultStack.push(key);
                resultStack.push(value);
            }
        }

        return new ArrayList<>(resultStack);
    }

    public static void main(String[] args) {
        String input = "holly may interesting MARCH corey November junior january paul december";
        System.out.println(process(input));
    }
}