package LeetcodePrograms;

import java.util.Arrays;
/**
 * Created by rkhurana on 3/25/19.
 */
public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int n=grid.length;

        int[][][] dp=new int[n+1][n+1][n+1];

        for (int i=0; i<=n; i++)
            for (int j=0; j<=n; j++)
                Arrays.fill(dp[i][j], -1);

        dp[1][1][1]=grid[0][0];

        for (int x1=1; x1<=n; x1++){
            for (int y1=1; y1<=n; y1++){
                for (int x2=1; x2<=n; x2++){
                    int y2 = x1 + y1 - x2;

                    // bounds checks wrt grid
                    if (dp[x1][y1][x2]>=0 || y2<1 || y2>n || grid[x1-1][y1-1]<0 || grid[x2-1][y2-1]<0) continue;

                    // if we consider 2 persons moving from [(x1, y1), (x2, y2)] towards (0, 0)
                    // there next position can be any one of the 4 position pairs
                    // (P1, P2) == [(towards up, towards left), (towards left, towards left), (towards up, towards up), (towards left, towards up)]
                    // we basically choose the position pair which gives us the best combined cherry pickups
                    int max = max(dp[x1-1][y1][x2], dp[x1][y1-1][x2], dp[x1-1][y1][x2-1], dp[x1][y1-1][x2-1]);

                    if (max==-1) continue;

                    // we pick up the cherry in current position
                    dp[x1][y1][x2] = max + grid[x1-1][y1-1];

                    // if the current positions are different for P1, P2, we collect the cherry from both positions
                    if (x2!=x1) dp[x1][y1][x2] += grid[x2-1][y2-1];
                }
            }
        }
        return Math.max(0, dp[n][n][n]);
    }

    int max(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}
