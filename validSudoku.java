public class Solution {
    private char[][] board;
    
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.board = board;
        
        for(int i = 0; i < 9; ++i) {
            if(!isStraightValid(i, i)) {
                return false;
            }
        }
        
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if(!isAreaValid(i*3, j*3)) {
                    return false;
                }
            }
        }
        
        return true;
        //return isValidSudoku();
        
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