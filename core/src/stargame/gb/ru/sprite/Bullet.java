package stargame.gb.ru.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import stargame.gb.ru.base.Sprite;
import stargame.gb.ru.math.Rect;


public class Bullet extends Sprite {

    private final Vector2 v = new Vector2();

    private Rect worldBounds;
    private int damage;
    private Sprite owner;
    private Sound sound;


    public Bullet(Sound sound) {
        regions = new TextureRegion[1];
        angle = 90;
        this.sound = sound;
    }

    public void set(
            Sprite owner,
            TextureRegion region,
            Vector2 pos,
            Vector2 v,
            Rect worldBounds,
            float height,
            int damage
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos);
        this.v.set(v);
        this.worldBounds = worldBounds;
        setHeightProportion(height);
        this.damage = damage;
        sound.play(0.01f);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }

    public int getDamage() {
        return damage;
    }

    public Sprite getOwner() {
        return owner;
    }
}
