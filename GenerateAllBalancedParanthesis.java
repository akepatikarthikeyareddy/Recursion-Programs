/*
Problem: Given An Integer N Representing The Number Of Pairs Of Parentheses, The Task Is To
Generate All Combinations Of Well-Formed(Balanced) Parentheses.

Input : 3
Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
class GenerateAllBalancedParanthesis{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        System.out.print(AllParenthesis(n));
    }
    static public List<String> AllParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        GenerateAllParenthesis(str, ans, n, 0, 0);
        return ans;
    }
    static boolean isValid(StringBuilder str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(stack.empty()){
                stack.push(str.charAt(i));
            }
            else{
                if(stack.peek() == '(' && str.charAt(i) == ')'){
                    stack.pop();
                }
                else{
                    stack.push(str.charAt(i));
                }
            }
        }
        return stack.size() == 0;
    }
    static void GenerateAllParenthesis(StringBuilder str, List<String> ans, int n, int openN, int closeN){
        if(str.length() == 2*n){
            if(isValid(str)){
                ans.add(str.toString());
            }
            return;
        }
        if(openN < n){
            GenerateAllParenthesis(str.append('('), ans, n, openN+1, closeN);
            str.deleteCharAt(str.length()-1);
        }
        if(closeN < n){
            GenerateAllParenthesis(str.append(')'), ans, n, openN, closeN+1);
            str.deleteCharAt(str.length()-1);
        }
    }
}

/*
Time Complexity : O(2^N*N)
Space Complexity: O(2*N)
*/