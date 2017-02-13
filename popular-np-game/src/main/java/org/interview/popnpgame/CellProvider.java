package org.interview.popnpgame;

import org.interview.popnpgame.model.Board;
import org.interview.popnpgame.model.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David_Mogyorosi on 2/13/2017.
 */
public class CellProvider {

    private Board board;

    public CellProvider(Board board) {
        this.board = board;
    }

    public List<Cell> getConnectedCells() {
        List<Cell> result = new ArrayList<>();
        result.add(new Cell(0,0, 1));

        return result;
    }
}
