package com.dke.hex.Screens.Window;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.dke.hex.HexDKE;
import com.dke.hex.Screens.MenuScreen;

/**
 * Created by Envy on 9/12/2016.
 */
public class HelpWindow extends Window {
    MenuScreen menu;
    Skin skin;
    public HelpWindow(Skin skin, HexDKE Game, MenuScreen screen) {
        super("Instructions", skin);
        this.skin = skin;
        this.setSize(500, 300);
        menu = screen;

        Label Instructions = new Label("Two players take turns placing their respective pieces on", skin);
        Label Instructions2 = new Label("the board one at a time. To win the game, a player has to", skin);
        Label Instructions3 = new Label("connect a path of their pieces from one side to the other", skin);

        this.addActor(Instructions);
        this.addActor(Instructions2);
        this.addActor(Instructions3);

        Instructions.setPosition(50,190);
        Instructions2.setPosition(50,160);
        Instructions3.setPosition(50,130);


        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                remove();
            }
        });
        this.addActor(backButton);
        backButton.setPosition(200,40);
        backButton.setSize(90,40);
    }
}
