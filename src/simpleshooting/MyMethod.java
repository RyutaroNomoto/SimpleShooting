package simpleshooting;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

abstract class MyMethod {

	/**
	 * @param s
	 *            imgフォルダ内の画像ファイル名(拡張子含む)
	 * @return Image
	 */
	public static Image setImage(String s) {
		try {
			return ImageIO.read(new File("img/" + s));
		} catch (Exception e) {
			System.out.println("画像がヌルポだよ!");
			e.printStackTrace();
		}
		return null;
	}

	public static void objectsUpdate() {
		for (int i = 0; i < MyInterface.SpriteSet.enemies.size(); i++) {
			MyInterface.SpriteSet.enemies.get(i).update();
		}
		for (int i = 0; i < MyInterface.SpriteSet.bullets.size(); i++) {
			MyInterface.SpriteSet.bullets.get(i).update();
		}
		for (int i = 0; i < MyInterface.SpriteSet.explosions.size(); i++) {
			MyInterface.SpriteSet.explosions.get(i).update();
		}
		for (int i = 0; i < MyInterface.SpriteSet.players.size(); i++) {
			MyInterface.SpriteSet.players.get(i).update();
		}
	}

	public static void objectsDraw(Graphics g, int cntFrame) {
		for (int i = 0; i < MyInterface.SpriteSet.enemies.size(); i++) {
			MyInterface.SpriteSet.enemies.get(i).draw(g, cntFrame);
		}
		for (int i = 0; i < MyInterface.SpriteSet.bullets.size(); i++) {
			MyInterface.SpriteSet.bullets.get(i).draw(g, cntFrame);
		}
		for (int i = 0; i < MyInterface.SpriteSet.explosions.size(); i++) {
			MyInterface.SpriteSet.explosions.get(i).draw(g, cntFrame);
		}
		for (int i = 0; i < MyInterface.SpriteSet.players.size(); i++) {
			MyInterface.SpriteSet.players.get(i).draw(g, cntFrame);
		}
	}
}
