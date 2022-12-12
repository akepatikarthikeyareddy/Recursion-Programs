/*
Problem: Given An Integer N , Generate All Binary Strings Of Size N Which Do Not Contain Consecutive 1s.
Input : 3
Output: [000 , 001 , 010 , 100 , 101]
Note: 011, 110 & 111 Are Not Considered Because They Have Consecutive 1s.
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class BinaryStringsOfLengthN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        input.close();
        System.out.print(generateBinaryStrings(length));
    }
    public static List<String> generateBinaryStrings(int n){
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        generateAllBinaryStrings(str, ans, n);
        return ans;
    }
    static void generateAllBinaryStrings(StringBuilder str, List<String> ans, int n){
        if(str.length() == n){
            ans.add(str.toString());
            return;
        }
        if(str.length() == 0 || str.charAt(str.length()-1) == '0'){
            generateAllBinaryStrings(str.append('0'), ans, n);
            str.deleteCharAt(str.length()-1);
            generateAllBinaryStrings(str.append('1'), ans, n);
            str.deleteCharAt(str.length()-1);
        }
        else{
            generateAllBinaryStrings(str.append('0'), ans, n);
            str.deleteCharAt(str.length()-1);
        }
    }
}
/*
Time Complexity: O(2^N)
Space Complexity: O(N)
*/
