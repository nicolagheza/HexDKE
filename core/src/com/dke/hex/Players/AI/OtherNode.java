package com.dke.hex.Players.AI;
import java.util.List;

    /**
     * Created by pauldisbeschl on 23/11/2016.
     * Used: http://ccg.doc.gold.ac.uk/teaching/ludic_computing/ludic16.pdf
     */
public class OtherNode {
    private int action;
    private int visits;             //number of times visited
    private float reward;           //accumulated reward value
    private List<OtherNode> children;

    public OtherNode parent;            //Null if root

    public void update(int value){

    } //update node and backpropegate to parent

    public void addChild(OtherNode child){

    } //add child node

}
