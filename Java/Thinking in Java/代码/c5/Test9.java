package c5;

class Eat{
    Eat(){
        this(3);//必须在最起始处
        System.out.println("我吃饱了。");
    }
    Eat(int a){
        System.out.println("我已经吃了"+a+"个东西了。");
    }
}
public class Test9 {
    public static void main(String[] args) {
        Eat I = new Eat();
    }
}
