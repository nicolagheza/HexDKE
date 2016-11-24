package com.dke.hex.Players.AI;

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
    private final LinkedList<Move> unexploredMoves;
    private final int player
    private final Move moveUsedToGetToNode;

    public Node(Node parent, Move move) {
        this.parent = parent;
        moveUsedToGetToNode = move;
        unexploredMoves =

    }

    public Move getMoveUsedToGetToNode(){
        return moveUsedToGetToNode();
    }
}
