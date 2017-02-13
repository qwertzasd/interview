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
        underTest = new CellProvider(new Board(3,3));
        //WHEN
        List<Cell> expectedcells = new ArrayList<Cell>(Arrays.asList(new Cell(0,0, 1)));
        //THEN
        assertEquals( expectedcells, underTest.getConnectedCells());
    }
}