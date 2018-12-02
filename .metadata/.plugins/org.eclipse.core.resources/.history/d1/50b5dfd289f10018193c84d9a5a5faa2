package LinearList;

/**
 * 
 * @author xubing 描述：算出n*n的棋盘，可以有多少正方形
 */
public class SquareNums {

	public static long calcSquareNums(int n) {
		long result = 0;
		// 保存结果 ===> 考虑使用滑动数组减低空间复杂度 结果至于i和i-1行之间有关系
		int[][] arr = new int[n][n];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if(i == j)
				{
					arr[i][j] = arr[i-1][j-1] + 1;
				}
				else
				{
					arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
				}
				result += arr[i][j];
			}
		}

		return result;
	}
	
	public static long calcSquareNumsBy2(int n) {
		long result = 0;
		// 保存结果 ===> 考虑使用滑动数组减低空间复杂度 结果至于i和i-1行之间有关系
		int[][] arr = new int[2][n];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if(i == j)
				{
					arr[i % 2][j] = arr[(i-1) % 2][j-1] + 1;
				}
				else
				{
					arr[i % 2][j] = Math.max(arr[i % 2][j-1], arr[(i-1) % 2][j]);
				}
				result += arr[i % 2][j];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		long squareNums = SquareNums.calcSquareNumsBy2(18);
		System.out.println("squareNums is " + squareNums);
	}
}
