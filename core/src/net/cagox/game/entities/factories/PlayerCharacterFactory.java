package net.cagox.game.entities.factories;

import com.badlogic.ashley.core.Entity;

import net.cagox.game.entities.components.CharacterSheetComponent;
import net.cagox.game.entities.components.MainCharacterComponent;
import net.cagox.game.entities.components.PlayerCharacterComponent;
import net.cagox.game.entities.components.PositionComponent;
import net.cagox.game.entities.components.RenderableComponent;
import net.cagox.game.entities.components.SpriteComponent;

/**
 *  This class will be a utility class to create player characters.
 *  <p>
 *  Eventually it might be refactored to work for characters in general, but for now I will keep it simple.
 *
 * @author      Kenneth M. Burling (burlingk) <burlingk@cagox.net>
 * @version     0.1
 * @since       0.1
 */


public class PlayerCharacterFactory {

    public PlayerCharacterFactory() {}

    public Entity createPlayerCharacter(boolean isMainCharacter)
    {
        Entity entity = new Entity();
        entity.add(new PositionComponent());
        entity.add(new PlayerCharacterComponent(isMainCharacter));
        entity.add(new CharacterSheetComponent());
        entity.add(new RenderableComponent());
        entity.add(new SpriteComponent());
        if (isMainCharacter) {
            entity.add(new MainCharacterComponent());
        }

        return entity;

        //TODO:  Flesh out PositionComponent constructores then update this method.
        //TODO:  Flesh out PlayerCharacterComponent constructors then update this method.
        //TODO:  Flesh out SpriteComponent then update this method.
    }



}
