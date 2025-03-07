
import java.util.Scanner;

public class ConnectFourTester {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        ConnectFour game = new ConnectFour(); 
        // Set board for a new game 
        game.reset(); 
        boolean lose = true;
        while(lose) {
            // Stop game if there is a winning combination
            if (game.isWon()) {
                game.printBoard();  
                System.out.println("Player " + game.getTurn() + " wins!");
                lose = false;
            // Otherwise continue playing game 
            } else {
                game.printBoard();  
                System.out.println("It is player " + game.getTurn() + "'s turn. Please enter the column you want to play.");
                game.set(kb.nextInt());
                
            }            
        }
    }
}