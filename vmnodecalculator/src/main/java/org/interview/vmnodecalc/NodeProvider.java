package org.interview.vmnodecalc;

import org.interview.vmnodecalc.model.Node;
import org.interview.vmnodecalc.model.VirtualMachine;

import java.util.ArrayList;
import java.util.List;

public class NodeProvider {

    private List<Node> clusterNodes;

    public NodeProvider() {
        clusterNodes = Node.getCluster();
    }

    public List<Node> getNodes(List<VirtualMachine> virtualMachines) {
        for( VirtualMachine currentVm : virtualMachines){
            getNode(currentVm).addVmToANode(currentVm);
        }
        return clusterNodes;
    }

    private Node getNode(VirtualMachine currentVm){
        for( Node currentNode : clusterNodes ){
            if(isNodeSatisfyVMReq(currentNode, currentVm)){
                //currentNode.addVmToANode(currentVm);
                return currentNode;
            }
        }
        return  Node.getNode();
    }

    private boolean isNodeSatisfyVMReq(Node currentNode, VirtualMachine vm) {
        return ( currentNode.getRemainingCpu() >= vm.getReqCPU()
                && currentNode.getRemainingDisk() >= vm.getReqDisk()
                && currentNode.getRemainingNetwork() >= vm.getReqNW() );
    }

}
