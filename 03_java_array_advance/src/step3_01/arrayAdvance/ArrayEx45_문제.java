package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//# 빙고 Ver2(플레이어 2명)

public class ArrayEx45_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int maxNum = 5;
		
		
		int size = 50;
		
		int[][] me  = new int[maxNum][maxNum];
		int[][] you = new int[maxNum][maxNum];
		
		int[][] meMark  = new int[maxNum][maxNum];
		int[][] youMark = new int[maxNum][maxNum];

		int[] temp = new int[maxNum*maxNum];
		
		int win = 0;
		int turn = 1;
		int p1X = 0;	int p1Y = 0;
		int p2X = 0;	int p2Y = 0;
		
		int indexCnt = 0;
		
		//me bingo set - 중복제거 숫자 세팅
		for (int i = 0  ; i < maxNum ; i ++) {
			temp [ i ] = rand.nextInt(50)+1;
			for(int j = 0 ; j < i ; j++) {
				if(temp[i] == temp[j]) {
					i--;
				}
			}
		}
		
		for(int i = 0 ; i < maxNum; i++) {
			for(int j  = 0 ; j < maxNum; j++) {
				me [i][j] = temp[indexCnt];
				indexCnt++;
			}
		}
		System.out.println(Arrays.toString(me));
		
		
		//you bingo set - 중복제거 숫자 세팅
		for (int i = 0; i < maxNum; i++) {
			temp[i] = rand.nextInt(50)+1;
			for(int j = 0 ; j < i ; j++) {
				if(temp[i] == temp[j]) {
					i--;
				}
			}
		}
		
		indexCnt = 0;
		for(int i = 0 ; i < maxNum ; i++) {
			for (int j = 0; j < maxNum ; j++) {
				you [i][j] = temp [ indexCnt ];
				indexCnt ++;
			}
		}
		
		//bingo  game start
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("**********************BINGO GAME START*********************************");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println();
		while(true) {
			//me print
			System.out.println("[ ME ]");
			for (int i = 0 ; i < maxNum; i++) {
				for(int j = 0 ; j < maxNum; j++) {
					System.out.print(me[i][j] + "/t");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("[ YOU ]");
			for (int i = 0 ; i < maxNum; i++) {
				for(int j = 0 ; j < maxNum; j++) {
					System.out.print(you[i][j] + "/t");
				}
				System.out.println();
			}
			System.out.println();
			
			if(turn == 1) {
				System.out.println();
				System.out.println("[ ME TURN ]");
				System.out.println("Y 좌표 입력 : ");
				p1Y = scan.nextInt();
				System.out.println("X 좌표 입력 : ");
				p1X = scan.nextInt();
				
				if( meMark [p1Y][p1X] == 0 ) {
					meMark [p1Y][p1X] = 1;
					//you에서 찾기
					for(int i = 0 ; i < maxNum; i++) {
						for(int j = 0 ; j < maxNum; j++) {
							if( you[i][j] == me[p1Y][p1X] ) {
								you[i][j] = 1;
							}
						}
					}
					turn = 2;
				}
				else if ( meMark[p1Y][p1X] == 1) {
					System.out.println("이미 선택된 숫자");
					continue;
				}
			}
			else if(turn == 2) {
				System.out.println();
				System.out.println("[ YOU TURN ]");
				System.out.println("Y 좌표 입력 : ");
				p2Y = scan.nextInt();
				System.out.println("X 좌표 입력 : ");
				p2X = scan.nextInt();
				
				if( meMark [p1Y][p1X] == 0 ) {
					
				}
			}
		}


	}

}
