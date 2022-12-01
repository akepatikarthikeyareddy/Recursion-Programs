/*
Given An Array Print All Possible Subsequences With Target Sum.
Input : arr = [1, 2, 1]
        target = 2
Output: [1, 1]
        [2]
*/

import java.util.ArrayList;
import java.util.Scanner;
class SubsequenceWithSumK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        int size = input.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = input.nextInt();
        }
        input.close();
        SubsequencesOfSumK(0, target, new ArrayList<Integer>(), arr);
    }

    static void SubsequencesOfSumK(int i, int target, ArrayList<Integer> ds, int[] arr) {
        if(i == arr.length){
            if(target == 0){
                System.out.println(ds);
            }
            return;
        }
        ds.add(arr[i]);
        SubsequencesOfSumK(i+1, target-arr[i], ds, arr);
        ds.remove(ds.size()-1);
        SubsequencesOfSumK(i+1, target, ds, arr);
    }
}

/*
Time Complexity : O(N*2^N)
Space Complexity: O(N)
*/