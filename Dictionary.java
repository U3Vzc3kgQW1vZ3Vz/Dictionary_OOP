import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public static List<Word> diction = new ArrayList<Word>();

    public void addWord(Word word) {
        diction.add(word);

    }

    public void removeDuplicate() {
        for (int i = 0; i < diction.size(); i++) {
            for (int j = i + 1; j < diction.size(); j++) {
                if (diction.get(i).equals(diction.get(j))) {
                    diction.remove(j);
                }
            }
        }
    }


}
