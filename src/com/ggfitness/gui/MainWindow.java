package com.ggfitness.gui;

import com.ggfitness.database.UserDBO;
import javax.swing.*;
import java.util.Scanner;

public class MainWindow extends JFrame
{
    UserDBO userDBO = new UserDBO();
    Scanner input = new Scanner(System.in); //

    public MainWindow()
    {

    }


    public void loginScreen()
    {
        int choice = 0;
        System.out.println("Welcome to GG Fitness");

        while(choice == 0)
        {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("5. Admin mode");
            choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    userDBO.loginUser();
                    break;
                case 2:
                    userDBO.createNewUser();
                    break;
                case 3:
                    System.out.println("Exiting... ");
                    System.exit(0);
                    break;
            }

        }
    }

    public void userScreen()
    {
        int choice = 0;

        while(choice == 0)
        {

            System.out.println("Welcome to GG Fitness");
            System.out.println("1. Buy com.ggfitness.model.Membership");
            System.out.println("2. Log out");

            choice = input.nextInt();

            if(choice == 2)
            {
                System.out.println("See you again ");
                loginScreen();
            }
        }



    }

}
