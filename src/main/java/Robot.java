import exceptions.ArticleDoesntFitException;

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

    public AssemblyLine packaging(Map<Integer, Integer> articles) throws ArticleDoesntFitException {
        AssemblyLine assemblyLine = new AssemblyLine();
        for (int i = Constants.BASE_ARTICLE_MAX_SIZE; i > 0; i--) {
            while (hasArticle(articles, i)) {
                Box newBox = new Box();
                movingArticle(articles, i, newBox);

                fillTheBox(articles, newBox);

                assemblyLine.addBox(newBox);
            }
        }
        return assemblyLine;
    }

    private Map<Integer, Integer> initializeArticleMap() {
        return IntStream.range(1, Constants.BASE_ARTICLE_MAX_SIZE + 1).boxed().collect(Collectors.toMap(article -> article, article -> 0));
    }

    private boolean hasArticle(Map<Integer, Integer> articles, int index) {
        return articles.get(index) > 0;
    }

    private void movingArticle(Map<Integer, Integer> articles, int article, Box box) throws ArticleDoesntFitException {
        box.addArticle(article);
        articles.put(article, articles.get(article) - 1);
    }

    private Box fillTheBox(Map<Integer, Integer> articles, Box box) throws ArticleDoesntFitException {
        Integer complement = box.getFreePlace();
        /*while (complement > 0) {
            if (hasArticle(articles, complement) && box.getFreePlace() > 0) {
                movingArticle(articles, complement, box);
                fillTheBox(articles, box);
                complement = box.getFreePlace();
            }else
            complement--;
        }*/
        if (hasArticle(articles, complement) && box.getFreePlace() > 0) {
            movingArticle(articles, complement, box);
            complement = box.getFreePlace();
        }
        return
                fillTheBoxRec(articles, box, complement);
    }

    private Box fillTheBoxRec(Map<Integer, Integer> articles, Box box, int complement) throws ArticleDoesntFitException {
        if(complement > 0){
            if (hasArticle(articles, complement)) {
                movingArticle(articles, complement, box);
                complement = box.getFreePlace();
            }else{
                complement--;
            }
            return fillTheBoxRec(articles, box, complement);
        }else
            return box;
    }
}