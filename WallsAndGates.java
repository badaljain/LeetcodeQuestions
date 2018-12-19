package LeetcodePrograms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rkhurana on 11/13/18.
 */

    class Grid {
        int x;
        int y;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
public class WallsAndGates {
        public void wallsAndGates(int[][] rooms) {

            if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
                return;
            }
   //         int[][] diffs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            Queue<Grid> queue = new LinkedList<>();
            for (int i = 0; i < rooms.length; i++)
                for (int j = 0; j < rooms[0].length; j++)
                    if (rooms[i][j] == 0)
                        queue.add(new Grid(i, j));

                while (queue.size() != 0) {
                    Grid cur = queue.poll();
                    int x = cur.x;
                    int y = cur.y;
                    for (int i = 0; i < 4; i++)
                        addToQueue(x + move[i][0], y + move[i][1], rooms, queue, rooms[x][y] + 1);

                }
                return ;
            }
        private void addToQueue(int x, int y, int[][] rooms, Queue<Grid> queue, int steps) {
            if (x < 0 || x >= rooms.length || y < 0 && y >= rooms[0].length
                    || rooms[x][y] != Integer.MAX_VALUE || rooms[x][y] == -1)
                return;
            rooms[x][y] = steps;
            queue.offer(new Grid(x, y));

        }

    public int[][] getDistanceMatrix(int[][] maze) {

        int n = maze.length;
        int m = maze[0].length;

        for(int i =0; i<n; i++) {
            for(int j=0; i<m; j++) {
                if(maze[i][j] == -1)
                    setDistance(maze, i,j+1,1);
                setDistance(maze, i+1,j,1);
                setDistance(maze, i-1,j,1);
                setDistance(maze, i,j-1,1);
            }
        }

        return maze;
    }

    private void setDistance(int[][] maze, int i, int j, int distance) {
        if(i >= maze.length || i < 0)
            return;

        if(j >= maze[0].length || j < 0)
            return;

        int currVal = maze[i][j];
//		int currDist = 0;
        int minDistace;

        if(currVal == -2 || currVal == -1)
            return;

//		if(currVal == 0)
//			currDist = 0;
//		else currDist = Integer.parseInt(currVal);

        minDistace = Math.min(currVal, distance);

        maze[i][j] = minDistace;

        setDistance(maze, i,j+1,minDistace +1);
        setDistance(maze, i+1,j,minDistace +1);
        setDistance(maze, i-1,j,minDistace +1);
        setDistance(maze, i,j-1,minDistace +1);
    }

    public static void main(String []args ){
        WallsAndGates w = new WallsAndGates();
        int [][]rooms={
            {Integer.MAX_VALUE , -1 , 0 , Integer.MAX_VALUE},
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
            {Integer.MAX_VALUE , -1 , Integer.MAX_VALUE , -1},
            {0,-1, Integer.MAX_VALUE,Integer.MAX_VALUE}
        };
        w.wallsAndGates(rooms);
    }

}
