package simpleshooting;

import java.awt.Graphics;
import java.awt.Image;

abstract public class GameObject {
	protected int life;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int gameWidth = MyInterface.GAME_WIDTH;
	protected int gameHeight = MyInterface.GAME_HEIGHT;
	private ObjectType type;
	protected boolean isAlive = true;
	protected Image img;

	public boolean isAlive() {
		return isAlive;
	}

	protected void delete() {
		this.isAlive = false;
	}

	public ObjectType getType() {
		return this.type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public boolean collideWith(GameObject object) {
		// 引数として与えられたobjectが死んでいない and 2つのobjectが違う属性(敵同士)ならあたり判定処理をする
		if (object.isAlive() && this.type != object.getType()) {
			if (x < object.x + object.width && object.x < x + width && y < object.y + object.height
					&& object.y < y + height) {
				hit();
				return true;
			}
		}
		return false;
	}

	protected int hit() {
		if (--life <= 0) {
			delete();
		}
		return 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	abstract protected void update();

	abstract protected void draw(Graphics g, int cntFrame);
}
