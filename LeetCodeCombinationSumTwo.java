/*
----------Problem Statement----------
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Input : candidates = [10,1,2,7,6,1,5], target = 8
Output: [[1,1,6], [1,2,5], [1,7], [2,6]]
*/
import java.util.*;
class LeetCodeCombinationSumTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int target = input.nextInt();
        int candidates[] = new int[n];
        for(int i = 0; i < n; i++){
            candidates[i] = input.nextInt();
        }
        input.close();
        for(List<Integer> i: combinations(candidates, target)){
            System.out.println(i);
        }
    }
    static List<List<Integer>> combinations(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }
    static void solve(int ind, int target, int array[], ArrayList<Integer> ds, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i = ind; i < array.length; i++){
            if(i > ind && array[i] == array[i-1]) continue;
            if(target < array[i]) break;
            ds.add(array[i]);
            solve(i+1, target-array[i], array, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}
/*
Time Complexity : O(2^N*K)
Space Complexity: O(K*X)
Where, K = Average Length Of Combinations
       X = Total Number Of Combinations
 */