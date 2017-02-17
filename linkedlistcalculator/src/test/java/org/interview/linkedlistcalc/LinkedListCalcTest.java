package org.interview.linkedlistcalc;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by David_Mogyorosi on 2/17/2017.
 */
public class LinkedListCalcTest {

    @Test
    public void addZeroToANumberShouldReturnTheOriginalValue() {
        //GIVEN
        //WHEN
        LinkedList<String> inputA = new LinkedList<String>(Arrays.asList("9", "9", "0", "1"));
        LinkedList<String> inputB = new LinkedList<String>(Arrays.asList("0"));
        //THEN
        List<String> expected = Arrays.asList("9", "9", "0", "1");
        assertEquals(expected, LinkedListCalc.add(inputA, inputB));
    }

    @Test
    public void addTwoNonNegativeNumbersShouldReturnTheCorrectValue() {
         //GIVEN
        //WHEN
        LinkedList<String> inputA = new LinkedList<String>(Arrays.asList("9", "9", "0", "1"));
        LinkedList<String> inputB = new LinkedList<String>(Arrays.asList("9", "9", "0", "1"));
        //THEN
        List<String> expected = Arrays.asList("1","9", "8", "0", "2");
        assertEquals(expected, LinkedListCalc.add(inputA, inputB));
    }


    @Test
    public void summationIsAssociative() {
        //GIVEN
        //WHEN
        List<String> input = Arrays.asList("9", "9", "0", "1");
        List<String> input2 = Arrays.asList("1", "1", "5", "9");
        LinkedList<String> inputA = new LinkedList<String>(input);
        LinkedList<String> inputB = new LinkedList<String>(input2);
        LinkedList<String> inputA2 = new LinkedList<String>(input2);
        LinkedList<String> inputB2 = new LinkedList<String>(input);
        //THEN

        assertEquals(LinkedListCalc.add(inputB, inputA), LinkedListCalc.add(inputA2, inputB2));
    }
}