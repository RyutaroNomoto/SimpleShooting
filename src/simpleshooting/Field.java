package simpleshooting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Field extends JPanel implements ActionListener {

	private boolean isRunninng;

	private static int cntFrame;

	private Player player;
	private EnemyHentai enemyHentai;
	private List<GameObject> gameObjects;
	private boolean up, down, right, left, test, isPose, shot;
	private final int fps = 30;
	private int score;
	private int backImgY1;
	private int backImgY2;
	private JLabel label;
	private List<Bullet> bullets = MyInterface.SpriteSet.bullets;
	private List<Enemy> enemies = MyInterface.SpriteSet.enemies;
	private List<Explosion> explosions = MyInterface.SpriteSet.explosions;

	private static MyKey keyboardlistener = MyInterface.KEYBOARD_LISTENER;

	public Field() {
		cntFrame = 0;

		this.enemyHentai = EnemyHentai.Stage1;
		this.score = 0;
		// this.label.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 13));
		// labelの上にあるパネルが持つレイアウト設定nullにしないとlabelのレイアウトを毎回自動設定される
		// 真ん中の中心に一瞬labelがちらつく
		this.setLayout(null);

		this.backImgY1 = 0;
		this.backImgY2 = -700;

		setSize(MyInterface.GAME_WIDTH, MyInterface.GAME_HEIGHT);
		setBackground(Color.white);
		setFocusable(true);
		addKeyListener(keyboardlistener);// KeyListenerはフォーカスする必要がある
		Timer timer = new Timer(1000 / fps, this);// 20ミリ秒ごとに自分の持つ「actionPerformed()」が呼ばれる
		timer.start();
		player = new Player();
		label = new JLabel();
		gameObjects = new ArrayList<GameObject>();

		// objects.add(new EnemyHoming(0, 0, player));

		for (int i = 0; i < 11; i++) {
			enemies.add(new EnemyHeri2(i * (600 / 10), 20));

		}

		// objects.add(new TestEnemy(MyInterface.GAME_X_CENTER, -5));

		// Fieldコンストラクタが実行される前にボタンが押されるとPlayerがインスタンス化する前に
		// actionPerformed関数が呼ばれてPlayerを参照するので準備ができた段階でtrueを代入する
		isRunninng = true;

	}

	@Override
	public void actionPerformed(ActionEvent e) { // 定期的に呼ばれるﾒｿｯﾄﾞ

		if (!isRunninng)
			return;

		KeyUpdate();

		String str = Integer.toString(score);
		str = "スコア : " + str;
		label.setText(str);
		label.setBounds(400, -10, 150, 50);
		label.setFont(MyInterface.FontSet.SCORE_FONT);
		// label.setFont(MyInterface.FontSet.DEFAULT_FONT);
		this.add(label);

		/*
		 * if (cntFrame % 120 == 0) { int[] tmp; tmp = enemyHentai.getEnemy();
		 * for (int i = 0; i < tmp.length; i++) { if (tmp[i] == 1) {
		 * enemies.add(new Enemy(MyInterface.GAME_X_CENTER + 20, -5));
		 * enemies.add(new Enemy(MyInterface.GAME_X_CENTER - 20, -5)); } } }
		 */

		for (Enemy ene : enemies) {
			if (!ene.isAlive()) {
				continue; // isAlive()で生きているか確認
			}
			// collideWidthﾒｿｯﾄﾞでobjectsList内のobject全てと当たり判定検査をする
			for (Bullet b : bullets) { // プレイヤーの弾と敵の当たり判定
				if (isCollision(b, ene)) { // 2つのゲームオブジェクトのあたり判定をbooleanで返す
					b.hit();
					score += ene.hit();
				}
			}
		}
		if (!isPose) {
			cntFrame++; // フレーム数をカウントアップ
			if (enemies.size() <= 9 && cntFrame % 15 == 0) {
				if (MyInterface.RAND.nextBoolean()) { // 半々の確率でHeri1かHeri2を出現させる
					enemies.add(new EnemyHeri1(MyInterface.RAND.nextInt(MyInterface.GAME_WIDTH), -5));
				} else {
					enemies.add(new EnemyHeri2(MyInterface.RAND.nextInt(MyInterface.GAME_WIDTH), -5));
				}
			}
			player.move(right, left, up, down);
			player.update();
			backImgY1 = backImgY1 < getHeight() ? backImgY1 + 5 : -getHeight() + 5;
			backImgY2 = backImgY2 < getHeight() ? backImgY2 + 5 : -getHeight() + 5;
			MyMethod.objectsUpdate();
		}

		enemies.removeIf(s -> !s.isAlive());
		bullets.removeIf(s -> !s.isAlive());
		// リスト名.removeIf(名前(基本s,t,u) -> 条件式orメソッド);

		// for (int i = 0; i < objects.size(); i++) {
		// if (!objects.get(i).isAlive()) {
		// objects.remove(i);
		// }
		// }

		repaint();
	}

	/**
	 * 2つのオブジェクトが衝突したかどうかを返す
	 *
	 * @return boolean
	 */
	private boolean isCollision(GameObject obj1, GameObject obj2) {
		// return go1.collideWith(go2) && go2.collideWith(go1);
		return obj1.collideWith(obj2);
	}

	public static int getFrame() {
		return cntFrame;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(MyInterface.Imageset.BACKGROUND1, 0, backImgY1, getWidth(), backImgY1 + getHeight(), 0, 0, 800, 600,
				null);
		g.drawImage(MyInterface.Imageset.BACKGROUND1, 0, backImgY2, getWidth(), backImgY2 + getHeight(), 0, 0, 800, 600,
				null);

		MyMethod.objectsDraw(g, cntFrame);

		player.draw(g, cntFrame); // 自機
	}

	private void KeyUpdate() {
		up = keyboardlistener.isUp();
		down = keyboardlistener.isDown();
		left = keyboardlistener.isLeft();
		right = keyboardlistener.isRight();
		shot = keyboardlistener.isShot();
		isPose = keyboardlistener.isPose();
		test = keyboardlistener.isTest();
	}

}
