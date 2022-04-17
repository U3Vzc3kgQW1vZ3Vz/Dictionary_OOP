import java.nio.file.Files;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.*;

import static java.nio.file.attribute.PosixFilePermission.*;

public class DictionaryManagement extends Dictionary {
    public String removeHeadspace(String str){
        String newStr="";
        int i;
for(i=0;i<str.length();i++) {
    if (str.charAt(i) != ' ') {
        break;
    }
}
    for(int j=i;j<str.length();j++){
        newStr+=str.charAt(j);
    }
return newStr;
    }
    public void insertFromCommandline() {
        String str, str1;
        Scanner ip = new Scanner(System.in);
        int numLine=ip.nextInt();
        ip.nextLine();
        System.out.println(numLine);
        for(int i=0;i<numLine;i++){
            str = ip.nextLine();
             str1 = ip.nextLine();
            Word word = new Word(str, str1);
            addWord(word);
        }
    }

    public void insertFromFile() {

        try {
           List<String> word=new ArrayList<String>();


            File myFile = new File("/home/nam/WordDictionary/src/main/java/dictionary.txt");
            FileReader fr = new FileReader(myFile);
String words="";
            BufferedReader br = new BufferedReader(fr);
            String line;

            boolean recorded=true;
            while ((line = br.readLine()) != null) {
                for(int i=0;i<line.length();i++){
       if(line.charAt(i)==' '&&recorded){
           word.add(removeHeadspace(words));
           words="";
           recorded=false;
       }
       else {
           words+=line.charAt(i);
       }
                }
                word.add(removeHeadspace(words));
                words="";
                recorded=true;

            }
            for (int i = 0; i < word.size()-1; i +=2) {
                addWord(new Word(word.get(i), word.get(i+1)));
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
    public void editDictionary(String str){
        Scanner scanner= new Scanner(System.in);
for(Word s: diction){
    if(str.equals(s.getWord_explain())){
        System.out.println("Insert word edit:");
        String def=scanner.nextLine();
        s.setWord_explain(def);
    }
    else if(str.equals(s.getWord_target())){
        System.out.println("Insert word edit:");
        String def=scanner.nextLine();
        s.setWord_target(def);
    }
}
    }
    public void deleteDictionary(String str){
        for(Word s: diction){
            if(str.equals(s.getWord_explain())){
               s.setWord_explain("");
            }
            else if(str.equals(s.getWord_target())){
              s.setWord_target("");
            }
        }
    }
    public List<String> dictionarySearcher(String str){
        List<String> wordslist=new ArrayList<String>();
        for (Word s: diction){
            if(s.getWord_target().startsWith(str)){
                wordslist.add(s.getWord_target());
            }
        }
        return wordslist;
    }
    public static void dictionaryExportToFile() throws IOException {
        FileWriter writer = new FileWriter("/home/nam/Downloads/dictionaries.txt");
        for (Word word : Dictionary.diction) {
            writer.write(String.format("%s\t%s\n", word.getWord_target(), word.getWord_explain()));
        }
        writer.close();
        System.out.println(Dictionary.diction);
    }
}
