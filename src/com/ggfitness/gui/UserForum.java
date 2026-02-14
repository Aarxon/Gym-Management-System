package com.ggfitness.gui;

import com.ggfitness.database.UserDBO;
import com.ggfitness.model.User;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class UserForum
{
    private final MainWindow mainWindow;
    private User user;

    public UserForum(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    public JPanel createAccount()
    {

        JPanel createAccountPanel = new JPanel(new MigLayout("fill"));
        JPanel formPanel = new JPanel(new MigLayout("insets 20"));



        JLabel firstNameLabel = new JLabel("First Name: ");
        JTextField firstNameField = new JTextField(20);
        formPanel.add(firstNameLabel, "align center, wrap");
        formPanel.add(firstNameField, "align center, wrap");

        JLabel lastNameLabel = new JLabel("Last Name: ");
        JTextField lastNameField = new JTextField(20);
        formPanel.add(lastNameLabel, "align center, wrap");
        formPanel.add(lastNameField, "align center, wrap");

        JLabel emailLabel = new JLabel("Email: ");
        JTextField emailField = new JTextField(20);
        formPanel.add(emailLabel, "align center, wrap");
        formPanel.add(emailField, "align center, wrap");

        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(20);
        formPanel.add(passwordLabel, "align center, wrap");
        formPanel.add(passwordField, "align center, wrap");

        JLabel phoneLabel = new JLabel("Phone: ");
        JTextField numberField = new JTextField(20);
        formPanel.add(phoneLabel, "align center, wrap");
        formPanel.add(numberField, "align center, wrap");

        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        formPanel.add(registerButton, "align center, split 2");
        formPanel.add(backButton, "align center, wrap");

        JButton alreadyButton = new JButton("Already have a account?");
        formPanel.add(alreadyButton, "align center");


        createAccountPanel.add(formPanel, "push, align center");



        registerButton.addActionListener(e ->
        {
            UserDBO user = new UserDBO();

            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());
            String phoneNumber = numberField.getText();

            user.createNewUser(firstName,lastName,email,password,phoneNumber);
        });

        alreadyButton.addActionListener(e ->
        {
            mainWindow.loginLayout();

        });

        backButton.addActionListener(e ->
        {
            mainWindow.choiceLayout();
        });

        return createAccountPanel;
    }

    public JPanel existingAccount()
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

            UserDBO user = new UserDBO();
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();

            User currentUser = user.loginUser(email, password);

            if(currentUser != null)
            {
                mainWindow.showUserHome(currentUser);
            };

        });

        backButton.addActionListener(e ->
        {
            mainWindow.choiceLayout();
        });

        return logInPanel;
    }

}
