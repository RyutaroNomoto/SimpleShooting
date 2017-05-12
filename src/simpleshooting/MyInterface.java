package simpleshooting;

import java.awt.Image;
import java.util.Random;

public interface MyInterface {
	final int GAME_WIDTH = 600;
	final int GAME_HEIGHT = 700;
	final int GAME_X_CENTER = GAME_WIDTH / 2;
	final int GAME_Y_CENTER = GAME_HEIGHT / 2;
	// ゲーム内で使うランダムクラスのインスタンス(サイコロは1つでいいよね)
	static final Random RAND = new Random();

	public interface Imageset{
		// ファイルパスが1個でもミスるとすべて初期化できないというエラーが出る
		final Image ENEMY_HERI = MyFrame.setImage("EnemyHeri.png");
		final Image PLAYER = MyFrame.setImage("Player.png");
		final Image BACKGROUND1 = MyFrame.setImage("Background1.png");
		final Image BACKGROUND2 = MyFrame.setImage("Background2.png");
		final Image EXPLOSION = MyFrame.setImage("Explosion.png");
	}
}
