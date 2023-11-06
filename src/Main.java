import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(palindromeCheck("abccba"));
        System.out.println(palindromeCheck("Was it a car or a cat I saw ?"));
        System.out.println(palindromeCheck("I did, did I?"));
        System.out.println(palindromeCheck("hello"));
        System.out.println(palindromeCheck("Don't node"));
        System.out.println("***********");
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));
        System.out.println("***********");
        System.out.println(decimalToBinary(56));
        System.out.println(decimalToBinary(17));
        System.out.println(decimalToBinary(9));



    }

    public static boolean palindromeCheck(String text) {

        text = text.replaceAll("[.,'?!_-]", "").replace(" ", "").toLowerCase(new Locale("en"));
        char[] chars = text.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for(char c: chars){
            charStack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while(!charStack.isEmpty()){
            reversed.append(charStack.pop());
        }
        return text.equals(reversed.toString());

    }

    public static boolean checkForPalindrome(String text) {
        text = text.replaceAll("[.,'?!_-]", "").replace(" ", "").toLowerCase(new Locale("en"));
        char[] chars = text.toCharArray();
        Stack<Character> charStack = new Stack<>();
        Queue<Character> charQueue = new LinkedList<>();
        for(char c: chars){
            charStack.push(c);
            charQueue.add(c);
        }
        while(!charStack.isEmpty()){
            if(!charStack.pop().equals(charQueue.remove())){
                return false;
            }
        }
        return true;
    }

    public static int decimalToBinary(int number) {
        Stack<Integer> binary = new Stack<>();
        while(number > 1){
            binary.push(number % 2);
            number = number / 2;
        }
        binary.push(number % 2);
        String num = "";
        while(!binary.isEmpty()){
            num += binary.pop();
        }
        return Integer.parseInt(num);
    }
}