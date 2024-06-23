import java.util.Scanner;

public class TicTacToe {
public static void main(String[] args) {
    char[][] arr = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    System.out.println("Welcome the Tic - Tac - Toe");

    Scanner input = new Scanner(System.in);

    System.out.println("Player 1 You are X");
    System.out.println("Player 2 You are O \n");


    print(arr);

    char player1 = 'X';
    char player2 = 'O';


   makeMovePlayer1(arr);
   isPlayer1Winner(arr, player1);

   makeMovePlayer2(arr);
   isPlayer2Winner(arr, player2);

   makeMovePlayer1(arr);
   isPlayer1Winner(arr, player1);

   makeMovePlayer2(arr);
   isPlayer2Winner(arr, player2);

   makeMovePlayer1(arr);
   isPlayer1Winner(arr, player1);

   makeMovePlayer2(arr);
   isPlayer2Winner(arr, player2);

   makeMovePlayer1(arr);
   isPlayer1Winner(arr, player1);

   makeMovePlayer2(arr);
   isPlayer2Winner(arr, player2);

   makeMovePlayer1(arr);
   isPlayer1Winner(arr, player1);


   System.out.println("\nDRAW");

}    

public static void isPlayer1Winner(char[][] arr , char player){
    if(isGameOver(arr, player)){
        System.out.println("Game is over Player 1 (X) is WINNER");
        return;
       }
}

public static void isPlayer2Winner(char[][] arr , char player){
    if(isGameOver(arr, player)){
        System.out.println("Game is over Player 2 (O) is WINNER");
        return;
       }
}


public static void makeMovePlayer1(char[][] arr){
    Scanner input = new Scanner(System.in);
    System.out.print("Player 1 make your move (ROW COLUMN) (1-3): ");
    int r = input.nextInt();
    int c = input.nextInt();


    while(true){
        if(arr[r-1][c-1] != ' '){
            System.out.print("Player 1 make your move (ROW COLUMN) (1-3): ");
         r = input.nextInt();
          c = input.nextInt();
          
        
    }
       else{
        play1(arr, r, c, 'X');
        print(arr);
    
        break;
        
       }
   
}
}

public static void makeMovePlayer2(char[][] arr){
    Scanner input = new Scanner(System.in);
    System.out.print("Player 2 make your move (ROW COLUMN) (1-3): ");
    int r = input.nextInt();
    int c = input.nextInt();


    while(true){
        if(arr[r-1][c-1] != ' '){
            System.out.print("Player 2 make your move (ROW COLUMN) (1-3): ");
          r = input.nextInt();
          c = input.nextInt();
        
    }
       else{
        play2(arr, r, c, 'O');
        print(arr);
        break;
        
       }
    

}

}


public static boolean isGameOver(char[][] arr , char player){
    for (int i = 0; i < arr.length; i++) {
        if (arr[i][0] == player && arr[i][1] == player && arr[i][2] == player) {
            return true;
        }
    }
    for (int j = 0; j < arr[0].length; j++) {
        if (arr[0][j] == player && arr[1][j] == player && arr[2][j] == player) {
            return true;
        }
    }
    if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) {
        return true;
    }
    if (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) {
        return true;
    }

    return false;

}

public static void print(char[][] arr ){
    String result = "";
    for(int i =0; i<arr.length; i++){
        result += "\n";
        result+= i+1;
        for(int j =0; j<arr.length; j++){
            result+=" _"+arr[i][j] + "_|";
        }
    }
    System.out.print("   1    2    3 ");
    System.out.println(result);
}

public static void play1(char[][] arr , int r , int c , char letter){
    if(arr[r-1][c-1] != ' '){
     makeMovePlayer1(arr);
    }
    else{
        arr[r-1][c-1] = letter;
    }
}


public static void play2(char[][] arr , int r , int c , char letter){
    if(arr[r-1][c-1] != ' '){
     makeMovePlayer2(arr);
    }
    else{
        arr[r-1][c-1] = letter;
    }
}
}