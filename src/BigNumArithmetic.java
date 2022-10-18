import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

/**
 * BigNumArithmetic class
 * @version (10-17-2022)
 * @name Cole, Riley
 *
 * Honor Pledge sign: Cole, Riley
 *
 * This class will take an input file and read through it to compute
 * big number problems. This will compute addition, multiplication, and exponentiation
 * in small or big formulas
 */
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
                } else if(w.equals("*")) {
                    if (stack.length() < 2) {
                        bool = false;
                    } else {
                        String a = stack.pop().toString();
                        String b = stack.pop().toString();
                        LList aLL = stringToLL(a);
                        LList bLL = stringToLL(b);
                        c = multiply(aLL, bLL);
                        finalRes = LListToString(c);
                        trimChar(finalRes);
                        stack.push(finalRes);
                    }
                    objects.next();
                } else if(w.equals("^")) {
                    if(stack.length() < 2) {
                        bool = false;
                    } else {
                        String a = stack.pop().toString();
                        String b = stack.pop().toString();
                        LList bLL = stringToLL(b);
                        LList aLL = stringToLL(a);
                        c = exp(bLL, aLL);
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

    /**
     * multiply function - multiplies two linked lists of digits together and returns a linked list containing the answer
     * with each digit represented by a node.
     * @param a linked list containing the first number (in digits) to be multiplied
     * @param b linked list containing the second number (in digits) to be multiplied
     * @return linked list containing the answer of 'a' multiplied by 'b' (in digits)
     */

    public static LList multiply(LList a, LList b) {           // the first section here makes both linked lists of equal length
        if (a.length() > b.length()) {                         // if 'a' is larger than 'b', then the length of 'b' needs to be adjusted
            int diff = (a.length() - b.length());              // the value of 'a' is subtracted from 'b' to get the difference
            for (int i = 0; i < diff; i++) {                   // a loop is executed to add the additional zeros to 'b'
                b.append(0);
            }
        } else {                                               // if 'b' is larger than 'a', then the length of 'a' needs to be adjusted
            int diff = (b.length() - a.length());              // the value of 'b' is subtracted from 'a' to get the difference
            for (int i = 0; i < diff; i++) {                   // a loop is executed to add the additional zeros to 'a'
                a.append(0);
            }
        }                                                      // at this point, the lengths of 'a' and 'b' are identical

        a.moveToStart();                                       // both linked lists 'curr' values are moved to the start of the linked lists
        b.moveToStart();
        LList finalNum = new LList();                          // linked list 'finalNum' is created to hold the final answer
        LList answer = new LList();                            // linked list 'answer' is created to hold the answer after each iteration of the bottom value in multiplication
        int carry = 0;                                         // 'carry' value is initialized to hold the value that needs to be carried over in multiplication
        for(int i = 0; i < a.length(); i++) {                  // while int value 'i' is less than the length of 'a' (this increments through the bottom values in multiplication)
            for(int x = 0; x < i; x++) {                       //     a zero is appended to 'answer' every time 'i' increments to keep the values lined up for the addition
                answer.append(0);                              //      portion of the multiplication process
            }
            int d = (int) a.getValue();                        //     'd' is initialized and is set to the digit of 'a' at 'i' (cast from an object to an int value)
            for(int j = 0; j < b.length(); j++) {              //     while int value 'j' is less than the length of 'b' (this increments through the top values in multiplication)
                if(j == 0) {                                   //         if the value of 'j' is equal to '0', then it means we're looking at the rightmost top value
                    b.moveToStart();                           //         move the 'curr' value in linked list 'b' to the start of the linked list
                }
                int c = (int) b.getValue();                    //         'c' is initialized and is set to the digit of 'b' at 'j' (cast from and object to an int value)
                int e = (c * d) + carry;                       //         'e' is created and set to the value of (c * d) + the value of carry
                if(e > 9) {                                    //         if 'e' is greater than 9, then we have to carry over a value from 'e' to the next calculation
                    carry = (e / 10);                          //             carry is divided by 10 to get the value that needs to be carried over
                    answer.append(e % 10);                     //             the value of (e modulus(%) 10) is appended to 'answer'
                } else if((c * d) == 0 && e > 0) {             //         if the value of 'e' is created entirely from the value of 'carry',
                    answer.append(carry);                      //             then the value of 'carry' is appended to 'answer'
                    carry = 0;                                 //              and 'carry' is set to '0'
                } else if((c * d) != 0 && e > 0) {             //         if the value of 'e' is not created entirely from the value of 'carry',
                    answer.append(e);                          //             then the value of 'e' is appended to 'answer'
                    carry = 0;                                 //              and 'carry' is set to '0'
                } else {                                       //         in all other instances,
                    answer.append(e);                          //             the value of 'e' is appended to 'answer'
                }
                b.next();                                      //         the 'curr' value in 'b' is set to its next value
            }                                                  //   at this point, all the top values in the multiplication have been visited for the current incrementation value 'i'
            if(carry != 0) {                                   //     if the value of 'carry' is not equal to '0',
                answer.append(carry);                          //         then it gets appended to 'answer'
                carry = 0;                                     //              and 'carry' is set to '0'
            }                                                  //   the values in 'answer' now equal the top value in the multiplication multiplied by the bottom digit at a given iteration value 'i'
            finalNum = add(answer, finalNum);                  //     the add() function is called and fed 'finalNum' and 'answer' to add them together and this value is set to the value of 'finalNum'
            String s = LListToString(finalNum);                //     string 's' is initialized and stores the value of 'finalNum' converted to a string using the LListToString() function
            String t = trimChar(s);                            //     string 't' is initialized and stores the value of 's' after it's been trimmed using the trimChar() function
            finalNum = stringToLL(t);                          //     't' is converted back to a linked list using the stringToLL() function and is set to the value of 'finalNum'
            answer.clear();                                    //     'answer' is cleared for the next iteration
            a.next();                                          //     the 'curr' value in 'a' is set to its next value
        }
        return finalNum;                                       // the value of 'finalNum' is returned
    }

    public static LList exp(LList x, LList n) {
        x.moveToStart();
        n.moveToStart();
        int power;
        String s = LListToString(n);
        power = parseInt(s);
        String xString = LListToString(x);

        if(power == 0) {
            LList finalNum = new LList();
            finalNum.append(1);
            return finalNum;
        } else if((power % 2) == 0) {
            LList x1 = new LList();
            LList x2 = new LList();
            x1 = stringToLL(xString);
            x2 = stringToLL(xString);
            return exp(multiply(x1, x2), stringToLL(Integer.toString(power/2)));

        } else {
            LList answer = new LList();
            LList x1 = new LList();
            LList x2 = new LList();
            LList x3 = new LList();
            x1 = stringToLL(xString);
            x2 = stringToLL(xString);
            x3 = stringToLL(xString);
            answer.append((power - 1) / 2);
            return multiply(x1, exp(multiply(x2, x3), stringToLL(Integer.toString((power - 1) / 2))));
        }

    }
}
