public class DictionaryCommandline extends Dictionary {

    public void showAllWords() {
removeDuplicate();
        System.out.println("No\t| English\t|Vietnamese");
        for (int i = 0; i < diction.size()/2 ; i++) {

            System.out.println((i + 1) + "\t" + diction.get(i).toString());
        }
    }
}
