package org.interview.graphtravel;

import org.interview.graphtravel.domain.Node;
import org.junit.Assert.*;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by David_Mogyorosi on 2/17/2017.
 */
public class GraphManagerTest {

    //underTest

    @Test
    public void graphShouldContainFourNodes() {
        //GIVEN
        GraphManager underTest = new GraphManager();
        underTest.addNode(new Node(1), new Node(2), new Node(3), new Node(4));
        underTest.addNode(new Node(2), new Node(1), new Node(3));
        underTest.addNode(new Node(3), new Node(1), new Node(2));
        underTest.addNode(new Node(4), new Node(1));
        //WHEN
        //THEN
        assertEquals( 4, underTest.getNodes().size() );
    }

    @Test
    public void graphFirstNodeShouldHaveTwoConnection() {
        //GIVEN
        GraphManager underTest = new GraphManager();
        Node firstNode = new Node(1);
        underTest.addNode(firstNode, new Node(2), new Node(3));
        underTest.addNode(new Node(2), new Node(1), new Node(3), new Node(4));
        underTest.addNode(new Node(3), new Node(1), new Node(2));
        underTest.addNode(new Node(4), new Node(1));
        //WHEN
        //THEN
        assertEquals( 2, underTest.getAdjacentNodes(firstNode).size() );
    }

    @Test
    public void depthFirstTravelShouldReturnTheNodesInOrder() {
        GraphManager underTest = new GraphManager();
        underTest.addNode(new Node(1), new Node(2), new Node(3), new Node(4));
        underTest.addNode(new Node(2), new Node(1), new Node(3));
        underTest.addNode(new Node(3), new Node(1), new Node(2));
        underTest.addNode(new Node(4), new Node(1));
        //WHEN
        //THEN
        assertEquals(4, underTest.getDepthFirstTraverseOfNodes(new Node(1)).size() );
    }
}