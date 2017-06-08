package simpleshooting;

import java.awt.Graphics;

public interface MyScene{
	void draw(Graphics g, int tick);

	MyScene update(int tick);
}
