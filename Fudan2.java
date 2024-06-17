package www;
import java.util.Scanner;

public class Fudan2 {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
     int count=sc.nextInt();
     System.out.println(step(count));

    }

    public static int step(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return step(n - 1) + step(n - 2);
        }


    }
}
