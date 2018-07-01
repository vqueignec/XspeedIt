import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

/**
 * @author - v.queignec
 */
public class RobotTest {

    private Robot robot = new Robot();

    @Test
    public void packagingWithWordingArticles() {
        assertFalse(true);
    }

    @Test
    public void listToMap() {
        Map<Integer, Integer> articleMapping = robot.listToMap(givenArticlesFromWording());
        assertThat(articleMapping.get(1), is(2));
        assertThat(articleMapping.get(2), is(1));
        assertThat(articleMapping.get(3), is(2));
        assertThat(articleMapping.get(4), is(1));
        assertThat(articleMapping.get(5), is(2));
        assertThat(articleMapping.get(6), is(2));
        assertThat(articleMapping.get(7), is(2));
        assertThat(articleMapping.get(8), is(2));
        assertThat(articleMapping.get(9), is(1));
    }

    @Test
    public void listToMapBis(){
        Map<Integer, Integer> articleMapping = robot.listToMap(givenArticles());
        assertThat(articleMapping.get(1), is(2));
        assertThat(articleMapping.get(2), is(1));
        assertThat(articleMapping.get(3), is(3));
        assertThat(articleMapping.get(4), is(1));
        assertThat(articleMapping.get(5), is(2));
        assertThat(articleMapping.get(6), is(2));
        assertThat(articleMapping.get(7), is(0));
        assertThat(articleMapping.get(8), is(0));
        assertThat(articleMapping.get(9), is(1));
    }

    private ArrayList<Integer> givenArticlesFromWording(){
        return new ArrayList<Integer>() {{
            add(1);
            add(6);
            add(3);
            add(8);
            add(4);
            add(1);
            add(6);
            add(8);
            add(9);
            add(5);
            add(2);
            add(5);
            add(7);
            add(7);
            add(3);
        }};
    }

    private ArrayList<Integer> givenArticles(){
        return new ArrayList<Integer>() {{
            add(1);
            add(9);
            add(4);
            add(3);
            add(3);
            add(3);
            add(1);
            add(2);
            add(5);
            add(5);
            add(6);
            add(6);
        }};
    }
}