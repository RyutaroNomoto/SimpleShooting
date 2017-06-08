package simpleshooting;

import java.awt.Color;
import java.awt.Graphics;

public class Item extends GameObject {

	protected int moveSpeed;

	protected Item(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 15;
		this.height = 15;
		this.moveSpeed = 5;
		this.life = 1;
	}

	@Override
	public void update() {
		if (y > MyInterface.GAME_HEIGHT) {
			delete();
		}
		y += moveSpeed;
	}

	@Override
	protected void draw(Graphics g, int cntFrame) {
		g.setColor(Color.GREEN);
		g.fillRect(x - width / 2, y - width /2, width, height);
	}
}
