package c3;

class Show{
    float x = 1;
    public Show(float a){
        this.x = a;
    }

}
public class Test2 {
    public static void main(String[] args){
        System.out.println("下面展示一下别名机制");
        Show that1 = new Show(3);
        Show that2 = new Show(4);
        System.out.print(that1.x);
        System.out.println(that2.x);
        that1 = that2;
        System.out.print(that1.x);
        System.out.println(that2.x);
        that1.x = 8;
        System.out.print(that1.x);
        System.out.println(that2.x);
    }
}
