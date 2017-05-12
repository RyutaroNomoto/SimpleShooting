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
}
