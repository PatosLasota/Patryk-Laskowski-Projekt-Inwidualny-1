package com.kodilla;

public class Game {
    private char[][] board;
    private boolean isCircleTurn;
    private int circleWins;
    private int crossWins;

    public Game() {
        this.board = new char[3][3];
        resetBoard();
        this.isCircleTurn = true;
        this.circleWins = 0;
        this.crossWins = 0;
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = isCircleTurn ? 'O' : 'X';
            isCircleTurn = !isCircleTurn;
            return true;
        }
        return false;
    }

    public int checkWin() {
        // Sprawdzanie wierszy, kolumn i przekątnych
        for (int i = 0; i < 3; i++) {
            // Sprawdzanie wierszy
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                updateScore(board[i][0]);
                return board[i][0] == 'O' ? 1 : 2;
            }
            // Sprawdzanie kolumn
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                updateScore(board[0][i]);
                return board[0][i] == 'O' ? 1 : 2;
            }
        }
        // Sprawdzanie przekątnych
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            updateScore(board[0][0]);
            return board[0][0] == 'O' ? 1 : 2;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            updateScore(board[0][2]);
            return board[0][2] == 'O' ? 1 : 2;
        }
        return 0;
    }

    private void updateScore(char winner) {
        if (winner == 'O') circleWins++;
        else crossWins++;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        isCircleTurn = true;
    }

    public boolean isCircleTurn() {
        return isCircleTurn;
    }

    public int getCircleWins() {
        return circleWins;
    }

    public int getCrossWins() {
        return crossWins;
    }
}