import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

        LList objects = new LList();
        while(scan.hasNext()) {
            String words = scan.nextLine();
            String split[] = words.split(" ");

            for (String s: split) {
                if (!s.equals("")) {
                    objects.append(s);
                }
            }

            for(int i = 0; i < objects.length(); i++) {
                String w = objects.getValue().toString().trim();
                boolean bool = true;
                w = trimChar(w);
                System.out.println(w);
                if(w.equals("+")) {
                    if(stack.length() < 2) {
                        bool = false;
                    } else {
                        String a = stack.pop().toString();
                        String b = stack.pop().toString();
                        LList aLL = stringToLL(a);
                        LList bLL = stringToLL(b);
                    }
                } else {

                }

            }
            System.out.println("new line");
            objects.clear();
        }
    }

    public static String trimChar(String s) {
        final int l = s.length();
        for(int i = 0; i < l - 1; i++) {
            if(s.charAt(0) == '0') {
                s = s.replaceFirst("0", "");
            }
        }
        return s;
    }

    public static LList stringToLL(String s) {
        LList a = new LList();
        for(int i = s.length()-1; i >= 0; i--) {
            a.append(s.charAt(i));
        }
        return a;
    }

    public static String LListToString(LList l) {
        StringBuilder sb = new StringBuilder();

        for (Character ch : l) {
            sb.append(ch);
        }

        String string = sb.reverse().toString();
        return string;
    }

}
