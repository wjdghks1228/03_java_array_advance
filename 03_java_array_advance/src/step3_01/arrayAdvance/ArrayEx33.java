package step3_01.arrayAdvance;

import java.util.Arrays;

public class ArrayEx33 {

	//배열의 주소 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//arr 과 temp 서로 LINK 연결
		int [ ] arr  = { 87, 100, 24, 11, 79};
		int [ ] temp = arr;
		
		System.out.println("arr : " + arr);
		System.out.println("temp : " + temp);
		System.out.println();
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(temp));
		System.out.println();
		
		
		//LINK연결 되어 있기 때문에 arr 바꾸든 temp  바꾸든 둘다 같이 바뀐다.
		arr [ 0 ] =  0;
		temp [ 1 ] = 0 ;
		arr [ 2 ] = 0;
		temp [ 3 ] = 0;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(temp));
		System.out.println();
	}

}
