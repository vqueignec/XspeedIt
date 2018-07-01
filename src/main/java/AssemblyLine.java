import lombok.Data;

import java.util.ArrayList;

/**
 * @author - v.queignec
 */
@Data
public class AssemblyLine {

    private ArrayList<Box> boxes = new ArrayList<>();

    public int getNumberOfBoxesUsed() {
        return boxes.size();
    }

    public void addBox(Box box) {
        boxes.add(box);
    }

    public String getStringResult() {
        StringBuilder result = new StringBuilder();
        for (Box box : boxes) {
            for (Integer article : box.getArticles()) {
                result.append(article);
            }
            result.append("/");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
