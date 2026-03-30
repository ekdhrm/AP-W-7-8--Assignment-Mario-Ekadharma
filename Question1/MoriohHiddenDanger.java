import java.util.*;

public class MoriohHiddenDanger {

    static List<String> months = Arrays.asList(
        "january","february","march","april","may","june",
        "july","august","september","october","november","december"
    );

    static boolean isMonth(String s){
        return months.contains(s.toLowerCase());
    }

    static int getMonthIndex(String s){
        return months.indexOf(s.toLowerCase());
    }

    static List<String> process(String input){
        String[] arr = input.split(" ");

        Stack<String> inputStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();

        for(String s : arr){
            inputStack.push(s);
        }

        while(!inputStack.isEmpty()){
            String value = inputStack.pop();
            if(!inputStack.isEmpty()){
                String key = inputStack.pop();

                resultStack.push(key);
                resultStack.push(value);
            }
        }

        return new ArrayList<>(resultStack);
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            
            List<String> list = process(input);
            
            // step 1: buat pasangan
            List<List<String>> pairs = new ArrayList<>();
            
            for(int i = 0; i < list.size(); i += 2){
                pairs.add(Arrays.asList(list.get(i), list.get(i+1)));
            }
            
            // step 2: sort pasangan berdasarkan bulan
            pairs.sort((p1, p2) -> {
                int m1 = 100, m2 = 100;
                
                for(String s : p1){
                    if(isMonth(s)){
                        m1 = getMonthIndex(s);
                        break;
                    }
                }
                
                for(String s : p2){
                    if(isMonth(s)){
                        m2 = getMonthIndex(s);
                        break;
                    }
                }
                
                return m1 - m2;
            });
            
            // step 3: flatten
            List<String> result = new ArrayList<>();
            for(List<String> p : pairs){
                result.add(p.get(0));
                result.add(p.get(1));
            }
            
            System.out.println(result);
        }
    }
}