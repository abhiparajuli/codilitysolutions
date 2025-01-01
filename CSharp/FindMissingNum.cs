/*
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
*/

using System;
// you can also use other imports, for example:
using System.Collections.Generic;

// you can write to stdout for debugging purposes, e.g.
// Console.WriteLine("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int N = A.Length;
        if(N<=0)
            return 1;

        int[] B = new int[N+1];

        for (int i=0; i<N; i++){
            B[A[i]-1] = A[i];            
        }

        for (int i=0; i < N+1; i++){
            //Console.Write($"{B[i]}, ");
            if(B[i] < 1 || B[i] > N+1){
                return i+1;
            }
        }

        throw(new Exception("Failed to find the missing number"));

    }
}