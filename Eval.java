package ce326.hw2;

import java.util.Arrays;

public class Eval {
    int choiceNum;
    int Evaluation;
    
    public Eval() {
        choiceNum = 0;
        Evaluation = 0;
    }
    
    
    public Eval minimax(Board board, char color, char plays, availableMoves moves, int depth, int alpha, int beta, boolean max) {
        Eval eva = new Eval();
        if (depth == 0) {
            eva.Evaluation = evaluate(board, plays);
            eva.choiceNum = -1;
            return eva;
        }
        
        Board computerBoard = new Board();
        availableMoves computerMoves = new availableMoves();
        
        
        if (max) {
            Eval  maxEva = new Eval();
            maxEva.Evaluation = -5000;
            maxEva.choiceNum = -1;
            if (moves.movesNum == 0) {
                maxEva.Evaluation = evaluate(board, plays);
                maxEva.choiceNum = 0;
                alpha = Math.max(maxEva.Evaluation, alpha);
            }
            for (int i = 0; i < moves.movesNum; i++) {
                computerBoard.board = Arrays.stream(board.board).map(Pawn[]::clone).toArray(Pawn[][]::new);
                computerBoard.board[moves.moves[i][0]][moves.moves[i][1]] = (color == 'X') ? new PawnWhite() : new PawnBlack();
                computerBoard.convert(computerBoard, moves.moves[i][1], moves.moves[i][0], color);
                color = (color == 'O') ? 'X' : 'O';
                computerMoves = computerBoard.printMoves(computerBoard, color, true);
                eva = minimax(computerBoard, color, plays, computerMoves, depth-1, alpha, beta, false);
                color = (color == 'O') ? 'X' : 'O';
                //maxEva.Evaluation = Math.max(eva.Evaluation, maxEva.Evaluation);
                if (eva.Evaluation > maxEva.Evaluation) {
                    maxEva.Evaluation = eva.Evaluation;
                    maxEva.choiceNum = i;
                    alpha = Math.max(maxEva.Evaluation, alpha);
                    if (beta <= alpha)
                        break;
                }
                //alpha = Math.max(maxEva.Evaluation, alpha);
                //if (beta <= alpha)
                   // break;
            }
            return maxEva;
        }
        
        else {
            Eval minEva = new Eval();
            minEva.Evaluation = 5000;
            minEva.choiceNum = -1;
            if (moves.movesNum == 0) {
                minEva.Evaluation = evaluate(board, plays);
                minEva.choiceNum = 0;
                beta = Math.min(minEva.Evaluation, beta);
            }
            for (int i = 0; i < moves.movesNum; i++) {
                computerBoard.board = Arrays.stream(board.board).map(Pawn[]::clone).toArray(Pawn[][]::new);
                computerBoard.board[moves.moves[i][0]][moves.moves[i][1]] = (color == 'X') ? new PawnWhite() : new PawnBlack();
                computerBoard.convert(computerBoard, moves.moves[i][1], moves.moves[i][0], color);
                color = (color == 'O') ? 'X' : 'O';
                computerMoves = computerBoard.printMoves(computerBoard, color, true);
                eva = minimax(computerBoard, color, plays, computerMoves, depth-1, alpha, beta, true);
                color = (color == 'O') ? 'X' : 'O';
                if (eva.Evaluation < minEva.Evaluation) {
                    minEva.Evaluation = eva.Evaluation;
                    minEva.choiceNum = i;
                    beta = Math.min(minEva.Evaluation, beta);
                        if (beta <= alpha)
                    break;
                }
                //beta = Math.min(minEva.Evaluation, beta);
                //if (beta <= alpha)
                    //break;
            }
            return minEva;
        }
    }
    
    public int evaluate(Board computerBoard, char color) {
        int[][] points =     {{ 500, -20,  10,  5,  5, 10, -20, 500}, // Row 1
                             { -20, -50,  -2, -2, -2, -2, -50, -20}, // Row 2
                             {  10,  -2,   1,  1,  1,  1,  -2,  10},  // Row 3
                             {   5,  -2,   1,  0,  0,  1,  -2,   5},  // Row 4
                             {   5,  -2,   1,  0,  0,  1,  -2,   5},  // Row 5
                             {  10,  -2,   1,  1,  1,  1,  -2,  10},  // Row 6
                             { -20, -50,  -2, -2, -2, -2, -50, -20},  // Row 7
                             { 500, -20,  10,  5,  5, 10, -20, 500}};  // Row 8
        int totalEval = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (computerBoard.board[i][j].color == color)
                    totalEval = totalEval + points[i][j];
                else if (computerBoard.board[i][j].color != '.' && computerBoard.board[i][j].color != '*')
                    totalEval = totalEval - points[i][j];
            }
        }
        return totalEval;
    }
}
