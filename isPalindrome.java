import java.util.Scanner;

public class isPalindrome {
public static void main(String[] args){

Scanner input = new Scanner(System.in);

System.out.print("Enter the word: ");

String word = input.nextLine();

if(isPalindromee(word)){

System.out.println("It is a palindrome.");

}

else
System.out.println("It is not a palindrome");

}
public static boolean isPalindromee(String word){

int length = word.length();

for(int i = 0; i< length /2; i++){

if(word.charAt(i) != word.charAt(length - 1 - i)){

return false;

}

}

return true;

}

}
