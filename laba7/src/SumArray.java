public class SumArray {

    private static class SumTask extends Thread {
        private int[] array;
        private int start;
        private int end;
        private int result;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                result += array[i];
            }
        }

        public int getResult() {
            return result;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int mid = array.length / 2;

        SumTask task1 = new SumTask(array, 0, mid);
        SumTask task2 = new SumTask(array, mid, array.length);

        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = task1.getResult() + task2.getResult();
        System.out.println("Общая сумма: " + totalSum);
    }
}