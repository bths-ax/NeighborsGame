import java.util.Scanner;

public class Game {
	private Player[] players;
	private int rowCnt;
	private int colCnt;
	private int sideCnt;

	public Game(int playerCnt, int rowCnt, int colCnt, int sideCnt) {
		this.players = new Player[playerCnt];
		for (int i = 0; i < playerCnt; i++)
			this.players[i] = new Player(rowCnt, colCnt, sideCnt);
		this.rowCnt = rowCnt;
		this.colCnt = colCnt;
		this.sideCnt = sideCnt;
	}

	public void startGame() {
		Scanner scanner = new Scanner(System.in);

		// Fill up grids
		for (int turn = 0; turn < rowCnt * colCnt; turn++) {
			int rolled = rollDice();

			System.out.println();
			System.out.println("Rolled a " + rolled);

			for (int i = 0; i < players.length; i++) {
				System.out.println();
				System.out.println(players[i]);
				System.out.print(String.format("Player %d, choose a space to place %d: ", i + 1, rolled));

				while (true) {
					String move = scanner.nextLine().toUpperCase();
					if (move.length() == 2) {
						int row = (int)(move.charAt(0) - 'A');
						int col = (int)(move.charAt(1) - 'A');
						if (players[i].place(row, col, rolled)) {
							break;
						}
					}
					System.out.print("Invalid move, try again: ");
				}
			}
		}

		// Find winner
		int maxScore = Integer.MIN_VALUE;
		int maxPlayer = -1;

		System.out.println();

		for (int i = 0; i < players.length; i++) {
			int score = players[i].calculateScore();
			if (score > maxScore) {
				maxScore = score;
				maxPlayer = i;
			}

			System.out.println();
			System.out.println("Player " + (i + 1));
			System.out.println(players[i]);
			System.out.println("Score: " + score);
		}

		System.out.println();
		System.out.println("Winner: Player " + (maxPlayer + 1) + " with a score of " + maxScore);
	}

	public int rollDice() {
		return (int)(Math.random() * sideCnt + 1);
	}
}
