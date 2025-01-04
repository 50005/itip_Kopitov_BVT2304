import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourcePath = "soujghhce.txt";
        String destinationPath = "destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Копирование завершено.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка: Проблема с чтением или записью файла. " + e.getMessage());
        }
    }
}