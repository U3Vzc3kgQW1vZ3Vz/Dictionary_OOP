import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
      DictionaryManagement dictiona = new DictionaryManagement();
      DictionaryCommandline dictionaryCommandline=new DictionaryCommandline();
      dictionaryCommandLine.dictionaryBasic();


        try {
            dictiona.dictionaryExportToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dictionaryCommandline.showAllWords();

    }
}
