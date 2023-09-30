// Dolcy Sareen
// 300339961
// lab 8 - Battleship
import java.util.Scanner;
public class BattleShip{
    public static void main(String args[]){
        int[][] ships = new int[6][6];
        // assigning positions to ships
        ships[0][0] = 2;
        ships[1][0] = 2;
        ships[1][4] = 3;
        ships[2][4] = 3;
        ships[3][4] = 3;
        ships[5][2] = 4;
        ships[5][3] = 4;
        ships[5][4] = 4;
        ships[5][5] = 4;
        char[][] guesses = new char[6][6];
        // setting the board for user guess display
        for(int i = 0; i < guesses.length; i++){
            for(int j = 0; j < guesses[0].length; j++){
                guesses[i][j] = '_';
            }
        }
        // printing the initial guess board for a user
        System.out.println("  1 2 3 4 5 6");
        for(int i = 0; i < guesses.length; i++){
            System.out.print((char)('A' + i) + " ");
            for(int j = 0; j < guesses[0].length; j++){
                System.out.print(guesses[i][j] + " ");
            }
            System.out.println();
        }
        int count=0;
        Scanner input = new Scanner(System.in);
        // loop will run till all ships are sunk(no of ships are 9)
        while(count<10){
            System.out.println("Please enter a guess in the form 'B5': ");
            String guess = input.next();
            guess = guess.toUpperCase();
            int row = guess.charAt(0) - 'A'; // converting character values into row index
            int col = guess.charAt(1) - '1'; // converting char value into col index
            
            // applying conditions when boat will hit or miss
            if(ships[row][col] == 0){
                System.out.println(guess + " is a Miss");
                guesses[row][col] = '0';
            }else{
                System.out.println(guess + " is a Hit");
                guesses[row][col] = 'X';
                count++;
            }
            
            // printing the message when patrol boat or destroyer or battleship is hitted
            // when required board position is x and ship at specific row and col is there then specific boats are sunk 
            if(ships[row][col] == 2 && guesses[0][0] == 'X' && guesses[1][0] == 'X'){
                System.out.println("You sunk the Patrol Boat");
            }else if(ships[row][col] == 3 && guesses[1][4] == 'X' && guesses[2][4] == 'X' && guesses[3][4] == 'X'){
                System.out.println("You sunk the Destroyer");
            }else if(ships[row][col] == 4 && guesses[5][2] == 'X' && guesses[5][3] == 'X' && guesses[5][4] == 'X' && guesses[5][5] == 'X'){
                System.out.println("You sunk the Battleship");
            }
            playerGuess(guesses);
        }
        System.out.println("Game over, You Win!");
    }

    // method to print the guessboard after every guess
    public static void playerGuess(char[][] guess){
        System.out.println("  1 2 3 4 5 6");
        for(int i = 0; i < guess.length; i++){
            System.out.print((char)('A' + i) + " ");
            for(int j = 0; j < guess[0].length; j++){
                System.out.print(guess[i][j] + " ");
            }
            System.out.println();
        }
    }
}