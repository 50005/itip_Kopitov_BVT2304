public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataManager dataManager = new DataManager();

        // Регистрация обработчиков данных
        dataManager.registerDataProcessor(new DataFilters());
        dataManager.registerDataProcessor(new DataTransformers());
        dataManager.registerDataProcessor(new DataAggregators());

        // Загрузка, обработка и сохранение данных
        dataManager.loadData("input_source");
        dataManager.processData();
        dataManager.saveData("output_destination");
    }
}
