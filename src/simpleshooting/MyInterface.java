package simpleshooting;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface MyInterface {
	int GAME_WIDTH = 600;
	int GAME_HEIGHT = 700;
	int GAME_X_CENTER = GAME_WIDTH / 2;
	int GAME_Y_CENTER = GAME_HEIGHT / 2;
	MyKey KEYBOARD_LISTENER = new MyKey();
	// ゲーム内で使うランダムクラスのインスタンス(サイコロは1つでいいよね)
	Random RAND = new Random();

	public interface Imageset {
		// ファイルパスが1個でもミスるとすべて初期化できないというエラーが出る
		Image ENEMY_HERI = MyMethods.setImage("EnemyHeri.png");
		Image PLAYER = MyMethods.setImage("Player.png");
		Image BACKGROUND1 = MyMethods.setImage("Background1.png");
		Image BACKGROUND2 = MyMethods.setImage("Background2.png");
		Image EXPLOSION = MyMethods.setImage("Explosion.png");
		Image PLAYER_BULLET = MyMethods.setImage("PlayerBullet.png");
		Image PLAYER_BULLET2 = MyMethods.setImage("PlayerBullet2.png");
		Image PLAYER_SUB = PLAYER_BULLET;
	}

	public interface SpriteSet {
		List<ExplosionNormal> explosions = new ArrayList<ExplosionNormal>();
		List<Enemy> enemies = new ArrayList<Enemy>();
		List<Bullet> bullets = new ArrayList<Bullet>();
		List<Player> players = new ArrayList<Player>();
		List<Item> items = new ArrayList<Item>();
	}

	public interface FontSet {
		// 現状文字はスコア表示のみなのでSCORE..としておく
		Font SCORE_FONT = new Font("ＭＳ ゴシック", Font.BOLD, 18);
		Font DEFAULT_FONT = new Font("Arial", Font.BOLD, 18);
	}
}
