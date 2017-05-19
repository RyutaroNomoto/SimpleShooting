package simpleshooting;

import java.awt.Graphics;

public class EnemyHeri1 extends Enemy {

	public EnemyHeri1(int x, int y) {
		super(x, y);
		this.life = 1;
		this.x = x;
		this.y = y;
		this.width = 46;
		this.height = 50;
		this.setType(ObjectType.ENEMY);
		this.img = MyInterface.Imageset.ENEMY_HERI;
	}

	@Override
	protected void update() {
		if (y > MyInterface.GAME_HEIGHT) {
			delete();
		}
		y += moveSpeed;

	}

	@Override
	protected void draw(Graphics g, int cntFrame) {
		if (!isAlive() || img == null)
			return;
		g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 63, 0, 109, 53, null);
		if (Field.getFrame() % 6 < 3) {
			g.drawImage(img, x - 24, y - 15, x + 24, y + 15, 117, 0, 166, 30, null);
		} else {
			g.drawImage(img, x - 15, y - 24, x + 15, y + 24, 128, 46, 157, 93, null);
		}
	}

	@Override
	protected void delete() {
		isAlive = false;
		if (y < MyInterface.GAME_HEIGHT) {
			MyInterface.SpriteSet.explosions.add(new Explosion(x, y));
		}
	}

}
