package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Rechtschreibtrainer {

    private int richtig= 0;
    private int falsch= 0;
    private Map<String, String> woerter;
    private List<Map.Entry<String, String>> entryList;
    private static String eingabe= "";
    private String anzeige= "Was ist das fuer ein Bild?: ";

    public Rechtschreibtrainer() {
        this.woerter= new Woerter().getWoerter();
        entryList= new ArrayList<>(woerter.entrySet());
        Collections.shuffle(entryList);
        System.out.println("Willkommen zu dem Rechtschreibtrainer!");
        System.out.println("Das Spiel beginnt jetzt!");

        for (Map.Entry<String, String> frage : entryList) {
            String value= frage.getValue();
            String key= frage.getKey();
            openFrame(key, value, "Bitte erraten Sie das Bild!: ");
        }
    }

    public void openFrame(String key, String value, String text) {
        JFrame frame= new JFrame("Benutzereingabe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        JPanel panel= new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea= new JTextArea(text+value);
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
                frame.dispose();

                System.out.println(value);

                if(eingabe.equals("")) {
                    textArea.setText("Antwort falsch! Nochmal versuchen: "+value);
                }
                if(eingabe.toLowerCase().equals(key.toLowerCase())) {
                    richtig++;
                } else {
                    falsch++;
                    openFrame(key, value, "Antwort falsch! Nochmal versuchen: ");
                }
            }
        });
        panel.add(okButton, BorderLayout.EAST);
        frame.add(panel);
        frame.setVisible(true);
    }
}
