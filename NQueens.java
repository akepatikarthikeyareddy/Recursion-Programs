/* 
Problem: N-Queens (Given A Number N, Find The Total Number Of Ways In Which We Can Place N-Queens In
         NxN Chess Board Such That Each Row And Column Contains AtLeast 1 Queen And None Of Them Kills Each Other)
         
Input  : 6
Output : [[2, 4, 6, 1, 3, 5], [3, 6, 2, 5, 1, 4], [4, 1, 5, 2, 6, 3], [5, 3, 1, 6, 4, 2]]
*/

import java.util.*;
class NQueens{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        System.out.print(solveNQueens(n));
    }
    static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> board = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) board.add(0);
        int left[] = new int[n];
        int lowerDiagonal[] = new int[2*n-1];
        int upperDiagonal[] = new int[2*n-1];
        solve(0, n, left, lowerDiagonal, upperDiagonal, board, ans);
        return ans;
    }
    static void solve(int col, int n, int left[], int lowerDiagonal[], int upperDiagonal[], ArrayList<Integer> board, ArrayList<ArrayList<Integer>> ans){
        if(col == n){
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int row = 0; row < n; row++){
            if(left[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[n-1+col-row] == 0){
                board.set(col, row+1);
                left[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[n-1+col-row] = 1;
                solve(col+1, n, left, lowerDiagonal, upperDiagonal, board, ans);
                board.set(col, 0);
                left[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[n-1+col-row] = 0;
            }
        }
    }
}

/*
Time Complexity: O(N!)
Space Complexity: O(N^2)
*/
