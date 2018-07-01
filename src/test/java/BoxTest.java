import exceptions.ArticleDoesntFitException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;


/**
 * @author - v.queignec
 */
public class BoxTest {

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Test
    public void addSimpleArticle() throws ArticleDoesntFitException {
        Box box = givenEmptyBox();

        box.addArticle(5);
        assertThat(box.getFreePlace(), is(5));
    }

    @Test
    public void addSimpleArticleBis() throws ArticleDoesntFitException {
        Box box = givenEmptyBox();

        box.addArticle(7);
        assertThat(box.getFreePlace(), is(3));
    }

    @Test
    public void addArticleExceedingCapacity() throws ArticleDoesntFitException {
        Box box = givenEmptyBox();

        box.addArticle(7);
        exceptionGrabber.expect(ArticleDoesntFitException.class);
        box.addArticle(7);
    }

    private Box givenEmptyBox(){
        return new Box();
    }

    private Box givenBoxWithArticles(List<Integer> articles) throws ArticleDoesntFitException {
        Box result = new Box();
        for (Integer article: articles) {
            result.addArticle(article);
        }
        return result;
    }
}
