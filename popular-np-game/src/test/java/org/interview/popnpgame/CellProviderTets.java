package org.interview.popnpgame;

import org.interview.popnpgame.model.Board;
import org.interview.popnpgame.model.Cell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by David_Mogyorosi on 2/13/2017.
 */
public class CellProviderTets {

    CellProvider underTest;

    @Before
    public void setup() {

    }

    @Test
    public void getConnectedCellShouldReturnOne() {
        //GIVEN
        Board board = new Board(3, 3);
        board.setColor(0,0,1);
        underTest = new CellProvider(board);
        //WHEN
        List<Cell> expectedcells = new ArrayList<>(Arrays.asList(new Cell(0,0)));
        //THEN
        assertEquals(expectedcells, underTest.getConnectedCells());
    }

    @Test
    public void getConnectedCellsShouldReturnNeigboursOfTheOrigin() {
        //GIVEN
        Board board = new Board(3, 3);

        board.setColor(0,0,1);
        board.setColor(1,0,1);
        board.setColor(0,1,1);
        CellProvider underTest = new CellProvider(board);
        //WHEN
        List<Cell> expected = new ArrayList<>(Arrays.asList(new Cell(0,0),new Cell(1,0), new Cell(0,1)));
        //THEN
        assertEquals(expected, underTest.getConnectedCells());
    }

    @Test
    public void getConnectedCellsShouldReturnOnlyTheRightNeigbourOfTheOriginWithTheSameColor() {
        //GIVEN
        Board board = new Board(3, 3);
        board.setColor(0,0,1);
        board.setColor(1,0,1);
        CellProvider underTest = new CellProvider(board);
        //WHEN
        List<Cell> expected = new ArrayList<>(Arrays.asList(new Cell(0,0), new Cell(1,0)));
        //THEN
        assertEquals(expected, underTest.getConnectedCells());
    }


    @Test
    public void getConnectedCellsShouldReturnCellsWithTheSameColor() {
        //GIVEN
        Board board = new Board(3, 3);
        board.setColor(0,0,1);
        board.setColor(1,0,1);
        board.setColor(0,1,1);
        board.setColor(1,1,1);
        CellProvider underTest = new CellProvider(board);
        //WHEN
        List<Cell> expected = new ArrayList<>(Arrays.asList(new Cell(0,0), new Cell(1,0), new Cell(0,1), new Cell(1,1)));
        //THEN
        assertEquals(expected, underTest.getConnectedCells());
    }

    @Test
    public void getConnectedCellsShouldReturnCellsWithTheSameColorUShapedDistribution() {
        //GIVEN
        Board board = new Board(3, 3);
        board.setColor(1,1,1);
        board.setColor(0,1,1);
        CellProvider underTest = new CellProvider(board);
        //WHEN
        //List<Cell> expected = new ArrayList<>(Arrays.asList(new Cell(0,0), new Cell(2,2), new Cell(1,2), new Cell(0,2),new Cell(2,0), new Cell(1, 0), new Cell(2,1)));
        List<Cell> expected = new ArrayList<>(Arrays.asList(new Cell(0,0), new Cell(1,0), new Cell(2,0), new Cell(2,1),new Cell(2,2), new Cell(1,2), new Cell(0,2)));
        //THEN
        assertEquals(expected, underTest.getConnectedCells());
    }
}