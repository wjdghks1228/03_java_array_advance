package step3_01.arrayAdvance;

import java.util.Random;
import java.util.Scanner;

// # 소코반

public class ArrayEx43_문제 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		final int SIZE = 7;
		final int PLAYER = 2;
		final int BALL = 3;
		final int GOAL = 7;
		final int WALL = 9;

		int[][] map = new int[SIZE][SIZE];

		int wallCount = 0;
		int playerY = 0;
		int playerX = 0;
		int ballY = 0;
		int ballX = 0;
		int goalY = 0;
		int goalX = 0;
		
		//move
		int move;
		//END
		int end = 0;
		
		//rand Y,X
		int randY;
		int randX;

		// 벽 설치
		System.out.print(">>>설치할 벽의 개수를 입력하세요 : ");
		wallCount = scan.nextInt();

		// 벽설치
		int wall = wallCount;
		while (wall != 0) {
			randY = rand.nextInt(SIZE);
			randX = rand.nextInt(SIZE);
			
			if( map[randY][randX] == 0 ) {
				map[randY][randX] = 9;
				wall --;
			}
		}
		
		//공설치
		while ( true ) {
			randY = rand.nextInt(SIZE);
			randX = rand.nextInt(SIZE);
			if( map [randY][randX] == 0 ) {
				map [randY][randX] = 3;
				ballY = randY;
				ballX = randX;
				break;
			}
		}
		
		//골 설치
		while ( true ) {
			randY = rand.nextInt(SIZE);
			randX = rand.nextInt(SIZE);
			if( map [randY][randX] == 0 ) {
				map [randY][randX] = 7;
				goalY = randY;
				goalX = randX;
				break;
			}
		}
		
		//player 설치
		while( true ) {
			
			System.out.println("SELECT PLAYER Y : ");
			randY = scan.nextInt();
			System.out.println("SELECT PLAYER X : ");
			randX = scan.nextInt();
			
			if( map [ randY ][randX ] == 0) {
				map [ randY ][ randX ] = 2	;
				playerY = randY;
				playerX = randX;
				break;
			}
		}
		
		for(int i = 0 ; i < SIZE ; i ++) {
			for(int j = 0 ; j < SIZE ; j++) {
				System.out.print(map [ i ][ j ] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("**********************************GAME START**************************************");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println();
		while ( true ) {
			if( end == 1)	break;
			//맵 출력
			for (int i = 0 ; i < SIZE ; i++ ) {
				for (int j = 0 ; j < SIZE; j++) {
					if( map [i][j] == 3) {
						System.out.print("B ");
					}
					else if ( map[i][j] ==7 ) {
						System.out.print("G ");
					}
					else if ( map[i][j] == 9) {
						System.out.print("! ");
					}
					else if ( map[i][j] == 2) {
						System.out.print("# ");
					}
					else System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();

			//PLAYER 이동
			System.out.println("        상(5)          ");
			System.out.println("좌(1)           우(3)  ");
			System.out.println("        하(2)          ");
			System.out.println("이동을 입력해주세요 : ");
			move = scan.nextInt();
			
			// player = 2	ball = 3	goal = 7 	wall = 9
			
			//UP
			if( move == 5 ) {
				//벽 or 맵 범위밖 이동불가
				if( (playerY - 1) < 0 || map[playerY - 1][playerX] == 9 ) {
					continue;
				}
				//ball 일 경우
				else if ( map [playerY - 1][playerX] == 3	) {
					//볼 밀었을때 맵 밖일때
					if ( (playerY - 2) < 0 || map[playerY - 2][playerX] == 9  ) {
						continue;
					}
					else if((map [playerY - 2][playerX]) == 7	) {
						System.out.println("게임종료");
						end = 1;
						break;
					}
					//ball 값 변경
					if( map[playerY - 1 ][playerX] == 3) {
						map[playerY-2][playerX] = 3;
					}
					map[playerY  ][playerX] = 0;
					map[playerY-1][playerX] = 2;
					
					continue;
				}
			}
			
			//DOWN
			else if( move == 2) {
				//벽 or 맵 범위밖 이동불가
				if( (playerY + 1) > 6 || map[playerY + 1][playerX] == 9 ) {
					continue;
				}
				//ball 일 경우
				else if ( map [playerY+1][playerX] == 3	) {
					//볼 밀었을때 맵 밖일때
					if ( (playerY + 2) > 6 || map[playerY + 2][playerX] == 9  ) {
						continue;
					}
					else if((map [ playerY + 2 ][playerX]) == 7	) {
						System.out.println("게임종료");
						end = 1;
						break;
					}
					//ball 값 변경
					map[playerY][playerX] = 0;
					map[playerY+1][playerX] = 2;
					map[playerY+2][playerX] = 3;
					ballY = playerY + 2;
					continue;
				}
			}
			
			//LEFT
			else if ( move == 1 ) {
				if( (playerX - 1) < 0 || map[playerY ][playerX - 1] == 9 ) {
					continue;
				}
				//ball 일 경우
				else if ( map [playerY][playerX-1] == 3	) {
					//볼 밀었을때 맵 밖일때
					if ( (playerX - 2) < 0 || map[playerY][playerX - 2] == 9  ) {
						continue;
					}
					else if((map[playerY][playerX - 2]) == 7	) {
						System.out.println("게임종료");
						end = 1;
						break;
					}
					//ball 값 변경
					map[playerY][playerX] = 0;
					map[playerY][playerX-1] = 2;
					map[playerY][playerX-2] = 3;
					ballX = playerX - 2;
					continue;
				}
			}
			//RIGHT
			else if ( move == 3) {
				if( (playerX + 1) > 6 || map[playerY ][playerX + 1] == 9 ) {
					continue;
				}
				//ball 일 경우
				else if ( map [playerY][playerX+1] == 3	) {
					//볼 밀었을때 맵 밖일때
					if ( (playerX + 2) > 6 || map[playerY][playerX + 2] == 9  ) {
						continue;
					}
					else if((map[playerY][playerX + 2]) == 7	) {
						System.out.println("게임종료");
						end = 1;
						break;
					}
					//ball 값 변경
					map[playerY][playerX] = 0;
					map[playerY][playerX+1] = 2;
					map[playerY][playerX+2] = 3;
					ballX = playerX + 2;
					continue;
				}
			}
		}
		

	}
}
