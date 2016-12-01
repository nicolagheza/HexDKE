package com.dke.hex.Players.AI;

import com.dke.hex.DataStructure.Board;
import com.dke.hex.DataStructure.Hex;

import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedList;

/**
 * Created by pauldisbeschl on 23/11/2016.
 */
public class Node {
    //Selection --> Expansion --> Simulation --> Backpropagation REPEAT
    //Parent --> Keeps track of the parent node for Backpropagation
    //numSimulations, reward, children, player --> All are necessary, used in formula for selection policy
    //unexploredMoves --> keep track of unexpanded nodes
    //moveUsedToGetToNode --> Tree building



    public Node parent;
    private int numSimulations = 0;
    private Reward reward;
    public ArrayList<Node> children;
    public ArrayList<Node> unexploredChildren;
    public Set<Integer> rVisited;
    public int player;
    public double[] pess;
    public double[] opti;
    public Move moveUsedToGetToNode;
    public boolean pruned;

    public Node(Board b){
        children = new ArrayList<Node>();
    }

    public Node(Node theParent, Move m, Board theBoard) {
        children = new ArrayList<Node>();
        this.parent = theParent;
        moveUsedToGetToNode = m;
        Board tempB; //Sim Class --> Copy the board
        unexploredChildren = theBoard.emptySpaces();
        reward = new Reward(0,0);
        player = null; //Change this
    }
    public double upperConfidenceBound(double c){
        return reward.getRewardForPlayer(parent.player) / numSimulations + c * Math.sqrt(Math.log(parent.numSimulations+1)/numSimulations);
    }
    public Node select(){
        Node selectionNode = this;
        double max = Integer.MIN_VALUE;
    }
    public Move getMoveUsedToGetToNode(){
        return moveUsedToGetToNode();
    }
}
