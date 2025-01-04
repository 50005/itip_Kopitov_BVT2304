// Класс AudioBook, наследует Book
class AudioBook extends Book {
    private static int counter = 0;
    private String duration;
    private String narrator;

    public AudioBook(String title, String author, int year, String duration, String narrator) {
        super(title, author, year);
        this.duration = duration;
        this.narrator = narrator;
        counter++;
    }

    @Override
    public void displayInfo() {
        System.out.println("Аудиокнига: " + getTitle() + ", Автор: " + getAuthor() + ", Год: " + getYear() +
                ", Длительность: " + duration + ", Читает: " + narrator);
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public static int getCounter() {
        return counter;
    }
}