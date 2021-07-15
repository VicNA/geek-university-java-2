package ru.geekbrains.lesson8.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private JTextField textField;
    private JPanel buttonsPanel;

    private int randomNumber;
    private int attempts;

    private final String title = "Игра: Угадай число";

    public GameWindow() throws HeadlessException {
        newPlay();

        setBounds(600, 300, 600, 130);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 20);
        textField.setFont(font);

        buttonsPanel = new JPanel(new GridLayout(1, 10));
        add(buttonsPanel, BorderLayout.CENTER);

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(font);
            buttonsPanel.add(button);

            int buttonIndex = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setTitle(title + " (Количество попыток: " + --attempts + ")");
                    tryToAnswer(buttonIndex);
                }
            });
        }

        JButton restartGame = new JButton("Перезапустить игру");
        restartGame.setFont(font);
        add(restartGame, BorderLayout.SOUTH);
        restartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPlay();
            }
        });

        setVisible(true);
    }

    private void newPlay(){
        randomNumber = (int)(Math.random() * 10) + 1;
        attempts = 3;
        setTitle(title + " (Количество попыток: " + attempts + ")");
        if (textField != null) textField.setText("Программа загадала число от 1 до 10");
        if (buttonsPanel != null) setButtonsPanel(true);
    }

    private void tryToAnswer(int answer) {
        if (answer == randomNumber) {
            textField.setText("Вы угадали!!! Ответ: " + randomNumber);
            setButtonsPanel(false);
        } else if (attempts == 0) {
            textField.setText("Вы проиграли! Загаданным числом было " + randomNumber);
            setButtonsPanel(false);
        } else if (answer > randomNumber) {
            textField.setText("Не угадали! Загаданное число меньше, чем " + answer);
        } else {
            textField.setText("Не угадали! Загаданное число больше, чем " + answer);
        }
    }

    private void setButtonsPanel(boolean enabled) {
        for (int i = 0; i < buttonsPanel.getComponentCount(); i++) {
            buttonsPanel.getComponents()[i].setEnabled(enabled);
        }
    }
}
