import java.util.ArrayList;
import java.util.List;

class Product {
    private final String name;
    private final int weight;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " (" + weight + " кг)";
    }
}

class Warehouse {
    private static final int MAX_WEIGHT = 150;
    private int currentWeight = 0;
    private final List<Product> products = new ArrayList<>();

    public synchronized void loadProduct(Product product) throws InterruptedException {
        while (currentWeight + product.getWeight() > MAX_WEIGHT) {
            System.out.println("Недостаточно места для " + product );
            wait();
        }
        currentWeight += product.getWeight();
        products.add(product);
        System.out.println("Грузчик загрузил: " + product + ". Текущий вес: " + currentWeight + " кг.");
        if (currentWeight == MAX_WEIGHT) {
            unloadProducts();
        }
        notifyAll();
    }

    private void unloadProducts() {
        System.out.println("Склад полностью загружен. Грузчики отправляются на разгрузку: " + products);
        currentWeight = 0;
        products.clear();
        notifyAll();
    }
}

class Loader extends Thread {
    private final Warehouse warehouse;
    private final List<Product> cargo;

    public Loader(Warehouse warehouse, List<Product> cargo) {
        this.warehouse = warehouse;
        this.cargo = cargo;
    }

    @Override
    public void run() {
        try {
            for (Product product : cargo) {
                warehouse.loadProduct(product);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        List<Product> allCargo = List.of(
                new Product("Товар1", 60),
                new Product("Товар2", 50),
                new Product("Товар3", 30),
                new Product("Товар4", 40),
                new Product("Товар5", 70),
                new Product("Товар6", 20),
                new Product("Товар7", 90)
        );

        Loader loader1 = new Loader(warehouse, allCargo.subList(0, 2));
        Loader loader2 = new Loader(warehouse, allCargo.subList(2, 5));
        Loader loader3 = new Loader(warehouse, allCargo.subList(5, 7));

        loader1.start();
        loader2.start();
        loader3.start();

        try {
            loader1.join();
            loader2.join();
            loader3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}