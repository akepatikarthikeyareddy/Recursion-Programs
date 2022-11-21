/*
Given A Positive Integer N, Generate All Possible Unique Ways To Represent N As Sum Of Positive Integers

Input : 4
Output: [[4], [3, 1], [2, 2], [2, 1, 1], [1, 1, 1, 1]]
*/

import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        System.out.print(UniquePartitions(n));
        
    }
    public static ArrayList<ArrayList<Integer>> UniquePartitions(int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ds = new ArrayList<Integer>();
        int num = n;
        solve(num, 0, n, ds, ans);
        return ans;
    }
    public static void solve(int num, int sum, int target, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans){
        if(num == 0){
            if(sum == target) ans.add(new ArrayList<Integer>(ds));
            return;
        }
        else if(sum > target) return;
        else{
            ds.add(num);
            solve(num, sum+num, target, ds, ans);//Picking And Staying At Same Index
            ds.remove(ds.size()-1);
            solve(num-1, sum, target, ds, ans);//Not Picking And Moving To Next Index
        }
    }
}
/*
Time Complexity : O(2^N)
Space Complexity: (N)
*/

