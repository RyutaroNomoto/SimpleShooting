package simpleshooting;

import java.awt.Color;
import java.awt.Graphics;

public class EnemyHeri extends Enemy {

	public EnemyHeri(int x, int y) {
		super(x, y);
		this.life = 3;
		this.x = x;
		this.y = y;
		this.width = 46;
		this.height = 50;
		this.setType(ObjectType.enemy);
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
		switch (life) {
		case 3:
			g.setColor(Color.GREEN);
			break;
		case 2:
			g.setColor(Color.YELLOW);
			break;
		case 1:
			g.setColor(Color.RED);
			break;
		}
		g.drawRect(x - width / 2, y - height / 2, width, height);
		if (cntFrame % 4 <= 2) {
			g.drawImage(img, x - 24, y - 15, x + 24, y + 15, 117, 0, 166, 30, null);
		} else {
			g.drawImage(img, x - 15, y - 24, x + 15, y + 24, 128, 46, 157, 93, null);
		}
	}

}
