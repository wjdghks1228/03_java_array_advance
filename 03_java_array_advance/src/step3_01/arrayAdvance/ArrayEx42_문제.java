package step3_01.arrayAdvance;

import java.util.Scanner;

// #오목
//2021_02_25 TIME --> 19 : 23 ~ 19 : 58
public class ArrayEx42_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int size = 10;
		int[][] omok = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0}
		};

		int p1Y = 0;
		int p1X = 0;
		int p2Y = 0;
		int p2X = 0;
		int turn = 1;
		int win = 0;
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("******************************오목게임 시작**********************************");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println();
		while ( true ){
			if(win == 1) {
				System.out.println("1승리");
			}
			else if(win == 2) {
				System.out.println("2승리");
			}
			//오목판 출력
			System.out.print("  ");  //처음 공백
			for(int i  = 0 ; i < size; i ++) {
				System.out.print( i +  " "); //처음 x index 표시
			}
			System.out.println();
			for (int i = 0 ; i < size; i++) {
				System.out.print(i + " ");
				for(int j = 0 ;  j < size; j++) {
					System.out.print(omok [i][j] + " ");
				}
				System.out.println();
			}
			
			//P1입력
			if( turn  == 1 ) {
				System.out.println();
				System.out.println("PLAYER1 TURN");
				System.out.println("Y좌표를 입력하세요 : ");
				p1Y = scan.nextInt();
				System.out.println("X좌표를 입력하세요 : ");
				p1X = scan.nextInt();
				
				if( omok [ p1Y ] [ p1X ] == 0 ) {
					omok [ p1Y ] [ p1X ] = 1;
					turn = 2;
				}
				else if( omok [ p1Y ] [ p1X ] == 1 || omok [ p1Y ][ p1X ] == 2  ) {
					System.out.println("이미 선택된 자리 입니다.");
					continue;
				}
			}
			else if ( turn == 2) {
				System.out.println();
				System.out.println("PLAYER2 TURN");
				System.out.println("Y좌표를 입력하세요 : ");
				p2Y = scan.nextInt();
				System.out.println("X좌표를 입력하세요 : ");
				p2X = scan.nextInt();
				
				if( omok [ p2Y ] [ p2X ] == 0 ) {
					omok [ p2Y ] [ p2X ] = 2;
					turn = 1;
				}
				else if( omok [ p2Y ] [ p2X ] == 1 || omok [ p2Y ][ p2X ] == 2 ) {
					System.out.println("이미 선택된 자리 입니다.");
					continue;
				}
			}
			
			//승리 분간
			
			//가로검사
			//size = 10 -4 = 6
			// 0 0 0 0 0 0 0 0 0 0
			for(int i = 0 ; i < size; i ++) {
				for (int j  = 0 ; j < size- 4; j ++) {
					if( omok [i][j] == 1 && omok [i][j + 1] == 1 && omok [i][j + 2] == 1 && omok [i][j + 3] == 1 && omok [i][j + 4] == 1 ) win = 1;
					if( omok [i][j] == 2 && omok [i][j + 1] == 2 && omok [i][j + 2] == 2 && omok [i][j + 3] == 2 && omok [i][j + 4] == 2 ) win = 2;
				}
			}
			//세로 검사
			//size = 10;
			for (int j =  0 ; j < size ; j++) {
				for(int i = 0; i < size - 4 ; i ++) {
					if( omok [i][j] == 1 && omok [i][j + 1] == 1 && omok [i][j + 2] == 1 && omok [i][j + 3] == 1 && omok [i][j + 4] == 1 ) win = 1;
					if( omok [i][j] == 2 && omok [i][j + 1] == 2 && omok [i][j + 2] == 2 && omok [i][j + 3] == 2 && omok [i][j + 4] == 2 ) win = 2;
				}
			}
			//대각선검사
			for (int i = 0; i < size - 4; i++) {
				for (int j = 0; j < size - 4; j++) {
					if (omok[i][j] == 1 && omok[i + 1][j + 1] == 1 && omok[i + 2][j + 2] == 1 && omok[i + 3][j + 3] == 1 && omok[i + 4][j + 4] == 1)  win = 1;					
					if (omok[i][j] == 2 && omok[i + 1][j + 1] == 2 && omok[i + 2][j + 2] == 2 && omok[i + 3][j + 3] == 2  && omok[i + 4][j + 4] == 2) win = 2;				
				}
			}
			
			for (int i = 9; i > size - 7; i--) {
				for (int j = 0; j < size - 4; j++) {
					if (omok[i][j] == 1 && omok[i - 1][j + 1] == 1 && omok[i - 2][j + 2] == 1 && omok[i - 3][j + 3] == 1 && omok[i - 4][j + 4] == 1) win = 1;
					if (omok[i][j] == 2 && omok[i - 1][j + 1] == 2 && omok[i - 2][j + 2] == 2 && omok[i - 3][j + 3] == 2 && omok[i - 4][j + 4] == 2) win = 2;
				}
			}
				
		}

	}

}
