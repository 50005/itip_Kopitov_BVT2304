import java.util.List;
import java.util.stream.Collectors;

public class DataFilters {
    @DataProcessor(description = "Filter short data strings")
    public List<String> filterShortData(List<String> data) {
        return data.stream()
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList());
    }
}
