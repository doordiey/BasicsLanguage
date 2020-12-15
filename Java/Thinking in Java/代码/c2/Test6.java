package c2;

public class Test6 {
    public static void main(String[] args){
        class func{
            int storage(String s){
                return s.length() * 2;
            }
        }
        func ah = new func();
        System.out.print(ah.storage("nihao"));
    }
}
