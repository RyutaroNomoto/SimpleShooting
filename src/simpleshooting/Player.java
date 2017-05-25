package simpleshooting;

import java.awt.Graphics;
import java.util.List;

public class Player extends GameObject {

	private int moveSpeed = 8;
	private int width = 62;
	private int bulletRate = 8;
	private int height = 61;
	private List<Player> players = MyInterface.SpriteSet.players;

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

		movePlayer();

		if (Scene.getFrame() % bulletRate == 0 && shot) {
			MyInterface.SpriteSet.bullets.add(new PlayerBullet(x, y));
		}

		// Cが押されたら初回のみプレイヤーの子機を左右にnewする(テスト用)
		if (players.size() < 3 && test) {
			players.add(new PlayerSub(x, y, -60, this));
			players.add(new PlayerSub(x, y, 60, this));
		}
	}

	protected boolean collideWith(Item item) {
		// アイテムとのあたり判定
			if (x < item.x + item.width && item.x < x + width && y < item.y + item.height
					&& item.y < y + height) {
				hit();
				return true;
			}
		return false;
	}

	/**
	 * プレイヤー移動用メソッド
	 */
	protected void movePlayer() {
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
