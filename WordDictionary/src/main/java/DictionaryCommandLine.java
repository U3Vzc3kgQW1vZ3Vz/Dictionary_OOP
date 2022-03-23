public class DictionaryCommandLine {
    public void dictionaryBasic(){
        DictionaryCommandline dict1=new DictionaryCommandline();
        DictionaryManagement dict2=new DictionaryManagement();
        dict2.insertFromCommandline();
        dict1.showAllWords();
    }
}
