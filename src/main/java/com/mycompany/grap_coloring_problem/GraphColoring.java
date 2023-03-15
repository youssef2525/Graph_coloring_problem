package com.mycompany.grap_coloring_problem;

public class GraphColoring {
    
    private static int[][] dp;
    

    
    int solve(int v, int mask, int n, int[][] adj) {
        
        // base case
        if (v == n+1) {
            return 0;
        }
        
        // check if we have already computed the answer for this subproblem
        if (dp[v][mask] != -1) {
            return dp[v][mask];
        }
        
        // try all possible colors for the current vertex
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if ((mask & (1 << (i-1))) == 0) {
                // if the i-th color is not used in the neighboring vertices
                boolean ok = true;
                for (int j = 1; j <= n; j++) {
                    if (adj[v][j] == 1 && (mask & (1 << (j-1))) != 0 && i == dp[j][mask^(1<<(j-1))]) {
                        // if the j-th vertex is adjacent to the current vertex and has the same color as i
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    res = Math.min(res, 1 + solve(v+1, mask|(1<<(i-1)), n, adj));
                }
            }
        }
        
        // save the answer for this subproblem in the dp array
        dp[v][mask] = res;
        return res;
       }
}
