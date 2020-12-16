package c5;

class Have{
    int i = 0;
    void add(){
        i++;
    }
    void pr(){
        System.out.println(i);
        add();
        System.out.println(i);
        this.add();
        System.out.println(i);
    }
}
public class Test8 {
    public static void main(String[] args) {
        Have that = new Have();
        that.pr();
    }
}
