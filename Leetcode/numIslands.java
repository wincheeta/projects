public class numIslands {
    public static void main(String[] args) {
        numIslands a = new numIslands();
        int[][] arr = {
                {1,1,0,0,0,1},
                {1,1,0,0,0,1},
                {1,0,1,0,0,1},
                {1,0,1,1,1,1}};
        System.out.println(a.islands(arr));
    }

    public int islands(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    grid = clearIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public int[][] clearIsland(int[][] grid, int x, int y) {
        if (x < grid.length-1 && grid[x+1][y] == 1) {
            grid[x+1][y] = 0;
            clearIsland(grid, x+1, y);
        } if (y<grid[x].length-1 && grid[x][y+1] == 1) {
            grid[x][y+1] = 0;
            clearIsland(grid, x, y+1);
        } if (x>0 && grid[x-1][y] == 1) {
            grid[x-1][y] = 0;
            clearIsland(grid, x-1, y);
        } if (y>0 && grid[x][y-1] == 1) {
            grid[x][y-1] = 0;
            clearIsland(grid, x, y-1);
        }
        return grid;
    }
}
