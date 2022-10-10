import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class BigNumArithmetic {
    public static void main(String[] args) {
        LList list = new LList();
        AStack stack = new AStack();
        Scanner scan;
        try {
            FileInputStream fileIn = new FileInputStream(args[0]);
            scan = new Scanner(fileIn);
        }
        catch (FileNotFoundException e) {
            return;
        }

        LinkedList<String> objects = new LinkedList();
        while(scan.hasNext()) {
            String word = scan.next();
            if (!word.equals("")) {
                objects.add(word);
            }
        }
        for(int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
        }
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
