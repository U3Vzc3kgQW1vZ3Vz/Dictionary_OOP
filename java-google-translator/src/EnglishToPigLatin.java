import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;

import com.darkprograms.speech.translator.*;
import com.darkprograms.speech.synthesiser.SynthesiserV2;
public class EnglishToPigLatin extends JFrame{

    private JTextArea inputArea, outputArea;
    private JButton bTranslate,bSpeakEnglish,bSpeakVietnamese;

    public EnglishToPigLatin() throws IOException{

        super("English to Pig Latin Conversion");

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        inputArea = new JTextArea(20, 20);
        inputArea.setEditable(true);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        container.add(inputArea);

        bTranslate = new JButton("Translate");
        container.add(bTranslate);
bSpeakEnglish=new JButton("Speak English");
bSpeakVietnamese=new JButton("Speak Vietnamese");
container.add(bSpeakEnglish);
container.add(bSpeakVietnamese);
        bTranslate.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Scanner sc = new Scanner(inputArea.getText());
                        String output = "";

                        while (sc.hasNext())
                            output += toPigLatin(sc.next()) + " ";

                        outputArea.setText(output);
                    }
                }
        );
        bSpeakVietnamese.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Scanner sc= new Scanner(inputArea.getText());
                String output="";
                while (sc.hasNext()){
                    output+=sc.next()+" ";
                }
speak(output);
            }
        });

        outputArea = new JTextArea(20, 20);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        container.add(outputArea);

        setSize(300, 450);
        setVisible(true);
    }

    public static String toPigLatin (String str)
    {
        String result = "";

        try {
            result=GoogleTranslate.translate("vi",str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
    public static void speak(String input){
SynthesiserV2 synthesiserV2=new SynthesiserV2("https://www.google.com/speech-api/v2/synthesize?enc=mpeg&client=chromium");
        try {
            synthesiserV2.getMP3Data(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        try{
            EnglishToPigLatin window = new EnglishToPigLatin();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}