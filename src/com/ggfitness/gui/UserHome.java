package com.ggfitness.gui;

import com.ggfitness.model.User;

import javax.swing.*;

public class UserHome
{
    private User user;

    public UserHome(User user)
    {
        this.user = user;

    }

    public JPanel homeScreen()
    {
        JPanel panel = new JPanel();

        JLabel userNameLabel = new JLabel("Welcome " + user.getFirstName());
        panel.add(userNameLabel);



        return panel;
    }
}
