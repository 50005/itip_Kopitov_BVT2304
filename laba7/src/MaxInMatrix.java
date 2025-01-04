import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxInMatrix {

    private static class MaxTask implements Callable<Integer> {
        private int[][] matrix;
        private int startRow;
        private int endRow;

        public MaxTask(int[][] matrix, int startRow, int endRow) {
            this.matrix = matrix;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        public Integer call() {
            int max = Integer.MIN_VALUE;
            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(new MaxTask(matrix, 0, 2));
        Future<Integer> future2 = executor.submit(new MaxTask(matrix, 2, 4));

        int max1 = future1.get();
        int max2 = future2.get();

        int finalMax = Math.max(max1, max2);
        executor.shutdown();

        System.out.println("Максимальный элемент: " + finalMax);
    }
}