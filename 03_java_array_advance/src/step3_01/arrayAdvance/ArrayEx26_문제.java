package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* 
 * # 1 to 50[3단계] : 1 to 18
 * 
 * 1. 구글에서 1 to 50 이라고 검색한다.
 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
 * 4. 숫자 1~9는 front 배열에 저장하고,
 *    숫자 10~18은 back 배열에 저장한다.
 */


public class ArrayEx26_문제 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 9;
		
		int[] front = new int[SIZE];
		int[] back  = new int[SIZE];
		
		int setNum = 1 ;
		
		for(int i = 0 ; i < front.length; i++) {
			front [ i ] = setNum;
			setNum++;
		}
		for(int i = 0 ; i < back.length; i++) {
			back [ i ] = setNum;
			setNum ++;
		}
		
		System.out.println("1 to 50 game start !!!!!!!!!!!");
		
		//찾을숫자
		int findNum = 1;
		//찾을숫자 index 
		int findIndex = 0;
		//random front생성시 변수
		int randIndex = 0;
		//back 배열 index count
		int backIndex = 0;
		int temp = 0;
		//front 3x3출력 카운트 변수
		int printFront = 0;
		//정답입력변수 
		int answer = 0 ;
		//front 섞기
		int mixFront = 0;
		//게임종료 숫자 
		int finalNum = 18;
		
		Random rand = new Random();
		while(mixFront < 100 ) {
			randIndex = rand.nextInt(8);
			temp = front [ 0 ];
			front [ 0 ] = front [ randIndex ];
			front [ randIndex  ] = temp;
			mixFront ++ ;
		}
		//System.out.println(Arrays.toString(front));
		
		while(true) {
			if( findNum == 19 ) {
				System.out.println();
				System.out.println("-------------------------------------------------------");
				System.out.println("*****************     게임종료   **********************");
				System.out.println("-------------------------------------------------------");
				break;
			}
			System.out.println();
			System.out.println("FRONT   " + Arrays.toString(front));
			System.out.println(" BACK   " + Arrays.toString(back));
			System.out.println();
			System.out.print(findNum + " 을 찾아라               ");
			for(int i = 0 ; i < front.length; i++) {
				if( front [ i ] == findNum) {
					System.out.println("정답 : " + i);
					findIndex = i;
				}
			}
			System.out.println();
			
			//front 3 x 3 배열로 출력 
		    printFront  = 0 ;
			for(int i = 0 ; i < front.length; i++) {
				if ( front[ i ] == 100 ) {
					System.out.print("##    ");
					printFront ++ ;
					if( printFront == 3 || printFront == 6 || printFront == 9) {
						System.out.println();
					}
					continue;
				}
				System.out.print(front[ i ] + "    ");
				printFront ++ ;
				if( printFront == 3 || printFront == 6 || printFront == 9) {
					System.out.println();
				}
			}
			
			//정답입력 
			answer = scan.nextInt();
			System.out.println();
			System.out.println("입력하신 정답 : " + answer );
			
			//정답확인
			if( findIndex == answer	&& findNum <= 9 ) {
				System.out.println();
				System.out.println("정답을 찾았습니다.");
				front [ findIndex ] = back [ backIndex ];
				back[ backIndex ] = 0 ;
				backIndex ++ ;
				findNum ++;
			}
			else if ( findIndex == answer && findNum >= 10) {
				System.out.println();System.out.println("정답을 찾았습니다.");
				findNum ++;
				front [ findIndex ] = 100;
			}
			else {
				System.out.println("정답찾기 실패 ");
				continue;
			}
			
		}
	}
}
