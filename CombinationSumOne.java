/*
Given An Array And Print All Combinations With The Given Target Sum.
Note: You Can Pick Any Element Any Number Of Times You Want.

Input : Target = 4
        Array  = [1, 2, 4]
Output: [1, 1, 1, 1]
        [1, 1, 2]
        [2, 2]
        [4]
*/

import java.util.Scanner;
import java.util.ArrayList;
class CombinationSumOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        int size = input.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = input.nextInt();
        }
        input.close();
        combinations(0, target, arr, new ArrayList<Integer>());
    }
    static void combinations(int i, int target, int[] arr, ArrayList<Integer> ds) {
        if(i == arr.length){
            if(target == 0){
                System.out.println(ds);
            }
            return;
        }
        if(arr[i] <= target){
            ds.add(arr[i]);
            combinations(i, target-arr[i], arr, ds);
            ds.remove(ds.size()-1);
        }
        combinations(i+1, target, arr, ds);
    }
}
/*
Time Complexity : O(K*2^N)
Space Complexity: O(k*X), Where X = Number Of Combinations.
*/