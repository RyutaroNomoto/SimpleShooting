package simpleshooting;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public final class MyFrame {

	/**
	 * @param s
	 *            ファイルパス
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
	}
}
