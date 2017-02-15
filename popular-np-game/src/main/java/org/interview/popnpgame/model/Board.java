package org.interview.popnpgame.model;

/**
 * Created by David_Mogyorosi on 2/13/2017.
 */
public class Board {

    private int[][] cells;
    private int numberOfColors;
    private int boardSize;

    public Board(int size, int numberOfColors) {
        this.cells = new int[size][size];
        this.numberOfColors = numberOfColors;
        this.boardSize = size;
    }


    public int getBoardSize() {
        return this.boardSize;
    }

    public int getColor(int i, int j) {
        return cells[i][j];
    }

    public void setColor(int x, int y, int color){
        cells[x][y] = color;
    }
}
