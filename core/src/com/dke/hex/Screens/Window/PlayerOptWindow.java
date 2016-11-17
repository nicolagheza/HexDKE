package com.dke.hex.Screens.Window;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.dke.hex.HexDKE;
import com.dke.hex.Players.AbstractPlayer;
import com.dke.hex.Players.HumanPlayer;
import com.dke.hex.Players.RandomAI;
import com.dke.hex.Screens.MenuScreen;
import com.dke.hex.desktop.DesktopLauncher;

public class PlayerOptWindow extends Window {
    Skin skin;
    HexDKE game;
    MenuScreen menu;
    Label Player1, Player2, p1AIDiff, p2AIDiff, p1Diff, p2Diff;
    final SelectBox<String> PlayerType1, PlayerType2;
    String[] pType = new String[]{" Human", "       AI"}; //Using spaces to center text. Terrible solution
    Slider P1DiffSlider, P2DiffSlider;
    public boolean hidePlayOpt;
    public int boardX, boardY;
    public TextButton startButton;
    AbstractPlayer p1, p2;

    public PlayerOptWindow(Skin skin, HexDKE Game, final MenuScreen screen) {
        super("Player Options", skin);
        this.setModal(true);
        this.skin = skin;
        game = Game;
        menu = screen;
        this.setSize(500, 300);
        this.setMovable(true);

        TextButton gOptButton = new TextButton("Back", skin);
        gOptButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                hidePlayOpt = true;
            }
        });
        this.addActor(gOptButton);
        gOptButton.setPosition(135,40);
        gOptButton.setSize(90,40);

        startButton = new TextButton("Start", skin);
        startButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(PlayerType1.getSelected()==" Human"){
                    p1 = new HumanPlayer("RED");
                }else if(P1DiffSlider.getValue()==1){
                    p1 = new RandomAI("RED");
                }
                if(PlayerType2.getSelected()==" Human"){
                    p2 = new HumanPlayer("BLUE");
                }else if(P2DiffSlider.getValue()==1){
                    p2 = new RandomAI("BLUE");
                }

                remove();
                setGameScreen();

            }
        });
        this.addActor(startButton);
        startButton.setPosition(275,40);
        startButton.setSize(90,40);

        PlayerType1 = new SelectBox<String>(skin);
        PlayerType1.setSize(83,50);
        this.addActor(PlayerType1);
        PlayerType1.setItems(pType);
        PlayerType1.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                switch(PlayerType1.getSelectedIndex()){
                    case 0:
                        toggleAIOptions(1);
                        break;
                    case 1:
                        toggleAIOptions(0);
                        break;
                }
            }
        });
        PlayerType1.setPosition(160, 182);

        PlayerType2 = new SelectBox<String>(skin);
        PlayerType2.setSize(83,50);
        this.addActor(PlayerType2);
        PlayerType2.setItems(pType);
        PlayerType2.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                switch(PlayerType2.getSelectedIndex()){
                    case 0:
                        toggleAIOptions(3);
                        break;
                    case 1:
                        toggleAIOptions(2);
                        break;
                }
            }
        });
        PlayerType2.setPosition(160, 107);

        Player1 = new Label("Player 1", skin);
        Player1.setPosition(80, 195);
        this.addActor(Player1);

        Player2 = new Label("Player 2", skin);
        Player2.setPosition(80, 120);
        this.addActor(Player2);

        //AI Difficulty stuff
        P1DiffSlider = new Slider(1, 3, 1, false, skin);
        P1DiffSlider.setSize(140,50);
        P1DiffSlider.setPosition(280, 187);

        p1AIDiff = new Label("Set AI Difficulty", skin);
        p1AIDiff.setPosition(295, 222);

        p1Diff = new Label("1             2              3", skin);
        p1Diff.setPosition(281, 177);

        P2DiffSlider = new Slider(1, 3, 1, false, skin);
        P2DiffSlider.setSize(140,50);
        P2DiffSlider.setPosition(280, 112);

        p2AIDiff = new Label("Set AI Difficulty", skin);
        p2AIDiff.setPosition(295, 147);

        p2Diff = new Label("1             2              3", skin);
        p2Diff.setPosition(281, 102);


    }
    public void setGameScreen(){
        //Order of players reversed because turns are swapped before game is played
        DesktopLauncher.dkl.rem(boardX,boardY, p2, p1);
        //game.setScreen(new GameScreen(game));
    }

    public void toggleAIOptions(int x){
        if(x == 0){
            this.addActor(P1DiffSlider);
            this.addActor(p1AIDiff);
            this.addActor(p1Diff);
        }else if(x == 1){
            this.removeActor(P1DiffSlider);
            this.removeActor(p1AIDiff);
            this.removeActor(p1Diff);
        }else if(x == 2){
            this.addActor(P2DiffSlider);
            this.addActor(p2AIDiff);
            this.addActor(p2Diff);
        }else if(x == 3){
            this.removeActor(P2DiffSlider);
            this.removeActor(p2AIDiff);
            this.removeActor(p2Diff);
        }
    }
}
