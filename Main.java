import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        System.out.print("Welcome to Othello!\n\n");
        Scanner sc = new Scanner(System.in);
        
        char color;
        while (true) {
        System.out.print("Choose color (black/white/b/w/B/W/O/X/o/x): ");
        String choice = sc.next();
        
            if (!choice.equals("black") && !choice.equals("white")
                && !choice.equals("b") && !choice.equals("w") && !choice.equals("B")
                && !choice.equals("W") && !choice.equals("O") && !choice.equals("X")
                && !choice.equals("o") && !choice.equals("x")) {
                System.out.println("Invalid color. Try again...");
            }
            else {
                if (choice.equals("black") || choice.equals("b") || choice.equals("B")
                    || choice.equals("O") || choice.equals("o"))
                    color = 'O';
                
                else 
                    color = 'X';
                break;
            }
        }
        
        System.out.print("Estimate forward moves [1,9]: ");
        
        int forwardMoves;
        
        while (true) {
            forwardMoves = Integer.parseInt(sc.next());
            if (forwardMoves < 1 || forwardMoves > 9) 
                System.out.println("Invalid moves. Try again...");
            else 
                break;
        }
        
        char plays = 'O';
        String move;
        char[] moveC;
        int[] moveI = {0,0};
        int i;
        boolean match;
        int checkEnd = 0; 
        ArrayList<char[]> history = new ArrayList<char[]>();
        while(true) {
            match = false;
            
            if (board.scoreboard(board, false))
                return;
            
            System.out.printf("Player's %c turn\n\n", plays);
            availableMoves moves = new availableMoves();
            moves = board.printMoves(board, plays, false);
            if (moves.movesNum == 0) {
                plays = (plays == 'O') ? 'X' : 'O';
                System.out.println("No available moves!");
                checkEnd++;
                if (checkEnd == 2) {
                    board.scoreboard(board, true);
                    return;
                }
                continue;
            }
            else
                checkEnd = 0;
            while (plays == color) {
                System.out.print("Enter your move (e.g. c2): ");
                move = sc.next();
                moveC = move.toCharArray();
                moveI[1] = moveC[0] - 'a';
                moveI[0] = Integer.parseInt(String.valueOf(moveC[1])) - 1;
                for (i = 0; i < moves.movesNum; i++) {
                    if (moveI[0] == moves.moves[i][0]
                        && moveI[1] == moves.moves[i][1]) {
                        match = true;
                        break;
                    }
                }
                if (!match)
                    System.out.print("Invalid move. Try again!\n\n");
                else {
                    System.out.printf("Player %c played: %s\n", plays, move);
                    board.board[moveI[0]][moveI[1]] = (plays == 'X') ? new PawnWhite() : new PawnBlack();
                    board.convert(board, moveI[1], moveI[0], plays);
                    history.add(moveC);
                    break;
                }
            }
            
            if (plays != color) {
                moveC = computer(board, plays, forwardMoves, moves);
                history.add(moveC);
            }
            
            board.printBoard(board);
            printHistory(history);
            plays = (plays == 'O') ? 'X' : 'O';
        }
        
    }
    
    static char[] computer(Board board, char color, int depth, availableMoves moves) {
        Eval eval = new Eval();
        char[] move = new char[2];
        eval = eval.minimax(board, color, color, moves, depth, -5000, 5000, true);
        board.board[moves.moves[eval.choiceNum][0]][moves.moves[eval.choiceNum][1]] = (color == 'X') ? new PawnWhite() : new PawnBlack();
        board.convert(board, moves.moves[eval.choiceNum][1], moves.moves[eval.choiceNum][0], color);
        move[0] = (char)(moves.moves[eval.choiceNum][1] + 'a');
        move[1] = (char)(moves.moves[eval.choiceNum][0] + '0' + 1);
        System.out.printf("Player %c played: %c%c\n", color, move[0], move[1]);
        return move;
    }
    
    static void printHistory(ArrayList history) {
        System.out.print("Moves history:");
        for (int i = 0; i < history.size(); i++) {
            char[] move = (char[]) history.get(i);
            System.out.print(" " + (move[0]) + (move[1]));
        }
        System.out.println();
        System.out.println();
    }
}
