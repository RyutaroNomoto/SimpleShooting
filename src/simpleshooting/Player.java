package simpleshooting;

import java.awt.Graphics;

public class Player extends GameObject {

	private int moveSpeed = 8;
	private int width = 62;
	private int height = 61;
	private int centerX = width / 2;
	private int centerY = height / 2;
	private boolean left, right, shot;

	public Player() {
		this.x = 300;
		this.y = 300;
		this.setType(ObjectType.player);
		this.img = MyInterface.Imageset.PLAYER;
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
		if (img == null)
			return;
		if (right && !left) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 130, 0, 180, 60, null);
		} else if (left && !right) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 74, 0, 124, 60, null);
		} else {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 0, 62, 61, null);
		}
	}

	/*
	 * g.drawImage(img, x - 25, y - 30, x + 25, y + 30, 130, 0, 180, 60, null);
	 * } else if (left && !right) { g.drawImage(img, x - 25, y - 30, x + 25, y +
	 * 30, 74, 0, 124, 60, null); } else { g.drawImage(img, x - 31, y - 30, x +
	 * 31, y + 30, 0, 0, 62, 61, null); }
	 */

	@Override
	public void update() {
	}

	public Bullet shoot() {
		return new PlayerBullet(x, y);
	}

	public void move(boolean right, boolean left, boolean up, boolean down) {
		this.right = right;
		this.left = left;

		if (right && !left) {
			if (up || down) {
				x = (int) (x <= gameWidth ? x + moveSpeed * 0.7 : x);
			} else {
				x = x <= gameWidth ? x + moveSpeed : x;
			}
		}
		if (left && !right) {
			if (up || down) {
				x = (int) (x >= 0 ? x - moveSpeed * 0.7 : x);
			} else {
				x = x >= 0 ? x - moveSpeed : x;
			}
		}
		if (up && !down)

		{
			if (left || right) {
				y = (int) (y >= 0 ? y - moveSpeed * 0.7 : y);
			} else {
				y = y >= 0 ? y - moveSpeed : y;
			}
		}
		if (!up && down) {
			if (left || right) {
				y = (int) (y <= gameHeight ? y + moveSpeed * 0.7 : y);
			} else {
				y = y <= gameHeight ? y + moveSpeed : y;
			}
		}
	}
}
