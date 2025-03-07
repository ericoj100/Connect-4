public class ConnectFour{
    private String[][] board;
    private String turn;
    private int[] tracker;
    private int[] header;

    //
    public ConnectFour() {
        board = new String[6][7]; 
        turn = "X"; 
        tracker = new int [] {0, 0, 0, 0, 0, 0, 0};
        header = new int[] {1, 2, 3, 4, 5, 6, 7};
    }

    //
    public void reset() {
        for (int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                board[r][c] = "-"; 
            }
        } 
    } 

    public void  printBoard() {
        for(int i = 0; i <header.length; i++){
                System.out.print(header[i] + "   ");
            }
            System.out.println();
        for (int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) { 
                System.out.print(board[r][c] + "   ");
            }
            System.out.println();
        }
    }

    public void set(int c){
        if (isValid(c)) {
            board[(board.length - 1) - tracker[c - 1]][c - 1] = getTurn();
            tracker[c - 1]++; 
            if (getTurn() == "X") {
                turn = "O"; 
            } else {
                turn = "X"; 
            }
        } 
    }

    public String getTurn() {
        return turn; 
    };

    // Checks if coordinate is valid 
    public boolean isValid(int c) {
        if ((c > (board[0].length) || c < 1)) {
            return false;
        } else if (tracker[c - 1] > board.length - 1) {
            return false; 
        }
        return true;
    }

    // Is this coordinate on the board 
    public boolean isOnBoard(int r, int c) {
        if ((c > (board[0].length) || c < 0)) {
            //System.out.println("THIS IS THE COLUMN NOT FOUND:" + c);
            return false;
        } else if ((r > (board.length - 1) || r < 0)) {
            System.out.println("THIS IS THE ERROR");
            return false; 
        }
        return true;
    }

    public boolean isWon(){
        int count = 1;
        // Search four-in-a-row in rows
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length - 1; c++){
                if (board[r][c].equals(board[r][c+1]) && !board[r][c].equals("-")) {
                    count++;
                    if (count == 4) {
                        turn = board[r][c]; 
                        return true; 
                    } 
                } else {
                        count = 1; 
                }
            }
            count = 1; 
        }
        // Search four-in-a-row in columns
        for(int c = 0; c < board[0].length; c++){
            for(int r = 0; r < board.length - 1; r++){
                if (board[r][c].equals(board[r + 1][c]) && !board[r][c].equals("-")) {
                    count++;
                    if (count == 4) {
                        turn = board[r][c];
                        return true; 
                    } 
                }
                else {
                    count = 1; 
                    }
            }
            count = 1; 
        }

        // Search four-in-a-row diagonals top-right to bottom-left
        for(int c = 3; c < board[0].length; c++){
            int row = 0; 
            int col = c; 
            if (col == 6) {
                for (int r = 0; r < 3; r++) {
                    row = r; 
                    System.out.println("index value of r" + r);
                    while(isOnBoard(row + 1, col - 1)) {
                        System.out.println("row " + row);
                        // System.out.print(board[row][col] + board[row + 1][col - 1] + "     " + row + " " + col + "   ");
                        // System.out.println(board[row][col].equals(board[row + 1][col - 1]) && !board[row][col].equals("-")); 

                        if (board[row][col].equals(board[row + 1][col - 1]) && !board[row][col].equals("-")) {
                            count++; 
                            System.out.println("TEST THIS SHOULD BE WORKING");
                            if (count == 4) {
                                turn = board[row][col];
                                return true; 
                            }
                        } else {
                            count = 1; 
                        }
                        row++;
                        col--; 
                    }
                        
                }
            } else {
                while(isOnBoard(row + 1, col - 1)) {
                    if (board[row][col].equals(board[row + 1][col - 1]) && !board[row][col].equals("-")) {
                        count++; 
                        if (count == 4) {
                            turn = board[row][col];
                            return true; 
                        }
                    } else {
                        count = 1; 
                    }
                    row++;
                    col--; 
                }
            }
            count = 1; 
        }
        return false;
    }
}