public class Solution {
    private char[][] board;
    
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(word.length() == 0) return true;
        
        int m = board.length;
        if(m <= 0) return false;
        
        int n = board[0].length;
        if(m *n < word.length()) return false;
        
        this.board = board;
        
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == word.charAt(0)) {
                    int[][] check = new int[m][n];
                    check[i][j] = 1;
                    if(find(i, j, word, 1, check)) {
                        return true;
                    }
                    check[i][j] = 0;
                }
            }
        }

        return false;
        
    }
    
    public boolean find(int i, int j, String word, int index, int[][] check) {
        if(word.length() <= index ) {
            return true;
        }

        if(i - 1 >= 0 && check[i-1][j]==0 && board[i-1][j] == word.charAt(index) ) {
            check[i-1][j] = 1;
            if(find(i-1, j, word, index+1, check)) {
                return true;
            } else {
                check[i-1][j] = 0;
            }
        }
        
        if(i + 1 < board.length && check[i+1][j]==0 && board[i+1][j] == word.charAt(index) ) {
            check[i+1][j] = 1;
            if(find(i+1, j, word, index+1, check)) {
                return true;
            } else {
                check[i+1][j] = 0;
            }
        }
        
        if(j >= 1 && check[i][j-1]==0 && board[i][j-1] == word.charAt(index) ) {
            check[i][j-1] = 1;
            if(find(i, j-1, word, index+1, check)) {
                return true;
            } else {
                check[i][j-1] = 0;
            }
        }
        
        if(j + 1 < board[0].length && check[i][j+1]==0 && board[i][j+1] == word.charAt(index) ) {
            check[i][j+1] = 1;
            if(find(i, j+1, word, index+1, check)) {
                return true;
            } else {
                check[i][j+1] = 0;
            }
        }
        return false;
    }
}