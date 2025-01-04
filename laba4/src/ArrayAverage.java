public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "four", "5"};
        double sum = 0;
        int count = 0;

        try {
            for (String s : arr) {
                sum += Integer.parseInt(s);
                count++;
            }
            double average = sum / count;
            System.out.println("Среднее арифметическое: " + average);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Не удалось преобразовать строку в число. " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Выход за границы массива. " + e.getMessage());
        } finally {
            System.out.println("Обработка завершена.");
        }
    }
}