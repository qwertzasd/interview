package org.interview.vmnodecalc;

import org.interview.vmnodecalc.model.Node;
import org.interview.vmnodecalc.model.VirtualMachine;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by David_Mogyorosi on 2/15/2017.
 */
public class NodeProviderTest {



    @Test
    public void noVmNeededShouldReturnEmptyList() {
        //GIVEN
        NodeProvider underTest = new NodeProvider();
        //WHEN
        List<VirtualMachine> input = Collections.emptyList();
        //THEN
        List<Node> expected = Collections.emptyList();
        assertEquals(expected, underTest.getNodes(input));
    }

    @Test
    public void oneVmShouldReturnListWithOneNode() {
        //GIVEN
        NodeProvider underTest = new NodeProvider();
        //WHEN
        List<VirtualMachine> input = new ArrayList<VirtualMachine>(Arrays.asList(new VirtualMachine(90,90,90)));
        //THEN
        List<Node> expected = Arrays.asList(Node.getNode());

        assertEquals(expected.size(), underTest.getNodes(input).size());
    }

    @Test
    public void threeLargeVmShouldReturnListWithThreeNode() {
        //GIVEN
        NodeProvider underTest = new NodeProvider();
        //WHEN
        List<VirtualMachine> input = new ArrayList<>(Arrays.asList(new VirtualMachine(90,90,90), new VirtualMachine(90,90,90), new VirtualMachine(90,90,90)));

        //THEN
        List<Node> expected = Arrays.asList(Node.getNode(), Node.getNode(), Node.getNode());
        assertEquals(expected.size(), underTest.getNodes(input).size());
    }

    @Test
    public void threeSmallVmShouldReturnListWithTwoNode() {
        //GIVEN
        NodeProvider underTest = new NodeProvider();
        //WHEN
        List<VirtualMachine> input = new ArrayList<>(Arrays.asList(new VirtualMachine(50,50,50), new VirtualMachine(50,50,50), new VirtualMachine(90,90,90)));

        //THEN
        List<Node> expected = Arrays.asList(Node.getNode(), Node.getNode());
        assertEquals(expected.size(), underTest.getNodes(input).size());
    }


    @Test
    public void fiveSmallVmShouldReturnListWithThreeNode() {
        //GIVEN
        NodeProvider underTest = new NodeProvider();
        //WHEN

        List<VirtualMachine> input = new ArrayList<>(Arrays.asList(
                new VirtualMachine(40,40,40),
                new VirtualMachine(70,40,40),
                new VirtualMachine(20,40,40),
                new VirtualMachine(5,40,40),
                new VirtualMachine(50,40,40)));

        //THEN
        List<Node> expected = Arrays.asList(Node.getNode(), Node.getNode(), Node.getNode());
        assertEquals(expected.size(), underTest.getNodes(input).size());
    }
}