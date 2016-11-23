package com.dke.hex.Players;

import com.badlogic.gdx.math.Vector3;

import java.util.Map;
import java.util.Random;
import com.dke.hex.DataStructure.Board;

/**
 * Created by pauldisbeschl on 23/11/2016.
 * Paul's notes on MCTS
 *      Using this source (partially) https://github.com/theKGS/MCTS/blob/master/src/main/MCTS.java
 * Steps:
 * Selection
 * Play-out
 * Expansion
 * Backpropagation
 */
public class MctsAI extends AbstractPlayer {
    private int explConstant;
    public MctsAI(String side) {
        super(side);
    }
    public void setExplorationConstant(int howDeep){
        explConstant = howDeep;
    }
    public Vector3 mctsMove(int h, int w){ //runs the search, returns the best move
        //run all steps
        //return move
        return movePicker();
    }

    private void select(Board currentBoard /*, Node currentNode*/){

    }

    private Vector3 movePicker(/*Node n*/){
        return null;
    }


    /*public static Vector3 chooseVec (int h, int w){
        Random rX = new Random(); //choosing a random tile
        int xCor = rX.nextInt(w);
        Random ry = new Random();
        int yCOr = ry.nextInt(h);
        int zCor = 0-yCOr-xCor;
        Vector3 vec = new Vector3(xCor, yCOr, zCor);

        return vec;
    }*/
    //public Map --Tree

}

