package com.dke.hex.Players;

import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * Created by Envy on 11/9/2016.
 */
public class RandomAI extends AbstractPlayer {
    public RandomAI(String side) {
        super(side);
    }

    public static Vector3 ranVec (int h, int w){
        Random rX = new Random();
        int xCor = rX.nextInt(w);
        Random ry = new Random();
        int yCOr = ry.nextInt(h);
        int zCor = 0-yCOr-xCor;
        Vector3 vec = new Vector3(xCor, yCOr, zCor);

        return vec;
    }
}
