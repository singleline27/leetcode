public class Solution {
    private char[][] board;
    private class Pos {
        int x;
        int y;
    }
    
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.board = board;
        isValidSudoku();
    }
    
    private boolean isValidSudoku() {
        Pos pos = findNext();    
        if(pos == null) {
            return true;
        }
        
        for(char c = '1'; c <= '9'; ++c) {
            board[pos.x][pos.y] = c;
            if(isStraightValid(pos.x, pos.y) && isAreaValid(pos.x, pos.y) && isValidSudoku()) {
                return true;
            }
        }
        board[pos.x][pos.y] = '.';
        return false;
    }
    
    private Pos findNext() {
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                if(board[i][j] == '.') {
                    Pos pos = new Pos();
                    pos.x = i;
                    pos.y = j;
                    return pos;
                }
            }
        }
        return null;
    }
     
    private boolean isStraightValid(int i, int j) {
        HashSet<Character> set = new HashSet<Character>();
        
        for(int index = 0; index < 9; ++index) {
            if(board[i][index] != '.') {
                if(set.contains(board[i][index])) {
                    return false;
                }
                set.add(board[i][index]);
            }
        }
        
        set.clear();
        for(int index = 0; index < 9; ++index) {
            if(board[index][j] != '.') {
                if(set.contains(board[index][j])) {
                    return false;
                }
                set.add(board[index][j]);
            }
        }
        
        return true;
    }
    
    private boolean isAreaValid(int i, int j) {
        HashSet<Character> set = new HashSet<Character>();
        int row = i/3;
        int col = j/3;
        
        for(int k = row*3; k < row*3 + 3; ++k) {
            for(int l = col*3; l < col*3 + 3; ++l) {
                if(board[k][l] != '.') {
                    if(set.contains(board[k][l])) {
                        return false;
                    }
                    set.add(board[k][l]);
                }
            }
        }
        return true;
    }
}