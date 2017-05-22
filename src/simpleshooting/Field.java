package simpleshooting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Field extends JPanel implements KeyListener, ActionListener {

	private boolean isRunninng;

	private static int cntFrame;

	private Player player;
	private EnemyHentai enemyHentai;
	private List<GameObject> gameObjects;
	private static boolean up, down, left, right, shot, isPose, test;
	private final int fps = 30;
	private int score;
	private int backImgY1;
	private int backImgY2;
	private JLabel label;
	private List<Bullet> bullets = MyInterface.SpriteSet.bullets;
	private List<Enemy> enemies = MyInterface.SpriteSet.enemies;
	private List<Explosion> explosions = MyInterface.SpriteSet.explosions;

	final int nKEY_SHOT1 = KeyEvent.VK_Z;
	final int nKEY_LEFT = KeyEvent.VK_LEFT;// KeyEvent.VK_A;
	final int nKEY_RIGHT = KeyEvent.VK_RIGHT;// KeyEvent.VK_D;
	final int nKEY_UP = KeyEvent.VK_UP;// KeyEvent.VK_W;
	final int nKEY_DOWN = KeyEvent.VK_DOWN;// KeyEvent.VK_S;

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
		setFocusable(true); // KeyListenerはフォーカスする必要がある
		addKeyListener(this);
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

	@Override
	public void keyTyped(KeyEvent e) {
	}

	// キーが押されている時の状態を検知
	@Override
	public void keyPressed(KeyEvent e) {
		// キーが押されたらboolean変数にtrueを代入
		switch (e.getKeyCode()) {
		case nKEY_SHOT1:
			shot = true;
			break;
		case KeyEvent.VK_SPACE:
			shot = true;
			break;
		case KeyEvent.VK_ESCAPE:
			isPose = !isPose;
			break;
		case nKEY_RIGHT:
			right = true;
			break;
		case nKEY_LEFT:
			left = true;
			break;
		case nKEY_UP:
			up = true;
			break;
		case nKEY_DOWN:
			down = true;
			break;
		case KeyEvent.VK_C:
			test = true;
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// キーが離されたらboolean変数にfalseを代入
		switch (e.getKeyCode()) {
		case nKEY_SHOT1:
			shot = false;
			break;
		case KeyEvent.VK_SPACE:
			shot = false;
			break;
		case nKEY_RIGHT:
			right = false;
			break;
		case nKEY_LEFT:
			left = false;
			break;
		case nKEY_UP:
			up = false;
			break;
		case nKEY_DOWN:
			down = false;
			break;
		}
	}

	protected static boolean isUp() {
		return up;
	}

	protected static boolean isDown() {
		return down;
	}

	protected static boolean isShot() {
		return shot;
	}

	protected static boolean isTest() {
		return test;
	}

	protected static boolean isRight() {
		return right;
	}

	protected static boolean isLeft() {
		return left;
	}

}
