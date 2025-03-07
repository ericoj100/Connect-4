# Connect-4
APCSA project
public class ConnectFour{
    private String[][] board;

    //
    public ConnectFour(String[][]connect){
        board = connect;
    }
    //
    public void reset() {
        for (int c = 0; c < board.length; c++){
            for(int r = 0; r < board[0].length; r++){
                board[c][r] = ""; 
            }
        } 
    } 
}