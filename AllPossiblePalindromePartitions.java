/*
Problem: Given A String S, Find All Possible Palindromic Partitions Of The Given String.
Input : inputString = "madam"
Output: [["m", "a", "d", "a", "m"], ["m", "ada", "m"], ["madam"]]
*/

import java.util.Scanner;
import java.util.ArrayList;
public class AllPossiblePalindromePartitions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.next();
        input.close();
        System.out.print(allPalindromicPartitions(inputString));
    }
    static ArrayList<ArrayList<String>> allPalindromicPartitions(String s) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> ds = new ArrayList<>();
        solve(0, s, ds, ans);
        return ans;
    }
    static void solve(int index, String s, ArrayList<String> ds, ArrayList<ArrayList<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                ds.add(s.substring(index, i+1));
                solve(i+1, s, ds, ans);
                ds.remove(ds.size()-1);
            }
        }
    }
    static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}

/*
Time Complexity: O(N*2^N)
Auxiliary Space: O(N)
*/
