import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EnglishToPigLatin extends JFrame{

    private JTextArea inputArea, outputArea;
    private JButton bTranslate;

    public EnglishToPigLatin() throws IOException{

        super("English to Pig Latin Conversion");

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        inputArea = new JTextArea(10, 20);
        inputArea.setEditable(true);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        container.add(inputArea);

        bTranslate = new JButton("Translate");
        container.add(bTranslate);

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

        outputArea = new JTextArea(10, 20);
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

        if (isVowel(str.charAt(0)))
            result = str + "way";
        else
        {
            for (int i=1; i<str.length(); i++)
                result += str.charAt(i);

            result += str.charAt(0) + "ay";
        }

        return result;
    }

    public static boolean isVowel (char ch)
    {
        String vowels = "aAeEiIoOuU";

        if (vowels.indexOf(ch) == -1)
            return false;
        else
            return true;
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