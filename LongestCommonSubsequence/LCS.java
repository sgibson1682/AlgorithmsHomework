package lcs;

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;




public class LCS {
	
	private static class Solution{
		String s;
		int row;
		int col;
		
		Solution(String s, int row, int col){
			this.s = s;
			this.row = row;
			this.col = col;
		}
	}
	
    
    /**
     * memoCheck is used to verify the state of your tabulation after
     * performing bottom-up and top-down DP. Make sure to set it after
     * calling either one of topDownLCS or bottomUpLCS to pass the tests!
     */
    public static int[][] memoCheck;
    
    // -----------------------------------------------
    // Shared Helper Methods
    // -----------------------------------------------
    
    // [!] TODO: Add your shared helper methods here!
    

    // -----------------------------------------------
    // Bottom-Up LCS
    // -----------------------------------------------
    
    /**
     * Bottom-up dynamic programming approach to the LCS problem, which
     * solves larger and larger subproblems iterative using a tabular
     * memoization structure.
     * @param rStr The String found along the table's rows
     * @param cStr The String found along the table's cols
     * @return The longest common subsequence between rStr and cStr +
     *         [Side Effect] sets memoCheck to refer to table
     */
    public static Set<String> bottomUpLCS (String rStr, String cStr) {
    	memoCheck = new int[rStr.length() + 1][cStr.length() + 1];
    	
    	int[][] matrix = new int[rStr.length() + 1][cStr.length() + 1];
    	for(int row = 1; row <= rStr.length(); row++) {
    		for(int col = 1; col <= cStr.length(); col++) {
        		if(rStr.charAt(row - 1) == cStr.charAt(col - 1)) {
        			matrix[row][col] = 1 + matrix[row - 1][col - 1];
        			memoCheck[row][col] = matrix[row][col];
        		} else {
        			matrix[row][col] = Math.max(matrix[row - 1][col], matrix[row][col - 1]);
        			memoCheck[row][col] = matrix[row][col];
        		}
        	}
    	}
    	
        return findSolutions(matrix, rStr.length(), cStr.length(), rStr, cStr);
    }
    
    // [!] TODO: Add any bottom-up specific helpers here!
    private static Set<String> findSolutions(int[][] matrix, int row, int col, String rStr, String cStr){
    	Set<String> solutions = new HashSet<String>();
    	Queue<Solution> q = new LinkedList<>();
    	Solution firstSolution = new Solution("", row, col);
    	q.add(firstSolution);
    	while(!q.isEmpty()){
    		Solution sol = q.remove();
    		if (sol.row == 0 || sol.col == 0) {
            	solutions.add(sol.s);
            }
            else if(rStr.charAt(sol.row - 1) == cStr.charAt(sol.col - 1)) {
            	sol.s = cStr.charAt(sol.col - 1) + sol.s;
        		sol.row -= 1;
        		sol.col -= 1;
        		q.add(sol);
        		
        	}
            else if(matrix[sol.row - 1][sol.col] > matrix[sol.row][sol.col - 1]) {
            	sol.row --;
            	q.add(sol);
            }
            else if(matrix[sol.row][sol.col - 1] > matrix[sol.row - 1][sol.col]) {
            	sol.col--;
            	q.add(sol);
            }
    	    else {
    	    	Solution topSolution = new Solution(sol.s, sol.row - 1, sol.col);
    	    	Solution leftSolution = new Solution(sol.s, sol.row, sol.col - 1);
    	    	q.add(topSolution);
    	    	q.add(leftSolution);
    	    }
    	}
    	return solutions;
    }

    // -----------------------------------------------
    // Top-Down LCS
    // -----------------------------------------------
    
    /**
     * Top-down dynamic programming approach to the LCS problem, which
     * solves smaller and smaller subproblems recursively using a tabular
     * memoization structure.
     * @param rStr The String found along the table's rows
     * @param cStr The String found along the table's cols
     * @return The longest common subsequence between rStr and cStr +
     *         [Side Effect] sets memoCheck to refer to table  
     */
//    private static boolean compareLetters(String rStr, String cStr) {
//    	return ()
//    }
    
    public static Set<String> topDownLCS (String rStr, String cStr) {
    	//add another 2d boolean array to be a graveyard instead of checking for 0's when memoizing
    	memoCheck = new int[rStr.length() + 1][cStr.length() + 1];
    	boolean[][] graveyard = new boolean[rStr.length() + 1][cStr.length() + 1];
    	fillTable(memoCheck, graveyard, rStr, cStr, rStr.length(), cStr.length());
    	return findSolutions(memoCheck, rStr.length(), cStr.length(), rStr, cStr);
    	
//    	if(rStr.charAt(rStr.length() - 1) != cStr.charAt(cStr.length() - 1)) {
//    		
//    	}
//    	else if(rStr.charAt(rStr.length() - 1) == cStr.charAt(cStr.length() - 1)) {
//    		
//    	}
    	
//    	Node root = new Node(rStr, cStr);
//    	
//    	if(root.leftString.charAt(rStr.length() - 1) != root.rightString.charAt(cStr.length() - 1)) {
//    		root.leftChild = new Node(root.leftString.substring(0, root.leftString.length() - 1), root.rightString);
//    		root.rightChild = new Node(root.leftString, root.rightString.substring(0, root.rightString.length() - 1));
//    		root.solutions = topDownLCS(root.leftChild.leftString, root.leftChild.rightString);
//    		root.solutions.addAll(topDownLCS(root.rightChild.leftString, root.rightChild.rightString));
//    	}
//    	if(root.leftString.charAt(rStr.length() - 1) == root.rightString.charAt(cStr.length() - 1)) {
//    		
//    	}
//        return root.solutions;
    }
    
    public static int fillTable(int[][] matrix, boolean[][] graveyard, String rStr, String cStr, int row, int col) {
    	
    	if(graveyard[row][col]) {
    		return matrix[row][col];
    	}
    	else {
    		graveyard[row][col] = true;
    		if(row == 0 || col == 0) {
        		return 0;
        	}
        	else if(rStr.charAt(row - 1) != cStr.charAt(col - 1)) {
        		matrix[row][col] = Math.max(fillTable(matrix, graveyard, rStr, cStr, row - 1, col), fillTable(matrix, graveyard, rStr, cStr, row, col - 1));
        		return matrix[row][col];
        		
        	}
        	else { //if(rStr.charAt(row) == cStr.charAt(col))
        		matrix[row][col] = 1 + fillTable(matrix, graveyard, rStr, cStr, row - 1, col - 1);
        		
        		return matrix[row][col];
        	}
    	}
    	
    }
    
    // [!] TODO: Add any top-down specific helpers here!
    
    
}
