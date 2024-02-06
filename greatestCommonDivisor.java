import java.util.Scanner;

public class greatestCommonDivisor{

public static void main(String[] args){
Scanner input = new Scanner(System.in);

    System.out.print("Enter the first number: ");
int number1 = input.nextInt();
System.out.print("Enter the second number: ");
int number2 = input.nextInt();
int gcd = 1;  

int smallerNumber = Math.min(number1, number2);

for (int i = 2; i <= smallerNumber; i++) {
    if (number1 % i == 0 && number2 % i == 0) {
gcd = i;
    }
}

System.out.println("The Greatest Common Divisor (GCD) is: " + gcd);
    }
}
