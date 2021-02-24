package step3_01.arrayAdvance;

import java.util.Scanner;

//2021_02_24 TIME -> 20 : 19 ~ 20 : 31
/*
 * # 숫자이동[2단계]
 * 
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
 * 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 5. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 */

public class ArrayEx27_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner( System.in );
		
		int[] game = {0,0,1,0,2,0,0,1,0};
		
		//왼쪽 벽 위치
		int leftWall = 2;
		//오른쪽 벽 위치
		int rightWall  = 7 ;
		
		//캐릭터 위치
		int my = 0 ;
		for(int i =  0 ; i < game.length; i++) {
			if( game [ i] == 2 ) {
				my = i ;
				break;
			}
		}
		
		while ( true ) { 
			for(int i = 0 ; i < game.length; i++) {
				if( game [ i ] == 1 ) {
					System.out.print("벽");
				}
				else if ( game [ i ] == 2) {
					System.out.print("옻");
				}
				else if ( game [ i ] == 0 ) {
					System.out.print("_");
				}
			}
			
			System.out.println();
			System.out.println("이동하세요");
			int move = scan.nextInt();
			
			if( move == 1 ) {
				if(my - 1 == leftWall ) {
					System.out.println();
					System.out.println("왼쪽 벽으로 막혀 이동할수 없습니다.");
					System.out.println();
					continue;
				}
				
				game [ my - 1 ] = game [ my ];
				game [ my ] = 0 ;
				
				my -= 1;
			}
			else if ( move == 2 ) {
				if(my + 1 == rightWall ) {
					System.out.println();
					System.out.println("오른쪽 벽으로 막혀 이동할수 없습니다.");
					System.out.println();
					continue;
				}
				
				game [ my + 1 ] = game [ my ];
				game [ my ] = 0 ;
				
				my += 1;
			}
			else if ( move > 2 || move < 1 ) {
				System.out.println();
				System.out.println("이동할수 없습니다.");
				System.out.println();
				continue;
			}
		}
	}
	
}
