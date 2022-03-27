public class DictionaryCommandLine {
    public void dictionaryBasic() {
        DictionaryCommandline dict1 = new DictionaryCommandline();
        DictionaryManagement dict2 = new DictionaryManagement();
        dict2.insertFromFile();
        dict1.showAllWords();

    }
    public void dictionaryAdvanced(){
        DictionaryCommandline dict1 = new DictionaryCommandline();
        DictionaryManagement dict2 = new DictionaryManagement();
        dict2.insertFromFile();
        dict1.showAllWords();
        dict2.dictionaryLookup();
    }
}
