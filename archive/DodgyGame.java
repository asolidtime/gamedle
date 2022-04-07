package dev.asolidtime.gamedle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class DodgyGame implements Screen {

    final Gamedle game;
    OrthographicCamera camera;
    Viewport viewport;
    ShapeRenderer shapeRenderer;
    Boolean isStarted;

    public DodgyGame(Gamedle game) {
        this.game = game;

        camera = new OrthographicCamera();
        //camera.setToOrtho(false, 800, 480);
        viewport = new ScreenViewport(camera);
        shapeRenderer = new ShapeRenderer();
        isStarted = false;
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.DARK_GRAY);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.LIGHT_GRAY);
        shapeRenderer.rect(viewport.getWorldWidth()/2 - 50, 0, 100, viewport.getWorldHeight());
        shapeRenderer.end();
        game.batch.begin();
        
        
        if (!isStarted) {
		    game.font.draw(game.batch, "dodgy game", 100, 150);
		    game.font.draw(game.batch, "jump from wall to wall to dodge the spikes. press space to jump", 100, 100);
        }
		game.batch.end();
        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			if (!isStarted) {
                isStarted = true;
            }
		}
        
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }
    
}
