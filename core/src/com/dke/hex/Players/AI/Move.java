package com.dke.hex.Players.AI;

import java.util.Vector;

/**
 * Created by pauldisbeschl on 24/11/2016.
 */
public class Move {
    private Vector v;
    private String side;

    public Move(Vector pos, String side){
        this.v = pos;
        this.side = side;
    }

    public Vector getPosition(){
        return v;
    }

    public String getSide(){
        return side;
    }
}
