package simpleshooting;

import java.awt.Graphics;
import java.awt.Image;

public class Explosion extends GameObject {

	private int cntFrame; // 生成された時のFrame数が入る
	private Image EXPLOSION = MyInterface.Imageset.EXPLOSION;
	private int rate = 2;

	protected Explosion(int x, int y) {
		this.x = x;
		this.y = y;
		this.cntFrame = 0;
		this.width = 64;
		this.height = 64;
	}

	@Override
	public void update() {
		cntFrame++;
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
		if (!isAlive) {
			return;
		}
		if (this.cntFrame >= rate * 8) {
			delete();
			return;
		}
		if (this.cntFrame >= rate * 7) {
			g.drawImage(EXPLOSION, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 128, 192, 192, 256, null);
			return;
		}
		if (this.cntFrame >= rate * 6) {
			g.drawImage(EXPLOSION, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 128, 128, 192, 192, null);
			return;
		}
		if (this.cntFrame >= rate * 5) {
			g.drawImage(EXPLOSION, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 128, 64, 192, 128, null);
			return;
		}
		if (this.cntFrame >= rate * 4) {
			g.drawImage(EXPLOSION, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 128, 0, 192, 64, null);
			return;
		}
		if (this.cntFrame >= rate * 3) {
			g.drawImage(EXPLOSION, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 192, 64, 256, null);
			return;
		}
		if (this.cntFrame >= rate * 2) {
			g.drawImage(EXPLOSION, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 128, 64, 192, null);
			return;
		}
		if (this.cntFrame >= rate) {
			g.drawImage(EXPLOSION, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 64, 64, 128, null);
			return;
		}
		if (this.cntFrame >= 0) {
			g.drawImage(EXPLOSION, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 0, width, height, null);
		}
	}

}
