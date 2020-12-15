package c3;

public class Test6 {
    public static void main(String[] args) {
        Dog spot = new Dog("spot","Ruff!");
        Dog scruffy = new Dog("scruffy","Wurf!");
        Dog a = spot;
        System.out.println(a==spot);
        System.out.println(scruffy==a);
        System.out.println(spot==scruffy);
        System.out.println(a.equals(spot));
        System.out.println(a.equals(scruffy));
        System.out.println(scruffy.equals(spot));
    }
}
