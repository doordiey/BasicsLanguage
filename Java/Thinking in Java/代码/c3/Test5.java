package c3;

class Dog{
    public String name;
    public String says;
    Dog(String name,String says){
        this.name=name;
        this.says=says;
    }
    void show(){
        System.out.println("Dog-name:"+this.name+" Dog-says:"+this.says);
    }
}
public class Test5 {
    public static void main(String[] args) {
        Dog spot = new Dog("spot","Ruff!");
        Dog scruffy = new Dog("scruffy","Wurf!");
        spot.show();
        scruffy.show();
    }
}
