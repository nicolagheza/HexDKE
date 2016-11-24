package com.dke.hex.Players.AI;

import Game.BoardView;
import Game.Players.AbstractPlayer.Side;
import Game.GameController;

/**
 * Created by Envy on 11/24/2016.
 */
public class SimGame {
    BoardView boardView;
    RandomAI currentPlayer, otherPlayer;
    GameController gameController;
    public SimGame(BoardView BoardView, AbstractPlayer P1, AbstractPlayer P2, boolean swapRule){
        if(P1 instanceof RandomAI && P2 instanceof RandomAI){
            if(P1.side == Side.RED) {
                currentPlayer = new RandomAI("RED");
                otherPlayer = new RandomAI("BLUE");
            }else{
                currentPlayer = new RandomAI("BLUE");
                otherPlayer = new RandomAI("RED");
            }
        }
        boardView = BoardView;
        if(swapRule){
            gameController = new GameController(boardView.layout, boardView, 0);
            gameController.otherPlayer = currentPlayer;
            gameController.currentPlayer = otherPlayer;
            gameController.switchTurns(gameController);
        }else{
            gameController = new GameController(boardView.layout, boardView, 1);
            gameController.otherPlayer = currentPlayer;
            gameController.currentPlayer = otherPlayer;
            gameController.switchTurns(gameController);
        }
    }

    public Side getWinner(){
        //returns opposite color because gamecontroller switches side even after win
        if(gameController.gameOver) {
            if(gameController.currentPlayer.side == Side.RED){
                return Side.BLUE;
            }
            else{
                return Side.RED;
            }
        }else{
            return null;
        }
    }

    public BoardView getBoardView(){
        return boardView;
    }
}
