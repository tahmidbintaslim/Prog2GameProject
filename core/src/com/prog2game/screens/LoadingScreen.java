package com.prog2game.screens;

import com.badlogic.gdx.Screen;
import com.prog2game.MyGdxGame;

public class LoadingScreen implements Screen {

    //-Properties:
    private final MyGdxGame parent;

    //-Constructors:
    public LoadingScreen(MyGdxGame myGdxGame) {
        parent = myGdxGame;
    }

    //-Methods:
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        parent.changeScreen(MyGdxGame.MENU);
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
