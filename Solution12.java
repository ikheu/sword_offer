package sword_offer;

public class Solution12 {
	public static boolean hasPath(char[][] matrix, String str) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int pathLength = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited))
					return true;
			}
		}
		return false;
	}

	// 上下左右递归搜索
	private static boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, String str,
			int pathLength, boolean[][] visited) {
		boolean hasPath = false;
		if (pathLength > str.length() - 1)
			return true;
		if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == str.charAt(pathLength)
				&& !visited[row][col]) {
			++pathLength;
			visited[row][col] = true;
			hasPath = hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited);
			if (!hasPath) {
				--pathLength;
				visited[row][col] = false;
			}
		}
		return hasPath;
	}

	// 测试
	public static void main(String[] args) {
		char[][] matrix = { { 'a', 'b', 't', 'g' }, { 'c', 'f', 'c', 's' }, { 'j', 'd', 'e', 'h' } };
		String str = "bfc";
		System.out.println(hasPath(matrix, str));
	}
}