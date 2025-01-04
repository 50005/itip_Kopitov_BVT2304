import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SalesTracker {
    private Set<Product> soldProducts;
    private Map<String, Integer> productSalesCount;

    public SalesTracker() {
        soldProducts = new HashSet<>();
        productSalesCount = new HashMap<>();
    }

    public void addSoldProduct(Product product) {
        soldProducts.add(product);
        productSalesCount.put(product.getName(), productSalesCount.getOrDefault(product.getName(), 0) + 1);
    }

    public void displaySoldProducts() {
        System.out.println("Список проданных товаров:");
        for (Product product : soldProducts) {
            System.out.println(product);
        }
    }

    public double calculateTotalSales() {
        double total = 0;
        for (Product product : soldProducts) {
            total += product.getPrice();
        }
        return total;
    }

    public String getMostPopularProduct() {
        String mostPopular = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : productSalesCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        tracker.addSoldProduct(new Product("Товар A", 10.99));
        tracker.addSoldProduct(new Product("Товар B", 5.49));
        tracker.addSoldProduct(new Product("Товар A", 10.99));
        tracker.addSoldProduct(new Product("Товар C", 7.29));

        tracker.displaySoldProducts();

        double totalSales = tracker.calculateTotalSales();
        System.out.println("Общая сумма продаж: $" + totalSales);

        String mostPopular = tracker.getMostPopularProduct();
        System.out.println("Наиболее популярный товар: " + mostPopular);
    }
}
