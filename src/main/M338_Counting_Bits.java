package main;

import java.util.ArrayList;

public class M338_Counting_Bits {
	
	/**
	 * [1]
	 * 20170216
	 * Yangdi
	 * Accepted
	 * O(n*sizeof(integer))
	 */
	 public static int[] countBits_1(int num) {
		 int[] results = new int[num+1];
		 for(int i=0; i<=num; i++){
			 results[i] = getOnesNumOfBinary(i);
		 }		 
		 
		 return results;
		 
	 }
	 public static int getOnesNumOfBinary(int decimal){
		 int count = 0;
		 while(decimal!=0){
			 if((decimal%2) == 1)
				 count++;
			 decimal = decimal/2;
		 }
		 return count;
	 }
	 
	 /**
	 * [2]
	 * 20170216
	 * Yangdi
	 * Accepted
	 * O(n)
	  */
	 public static int[] countBits(int num) {
		 int[] results = new int[num+1];
		 results[0] = 0;
		 for(int i=1; i<=num; i++){
			 //如果是偶数，则为偶数/2后那个数的1的个数值
			 if(i%2 == 0)
				 results[i] = results[i/2];
			 else //为奇数，则为前一个数的1个数+1
				 results[i] = results[i-1]+1;
			 
		 }		 
		 
		 return results;
		 
	 }
	
	 /**
	  * 
	  * Copy from LeetCode
	  * 同[1]
	  * 
	  */
	public static int[] countBits_(int num) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i <= num; i++) {
			int tmp = getCount(i);
			result.add(tmp);
		}

		return arrayListToArray(result);
	}

	public static int[] arrayListToArray(ArrayList<Integer> list) {
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	public static int getCount(int num) {
		int count = 0;
		int shang = num;
		int residue = num;
		while (shang != 1 && shang != 0) {
			residue = shang % 2;
			shang = shang / 2;

			if (residue == 1) {
				count++;
			}
		}
		if (shang != 0) {
			count++;
		}

		return count;
	}
}
