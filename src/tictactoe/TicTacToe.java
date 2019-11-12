package tictactoe;

public class TicTacToe {

	
	private static final int X = 1, O = -1;
	private static final int EMPTY = 0;
      
    private int player = X;
    private int[][] board = new int[3][3];	
	private boolean isEmpty = false;
	private String message = "";
         
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPlayer() {
		return player;
	}
    
    public boolean isEmpty() {
		return isEmpty;
	}


	/** Puts an X or O mark at position i,j. */
    public void putSign(int position)
    {
        if(position < 1 || position > 9)
        {	
        	setMessage("Invalid board position");
            System.out.println(message);
            return;
        }
		switch (position) {
		case 1:
			checkBoardPosition(0, 0);
			break;
		case 2:
			checkBoardPosition(0, 1);
			break;
		case 3:
			checkBoardPosition(0, 2);
			break;
		case 4:
			checkBoardPosition(1, 0);
			break;
		case 5:
			checkBoardPosition(1, 1);
			break;
		case 6:
			checkBoardPosition(1, 2);
			break;
		case 7:
			checkBoardPosition(2, 0);
			break;
		case 8:
			checkBoardPosition(2, 1);
			break;
		case 9:
			checkBoardPosition(2, 2);
			break;
		}

    }
      
    private void checkBoardPosition(int x, int y) {
        if(board[x][y] != EMPTY)
        {	
        	setMessage("Board position occupied");
            System.out.println(message);
            return;
        }
        board[x][y] = player;   // place the mark for the current player
        player = -player;       // switch players (uses fact that O = - X)
    }
    
    /** Checks whether the board configuration is a win for the given player. */
    public boolean isWin(int player)
    {
        return ((board[0][0] + board[0][1] + board[0][2] == player*3) ||
                (board[1][0] + board[1][1] + board[1][2] == player*3) ||
                (board[2][0] + board[2][1] + board[2][2] == player*3) ||
                (board[0][0] + board[1][0] + board[2][0] == player*3) ||
                (board[0][1] + board[1][1] + board[2][1] == player*3) ||
                (board[0][2] + board[1][2] + board[2][2] == player*3) ||
                (board[0][0] + board[1][1] + board[2][2] == player*3) ||
                (board[2][0] + board[1][1] + board[0][2] == player*3));
    }
      
    /**display the winning player or indicate a tie (or unfinished game).*/
    public void displayWinner()
    {
        if(isWin(X))
        {
            System.out.println("\n X wins...!!");
            isEmpty=false;
        }
        else if(isWin(O))
        {
            System.out.println("\n O wins...!!");
            isEmpty=false;
        }
        else
        {
            if(!isEmpty)
            {
                System.out.println("its a tie");
            }
              
        }
    }
      
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        isEmpty = false;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                switch(board[i][j])
                {
                case X:
                    s.append(" X ");
                    break;
                case O:
                    s.append(" O ");
                    break;
                case EMPTY:
                    s.append("   ");
                    isEmpty=true;
                    break;
                }
                if(j<2)
                {
                    s.append("|");
                }
                  
            }
            if(i<2)
            {
                s.append("\n-----------\n");
            }
        }
        return s.toString();
    }

}
