package com.prog2game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.w3c.dom.Text;

public class MainScreen implements Screen   {

    private MyGdxGame parent;
    private Stage stage;
    public MainScreen(MyGdxGame myGdxGame) {
        parent = myGdxGame;
        parent = myGdxGame;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        table.bottom();
        table.left();
        stage.addActor(table);
        Skin skin = new Skin(Gdx.files.internal("skin/Holo-dark-hdpi.json"));

        TextButton attack = new TextButton("Attack",skin);
        TextButton skills = new TextButton("Skills",skin);
        TextButton items = new TextButton("Items",skin);



        table.add(attack).fillX().uniformX();
        table.row().pad(10,0,10,0);
        table.add(skills).fillX().uniformX();
        table.add(items).left().fillX().uniformX();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
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
