package com.javarush.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Check implements ActionListener{
    JTextArea textArea;
    int i;

    public static void main(String[] args) {
        Check check = new Check();
        check.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(panel);

        textArea = new JTextArea(10, 20);
        textArea.setLineWrap(true);
        panel.add(textArea);

        JButton button = new JButton("button");
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        button.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scrollPane);

        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        i++;
        textArea.append("New text! (" + i + "times)\n");
    }
}