/*
Given An Array Print All Possible Subsequences.
Input: arr = [1, 2, 3]
Output: [1, 2, 3]
        [1, 2]
        [1, 3]
        [1]
        [2, 3]
        [2]
        [3]
        []
*/
import java.util.ArrayList;
import java.util.Scanner;
class PrintAllSubsequences{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        input.close();
        Subsequences(0, new ArrayList<Integer>(), arr);
    }

    static void Subsequences(int i, ArrayList<Integer> ds, int[] arr) {
        if(i == arr.length){
            System.out.println(ds);
            return;
        }
        ds.add(arr[i]);
        Subsequences(i+1 , ds, arr);
        ds.remove(ds.size()-1);
        Subsequences(i+1 , ds, arr);
    }
}
/*
Time Complexity : O(N*2^N)
Space Complexity: O(N)
*/