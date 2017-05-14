/**
 * Created by marina on 05.05.2017.
 */
public class SumNClass {
    public static void main(String[] args) {
        int res = getSum(100);
        System.out.println(res);
    }

    private static int getSum(int count){
        int sum =0;
        for (int i=1;i<=count; i++) {
            sum+=i;
        }
        return sum;
    }
}
