package c4;

public class Test4 {
    public static void main(String[] args) {
        for(int x=1;x<100;x++){
            int m = 0;
            for(int y=1;y<x;y++){
                if (x%y==0 && x!=y && y!=1){
                    m = 1;
                    break;
                }
            }
            if(m==0){
                System.out.println(x);
            }
        }
    }
}
