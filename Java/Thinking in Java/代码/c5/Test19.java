package c5;

class Po{
    static void f(String... args){
        for(String a:args){
            System.out.print(a);
        }
        System.out.println("");
    }
}

public class Test19 {
    public static void main(String[] args) {
        Po.f("我","want","睡觉","了",new String("但现在还早"));
        Po.f(new String[]{"现在","才","17","点",});
    }
}
