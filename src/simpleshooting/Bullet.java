package simpleshooting;

import java.awt.Graphics;

public class Bullet extends GameObject {

	private static int bulletNum = 0;

	public Bullet(int x, int y) {
		if (++bulletNum % 2 == 0) {
			this.x = x - 100;
		} else {
			this.x = x + 100;
		}
		this.y = y - 10;
		this.width = 12;
		this.height = 36;
		this.setType(ObjectType.player);
	}

	@Override
	public boolean collideWith(GameObject object) {
		// 引数として与えられたobjectが死んでいない and 2つのobjectが違う属性(敵同士)ならあたり判定処理をする
		/*
		 * if (x < object.x + object.width && object.x < x + width && y <
		 * object.y + object.height && object.y < y + height) { delete(); return
		 * true; }
		 */
		if (this.x < object.getX() + object.getWidth() && object.getX() < this.x + this.width
				&& this.y < object.getY() + object.getHeight() && object.getY() < this.y + this.height) {
			return true;
		}
		return false;
	}

	@Override
	public void update() {
		if (y < 0) {
			delete();
		}
		y -= 8;
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
		if (isAlive()) {
			g.drawRect(x, y, width, height);
			g.drawImage(MyInterface.Imageset.PLAYER_BULLET, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 100,
					231, 112, 267, null);
		}
	}
}
