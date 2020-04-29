package com.prog2game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.exit;

public class MenuScreen implements Screen {

    private SpriteBatch batch;
    private Texture texture;
    private MyGdxGame parent;
    private Stage stage;
    public MenuScreen(MyGdxGame myGdxGame) {
     parent = myGdxGame;
     batch = new SpriteBatch();
     texture = new Texture(Gdx.files.internal("logo2.png"));
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
      TextButton newGame = new TextButton("Start", skin);
      TextButton preferences = new TextButton("Settings", skin);
      TextButton exit = new TextButton("Exit", skin);


      newGame.addListener(new ChangeListener() {
          @Override
          public void changed(ChangeEvent event, Actor actor) {
              ///add code here to execute when this button is pressed
              parent.changeScreen(MyGdxGame.APPLICATION);
          }
      });

     exit.addListener(new ChangeListener() {

         public void changed(ChangeListener.ChangeEvent event, Actor actor) {
             Gdx.app.exit();
         }
     });
        ///Tables used to align,adjust ect. buttons like excel
      table.bottom();
      table.add(newGame).fillX().uniformX();
      table.row().pad(10, 0, 10, 0);
      table.add(preferences).fillX().uniformX();
      table.row();
      table.add(exit).fillX().uniformX();
    }

    @Override
    public void render(float delta) {

//        batch.begin();
//        batch.draw(texture,100,100);
//        batch.end();

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.getBatch().begin();
        stage.getBatch().draw(texture,150,300);
        stage.getBatch().end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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

    //Gets rid of stuff from here
    @Override
    public void dispose() {
    stage.dispose();
    }
}
