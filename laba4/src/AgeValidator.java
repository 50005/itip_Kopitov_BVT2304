import java.io.FileWriter;
import java.io.IOException;

class CustomAgeException extends Exception {
    public CustomAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    public static void main(String[] args) {
        int age = -1;

        try {
            validateAge(age);
        } catch (CustomAgeException e) {
            System.out.println("Исключение: " + e.getMessage());
            logException(e);
        }
    }

    public static void validateAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Недопустимый возраст: " + age);
        }
        System.out.println("Возраст допустим: " + age);
    }

    public static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("exceptions.log", true)) {
            writer.write(e.getMessage() + "\n");
        } catch (IOException ioException) {
            System.out.println("Ошибка при записи в файл логов: " + ioException.getMessage());
        }
    }
}