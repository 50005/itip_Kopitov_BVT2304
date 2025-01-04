import java.util.List;
import java.util.stream.Collectors;

public class DataTransformers {
    @DataProcessor(description = "Transform data to uppercase")
    public List<String> transformToUpperCase(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
