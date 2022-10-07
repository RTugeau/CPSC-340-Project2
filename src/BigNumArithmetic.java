import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BigNumArithmetic {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileIn = new FileInputStream(args[0]);
        Scanner scan = new Scanner(fileIn);
        LList list = new LList();
        AStack stack = new AStack();


    }

    public static String trimChar(String s) {
        for(int i = 0; i < s.length()-2; i++) {
            if(s.charAt(0) != '0') {
                break;
            }
            if(s.charAt(0) == '0') {
                s = s.replaceFirst("0", "");
            }
        }
        return s;
    }
}
