package c5;

class Mo1{
    Mo1(){
        System.out.println("默认构造器");
    }
    Mo1(String a){
        System.out.println("接收参数："+a);
    }
}
public class Test4 {
    public static void main(String[] args) {
        Mo1 that = new Mo1("我是参数");
    }

}
