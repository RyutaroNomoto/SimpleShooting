package simpleshooting;

public enum EnemyHentai {
	Stage1(0), Stage2(1), Stage3(2);

	private int num;
	private int enemy[][] = { { 1, 2, 3, 4, }, { 3, 4, 5, 6, }, { 7, 8, 9, 10 }, { 0 } };

	private EnemyHentai(int num) {
		this.num = num;
	}

	public int[] getEnemy() {
		switch (this) {
		case Stage1:
			return enemy[0];
		case Stage2:
			return enemy[1];
		case Stage3:
			return enemy[2];
		default:
			return enemy[3];
		}
	}

	public int getStageNum() {
		return num;
	}
}