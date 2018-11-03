package leetcode;


import java.util.PriorityQueue;

/**
 * Created by rkhurana on 6/12/18.
 */


    public class KthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid)
                    j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // Note that it is the kth smallest element in the sorted order, not the kth distinct element.
// Solution : Build a minHeap of elements from the first row.
// Do the following operations k-1 times :
// Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number
// of that element(so we can create a tuple class here), replace that root with the next element from the same column.
// explained it very well https://www.youtube.com/watch?v=zIaMTdBQT34&t=309s
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<leetcode.Tuple> pq = new PriorityQueue<leetcode.Tuple>();
        for(int j = 0; j <= n-1; j++)
            pq.offer(new leetcode.Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            leetcode.Tuple t = pq.poll();
            if(t.x == n-1)
                continue;
            pq.offer(new leetcode.Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }





    public static void main(String[] args)
        {
            KthSmallestElement solution = new KthSmallestElement();

            int [][] matrix = {
                     { 1,  5,  9},
                     {10, 11, 13},
                     {12, 13, 15}
            };

            System.out.println("kth smallest element = "
                    + solution.kthSmallest(matrix,3));

        }

}