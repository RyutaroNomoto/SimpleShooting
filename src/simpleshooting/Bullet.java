package simpleshooting;

import java.awt.Graphics;

public class Bullet extends GameObject {

	private int moveSpeed = 10;

	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 12;
		this.height = 36;
		this.setType(ObjectType.PLAYER);
	}

	@Override
	public boolean collideWith(GameObject object) {
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
		y -= moveSpeed;
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
		if (isAlive()) {
			g.drawRect(x, y, width, height);
		}
	}
}
