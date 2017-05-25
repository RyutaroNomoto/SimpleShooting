package simpleshooting;

import java.awt.Graphics;

public class ExplosionNormal extends Explosion {

	private boolean isAlive = true;

	protected ExplosionNormal(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 64;
		this.height = 64;
		this.img = MyInterface.Imageset.EXPLOSION;
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
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 128, 192, 192, 256,
					null);
			return;
		}
		if (this.cntFrame >= rate * 6) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 128, 128, 192, 192,
					null);
			return;
		}
		if (this.cntFrame >= rate * 5) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 128, 64, 192, 128,
					null);
			return;
		}
		if (this.cntFrame >= rate * 4) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 128, 0, 192, 64, null);
			return;
		}
		if (this.cntFrame >= rate * 3) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 192, 64, 256, null);
			return;
		}
		if (this.cntFrame >= rate * 2) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 128, 64, 192, null);
			return;
		}
		if (this.cntFrame >= rate) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 64, 64, 128, null);
			return;
		}
		if (this.cntFrame >= 0) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 0, width, height,
					null);
		}
	}

}
