package com.prog2game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sun.java.swing.action.ExitAction;
import org.w3c.dom.Text;

public class FightScreen implements Screen   {

    private MyGdxGame parent;
    private Stage stage;

    public FightScreen(MyGdxGame myGdxGame) {
        parent = myGdxGame;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

    }


    //This method will create a pop up
    public static class ExitDialog extends Dialog {

        public ExitDialog(String title, Skin skin) {
            super(title, skin);
        }

        public ExitDialog(String title, Skin skin, String windowStyleName) {
            super(title, skin, windowStyleName);
        }

        public ExitDialog(String title, WindowStyle windowStyle) {
            super(title, windowStyle);
        }
        /// Code under here will executed no matter which method used from above
        {
            text("Attack");
        }
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
        ExitDialog exitDialog = new ExitDialog("",skin);

        exitDialog.show(stage);
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
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
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
