package com.kodilla;

public class Game {
    private boolean[][] board;
    private boolean isCircleTurn;
    private int circleWins;
    private int crossWins;

    public Game() {
        this.board = new boolean[3][3];
        this.isCircleTurn = true;
        this.circleWins = 0;
        this.crossWins = 0;
    }

    public boolean makeMave(int row, int col){
        if(!board[row][col]){
            board[row][col] = true;
            isCircleTurn = !isCircleTurn;
            return true;
        }
        return false;
    }

    public boolean checkWin(){
        for(int i=0; i < 3; i++){
            if(board[i][0] && board[i][1] && board[i][2]) return true;
            if(board[0][i] && board[1][i] && board[2][i]) return true;
        }
        if(board[0][0] && board[1][1] && board[2][2]) return true;
        if(board[0][2] && board[1][1] && board[2][0]) return true;
        return false;
    }


}
