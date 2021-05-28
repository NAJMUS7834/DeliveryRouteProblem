package com.getwayssolution.www;

public class Test {
	static int[][] grid = {{1,0,0},{1,0,0},{1,9,1}};
	
	
	public static int minPath(int[][] grid)
	{
		int row = grid.length;
		int col = grid[0].length;
		int destRow = -1;
		int destCol = -1;
		int[][] dp = new int[row][col];
		
		dp[0][0] = grid[0][0];
		
		//fill row
		for(int i = 1; i < col; i++)
		{
			if(grid[0][i] == 0)
			{
				dp[0][i] = 0;
			}
			else
			{
				dp[0][i] = dp[0][i-1] + grid[0][i];
			}
		}
		//fill column
		for(int i = 1; i < row; i++)
		{
			if(grid[i][0] == 0)
			{
				dp[i][0] = 0;
			}
			else
			{
				dp[i][0] = dp[i-1][0] + grid[i][0];
			}
		}
		
		//fill remaining
		for(int i = 1; i< row; i++)
		{
			for(int j = 1; j < col; j++)
			{
				
				if(grid[i][j] == 0)
				{
					dp[i][j] = 0;
				}
				else
				{
					if(dp[i-1][j] !=0 && dp[i][j-1] != 0)
					dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
					else
					{
						if(dp[i-1][j] ==0 && dp[i][j-1] == 0)
							continue;
						if(dp[i-1][j] ==0)
							dp[i][j] = grid[i][j] +dp[i][j-1];
						if(dp[i][j-1] ==0)
							dp[i][j] = grid[i][j] +dp[i-1][j];
					}
				}
				
				if(grid[i][j] == 9)
				{
					destRow = i;
					destCol = j;
					break;
				}
			}
		}
		
		if(destCol < 0)
			return -1;
		
		return (dp[destRow][destCol] - grid[destRow][destCol]);
	}


	public static void main(String[] args) {
		System.out.println(minPath(grid));
	}

}
