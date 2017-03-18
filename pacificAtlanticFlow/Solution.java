public class Solution {
    public static final int[] dx = {-1,1,0,0};
    public static final int[] dy = {0,0,-1,1};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> answerList = new ArrayList<int[]>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)return answerList;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            pacific[i][0] = true;
            atlantic[i][n-1] = true;
        }
        
        for(int j=0;j<n;j++){
            pacific[0][j] = true;
            atlantic[m-1][j] = true;
        }
        
        for(int i=0;i<m;i++){
            explore(pacific,matrix,i,0,m,n);
            explore(atlantic,matrix,i,n-1,m,n);
        }
        
        for(int j=0;j<n;j++){
            explore(pacific,matrix,0,j,m,n);
            explore(atlantic,matrix,m-1,j,m,n);
        }
        
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    answerList.add(new int[]{i,j});
                }
            }
        }
        return answerList;
    }
    
    public void explore(boolean[][] grid, int[][] matrix, int i, int j, int m, int n){
        grid[i][j] = true;
        for(int k=0;k<4;k++){
            int x = i+dx[k]; int y = j+dy[k];
            if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && !grid[x][y] && matrix[x][y] >= matrix[i][j])
                explore(grid,matrix,x,y,m,n);
        }
    }

}