package simpleshooting;

import java.awt.Dimension;

import javax.swing.JFrame;

public class SimpleShooting {

	public static void main(String[] args) {

		Scene Field = new Scene();

		JFrame f = new JFrame("SimpleShooting"); // frame.setTitle("hoge");とも書ける
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// f.setSize(MyInterface.GAME_WIDTH, MyInterface.GAME_HEIGHT);
		f.setResizable(false);
		f.getContentPane().setPreferredSize(new Dimension(MyInterface.GAME_WIDTH, MyInterface.GAME_HEIGHT));
		f.pack();
		f.setLocationRelativeTo(null);
		f.add(Field);
		f.setVisible(true);
	}

}
