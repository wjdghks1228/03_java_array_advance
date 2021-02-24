package step3_01.arrayAdvance;

/*
 * # 석차 출력
 * 
 * . 성적 순으로 이름 출력
 */

public class ArrayEx32_정답예시 {
	public static void main(String[] args) {


		String[] names  = {"홍길동", "김영", "자바킹", "민병철", "메가맨"};
		int[] scores    = {    87,    42,    100,     11,     98};
		int maxScore    = 0;
		int maxIdx      = 0;
		int scoreTemp   = 0;
		String nameTemp = "";
		
		for (int i=0; i<5; i++) {
			
			maxScore = scores[i];
			maxIdx = i;
			
			for (int j=i; j<5; j++) {
				if (maxScore < scores[j]) {
					maxScore = scores[j];
					maxIdx = j;
				}
			}
			
			scoreTemp = scores[i];
			scores[i] = scores[maxIdx];
			scores[maxIdx] = scoreTemp;
			
			nameTemp = names[i];
			names[i] = names[maxIdx];
			names[maxIdx] = nameTemp;
			
		}
		
		for (int i=0; i<5; i++) {
			System.out.println(names[i] + " : " + scores[i]);
		}
		
	}

}
