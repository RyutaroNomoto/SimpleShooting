package simpleshooting;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends GameObject {

	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 5;
		this.height = 5;
		this.setType(ObjectType.player);
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
		if (this.isAlive()) {
			g.setColor(Color.RED);
			g.drawLine(x, y, x + 5, y + 15);
			g.drawLine(x, y, x - 5, y + 15);
			g.drawLine(x + 5, y + 15, x - 5, y + 15);
		}
	}
}
