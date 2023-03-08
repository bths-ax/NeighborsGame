import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("How many players? ");
		int playerCnt = scanner.nextInt();

		System.out.print("Number of rows? ");
		int rowCnt = scanner.nextInt();

		System.out.print("Number of columns? ");
		int colCnt = scanner.nextInt();

		System.out.print("Sides of dice? ");
		int sideCnt = scanner.nextInt();

		Game game = new Game(playerCnt, rowCnt, colCnt, sideCnt);
		game.startGame();
	}
}
