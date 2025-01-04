import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        // Загружаем данные из файла или другого источника (эмуляция данных)
        data = Arrays.asList("data1", "data2", "data3", "data4", "data5");
        System.out.println("Data загрузка: " + data);
    }

    public void processData() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<String> processedData = Collections.synchronizedList(new ArrayList<>());

        for (Object processor : processors) {
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    executor.submit(() -> {
                        try {
                            List<String> result = (List<String>) method.invoke(processor, data);
                            synchronized (processedData) {
                                processedData.addAll(result);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        data = processedData;
        System.out.println("Data обработка: " + data);
    }

    public void saveData(String destination) {
        // Сохранение обработанных данных (эмуляция)
        System.out.println("Data сохранена в " + destination + ": " + data);
    }
}
