public class Player {
	private int[][] grid;
	private int rowCnt;
	private int colCnt;
	private int sideCnt;

	public Player(int rowCnt, int colCnt, int sideCnt) {
		this.grid = new int[rowCnt][colCnt];
		this.rowCnt = rowCnt;
		this.colCnt = colCnt;
		this.sideCnt = sideCnt;
	}

	public boolean place(int row, int col, int value) {
		if (!(0 <= row && row < rowCnt)) return false;
		if (!(0 <= col && col < colCnt)) return false;
		if (grid[row][col] != 0) return false;
		grid[row][col] = value;
		return true;
	}

	public int calculateScore() {
		int score = 0;

		// Calculate rows
		for (int i = 0; i < rowCnt; i++) {
			for (int j = 0, k = 1; j < colCnt; j = k) {
				while (k < colCnt && grid[i][j] == grid[i][k])
					k++;
				if (k - j > 1) {
					score += (k - j) * grid[i][j];
				}
			}
		}

		// Calculate columns
		for (int i = 0; i < colCnt; i++) {
			for (int j = 0, k = 1; j < rowCnt; j = k) {
				while (k < rowCnt && grid[j][i] == grid[k][i])
					k++;
				if (k - j > 1) {
					score += (k - j) * grid[j][i];
				}
			}
		}

		return score;
	}

	public String toString() {
		int maxPad = Math.max(2, (int)Math.log10(sideCnt) + 1);

		String result = "";
		for (int r = 0; r < rowCnt; r++) {
			for (int c = 0; c < colCnt; c++) {
				if (grid[r][c] != 0) {
					result += String.format("%" + maxPad + "d", grid[r][c]);
				} else {
					result += (char)('A' + r);
					result += (char)('A' + c);
					result += new String(" ").repeat(maxPad - 2);
				}
				if (c + 1 < colCnt) {
					result += "|";
				}
			}
			if (r + 1 < rowCnt) {
				result += "\n";
				result += new String("-").repeat(colCnt * (maxPad + 1) - 1);
				result += "\n";
			}
		}
		return result;
	}
}
