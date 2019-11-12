package tictactoe;

import java.util.Scanner;

public class TicTacToePlay {

	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
        Scanner s = new Scanner(System.in);
        int x=0;
        final int X = 1;
        do
        {
            System.out.println(t.getPlayer()==X?"Player X turn":"Player O turn");
            System.out.println("Enter position which you want to mark between 1 to 9");
            x=s.nextInt();
              
            t.putSign(x);
            System.out.println(t.toString());
            System.out.println("_____________________________");
            t.displayWinner();
              
        }while(t.isEmpty());
    }
}
