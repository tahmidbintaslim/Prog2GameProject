package com.prog2game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MenuScreen implements Screen {



    private MyGdxGame parent;
    private Stage stage;
    public MenuScreen(MyGdxGame myGdxGame) {
     parent = myGdxGame;
     stage = new Stage(new ScreenViewport());
       Gdx.input.setInputProcessor(stage);

     }





 @Override
    public void show() {

    Table table = new Table();
    table.setFillParent(true);
    table.setDebug(true);
    stage.addActor(table);
    Skin skin = new Skin(Gdx.files.internal("skin/Holo-dark-hdpi.json"));

    TextButton newGame = new TextButton("Start", skin);
    TextButton preferences = new TextButton("Settings", skin);
    TextButton exit = new TextButton("Exit", skin);

     table.add(newGame).fillX().uniformX();
     table.row().pad(10, 0, 10, 0);
     table.add(preferences).fillX().uniformX();
     table.row();
     table.add(exit).fillX().uniformX();
    }

    @Override
    public void render(float delta) {
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
