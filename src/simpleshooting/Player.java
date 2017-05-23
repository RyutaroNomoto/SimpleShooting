package simpleshooting;

import java.awt.Graphics;

public class Player extends GameObject {

	private int moveSpeed = 8;
	private int width = 62;
	private int bulletRate = 8;
	private int height = 61;
	private int centerX = width / 2;
	private int centerY = height / 2;
	private int cntNew;
	protected boolean right, left, test, shot, up, down;
	private static MyKey keyboardlistener = MyInterface.KEYBOARD_LISTENER;

	public Player() {
		this.x = 300;
		this.y = 300;
		this.setType(ObjectType.PLAYER);
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

		KeyUpdate();

		if (Field.getFrame() % bulletRate == 0 && shot) {
			MyInterface.SpriteSet.bullets.add(new PlayerBullet(x, y));
		}

		if (cntNew == 0 && test) {
			MyInterface.SpriteSet.players.add(new PlayerSub(x - 60, y));
			MyInterface.SpriteSet.players.add(new PlayerSub(x + 60, y));
			cntNew++;
		}
	}

	protected void move(boolean right, boolean left, boolean up, boolean down) {

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

	private void KeyUpdate() {
		up = keyboardlistener.isUp();
		down = keyboardlistener.isDown();
		left = keyboardlistener.isLeft();
		right = keyboardlistener.isRight();
		shot = keyboardlistener.isShot();
		test = keyboardlistener.isTest();
	}
}
