// Класс Musical, наследует Movie
class Musical extends Movie {
    private String composer;

    public Musical(String title, String author, int year, String director, String duration, String composer) {
        super(title, author, year, director, duration);
        this.composer = composer;
    }

    @Override
    public void displayInfo() {
        System.out.println("Мюзикл: " + getTitle() + ", Автор: " + getAuthor() + ", Год: " + getYear() + ", Режиссер: " + getDirector() + ", Длительность: " + getDuration() + ", Композитор: " + composer);
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }
}