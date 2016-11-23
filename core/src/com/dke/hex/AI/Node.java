package com.dke.hex.AI;

import java.util.List;

/**
 * Created by pauldisbeschl on 23/11/2016.
 * Used: http://ccg.doc.gold.ac.uk/teaching/ludic_computing/ludic16.pdf
 */
public class Node {
    private int action;
    private int visits;             //number of times visited
    private float reward;           //accumulated reward value
    private List<Node> children;

    public Node parent;            //Null if root

    public void update(int value); //update node and backpropegate to parent
    public void addChild(Node child); //add child node
}
