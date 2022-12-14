/* 
Problem: Given A Keypad, And An N Digit Number Which Is Represented By Array Nums[], The Task Is To List All Words Which Are Possible By Pressing These Numbers.

Input : N = 3, Nums[] = {2, 3, 4}
Output: {adg, adh, adi, aeg, aeh, aei, afg, afh, afi, 
        bdg, bdh, bdi, beg, beh, bei, bfg, bfh, bfi, 
        cdg, cdh, cdi, ceg, ceh, cei, cfg, cfh, cfi}
*/

import java.util.Scanner;
import java.util.ArrayList;
public class GenerateAllPossibleKeypadWords {
    static String keypad[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = input.nextInt();
        }
        input.close();
        System.out.print(possibleWords(nums, n));
    }
    static ArrayList <String> possibleWords(int arr[], int n){
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        GenerateAllPossibleWords(str, arr, ans, 0, n);
        return ans;
    }
    static void GenerateAllPossibleWords(StringBuilder str, int arr[], ArrayList<String> ans, int i, int n){
        if(i == n){
            ans.add(str.toString());
            return;
        }
        for(int j = 0; j < keypad[arr[i]].length(); j++){
            str.append(keypad[arr[i]].charAt(j));
            GenerateAllPossibleWords(str, arr, ans, i+1, n);
            str.deleteCharAt(str.length()-1);
        }
    }
}

/*
Time Complexity : O(4^N*N)
Space Complexity: O(N)
*/