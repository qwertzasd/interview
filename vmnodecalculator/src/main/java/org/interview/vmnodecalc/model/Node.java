package org.interview.vmnodecalc.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by David_Mogyorosi on 2/15/2017.
 */
public class Node {

    private int cpu, disk, network;
    private List<VirtualMachine> alreadyRunningVms;

    //private static List<Node> cluster = new ArrayList<>();

    private Node() {
        this.cpu = 100;
        this.disk = 100;
        this.network = 100;
        this.alreadyRunningVms = new ArrayList<>();
    }

    public static Node getNode(){
        Node newNode = new Node();
        //cluster.add(newNode);
        return newNode;
    }

    public int getRemainingCpu() {
        int sum = 0;
        for( VirtualMachine vm : alreadyRunningVms ){
            sum += vm.getReqCPU();
        }
        return cpu - sum;
    }

    public int getRemainingDisk() {
        int sum = 0;
        for( VirtualMachine vm : alreadyRunningVms ){
            sum += vm.getReqDisk();
        }
        return disk - sum;
    }

    public int getRemainingNetwork() {
        int sum = 0;
        for( VirtualMachine vm : alreadyRunningVms ){
            sum += vm.getReqNW();
        }
        return network - sum;
    }

//    public static List<Node> getCluster() {
//        return cluster;
//    }

    public void addVmToANode(VirtualMachine vm){
        this.alreadyRunningVms.add(vm);
    }
}
