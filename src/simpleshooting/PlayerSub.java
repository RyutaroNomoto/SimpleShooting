package simpleshooting;

import java.awt.Graphics;
import java.awt.Image;

public class PlayerSub extends Player {

	private int width = 34;
	private int height = 32;
	private int bulletRate = 8;
	private int moveSpeed = 8;
	private Image img;

	public PlayerSub(int x, int y) {
		this.x = x;
		this.y = y;
		this.setType(ObjectType.PLAYER);
		this.img = MyInterface.Imageset.PLAYER_SUB;
	}

	@Override
	public void update() {

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
		if (up && !down) {
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

		if (Field.getFrame() % bulletRate == 0 && shot) {
			MyInterface.SpriteSet.bullets.add(new PlayerSubBullet(x, y));
		}
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
		if (img == null)
			return;
		if (right && !left) {
			// g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y
			// + height / 2, 130, 0, 180, 60, null);
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 0, 34, 32, null);
		} else if (left && !right) {
			// g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y
			// + height / 2, 74, 0, 124, 60, null);
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 0, 34, 32, null);
		} else {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 0, 34, 32, null);
		}
	}
}
