package org.interview.graphtravel;

import org.interview.graphtravel.domain.Node;

import java.util.*;

public class GraphManager
{

    private final Map<Node, List<Node>> connections;


    public GraphManager() {
        connections = new HashMap<Node, List<Node>>();
    }

    public void addNode(Node targetNode, Node... connectedNodes){
        if(!connections.keySet().contains(targetNode)){
           connections.put(targetNode, Arrays.asList(connectedNodes));
        } else {
            for(Node node : connectedNodes){
                if(!connections.get(targetNode).contains(node)){
                    connections.get(targetNode).add(node);
                }
            }
        }
    }

    public Set<Node> getNodes(){
        return connections.keySet();
    }


    public List<Node> getAdjacentNodes(Node parentNode) {
        return connections.get(parentNode);
    }

    public List<Node> getDepthFirstTraverseOfNodes(Node startNode){
        List<Node> result = new ArrayList<Node>();
        LinkedList<Node> que = new LinkedList<Node>();
        que.add(startNode);

        while( !que.isEmpty() ){
            Node tempNode = que.getFirst();
            if( !result.contains(tempNode) ){
                result.add(tempNode);
                for(Node currNode : connections.get(tempNode)){
                    if( !result.contains(currNode) && !que.contains(currNode)){
                        que.addLast(currNode);
                    }
                }
            }
            que.remove(tempNode);
        }
        return result;
    }
}
