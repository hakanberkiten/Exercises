import java.util.Scanner;
public class randomSumOfDigits {

public static void main(String[] args){

int random =  (int) (Math.random() * 1001);
System.out.println(random);

int sum = 0;

while(random != 0){
int reminder = ((int)random % 10);
random = ((int)random / 10);  


sum += reminder;
}
System.out.println("The sum of the digits is "+ sum);
}
}