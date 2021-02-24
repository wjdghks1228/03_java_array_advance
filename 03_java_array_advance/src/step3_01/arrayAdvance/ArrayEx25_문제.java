package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * # 최대값 구하기[3단계]
 * 
 * 1. 가장 큰 값을 찾아 입력한다.
 * 2. 정답이면 해당 값을 0으로 변경한다.
 * 3. arr배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
 * 예)
 * 11, 87, 42, 100, 24
 * 입력 : 100
 * 
 * 11, 87, 42, 0, 24
 * 입력 : 87
 * 
 * 11, 0, 42, 0, 24
 * 
 */


public class ArrayEx25_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {11, 87, 42, 100, 24};
		
		System.out.println("최대값 찾기 게임!");
		
		int maxIndex = 0 ;
		
		while(true) {
			System.out.println();
			System.out.println(Arrays.toString(arr));
			System.out.println("숫자를 입력하세요 : ");
			int maxNum = scan.nextInt();
			System.out.println("입력하신 숫자 : " + maxNum);
			
			int zeroCount = 0;
			int arrMax = 0;
			for( int i = 0 ;  i < arr.length ; i++) {
				if( arr [ i ] >= arrMax ) {
					maxIndex = i;
					arrMax = arr[ i ] ;
				}
				if( arr [ i ]  == 0 ) {
					zeroCount ++ ;
				}
			}
			if( arrMax == maxNum && zeroCount < 4 ) {
				System.out.println();
				System.out.println("최대값을 찾았다! 다음최대값을 찾자");
				arr [ maxIndex ] = 0 ;
			}
			else if ( arrMax == maxNum && zeroCount == 4) {
				System.out.println();
				System.out.println("마지막 최대값을 찾았다 ! 게임종료 !");
				break;
			}
			else {
				System.out.println();
				System.out.println("최대값 찾기 실패 , 다시시도!");
				continue;
			}
		}
		scan.close();
	}
}
