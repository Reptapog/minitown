package net.cagox.game.entities;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;

import net.cagox.game.entities.factories.CameraFactory;
import net.cagox.game.entities.factories.PlayerCharacterFactory;
import net.cagox.game.entities.systems.PlayerInputSystem;
import net.cagox.game.entities.systems.RenderSystem;

/**
 *  This class will be an Entity Manager.  Just exactly what that means will evolve over time.
 *  <p>
 *  I am currently following the tutorial at https://www.youtube.com/watch?v=Ool0zyg7iKg
 *  It is discussing how to get things up and going using the Ashley Entity System.
 *  As such, what I am building here will be for learning, and may or may not be completely rewritten
 *  or thrown out as things progress.
 *  <p>
 *  Part of the purpose of the EntityManager class is going to be to create entities and track things
 *  so that those with a graphic element will be drawn by the Ashley Entity System.
 *
 * @author      Kenneth M. Burling (burlingk) <burlingk@cagox.net>
 * @version     1.0
 * @since       1.0
 */

public class EntityManager {
    private Engine engine;
    private PlayerInputSystem playerInput;
    private RenderSystem renderSystem;
    public CameraFactory cameraFactory;
    public PlayerCharacterFactory playerCharacterFactory;




    public EntityManager(Engine e) {
        this.engine = e;

        setUpFactories();
        setUpSystems();
        addInitialEntities();


    }


    public void update() {
        engine.update(Gdx.graphics.getDeltaTime());
    }

    public void resize(int width, int height) {
        renderSystem.resize(width, height);
    }

    private void setUpSystems() {
        //Here we will add our systems.
        playerInput = new PlayerInputSystem(this);
        engine.addSystem(playerInput);
        renderSystem = new RenderSystem(this);
        engine.addSystem(renderSystem);

    }

    private void setUpFactories() {
        //Here we will create our Factories.
        //It is possible that these will get moved eventually.
        playerCharacterFactory = new PlayerCharacterFactory();
        cameraFactory = new CameraFactory();
    }

    public void addInitialEntities() {
        //Instantiate the Player Character
        engine.addEntity(playerCharacterFactory.createPlayerCharacter(true));

    }

    public RenderSystem getRenderSystem() {
        return renderSystem;
    }

    public PlayerCharacterFactory getPlayerCharacterFactory() {
        return playerCharacterFactory;
    }

    public CameraFactory getCameraFactory() {
        return cameraFactory;
    }

}
