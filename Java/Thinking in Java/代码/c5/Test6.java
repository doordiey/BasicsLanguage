package c5;

class Dog1{
    Dog1(int a,char b){
        System.out.println("barking");
    }
    Dog1(char b,int a){
        System.out.println("howling");
    }
}
public class Test6 {
    public static void main(String[] args) {
        Dog1 that = new Dog1(1,'a');
        Dog1 that1 = new Dog1('a',1);
    }
}
