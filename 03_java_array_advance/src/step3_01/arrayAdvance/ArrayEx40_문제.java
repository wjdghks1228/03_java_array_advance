package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * # 배열 컨트롤러[2단계] : 벡터(Vector)
 * 
 * 1. 추가
 * . 값을 입력받아 순차적으로 추가
 * 2. 삭제(인덱스)
 * . 인덱스를 입력받아 해당 위치의 값 삭제
 * 3. 삭제(값)
 * . 값을 입력받아 삭제
 * . 없는 값 입력 시 예외처리
 * 4. 삽입
 * . 인덱스와 값을 입력받아 삽입
 * 
 */



public class ArrayEx40_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] scores = null;
		int elementCnt = 0;
		
		//scores 백업 배열
		int temp [  ] = null;
		
		//sel(3) : 삭제값 확인 카운트변수
		int valueCheck = 0 ;
		//sel(3) : 해당삭제값 인덱스 변수
		int delValueIndex = 0;
		
		//sel(4) : 삽입할 인덱스 변수
		int insertIndex = 0;
		//sel(4) : insertTempCnt
		int insertTempCnt = 0 ;
		
		
		
		while(true) {
			
			System.out.println();
			System.out.println();
			
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			
			int sel = scan.nextInt();
			//추가   값을 입력받아 순차적으로 추가
			if		(sel == 1) {
				//애니메이션
				System.out.println("-----------------------------------------------");
				System.out.println("                      추가                     ");
				System.out.println("-----------------------------------------------");
				
				System.out.println();
				//새값 추가 
				System.out.println("값을 입력하세요 : ");
				int newScore = scan.nextInt();
				System.out.println("입력하신 값 : " + newScore);

				//scores 배열 크기 0 일때
				if( elementCnt == 0 ) {
					scores = new int [ elementCnt + 1 ];
					scores [ elementCnt ] = newScore;
					elementCnt++;
					System.out.println();
					System.out.println("추가완료");
					System.out.println(Arrays.toString(scores));
					System.out.println();
				}
				else if ( elementCnt > 0 ) {
					temp  =  new int [ elementCnt ];
					temp = scores;
					//scores 크기 1 증가
					scores = new int [ elementCnt + 1 ];
					//기존 백업 파일 복구
					for(int i = 0 ; i < elementCnt; i++) {
						scores [ i ] = temp [ i ];
					}
					//scores 등록
					scores[ elementCnt ] = newScore;
					elementCnt++;
					//temp 초기화
					temp = null;
					System.out.println();
					System.out.println("추가완료");
					System.out.println(Arrays.toString(scores));
					System.out.println();
				}
				
			}
			//2. 삭제(인덱스)   인덱스를 입력받아 해당 위치의 값 삭제
			else if (sel == 2) {
				//현재 값이 있는 인덱스들 출력
				System.out.println();
				System.out.println("----------------------------------------------------");
				System.out.println("[ 현재 값이 존재하는 인덱스 ]");
				for(int i = 0 ; i < elementCnt; i++) {
					System.out.print( i + " ");
				}
				System.out.println();
				System.out.println("----------------------------------------------------");
				System.out.println("인덱스를 입력하세요 : ");
				int delIndex = scan.nextInt();
				System.out.println("입력하신 인덱스 : " + delIndex );
				
				//해당 인덱스에 값이 있는지 확인
				if ( delIndex > elementCnt) {
					System.out.println("해당 인덱스에 값이 없습니다 . ");
					continue;
				}
				else { 
					//해당인덱스 삭제
					scores [ delIndex ]  = 0 ;
					//5                      : elementCnt
					//0  1  2  3  4          : index
					//10 20 30 40 50         : value
					//정렬
					for( int i = delIndex ; i < elementCnt - 1; i ++) {
						scores [ i ] = scores [ i + 1 ];
					}
					
					//배열 정렬
					temp = scores;                //백업
					elementCnt -- ;
					scores = new int [ elementCnt ];
					for(int i =  0 ; i < temp.length - 1 ; i++) {
						scores [ i  ] = temp [ i ];
					}
					
					
					System.out.println();
					System.out.println("삭제완료");
					System.out.println(Arrays.toString(scores));
					System.out.println();
					
					temp = null;
				}
			}
//			3. 삭제(값)
//			 * . 값을 입력받아 삭제
//			 * . 없는 값 입력 시 예외처리
			else if (sel == 3) {
				System.out.println();
				System.out.println("----------------------------------------------------------");
				System.out.println("-------------------------삭제-----------------------------");
				System.out.println("----------------------------------------------------------");
				System.out.println();

				//삭제값 받기
				System.out.println("삭제하실 값을 입력하세요 : ");
				int delValue  = scan.nextInt();
				System.out.println("입력하신 삭제값 : " + delValue);
				
				
				//없는값 확인
				for( int i = 0 ; i < scores.length; i++) {
					if( scores [ i ] == delValue ) {
						valueCheck ++;
						delValueIndex = i;
					}
				}
				if(valueCheck == 0 ) {
					System.out.println();
					System.out.println("입력하신 삭제값을 찾을수 없습니다.");
					continue;
				}
				else {
					valueCheck = 0;

					scores [ delValueIndex ] = 0 ;
					for (int i  = delValueIndex ; i < elementCnt - 1 ; i ++ ) {
						scores [ i ] = scores [ i + 1 ];
					}
					//temp 에 복원
					temp = scores;
					elementCnt --;
					scores = new int [ elementCnt ];
					for(int i = 0 ; i < elementCnt; i++ ) {
						scores [ i ] = temp [ i ] ;
					}
					
					System.out.println();
					System.out.println("삭제완료");
					System.out.println(Arrays.toString(scores));
					System.out.println();
					
					temp = null;
				}
			}
//			 * 4. 삽입
//			 * . 인덱스와 값을 입력받아 삽입
//			 * 
			else if (sel == 4) {
				System.out.println();
				System.out.println("----------------------------------------------------------");
				System.out.println("*************************삽입*****************************");
				System.out.println("----------------------------------------------------------");
				System.out.println();
				
				System.out.println("삽입하실 인덱스 위치를 입력하세요 : ");
				System.out.println("[ 현재 삽입가능한 인덱스 ]");
				for(int i = 0 ;  i < elementCnt ; i++ ) {
					System.out.print( i + " " );
				}
				System.out.println();
				insertIndex = scan.nextInt();
				System.out.println("삽입할 값을 입력하세요 : ");
				int insertValue = scan.nextInt();
				System.out.println("[ " + insertIndex + " 번 인덱스 ] 에 " + "[ " + insertValue + " ] 를 삽입합니다.");
				System.out.println();
				
				//temp 에 복원
				temp  = scores;
				//배열크기 1 증가
				elementCnt ++;
				//score새로 생성
				scores = new int [ elementCnt ];
				
				//삽입
				//6                        : elementCnt
				//         3	     	   : insertIndex
				//0  1  2  3  4  5         : scores index
				//10 20 30 40 50           : value
				
				for(int i = 0 ; i < elementCnt ; i++ ) {
					if(i == insertIndex ) {
						scores[ i ]  =  insertValue;
						continue;
					}
					scores[ i ] = temp [ insertTempCnt ++ ];
				}
				insertTempCnt = 0;
				
				System.out.println();
				System.out.println("삽입완료");
				System.out.println(Arrays.toString(scores));
				
				temp = null;
				
			}
			else if (sel == 0) {
				break;
			}
		}



	}

}
