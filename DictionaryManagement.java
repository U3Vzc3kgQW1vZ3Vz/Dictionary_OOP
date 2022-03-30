import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    public void insertFromCommandline() {
        Scanner ip = new Scanner(System.in);
        String str = ip.nextLine();
        ip.nextLine();
        String str2 = ip.nextLine();
        Word word = new Word(str, str2);
        addWord(word);
    }

    public void insertFromFile() {

        try {
            List<String> word = new ArrayList<String>();


            File myFile = new File("/home/nam/WordDictionary/src/main/java/dictionary.txt");
            FileReader fr = new FileReader(myFile);

            BufferedReader br = new BufferedReader(fr);
            String line;
            int j = 0;
            while ((line = br.readLine()) != null) {
                word.add(line);
            }
            for (int i = 0; i < word.size() - 1; i += 2) {
                addWord(new Word(word.get(i), word.get(i + 1)));
            }
                   fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
    }

    public void dictionaryLookup() {
        Scanner scanner = new Scanner(System.in);
        String answer="There's no such word";
        String word = scanner.nextLine();
        for (int i = 0; i < diction.size(); i++) {
            if (word.equals(diction.get(i).getWord_explain())
                    || (word.equals(diction.get(i).getWord_target()))) {
                answer= diction.get(i).toString();
            }
        }

        System.out.println(answer);
    }
}
