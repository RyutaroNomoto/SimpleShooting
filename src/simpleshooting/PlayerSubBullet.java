package simpleshooting;

import java.awt.Graphics;

public class PlayerSubBullet extends Bullet {

	private static int bulletNum = 0;
	private int width, height;

	public PlayerSubBullet(int x, int y) {
		super(x, y);
		this.x = bulletNum++ % 2 == 0 ? this.x : this.x - 10;
		this.y = y - 20;
		this.width = 14;
		this.height = 27;
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
		if (isAlive()) {
			// g.drawImage(MyInterface.Imageset.PLAYER_BULLET, x, y, x + width,
			// y + height, 100, 231, 112, 267, null);
				g.drawImage(MyInterface.Imageset.PLAYER_BULLET2, x, y, x + width, y + height, 0, 98, 14, 125, null);

		}
	}

}
