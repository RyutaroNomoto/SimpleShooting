package simpleshooting;

public class EnemyHoming extends Enemy {

	private Player player;

	public EnemyHoming(int x, int y, Player player) {
		super(x, y);
		this.player = player;
	}

	@Override
	public void update() {
		this.x += 0.05 * (player.x - this.x);
		this.y += 0.05 * (player.y - this.y);
	}

}
