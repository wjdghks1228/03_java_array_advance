package step3_01.arrayAdvance;

public class ArrayEx34 {

	//2차원 배열 
	public static void main(String[] args) {
		//int [ ] arr = new int [ 4 ]; //4칸 짜리 1차원 배열
		int [ ][ ] arr = new int [ 2 ][ 4 ]; // 2 X 4 배열	
		
		System.out.println("arr[ 0 ]  : " + arr [ 0 ] ); 
		System.out.println("arr[ 1 ]  : " + arr [ 1 ] );
		
		arr [ 0 ][ 0 ] = 10 ;
		arr [ 0 ][ 1 ] = 20 ;
		arr [ 0 ][ 2 ] = 30 ;
		arr [ 0 ][ 3 ] = 40 ;
		
		arr [ 1 ][ 0 ] = 50 ;
		arr [ 1 ][ 1 ] = 60 ;
		arr [ 1 ][ 2 ] = 70 ;
		arr [ 1 ][ 3 ] = 80 ;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("[" + arr[ i ][ j ] + "]" + " ");
			}
			System.out.println();
		}
	}
}
