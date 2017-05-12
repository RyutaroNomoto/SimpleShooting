package simpleshooting;

import java.awt.Graphics;

public class Bullet extends GameObject {

	private static int bulletNum = 0;
	private int bulletNo;

	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 12;
		this.height = 36;
		this.setType(ObjectType.player);
		this.bulletNo = ++bulletNum;
	}

	@Override
	public boolean collideWith(GameObject object) {
		// 引数として与えられたobjectが死んでいない and 2つのobjectが違う属性(敵同士)ならあたり判定処理をする
		if (x < object.x + object.width && object.x < x + width && y < object.y + object.height
				&& object.y < y + height) {
			delete();
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
			if (bulletNo % 2 == 0) {
				g.drawImage(MyInterface.Imageset.PLAYER_BULLET, x + 21, y - 18, x + 9, y + 18, 100, 231, 112, 267,
						null);
			} else {
				g.drawImage(MyInterface.Imageset.PLAYER_BULLET, x - 20, y - 18, x - 8, y + 18, 100, 231, 112, 267,
						null);
			}
		}
	}
}
