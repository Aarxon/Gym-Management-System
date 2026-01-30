package com.ggfitness.gui;

import com.ggfitness.database.UserDBO;

import javax.swing.*;
import java.awt.*;

public class UserForum
{
    public UserForum()
    {

    }

    public JPanel createAccount()
    {
        JPanel createAccountPanel = new JPanel();
        createAccountPanel.setLayout(new BoxLayout(createAccountPanel, BoxLayout.Y_AXIS));

        createAccountPanel.add(Box.createVerticalGlue());

        JTextField firstNameField = new JTextField(20);
        createAccountPanel.add(createFieldPanel("Enter First Name: ", firstNameField));
        createAccountPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField lastNameField = new JTextField(20);
        createAccountPanel.add(createFieldPanel("Enter Last Name: ", lastNameField));
        createAccountPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField numberField = new JTextField(20);
        createAccountPanel.add(createFieldPanel("Enter Number: ", numberField));
        createAccountPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField emailField = new JTextField(20);
        createAccountPanel.add(createFieldPanel("Enter Email: ", emailField));
        createAccountPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPasswordField passwordField = new JPasswordField(20);
        createAccountPanel.add(createFieldPanel("Enter Password: ", passwordField));

        JButton createButton = new JButton("Create Account");
        createButton.setLayout(new BoxLayout(createButton, BoxLayout.Y_AXIS));
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createAccountPanel.add(createButton);

        createButton.addActionListener(e ->
        {
            UserDBO user = new UserDBO();

            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());
            String phoneNumber = numberField.getText();

            user.createNewUser(firstName,lastName,email,password,phoneNumber);
        });

        createAccountPanel.add(Box.createVerticalGlue());
        return createAccountPanel;
    }

    private JPanel createFieldPanel(String labelText, JTextField textField)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        textField.setMaximumSize(textField.getPreferredSize()); // important!
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(textField);

        return panel;
    }

    public JPanel login()
    {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JLabel email = new JLabel("Enter Email: ");
        JPasswordField password = new JPasswordField("Enter Password: ");

        return loginPanel;

    }
}
