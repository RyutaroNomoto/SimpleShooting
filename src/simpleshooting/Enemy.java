package simpleshooting;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {

	int moveSpeed = 6;
	int isScore = 100;

	public Enemy(int x, int y) {
		this.life = 4;
		this.x = x;
		this.y = y;
		this.width = 20;
		this.height = 20;
		this.setType(ObjectType.ENEMY);
	}

	@Override
	public boolean collideWith(GameObject object) {
		// 引数として与えられたobjectが死んでいない and 2つのobjectが違う属性(敵同士)ならあたり判定処理をする
		if (this.x < object.getX() + object.getWidth() && object.getX() < this.x + this.width
				&& this.y < object.getY() + object.getHeight() && object.getY() < this.y + this.height) {
			return true;
		}
		return false;
	}

	@Override
	protected void update() {
		if (y > MyInterface.GAME_HEIGHT) {
			delete();
		}
		y += moveSpeed;
	}

	@Override
	protected void draw(Graphics g, int cntFrame) {
		if (isAlive()) { // 自分が生きている時だけ描画処理をする
			switch (life) {
			case 4:
				g.setColor(Color.BLUE);
				break;
			case 3:
				g.setColor(Color.GREEN);
				break;
			case 2:
				g.setColor(Color.YELLOW);
				break;
			case 1:
				g.setColor(Color.RED);
				break;
			}
			g.drawRect(x, y, width, height);
		}
	}

	@Override
	protected int hit() {
		if (--life <= 0) {
			delete();
			return isScore;
		}
		return 0;
	}

}
