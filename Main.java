public class Main {
    public static void main(String[] args) {
        DictionaryManagement dict = new DictionaryManagement();
        dict.insertFromFile();
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
        dictionaryCommandLine.dictionaryAdvanced();
    }
}
