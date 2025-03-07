
import java.util.Scanner;

public class ConnectFourTester {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        ConnectFour game = new ConnectFour(); 
        game.reset(); 
        boolean lose = true;
        while(lose){
            if (game.isWon()) {
                game.printBoard();  
                System.out.println("Player " + game.getTurn() + " wins!");
                lose = false;
            } else {
                game.printBoard();  
                System.out.println("It is player " + game.getTurn() + "'s turn. Please enter the column you want to play.");
                game.set(kb.nextInt());
                
            }            
       }
    }
}