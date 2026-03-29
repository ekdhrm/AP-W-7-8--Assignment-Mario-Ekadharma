public class MenuPricing {

    static class Food {
        String name;
        int basePrice;

        Food(String n, int p){
            name = n;
            basePrice = p;
        }

        int calcPrice(){
            return basePrice + 5000;
        }

        void getInfo(){
            System.out.println("Name: " + name);
            System.out.println("Price: " + calcPrice());
            System.out.println();
        }
    }

    static class RegularMenu extends Food {
        RegularMenu(String n, int p){ super(n,p); }
        @Override
        int calcPrice(){
            return super.calcPrice() + 10000;
        }
    }

    static class SpecialMenu extends Food {
        SpecialMenu(String n, int p){ super(n,p); }
        @Override
        int calcPrice(){
            return super.calcPrice() + 20000;
        }
    }

    public static void main(String[] args) {

        Food f = new Food("Beef Rendang",15000);
        Food r = new RegularMenu("Chicken Ramen",20000);
        Food s = new SpecialMenu("Fiery Fried Rice",80000);

        f.getInfo();
        r.getInfo();
        s.getInfo();
    }
}