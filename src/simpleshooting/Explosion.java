package simpleshooting;

import java.awt.Graphics;

public class Explosion extends GameObject {

	private int newFrame; // 生成された時のFrame数が入る

	protected Explosion(int x, int y, int cntFrame) {
		this.x = x;
		this.y = y;
		this.newFrame = cntFrame;
		this.width = 64;
		this.height = 64;
	}

	@Override
	public void update() {
		newFrame++;
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
			g.drawImage(MyInterface.Imageset.EXPLOSION, x, y, x + width, y + height, 0, 0, width, height, null);
	}

}
