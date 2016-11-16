package com.dke.hex;


import com.badlogic.gdx.math.Vector3;
import com.dke.hex.DataStructure.Board;
import com.dke.hex.DataStructure.Hex;
import com.dke.hex.Helper.Layout;
import com.dke.hex.Helper.Point;
import com.dke.hex.Players.AbstractPlayer.Side;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class BoardView extends JPanel {

    public static Layout layout;
    public Board board;

    public BoardView(Board board) {

        Point hexSize = new Point(30, 30);

        this.layout = new Layout(hexSize, new Point(hexSize.x*2, hexSize.y*2));
        this.board = board;
    }

    public void setListener(GameController controller, MouseAdapter adapter) {

        this.addMouseListener(adapter);
        /*

        */
    }

    private void drawHex(Vector3 coord, Hex hex, Graphics g) {

        ArrayList<Point> corners = layout.polygonCorners(coord);

        int[] X = new int[corners.size()];
        int[] Y = new int[corners.size()];

        for (int i = 0; i < corners.size(); i++) {
            X[i] = (int) corners.get(i).x;
            Y[i] = (int) corners.get(i).y;
        }

        //g.setColor(Color.WHITE);
        g.setColor(Color.BLACK);
        g.drawPolygon(X, Y, corners.size());

        if (hex.getOwner() == null)
            return;

        if (hex.getOwner().side == Side.RED) {
            g.setColor((Color.RED));
            g.fillPolygon(X, Y, corners.size());
        }
        else if (hex.getOwner().side == Side.BLUE) {
            g.setColor((Color.BLUE));
            g.fillPolygon(X, Y, corners.size());
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawMap(g);
    }

    private void drawMap(Graphics g) {
        board.map.forEach((coord, hex) -> drawHex(coord, hex, g));
        repaint();
    }
}
