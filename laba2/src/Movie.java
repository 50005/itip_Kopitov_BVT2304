// Класс Movie, наследует Book
class Movie extends Book {
    private String director;
    private String duration;

    public Movie(String title, String author, int year, String director, String duration) {
        super(title, author, year);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public void displayInfo() {
        System.out.println("Фильм: " + getTitle() + ", Автор: " + getAuthor() + ", Год: " + getYear() + ", Режиссер: " + director + ", Длительность: " + duration);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}