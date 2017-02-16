package org.interview.vmnodecalc.model;

/**
 * Created by David_Mogyorosi on 2/15/2017.
 */
public class VirtualMachine {

    private int reqCPU, reqDisk, reqNW;

    public VirtualMachine(int reqCPU, int reqDisk, int reqNW) {
        this.reqCPU = reqCPU;
        this.reqDisk = reqDisk;
        this.reqNW = reqNW;
    }

    public int getReqCPU() {
        return reqCPU;
    }

    public int getReqDisk() {
        return reqDisk;
    }

    public int getReqNW() {
        return reqNW;
    }
}
