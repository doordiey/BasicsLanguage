package c3;

class MyShow{
    static byte ShowChar(char a){
        return ((byte) a);
    }
}
public class Test13 {
    public static void main(String[] args) {
        System.out.println(MyShow.ShowChar('n'));
        System.out.println(MyShow.ShowChar('m'));
        System.out.println(MyShow.ShowChar('a'));
    }
}
