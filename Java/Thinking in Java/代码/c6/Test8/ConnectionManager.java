package c6.Test8;

class Connection{
    private int a;
    private Connection(){
    }
    static Connection mkc(){
        return new Connection();
    }
}
public class ConnectionManager {
    private static Connection[] c;
    public Connection getc(){
        set();
        for(int i=0;i<3;i++){
            if(c[i]!=null){
                Connection a ;
                a = c[i];
                c[i] = null;
                return a;
            }
        }
        return null;
    }
    private static void set(){
        for(int i=0;i<3;i++){
            c[i] = Connection.mkc();
            System.out.println(c[i]);
        }
    }

    public static void main(String[] args) {
        ConnectionManager it = new ConnectionManager();
        for(int i=0;i<4;i++){
            System.out.println(it.getc());
        }
    }
}
