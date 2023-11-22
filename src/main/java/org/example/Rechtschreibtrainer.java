package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Rechtschreibtrainer {

    private int richtig= 0;
    private int falsch= 0;
    private Map<String, String> woerter;
    private List<Map.Entry<String, String>> entryList;
    private static String eingabe= "";
    private String anzeige= "Was ist das fuer ein Bild?: ";

    public static void main(String[] args) {
        new JSONUsage();        //die auszutauschende Klasse
    }

    public int[] openFrame(String name, String url, String text) {
        JFrame frame= new JFrame("Benutzereingabe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        JPanel panel= new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea= new JTextArea(text+url);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);

        JScrollPane scrollPane= new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JTextField inputField= new JTextField();
        panel.add(inputField, BorderLayout.SOUTH);

        JButton okButton= new JButton("OK");
        okButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe= inputField.getText();

                if(eingabe.equals("")) {
                    textArea.setText("Antwort falsch! Nochmal versuchen: "+url);
                }
                if(eingabe.toLowerCase().equals(name.toLowerCase())) {
                    richtig++;
                } else {
                    falsch++;
                    openFrame(name, url, "Antwort falsch! Nochmal versuchen: ");
                }
                frame.dispose();
            }
        });
        panel.add(okButton, BorderLayout.EAST);
        frame.add(panel);
        frame.setVisible(true);

        return new int[]{richtig, falsch};
    }
}
