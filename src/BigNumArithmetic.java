import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BigNumArithmetic {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileIn = new FileInputStream(args[0]);
        Scanner scan = new Scanner(fileIn);
        int num1 = scan.nextInt();
        System.out.println(num1);
    }
}
