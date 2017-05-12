package simpleshooting;

public class TestEnemy extends Enemy {

	public TestEnemy(int x, int y) {
		super(x, y);
	}

	@Override
	public void update() {
		System.out.println("life :" + life);
		if (y > MyInterface.GAME_HEIGHT) {
			delete();
		}
		if (y < MyInterface.GAME_Y_CENTER) {
			y += moveSpeed;
		}
	}

}
