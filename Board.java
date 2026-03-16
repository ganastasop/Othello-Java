public class Board {
    Pawn[][] board = new Pawn[8][8];
    
    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                this.board[i][j] = new Dot();
        }
        this.board[3][3] = new PawnWhite();
        this.board[3][4] = new PawnBlack();
        this.board[4][3] = new PawnBlack();
        this.board[4][4] = new PawnWhite();
    }
    
    public availableMoves printMoves(Board board, char color, boolean cpu) {
        int count;
        availableMoves moves = new availableMoves();
        moves.movesNum = 0;
        if (color == 'X') {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board.board[i][j].color == color) {
                        if (j != 0 && board.board[i][j-1].color == 'O') {
                            count = findMoves(board, color, "l", i, j, false);
                            if (count != 0 && board.board[i][j-count].color == '.') {
                                board.board[i][j-count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i;
                                moves.moves[moves.movesNum][1] = j-count;
                                moves.movesNum++;
                            }
                        }
                        if (j != 7 && board.board[i][j+1].color == 'O') {
                            count = findMoves(board, color, "r", i, j, false);
                            if (count != 0 && board.board[i][j+count].color == '.') {
                                board.board[i][j+count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i;
                                moves.moves[moves.movesNum][1] = j+count;
                                moves.movesNum++;
                            }
                        }
                        if (i != 0 && board.board[i-1][j].color == 'O') {
                            count = findMoves(board, color, "u", i, j, false);
                            if (count != 0 && board.board[i-count][j].color == '.') {
                                board.board[i-count][j] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i-count;
                                moves.moves[moves.movesNum][1] = j;
                                moves.movesNum++;
                            }
                        }
                        if (i != 7 && board.board[i+1][j].color == 'O') {
                            count = findMoves(board, color, "d", i, j, false);
                            if (count != 0 && board.board[i+count][j].color == '.') {
                                board.board[i+count][j] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i+count;
                                moves.moves[moves.movesNum][1] = j;
                                moves.movesNum++;
                            }
                        }
                        if (i != 0 && j != 0 && board.board[i-1][j-1].color == 'O') {
                            count = findMoves(board, color, "ul", i, j, false);
                            if (count != 0 && board.board[i-count][j-count].color == '.') {
                                board.board[i-count][j-count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i-count;
                                moves.moves[moves.movesNum][1] = j-count;
                                moves.movesNum++;
                            }
                        }
                        if (i != 0 && j != 7 && board.board[i-1][j+1].color == 'O') {
                            count = findMoves(board, color, "ur", i, j, false);
                            if (count != 0 && board.board[i-count][j+count].color == '.') {
                                board.board[i-count][j+count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i-count;
                                moves.moves[moves.movesNum][1] = j+count;
                                moves.movesNum++;
                            }
                        }
                        if (i != 7 && j != 0 && board.board[i+1][j-1].color == 'O') {
                            count = findMoves(board, color, "dl", i, j, false);
                            if (count != 0 && board.board[i+count][j-count].color == '.') {
                                board.board[i+count][j-count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i+count;
                                moves.moves[moves.movesNum][1] = j-count;
                                moves.movesNum++;
                            }
                        }
                        if (i != 7 && j != 7 && board.board[i+1][j+1].color == 'O') {
                            count = findMoves(board, color, "dr", i, j, false);
                            if (count != 0 && board.board[i+count][j+count].color == '.') {
                                board.board[i+count][j+count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i+count;
                                moves.moves[moves.movesNum][1] = j+count;
                                moves.movesNum++;
                            }
                        }
                    }
                }
            }
        }
        
        if (color == 'O') {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board.board[i][j].color == color) {
                        if (j != 0 && board.board[i][j-1].color == 'X') {
                            count = findMoves(board, color, "l", i, j, false);
                            if (count != 0 && board.board[i][j-count].color == '.') {
                                board.board[i][j-count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i;
                                moves.moves[moves.movesNum][1] = j-count;
                                moves.movesNum++;
                            }
                        }
                        if (j != 7 && board.board[i][j+1].color == 'X') {
                            count = findMoves(board, color, "r", i, j, false);
                            if (count != 0 && board.board[i][j+count].color == '.') {
                                board.board[i][j+count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i;
                                moves.moves[moves.movesNum][1] = j+count;
                                moves.movesNum++;
                            }
                        }
                        if (i != 0 && board.board[i-1][j].color == 'X') {
                            count = findMoves(board, color, "u", i, j, false);
                            if (count != 0 && board.board[i-count][j].color == '.') {
                                board.board[i-count][j] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i-count;
                                moves.moves[moves.movesNum][1] = j;
                                moves.movesNum++;
                            }
                        }
                        if (i != 7 && board.board[i+1][j].color == 'X') {
                            count = findMoves(board, color, "d", i, j, false);
                            if (count != 0 && board.board[i+count][j].color == '.') {
                                board.board[i+count][j] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i+count;
                                moves.moves[moves.movesNum][1] = j;
                                moves.movesNum++;
                            }
                        }
                        if (i != 0 && j != 0 && board.board[i-1][j-1].color == 'X') {
                            count = findMoves(board, color, "ul", i, j, false);
                            if (count != 0 && board.board[i-count][j-count].color == '.') {
                                board.board[i-count][j-count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i-count;
                                moves.moves[moves.movesNum][1] = j-count;
                                moves.movesNum++;
                            }
                        }
                        if (i != 0 && j != 7 && board.board[i-1][j+1].color == 'X') {
                            count = findMoves(board, color, "ur", i, j, false);
                            if (count != 0 && board.board[i-count][j+count].color == '.') {
                                board.board[i-count][j+count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i-count;
                                moves.moves[moves.movesNum][1] = j+count;
                                moves.movesNum++;
                            }
                        }
                        if (i != 7 && j != 0 && board.board[i+1][j-1].color == 'X') {
                            count = findMoves(board, color, "dl", i, j, false);
                            if (count != 0 && board.board[i+count][j-count].color == '.') {
                                board.board[i+count][j-count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i+count;
                                moves.moves[moves.movesNum][1] = j-count;
                                moves.movesNum++;
                            }
                        }
                        if (i != 7 && j != 7 && board.board[i+1][j+1].color == 'X') {
                            count = findMoves(board, color, "dr", i, j, false);
                            if (count != 0 && board.board[i+count][j+count].color == '.') {
                                board.board[i+count][j+count] = new Asterisk();
                                moves.moves[moves.movesNum][0] = i+count;
                                moves.moves[moves.movesNum][1] = j+count;
                                moves.movesNum++;
                            }
                        }
                    }
                }
            }
        }
        
        
        if (!cpu) {
            System.out.println("  a b c d e f g h");
            for (int i = 0; i < 8; i++) {
                System.out.printf("%d", i+1);
                for (int j = 0; j < 8; j++) 
                    System.out.print(" " + board.board[i][j].color);
                System.out.println();
            }
        }
        
        fixBoard(board);
        return moves;
    }

    
    static int findMoves(Board board, char color, String direction, int i, int j, boolean convert) {
        int count = 1;
        if (direction.equals("l")) {  //left
            while (j > 0) {
                if (board.board[i][j-1].color == color) {
                    if (convert)
                        return count;
                    else 
                        break;
                }
                else if (board.board[i][j-1].color != '.' && board.board[i][j-1].color != '*')
                    j--;
                else {
                    if (convert)
                        break;
                    return count;
                }
                count++;
            }
            return 0;
        }
        
        if (direction.equals("r")) {  //right
            while (j < 7) {
                if (board.board[i][j+1].color == color) {
                    if (convert)
                        return count;
                    else 
                        break;
                }
                else if (board.board[i][j+1].color != '.' && board.board[i][j+1].color != '*')
                    j++;
                else {
                    if (convert)
                        break;
                    return count;
                }
                count++;
            }
            return 0;
        }
        
        if (direction.equals("u")) {  //up
            while (i > 0) {
                if (board.board[i-1][j].color == color) {
                    if (convert)
                        return count;
                    else 
                        break;
                }
                else if (board.board[i-1][j].color != '.' && board.board[i-1][j].color != '*')
                    i--;
                else {
                    if (convert)
                        break;
                    return count;
                }
                count++;
            }
            return 0;
        }
        
        if (direction.equals("d")) {  //down
            while (i < 7) {
                if (board.board[i+1][j].color == color) {
                    if (convert)
                        return count;
                    else 
                        break;
                }
                else if (board.board[i+1][j].color != '.' && board.board[i+1][j].color != '*')
                    i++;
                else {
                    if (convert)
                        break;
                    return count;
                }
                count++;
            }
            return 0;
        }
        
        if (direction.equals("ul")) {  //upleft
            while (j > 0 && i > 0) {
                if (board.board[i-1][j-1].color == color) {
                    if (convert)
                        return count;
                    else 
                        break;
                }
                else if (board.board[i-1][j-1].color != '.' && board.board[i-1][j-1].color != '*') {
                    j--;
                    i--;
                }
                else {
                    if (convert)
                        break;
                    return count;
                }
                count++;
            }
            return 0;
        }
        
        if (direction.equals("ur")) {  //upright
            while (j < 7 && i > 0) {
                if (board.board[i-1][j+1].color == color) {
                    if (convert)
                        return count;
                    else 
                        break;
                }
                else if (board.board[i-1][j+1].color != '.' && board.board[i-1][j+1].color != '*') {
                    j++;
                    i--;
                }
                else {
                    if (convert)
                        break;
                    return count;
                }
                count++;
            }
            return 0;
        }
        
        if (direction.equals("dl")) {  //downleft
            while (j > 0 && i < 7) {
                if (board.board[i+1][j-1].color == color) {
                    if (convert)
                        return count;
                    else 
                        break;
                }
                else if (board.board[i+1][j-1].color != '.' && board.board[i+1][j-1].color != '*') {
                    j--;
                    i++;
                }
                else {
                    if (convert)
                        break;
                    return count;
                }
                count++;
            }
            return 0;
        }
        
        if (direction.equals("dr")) {  //downright
            while (j < 7 && i < 7) {
                if (board.board[i+1][j+1].color == color) {
                    if (convert)
                        return count;
                    else 
                        break;
                }
                else if (board.board[i+1][j+1].color != '.' && board.board[i+1][j+1].color != '*') {
                    j++;
                    i++;
                }
                else {
                    if (convert)
                        break;
                    return count;
                }
                count++;
            }
            return 0;
        }
        
        return 0;
    }
    
    public boolean scoreboard(Board board, boolean gameOver) {
        int scoreX = 0;
        int scoreO = 0;
        boolean end = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (board.board[i][j].color) {
                    case 'X':
                        scoreX++;
                        break;
                    case 'O':
                        scoreO++;
                        break;
                    default:
                        end = false;
                        break;
                }
            }
        }
        
        if (gameOver || end || scoreX == 0 || scoreO == 0) {
            char winner;
            if (scoreX == scoreO) 
                System.out.printf("X:%d/O:%d It's a draw!\n\n", scoreX, scoreO);
            else {
                winner = (scoreX > scoreO) ? 'X' : 'O';
                System.out.printf("X:%d/O:%d Player %c won!\n\n", scoreX, scoreO, winner);
            }
            return true;
        }
        
        return false;
    }
    
    public void convert(Board board, int y, int x, char color) {
        int count;
        if (color == 'X') {
            if (y != 0 && board.board[x][y-1].color == 'O') {
                count = findMoves(board, color, "l", x, y, true);
                while (count > 0) {
                    board.board[x][y-count+1] = new PawnWhite();
                    count--;
                }
            }
            if (y != 7 && board.board[x][y+1].color == 'O') {
                count = findMoves(board, color, "r", x, y, true);
                while (count > 0) {
                    board.board[x][y+count-1] = new PawnWhite();
                    count--;
                }
            }
            if (x != 0 && board.board[x-1][y].color == 'O') {
                count = findMoves(board, color, "u", x, y, true);
                while (count > 0) {
                    board.board[x-count+1][y] = new PawnWhite();
                    count--;
                }
            }
            if (x != 7 && board.board[x+1][y].color == 'O') {
                count = findMoves(board, color, "d", x, y, true);
                while (count > 0) {
                    board.board[x+count-1][y] = new PawnWhite();
                    count--;
                }
            }
            if (y != 0 && x != 0 && board.board[x-1][y-1].color == 'O') {
                count = findMoves(board, color, "ul", x, y, true);
                while (count > 0) {
                    board.board[x-count+1][y-count+1] = new PawnWhite();
                    count--;
                }
            }
            if (y != 7 && x != 0 && board.board[x-1][y+1].color == 'O') {
                count = findMoves(board, color, "ur", x, y, true);
                while (count > 0) {
                    board.board[x-count+1][y+count-1] = new PawnWhite();
                    count--;
                }
            }
            if (y != 0 && x != 7 && board.board[x+1][y-1].color == 'O') {
                count = findMoves(board, color, "dl", x, y, true);
                while (count > 0) {
                    board.board[x+count-1][y-count+1] = new PawnWhite();
                    count--;
                }
            }
            if (y != 7 && x != 7 && board.board[x+1][y+1].color == 'O') {
                count = findMoves(board, color, "dr", x, y, true);
                while (count > 0) {
                    board.board[x+count-1][y+count-1] = new PawnWhite();
                    count--;
                }
            }
        }
        
        if (color == 'O') {
            if (y != 0 && board.board[x][y-1].color == 'X') {
                count = findMoves(board, color, "l", x, y, true);
                while (count > 0) {
                    board.board[x][y-count] = new PawnBlack();
                    count--;
                }
            }
            if (y != 7 && board.board[x][y+1].color == 'X') {
                count = findMoves(board, color, "r", x, y, true);
                while (count > 0) {
                    board.board[x][y+count] = new PawnBlack();
                    count--;
                }
            }
            if (x != 0 && board.board[x-1][y].color == 'X') {
                count = findMoves(board, color, "u", x, y, true);
                while (count > 0) {
                    board.board[x-count][y] = new PawnBlack();
                    count--;
                }
            }
            if (x != 7 && board.board[x+1][y].color == 'X') {
                count = findMoves(board, color, "d", x, y, true);
                while (count > 0) {
                    board.board[x+count][y] = new PawnBlack();
                    count--;
                }
            }
            if (y != 0 && x != 0 && board.board[x-1][y-1].color == 'X') {
                count = findMoves(board, color, "ul", x, y, true);
                while (count > 0) {
                    board.board[x-count+1][y-count+1] = new PawnBlack();
                    count--;
                }
            }
            if (y != 7 && x != 0 && board.board[x-1][y+1].color == 'X') {
                count = findMoves(board, color, "ur", x, y, true);
                while (count > 0) {
                    board.board[x-count+1][y+count-1] = new PawnBlack();
                    count--;
                }
            }
            if (y != 0 && x != 7 && board.board[x+1][y-1].color == 'X') {
                count = findMoves(board, color, "dl", x, y, true);
                while (count > 0) {
                    board.board[x+count-1][y-count+1] = new PawnBlack();
                    count--;
                }
            }
            if (y != 7 && x != 7 && board.board[x+1][y+1].color == 'X') {
                count = findMoves(board, color, "dr", x, y, true);
                while (count > 0) {
                    board.board[x+count-1][y+count-1] = new PawnBlack();
                    count--;
                }
            }
        }
    }
    
    public void printBoard(Board board) {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d", i+1);
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j].color == '*')
                    board.board[i][j] = new Dot();
                System.out.print(" " + board.board[i][j].color);
            }
            System.out.println();
        }
    }
    
    public void fixBoard(Board board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j].color == '*')
                    board.board[i][j] = new Dot();
            }
        }
    }
}
