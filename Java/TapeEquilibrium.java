package codility.exercises.timecomplexity;
import java.util.Arrays;
/*
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
 */
public class TapeEquilibrium {
	
	//O(N) solution: more logically complex solution but time efficient
	public int solution(int[] A) {
		if(A.length==0) {
			return 0;
		}
		if(A.length==1) {
			return A[0];
		}
		
		int[] runningSumFwd = new int[A.length];
		int[] runningSumBwd = new int[A.length];
		
		int sumF = 0;
		int sumB = 0;
		
		for(int i=0; i<A.length;i++) {
			
			sumF += A[i];
			sumB += A[A.length-1-i];
			
			runningSumFwd[i] = sumF;
			runningSumBwd[A.length-i-1] = sumB;			
		}
		
		int minDiff = Math.abs(runningSumFwd[0]-runningSumBwd[1]);
		
		for(int i=0; i<A.length-1; i++) {
			int newDiff = Math.abs(runningSumFwd[i]-runningSumBwd[i+1]);
			if(newDiff < minDiff) {
				minDiff = newDiff;
			}
		}
		
		return minDiff;
	}
	
	private int getAbsDiff(int[] A, int p) {
		int sums[] = new int[2];
		int i;
		for(i=0; i < p; i++) {
			sums[0] += A[i];
		}
		for(i=p; i < A.length; i++) {
			sums[1] += A[i];
		}
		return Math.abs(sums[0]-sums[1]);
	}
	
	//O(N * N) time complexity: simpler solution but time inefficient
	public int solution1(int[] A) {
        // Implement your solution here
		if(A.length==0) {
			return 0;
		}
		if(A.length==1) {
			return A[0];
		}
		
		int sums[] = new int[A.length-1];
		for (int p=1; p < A.length; p++) {
			sums[p-1] = getAbsDiff(A, p);
		}
		
		int minDiff = Arrays.stream(sums).min().getAsInt();
		return minDiff;
    }
	
	//more efficient algorithm needed
	public int solution2(int[] A) {
        // Implement your solution here
		if(A.length==0) {
			return 0;
		}
		if(A.length==1) {
			return A[0];
		}
		
		int sums[] = new int[A.length-1];
		for (int p=1; p < A.length; p++) {
			sums[p-1] = getAbsDiff(A, p);
		}
		
		int minDiff = Arrays.stream(sums).min().getAsInt();
		return minDiff;
    }
	
}
