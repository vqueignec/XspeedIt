import exceptions.ArticleDoesntFitException;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author - v.queignec
 */
@Data
public class Box {

    private ArrayList<Integer> articles = new ArrayList<>();
    private int freePlace = Constants.MAX_BOX_SIZE;

    private int getUsedPlace(){
        return articles.stream().mapToInt(value -> value).sum();
    }


    private boolean doesArticleFit(int article){
        return getFreePlace() >= article;
    }

    public void addArticle(int article) throws ArticleDoesntFitException {
        if(!doesArticleFit(article))
            throw new ArticleDoesntFitException();
        articles.add(article);
        freePlace -= article;
    }
}
