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
		Image ENEMY_HERI = MyMethod.setImage("EnemyHeri.png");
		Image PLAYER = MyMethod.setImage("Player.png");
		Image BACKGROUND1 = MyMethod.setImage("Background1.png");
		Image BACKGROUND2 = MyMethod.setImage("Background2.png");
		Image EXPLOSION = MyMethod.setImage("Explosion.png");
		Image PLAYER_BULLET = MyMethod.setImage("PlayerBullet.png");
		Image PLAYER_SUB = PLAYER_BULLET;
	}

	public interface SpriteSet {
		List<Explosion> explosions = new ArrayList<Explosion>();
		List<Enemy> enemies = new ArrayList<Enemy>();
		List<Bullet> bullets = new ArrayList<Bullet>();
		List<Player> players = new ArrayList<Player>();
	}

	public interface FontSet {
		// 現状文字はスコア表示のみなのでSCORE..としておく
		Font SCORE_FONT = new Font("ＭＳ ゴシック", Font.BOLD, 18);
		Font DEFAULT_FONT = new Font("Arial", Font.BOLD, 18);
	}
}
