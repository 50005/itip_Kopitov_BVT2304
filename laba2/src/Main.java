public class Main {
    public static void main(String[] args) {
        AudioBook audioBook1 = new AudioBook("1984", "Джордж Оруэлл", 1949, "12:45", "Иван Иванов");
        Movie movie1 = new Movie("Интерстеллар", "Кристофер Нолан", 2014, "Кристофер Нолан", "2:49");
        Musical musical1 = new Musical("Отверженные", "Виктор Гюго", 2012, "Том Хупер", "2:38", "Клод-Мишель Шёнберг");

        audioBook1.displayInfo();
        movie1.displayInfo();
        musical1.displayInfo();

        System.out.println("Количество созданных аудиокниг: " + AudioBook.getCounter());
    }
}