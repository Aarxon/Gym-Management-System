package com.ggfitness.gui;

import com.ggfitness.database.TrainerDBO;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class TrainerFourm
{
    private final MainWindow mainWindow;

    public TrainerFourm(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    public JPanel trainerLogin()
    {
        JPanel logInPanel = new JPanel(new MigLayout("fill"));

        JPanel formPanel = new JPanel(new MigLayout("insets 20"));

        JTextField emailField = new JTextField(20);
        JLabel emailLabel = new JLabel("Enter Email");
        formPanel.add(emailLabel, "align center, wrap");
        formPanel.add(emailField, "align center, wrap");

        JPasswordField passwordField = new JPasswordField(20);
        JLabel passwordLabel = new JLabel("Enter Password");
        formPanel.add(passwordLabel, "align center, wrap");
        formPanel.add(passwordField, "align center, wrap");

        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        formPanel.add(loginButton, "split 2, align center");
        formPanel.add(backButton, "align center");

        logInPanel.add(formPanel, "push, align center");

        loginButton.addActionListener(e ->
        {

            TrainerDBO trainer = new TrainerDBO();

            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();

            trainer.loginTrainer(email,password);

        });

        backButton.addActionListener(e ->
        {
            mainWindow.choiceLayout();
        });

        return logInPanel;
    }
}
