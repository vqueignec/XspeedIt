import exceptions.ArticleDoesntFitException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author - v.queignec
 */
public class BenchmarkTest {

    Robot robot = new Robot();


    @Test
    public void BenchmarkWithThousandElements() throws ArticleDoesntFitException {
        robot.packaging(robot.listToMap(givenRandomArticles(1_000)));
    }

    @Test
    public void BenchmarkWithTenThousandsElements() throws ArticleDoesntFitException {
        robot.packaging(robot.listToMap(givenRandomArticles(10_000)));
    }

    @Test
    public void BenchmarkWithHundredThousandsElements() throws ArticleDoesntFitException {
        robot.packaging(robot.listToMap(givenRandomArticles(100_000)));
    }

    @Test
    public void BenchmarkWithMillionElements() throws ArticleDoesntFitException {
        robot.packaging(robot.listToMap(givenRandomArticles(1_000_000)));
    }

    @Test
    public void BenchmarkWithTenMillionsElements() throws ArticleDoesntFitException {
        robot.packaging(robot.listToMap(givenRandomArticles(10_000_000)));
    }

    private ArrayList<Integer> givenRandomArticles(int numberOfArticles){
        ArrayList<Integer> arrayRandom = new ArrayList<Integer>(numberOfArticles);

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i=0; i < numberOfArticles; i++)
        {
            Integer r = rand.nextInt(10);
            arrayRandom.add(r);
        }
        return arrayRandom;
    }
}