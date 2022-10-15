import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BigNumArithmetic {
    public static void main(String[] args) {
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
        while (scan.hasNext()) {
            String words = scan.nextLine();
            String[] split = words.split(" ");

            for (String s: split) {
                if (!s.equals("")) {
                    objects.append(s);
                }
            }

            boolean bool = true;
            String finalRes = "";
            LList c = new LList();
            for (int i = 0; i < objects.length(); i++) {
                String w = objects.getValue().toString().trim();
                w = trimChar(w);
                if (w.equals("+")) {
                    if (stack.length() < 2) {
                        bool = false;
                    } else {
                        String a = stack.pop().toString();
                        String b = stack.pop().toString();
                        LList aLL = stringToLL(a);
                        LList bLL = stringToLL(b);
                        c = add(aLL, bLL);
                        finalRes = LListToString(c);
                        trimChar(finalRes);
                        stack.push(finalRes);
                    }
                    objects.next();
                } else {
                    stack.push(w);
                    objects.next();
                }
            }
            if (stack.length() != 1) {
                bool = false;
            }
            objects.moveToStart();
            for (int i = 0; i < objects.length(); i++) {
                System.out.print(objects.getValue() + " ");
                objects.next();
            }
            if(objects.isEmpty()) {
            } else {
                System.out.print("= ");
                if (bool) {
                    System.out.print(stack.pop());
                }
                System.out.println();
            }
            objects.clear();
            stack.clear();
        }
    }

    public static String trimChar(String s) {
        final int l = s.length();
        for (int i = 0; i < l - 1; i++) {
            if (s.charAt(0) == '0') {
                s = s.replaceFirst("0", "");
            }
        }
        return s;
    }

    public static LList stringToLL(String s) {
        LList a = new LList();
        for (int i = s.length()-1; i >= 0; i--) {
            int c = Character.getNumericValue(s.charAt(i));
            a.append(c);
        }
        return a;
    }

    public static String LListToString(LList l) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < l.length(); i++) {
            sb.append(l.getValue());
            l.next();
        }

        String string = sb.reverse().toString();
        return string;
    }

    public static LList add(LList a, LList b) {
        if (a.length() > b.length()) {
            int diff = (a.length() - b.length());
            for (int i = 0; i < diff; i++) {
                b.append(0);
            }
        } else {
            int diff = (b.length() - a.length());
            for (int i = 0; i < diff; i++) {
                a.append(0);
            }
        }

        a.moveToStart();
        b.moveToStart();
        LList finalNum = new LList();
        int carry = 0;
        for (int i = 0; i < a.length(); i++) {
            int c = (int) a.getValue();
            int d = (int) b.getValue();
            int e = c + d + carry;
            if (e > 9) {
                carry = 1;
                e = e - 10;
                finalNum.append(e);
            } else {
                carry = 0;
                finalNum.append(e);
            }
            a.next();
            b.next();
        }
        if (carry == 1) {
            finalNum.append(carry);
        }

        return finalNum;
    }
}
