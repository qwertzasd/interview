package org.interview.popnpgame;

import org.interview.popnpgame.model.Board;
import org.interview.popnpgame.model.Cell;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by David_Mogyorosi on 2/13/2017.
 */
public class CellProvider {

    private Board board;
    private List<Cell> selectedCells;

    public CellProvider(Board board) {
        this.board = board;
        this.selectedCells = new ArrayList<>();
        selectedCells.add(new Cell(0,0));
    }

    public List<Cell> getConnectedCells() {
        List<Cell> result = new ArrayList<>();
        int originColor = board.getColor(0,0);
        Cell origin = new Cell(0,0);

        LinkedList<Cell> que = new LinkedList<>();
        que.add(origin);

        while( !que.isEmpty() ){
            Cell currentCell = que.getFirst();
            List<Cell> tempList = new ArrayList<>(getSameColoredNeigbouringCells(currentCell, originColor));
            que.remove(currentCell);
            result.add(currentCell);

            for(Cell c : tempList){
                if( !result.contains(c) && !que.contains(c) ){
                    que.addLast(c);
                }
            }
        }

        return result;
    }


    private List<Cell> getSameColoredNeigbouringCells(Cell currentCell, int originColor){
        List<Cell> result = new ArrayList<>();
        int x = currentCell.getX();
        int y = currentCell.getY();

        //right neigbour
        if( (x - 1) >= 0){
            Cell tempCell = new Cell(x - 1, y);
            if( board.getColor(tempCell.getX(), tempCell.getY()) == originColor ){
                result.add(tempCell);
            }
        }
        //left neighbour
        if( (x + 1) < board.getBoardSize() ){
            Cell tempCell = new Cell(x + 1, y);
            if( board.getColor(tempCell.getX(), tempCell.getY()) == originColor ){
                result.add(tempCell);
            }
        }

        //down neigbour
        if( (y + 1) < board.getBoardSize() ){
            Cell tempCell = new Cell(x, y + 1);
            if( board.getColor(tempCell.getX(), tempCell.getY()) == originColor ){
                result.add(tempCell);
            }

        }
        //up neighbour
        if( (y - 1) >= 0 ){
            Cell tempCell = new Cell(x, y - 1);
            if( board.getColor(tempCell.getX(), tempCell.getY()) == originColor ){
                result.add(tempCell);
            }
        }
        return result;
    }
}
