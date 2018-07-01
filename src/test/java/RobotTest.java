import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

/**
 * @author - v.queignec
 */
public class RobotTest {

    @Test
    public void packagingWithWordingArticles() {
        assertFalse(true);
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
}