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
	// ゲーム内で使うランダムクラスのインスタンス(サイコロは1つでいいよね)
	static final Random RAND = new Random();

	// 現状文字はスコア表示のみなのでSCORE..としておく
	Font SCORE_FONT = new Font("ＭＳ ゴシック", Font.BOLD, 18);

	public interface Imageset {
		// ファイルパスが1個でもミスるとすべて初期化できないというエラーが出る
		Image ENEMY_HERI = MyFrame.setImage("EnemyHeri.png");
		Image PLAYER = MyFrame.setImage("Player.png");
		Image BACKGROUND1 = MyFrame.setImage("Background1.png");
		Image BACKGROUND2 = MyFrame.setImage("Background2.png");
		Image EXPLOSION = MyFrame.setImage("Explosion.png");
		Image PLAYER_BULLET = MyFrame.setImage("PlayerBullet.png");
	}

	public interface SpriteSet {
		List<Explosion> explosions = new ArrayList<Explosion>();
		List<Enemy> enemies = new ArrayList<Enemy>();
		List<Bullet> bullets = new ArrayList<Bullet>();
	}
}
