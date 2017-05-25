package simpleshooting;

import java.awt.Graphics;
import java.awt.Image;

// 爆発エフェクトの親クラス
abstract class Explosion {

	protected int cntFrame;
	protected int x, y, width, height;
	protected int rate = 2;
	protected Image img;
	protected boolean isAlive = true;

	protected void delete() {
		MyInterface.SpriteSet.items.add(new Item(x, y));
		isAlive = false;
	}

	protected boolean isAlive() {
		return isAlive;
	}

	public void update() {
		cntFrame++;
	}

	public abstract void draw(Graphics g, int cntFrame);

}
