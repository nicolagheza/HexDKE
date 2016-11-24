package com.dke.hex.Players.AI;

import com.dke.hex.DataStructure.Board;
import com.dke.hex.DataStructure.Hex;

import java.util.HashMap;
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



    private final Node parent;
    private int numSimulations = 0;
    private Reward reward;
    private final LinkedList<Node> children = new LinkedList<>();
    private final /*LinkedList<Move>*/ HashMap<Vector3, Hex> unexploredMoves;
    private final int player;
    private final Move moveUsedToGetToNode;

    public Node(Node parent, Move move, Board board) {
        this.parent = parent;
        moveUsedToGetToNode = move;
        unexploredMoves = board.emptySpaces();
        reward = new Reward(0,0);
        player = null; //Change this
    }

    public Node select(){
        Node selectionNode = this;
        double max = Integer.MIN_VALUE;
    }
    public Move getMoveUsedToGetToNode(){
        return moveUsedToGetToNode();
    }
}
