package step3_01.arrayAdvance;
//2021_02_24 TIME --> 20 : 36 ~ 20 : 

import java.util.Arrays;
import java.util.Random;

/*
 * # 숫자 야구 게임
 * 
 * 1. me에 1~9 사이의 숫자 3개를 저장
 *    (단, 중복되는 숫자는 저장 불가)
 * 2. com과 me를 비교해 정답을 맞출 때까지 반복
 * 3. 숫자와 자리가 같으면 		    strike += 1
 *    숫자만 같고 자리가 틀리면 	ball += 1
 * 예)
 * 정답 : 1 7 3
 * 3 1 5		: 2b
 * 7 5 1        : 1b
 * 1 5 6		: 1s
 * 1 7 3        : 1s 2b
 * 2 4 9        : 없음
 * 1 7 3        : 3s  > 게임종료
 * 
 */

public class ArrayEx29_문제 {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int[] com = {1,7,3};
		int[] me  = new int[3];
		
		int randNum ;
		int inputCnt = 0 ; 				//랜덤숫자 넣을때 카운트변수
		int log =  0;  					//랜덤숫자 초기상태 : 0
										//		   이후상태 : 1
			
		//게임시작
		while( true ) {
		
			//랜덤 me 생성
			if(log == 0) {
				randNum = rand.nextInt(9)+1;
				me[inputCnt] = randNum;
				log++;
				inputCnt++;
				continue;
			}
			else if(log == 1) {
				if(inputCnt == 3) {
					log = 0;
					inputCnt = 0;
					break;
				}
				randNum = rand.nextInt(9)+1;
				//중복숫자 검사
				for(int i = 0; i < 3; i++) {
					if(me[i] == randNum) {
						log = -1;
						continue;
					}
				}
				if(log == -1) {
					log = 1;
					continue;
				}
				me[inputCnt] = randNum;
				inputCnt++;
			}
			int threeCount = 0;
			int strike = 0;
			int ball = 0;
			while(true) {
				if(threeCount == 3) {
					if(strike == 3) {
						break;
					}
					threeCount = 0;
					strike = 0;
					ball = 0;
					break;
				}
				if(me[threeCount] == com[threeCount]) {
					strike++;
					threeCount++;
				}
				else if(me[threeCount] != com[threeCount]) {
					ball++;
					threeCount++;
				}
				
				System.out.print(strike + ball);
				System.out.println();
			}
		}
		
	}
}
