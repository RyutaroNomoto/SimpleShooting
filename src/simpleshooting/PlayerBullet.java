package simpleshooting;

import java.awt.Graphics;

public class PlayerBullet extends Bullet {

	private static int bulletNum = 0;

	public PlayerBullet(int x, int y) {
		super(x, y);
		this.width = 12;
		this.height = 36;
		this.x = x - width / 2;

		this.x = bulletNum++ % 2 == 0 ? this.x + 17 : this.x - 17;

		this.y = y - 10;
		this.setType(ObjectType.PLAYER);
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
		if (isAlive()) {
			g.drawImage(MyInterface.Imageset.PLAYER_BULLET, x, y, x + width, y + height, 100, 231, 112, 267, null);

		}
	}

}
