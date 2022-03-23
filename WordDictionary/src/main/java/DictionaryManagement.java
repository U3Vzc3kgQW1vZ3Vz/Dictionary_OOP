import java.util.Scanner;
import java.io.*;
public class DictionaryManagement extends Dictionary {
    public void insertFromCommandline(){
        Scanner ip=new Scanner(System.in);
        String str= ip.nextLine();
        ip.nextLine();
        String str2=ip.nextLine();
        Word word=new Word(str,str2);
        addWord(word);
    }
    public void insertFromFile(){
File myFile=new File("/home/nam/WordDictionary/src/main/resources/dictionary.txt");
        Scanner scanner=new Scanner(myFile);



    }
}
