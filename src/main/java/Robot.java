import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author - v.queignec
 */
public class Robot {

    public Map<Integer, Integer> listToMap(List<Integer> inputs) {
        Map<Integer, Integer> resultingMap = initializeArticleMap();
        resultingMap.putAll(inputs.stream().collect(Collectors.toMap(input -> input, input -> 1, (oldValue, newValue) -> (oldValue + 1))));
        return resultingMap;
    }

    private Map<Integer, Integer> initializeArticleMap() {
        return IntStream.range(1, Constants.BASE_ARTICLE_MAX_SIZE + 1).boxed().collect(Collectors.toMap(article -> article, article -> 0));
    }
}
