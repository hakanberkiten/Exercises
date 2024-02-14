import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String target = "Target";
        int wordNumber = countWord(target);
        System.out.println("Find the target. Target is " + wordNumber + " words");
        int number = 6;
        String currentResult = printString(target);
        System.out.println(currentResult);
    
        while (number != 0) {
            System.out.print("Enter the letter: ");
            String letter = input.nextLine();
            if (target.contains(letter)) {
                System.out.println("Good guess");
                currentResult = replace(target, currentResult, letter);
                System.out.println(currentResult);
    
            } else {
                number--;
                System.out.println("Your guess is wrong. You have "+number+" attempts left.");
            }
            if (target.equals(currentResult.replaceAll(" ", ""))) {
                System.out.println("************************** You won the game ********************************");
                break;
            }
            if(number == 0) {
            System.out.println("Game is over, try again");
            }
    
        }
        input.close();
    }
    
    public static int countWord(String target) {
        int count = 1;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
    
    public static String printString(String target) {
        StringBuilder result = new StringBuilder();
        int length = target.length();
        for (int i = 0; i < length; i++) {
            if (target.charAt(i) == ' ') {
                result.append("/");
            } else
                result.append("_ ");
        }
        return result.toString();
    }
    
    public static String replace(String target, String result, String letter) {
        StringBuilder newResult = new StringBuilder(result);
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == letter.charAt(0)) {
                newResult.setCharAt(i * 2, letter.charAt(0));
            }
        }
        return newResult.toString();
    }
}
