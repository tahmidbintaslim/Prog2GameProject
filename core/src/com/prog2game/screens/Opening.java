package com.prog2game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.prog2game.MyGdxGame;
import org.graalvm.compiler.phases.common.NodeCounterPhase;

import java.awt.*;

public class Opening implements Screen {

    private Stage stage;
    private SpriteBatch batch;
    private Texture texture;
    private MyGdxGame parent;
    private float posy = -1800;
    public Opening (MyGdxGame myGdxGame) {
        parent = myGdxGame;
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("Opening_text.png"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void show() {


        ///Create the tables and setting methods for them
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);
        Skin skin = new Skin(Gdx.files.internal("skin/Holo-dark-hdpi.json"));
        ///Create the button objects to use later
        TextButton skip = new TextButton("Skip", skin);
        skip.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                ///add code here to execute when this button is pressed
                parent.changeScreen(MyGdxGame.APPLICATION);

            }
        });


        ///Tables used to align,adjust ect. buttons like excel
        table.bottom();
        table.add(skip).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.getBatch().begin();
        stage.getBatch().draw(texture,0,posy,600,2000);
        stage.getBatch().end();
        stage.draw();
        posy = MyGdxGame.scroll(posy,0,20);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
