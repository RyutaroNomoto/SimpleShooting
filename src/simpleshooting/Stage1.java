package simpleshooting;

import java.awt.Graphics;
import java.util.List;

public class Stage1 extends Scene {

	private List<Bullet> bullets = MyInterface.SpriteSet.bullets;
	private List<Enemy> enemies = MyInterface.SpriteSet.enemies;
	private List<Player> players = MyInterface.SpriteSet.players;
	private List<ExplosionNormal> explosions = MyInterface.SpriteSet.explosions;
	private Player player;

	Stage1() {
		super();
		player = new Player();
	}

	@Override
	public void draw(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(MyInterface.Imageset.BACKGROUND2, 0, backImgY1, getWidth(), backImgY1 + getHeight(), 0, 0, 800, 600,
				null);
		g.drawImage(MyInterface.Imageset.BACKGROUND2, 0, backImgY2, getWidth(), backImgY2 + getHeight(), 0, 0, 800, 600,
				null);

		MyMethods.objectsDraw(g, Scene.getFrame());

		player.draw(g, Scene.getFrame()); // 自機
	}
}
