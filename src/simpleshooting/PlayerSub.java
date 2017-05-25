package simpleshooting;

import java.awt.Graphics;
import java.awt.Image;

// プレイヤーの左右に展開できる子機(今後ﾊﾟﾜｰｱｯﾌﾟｱｲﾃﾑ等で発動可能予定)
public class PlayerSub extends Player {

	private int width = 34;
	private int height = 32;
	private int bulletRate = 10;
	private int gap;
	private Image img;
	private Player player;

	/**
	 * @param x newされた瞬間のX座標
	 * @param y newされた瞬間のY座標
	 * @param gap 左右に展開する際のプレイヤーとのX座標のずれ
	 * @param player
	 */
	public PlayerSub(int x, int y,int gap, Player player) {
		this.x = x;
		this.y = y;
		this.gap = gap;
		this.player = player;
		this.setType(ObjectType.PLAYER);
		this.img = MyInterface.Imageset.PLAYER_SUB;
	}

	@Override
	public void update() {

		KeyUpdate();
		x = player.getX() + gap;
		y = player.getY();

		if (Scene.getFrame() % bulletRate == 0 && shot) {
			MyInterface.SpriteSet.bullets.add(new PlayerSubBullet(x, y - 5));
		}
		if(test2){
			delete();
		}
	}

	@Override
	public void draw(Graphics g, int cntFrame) {
		if (!isAlive || img == null)
			return;
		if (right && !left) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 96, 34, 129, null);
		} else if (left && !right) {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 160, 34, 192, null);
		} else {
			g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 0, 34, 32, null);
		}
	}
}
