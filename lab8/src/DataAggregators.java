import java.util.List;
import java.util.Collections;

public class DataAggregators {
    @DataProcessor(description = "Aggregate data as single string")
    public List<String> aggregateData(List<String> data) {
        String result = String.join(";", data);
        return Collections.singletonList(result);
    }
}
