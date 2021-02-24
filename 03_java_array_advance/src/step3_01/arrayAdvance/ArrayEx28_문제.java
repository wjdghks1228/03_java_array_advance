package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Random;

//2021 _ 02 _ 24 TIME : 20 : 32 ~ 20 : 
/*
 * # 중복숫자 금지[2단계]
 * 
 * 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
 * 2. 단 중복되는 숫자가 없어야 한다.
 */


public class ArrayEx28_문제 {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		int[] check = new int [ 10 ];
		Random rand = new Random();
		
		int arrIndex = 0;
		while( true ) {
			if( arrIndex == 5) {
				break;
			}
			int randNum = rand.nextInt(10) + 1;
			if( check [ randNum - 1 ] != 1	) {
				arr [ arrIndex ] = randNum ;
				arrIndex ++ ;
				check [ randNum - 1 ] ++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
}
