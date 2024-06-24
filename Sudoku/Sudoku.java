import java.util.*;
public class Sudoku {
    public static void main(String[] args) {

        int[][] arr = new int[9][9];
        initializeBoard(arr,27);
        print(arr);
        for(int i =0; i<54; i++){
            makeMove(arr);
        }

        System.out.println("YOU WON");

        
    }

    

    

    public static  void makeMove(int[][] arr) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("\nMake your move (row and column as 1-9): ");
            int r = input.nextInt();
            int c = input.nextInt();

            if (r < 1 || r > 9 || c < 1 || c > 9) {
                System.out.println("Invalid input. Row and column must be between 1 and 9.");
                continue;
            }

            System.out.print("Enter the number (1-9): ");
            int number = input.nextInt();

            if (number < 1 || number > 9) {
                System.out.println("Invalid number. Enter a number between 1 and 9.");
                continue;
            }
            while(!isValid(arr, r-1, c-1, number)){
                System.out.println("Invalid number entered.");
                System.out.print("Enter the number (1-9): ");
            number = input.nextInt();
            }
            
        

            if (isValid(arr, r - 1, c - 1, number)) {
                arr[r - 1][c - 1] = number;
                print(arr);
                

                
            } else {
                System.out.println("Cell is already filled. Choose another cell.");
            }
        }

        
    }



    public static void print(int[][] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += "\n";
            result += (i + 1) + " ";
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    result += "_ _|";
                } else {
                    result += "_" + arr[i][j] + "_|";
                }
            }
        }

        System.out.print("   1   2   3   4   5   6   7   8   9");
        System.out.println(result);
    }
    public static void initializeBoard(int[][] arr, int numFilledCells) {
        Random random = new Random();
        int count = 0;

        while (count < numFilledCells) {
            int i = random.nextInt(9);
            int j = random.nextInt(9);

            if (arr[i][j] == 0) {
                int num = random.nextInt(9) + 1;
                if (isValid(arr, i, j, num)) {
                    arr[i][j] = num;
                    count++;
                }
            }
        }
    }

    public static boolean isValid(int[][] arr, int r, int c, int number) {

        
        for (int i = 0; i < 9; i++) {
            if (arr[r][i] == number) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if (arr[j][c] == number) {
                return false;
            }
        }

        int startRow = r - r % 3;
        int startCol = c - c % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (arr[i][j] == number) {
                    return false;
                }
            }
        }

        return true; 
    }

}
