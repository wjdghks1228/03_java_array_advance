package step3_01.arrayAdvance;

/*
 *	# 2차원배열 기본문제[1단계]
*/

public class ArrayEx35_문제 {

	public static void main(String[] args) {

		int[][] arr = new int[3][3];

		int k = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}

		// 문제 1) 전체 합 출력
		// 정답 1) 450
		int sum = 0;
		System.out.println("문제 1      답 : 450");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
		System.out.println();
		// 문제 2) 4의 배수만 출력
		// 정답 2) 20 40 60 80
		System.out.println("문제 2      답 : 20 40 60 80");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % 4 == 0) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
		System.out.println();
		System.out.println();
		// 문제 3) 4의 배수의 합 출력
		// 정답 3) 200
		int fourSum = 0;
		System.out.println("문제 3      답 : 200 ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % 4 == 0) {
					fourSum += arr[i][j];
				}
			}
		}

		System.out.println(fourSum);
		System.out.println();
		// 문제 4) 4의 배수의 개수 출력
		// 정답 4) 4
		System.out.println("문제 4      답 : 4");
		int fourCount = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % 4 == 0) {
					fourCount++;
				}
			}
		}
		System.out.println(fourCount);
		System.out.println();

	}

}
