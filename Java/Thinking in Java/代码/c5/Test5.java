package c5;

class Dog{
    Dog(){
        System.out.println("barking");
    }
    Dog(int a){
        System.out.println("howling");
    }
    Dog(char a){
        System.out.println("barking+howling");
    }
    Dog(float a){
        System.out.println("smile");
    }
}
public class Test5 {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        Dog d2 = new Dog(1);
        Dog d3 = new Dog('a');
        Dog d4 = new Dog((float) 1);
    }
}
