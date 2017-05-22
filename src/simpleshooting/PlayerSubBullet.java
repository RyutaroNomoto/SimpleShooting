package simpleshooting;

import java.awt.Graphics;

public class PlayerSubBullet extends Bullet {

	private static int bulletNum = 0;

	public PlayerSubBullet(int x, int y) {
		super(x, y);
		this.x = bulletNum++ % 2 == 0 ? this.x  : this.x - 10;
		this.y = y - 20;
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
		if (isAlive()) {
			g.drawImage(MyInterface.Imageset.PLAYER_BULLET, x, y, x + width, y + height, 100, 231, 112, 267, null);

		}
	}

}
