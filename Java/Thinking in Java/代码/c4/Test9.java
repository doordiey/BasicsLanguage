package c4;

class Fibonacci{
    static int fib(int n){
        if(n==1){
            return 1;
        }
        if (n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
    static void fibs(int s){
        for(int i=1;i<s+1;i++){
            System.out.print(fib(i) + " ");
        }
    }
}
public class Test9 {
    public static void main(String[] args) {
        Fibonacci.fibs(7);
    }
}
