package exceptions;

/**
 * @author - v.queignec
 */
public class ArticleDoesntFitException extends Exception {
    public ArticleDoesntFitException() {
        super("This article doesn't fit in the remaining space");
    }
}
