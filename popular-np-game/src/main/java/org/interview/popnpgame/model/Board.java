package org.interview.popnpgame.model;

/**
 * Created by David_Mogyorosi on 2/13/2017.
 */
public class Board {

    private int[][] cells;
    private int numberOfColors;

    public Board(int size, int numberOfColors) {
        this.cells = new int[size][size];
        this.numberOfColors = numberOfColors;
    }
}
