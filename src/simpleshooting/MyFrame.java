package simpleshooting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements Runnable {

	private boolean isPause;
	MyScene scene;
	private Image screen;
	private Graphics graphics;
	private static final int G_WIDTH = MyInterface.GAME_WIDTH;
	private static final int G_HEIGHT = MyInterface.GAME_HEIGHT;

	MyFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setPreferredSize(new Dimension(G_WIDTH, G_HEIGHT));
		pack();
		setLocationRelativeTo(null);
		JPanel panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(screen, 0, 0, this);
			}

			@Override
			public void update(Graphics g) {
				paint(g);
			}
		};

		panel.addKeyListener(MyInterface.KEYBOARD_LISTENER);
		panel.setFocusable(true);
		add(panel);

		screen = createImage(G_WIDTH, G_HEIGHT);

	}

	@Override
	public void run() {
		Graphics g = screen.getGraphics();
		this.graphics = g;
		int tick = 0;
		int tickPause = 0;
		while (true) {
			long processTime = System.currentTimeMillis();
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, G_WIDTH, G_HEIGHT); // とりあえず背景を真っ黒にする
			scene.draw(g, tick);
			g.drawImage(screen, 0, 0, this);

			if (isPause && tickPause % 60 < 20) {
				g.setFont(MyInterface.FontSet.SCORE_FONT);
				g.setColor(Color.BLACK);
				g.drawString(MyInterface.strPause, 20, 20);
			}

			repaint();

			if (isPause) {
				tickPause++; // ポーズ状態ならポーズ用のtickに加算
			} else {
				MyScene newScene = scene.update(tick);
				// 現在のシーンと、ｱｯﾌﾟﾃﾞｰﾄﾒｿｯﾄﾞの返り値としてもらったシーンが同じか比較する
				if (scene == newScene) {
					tick++;
				} else {
					tick = 0;
				}
				scene = newScene;
			}
		}

	}

}
