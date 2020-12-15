package c4;

public class Test6 {
    static int test(int testval, int target, int begin, int end){
        if(testval<=end && testval>=begin && target<=end && target>=begin){
            System.out.println("在范围内");
        }
        else{
            System.out.println("不在范围内");
        }
        if(testval > target)
            return 1;
        else if(testval < target)
            return -1;
        else
            return 0;

    }
    public static void main(String[] args) {
        int res = test(1,2,0,4);
        System.out.println(res);
    }
}
