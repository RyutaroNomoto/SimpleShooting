package simpleshooting;

import java.awt.Graphics;
import java.awt.Image;

public class EnemyHeri2 extends EnemyHeri1 {

	private Image img;

	public EnemyHeri2(int x, int y) {
		super(x, y);
		this.life = 1;
		this.x = x;
		this.y = y;
		this.width = 48;
		this.height = 48;
		this.setType(ObjectType.ENEMY);
		this.img = MyInterface.Imageset.ENEMY_HERI;
	}

	@Override
	protected void draw(Graphics g, int cntFrame) {
		if (!isAlive() || img == null)
			return;
		g.drawImage(img, x - width / 2, y - height / 2, x + width / 2, y + height / 2, 0, 0, width, height, null);
		if (Scene.getFrame() % 6 < 3) {
			g.drawImage(img, x - 24, y - 15, x + 24, y + 15, 117, 0, 166, 30, null);
		} else {
			g.drawImage(img, x - 15, y - 24, x + 15, y + 24, 128, 46, 157, 93, null);
		}
	}

}
