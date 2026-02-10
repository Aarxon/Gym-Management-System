package com.ggfitness.database;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ggfitness.model.Trainer;
import org.apache.commons.validator.routines.EmailValidator;

public class TrainerDBO
{
    Scanner input = new Scanner(System.in);
    DatabaseConnection dbcon = new DatabaseConnection();
    EmailValidator emailValidator = EmailValidator.getInstance();

    Connection connection = null;
    PreparedStatement pstat = null;
    ResultSet resultSet = null;

    public void createNewTrainer()
    {
        int i = 0;
        int switchChoice = 0;
        String firstName;
        String lastName;
        String email;
        String password;
        String trainingType = "";
        String description = "";
        boolean isAddValid;
        String phone;

        System.out.println("Enter your first name: ");
        firstName = input.next();
        System.out.println("Enter your last name: ");
        lastName = input.next();
        System.out.println("Enter your email: ");
        email = input.next();
        System.out.println("Enter your password: ");
        password = input.next();
        System.out.println("Enter your phone number: ");
        phone = input.next();
        System.out.println("Pick a training type: "
                + "\n 1. Yoga"
                + "\n 2. HIIT"
                + "\n 3. Spinning/Cycling"
                + "\n 4. Strength Training"
                + "\n 5. Pilates");
        switch(switchChoice)
        {
            case 1:
                trainingType = "Yoga";
                break;
            case 2:
                trainingType = "HITT";
                break;
            case 3:
                trainingType = "Spinning/Cycling";
                break;
            case 4:
                trainingType = "Strength Training";
                break;
            case 5:
                trainingType = "Pilates";
                break;
        }
        System.out.println("Enter a little description about yourself and your training: ");

        isAddValid = emailValidator.isValid(email);
        if (!isAddValid)
        {
            System.out.println("Email is not in a valid format");
            return;
        }
        else
        {
            Trainer trainer = new Trainer(firstName, lastName, email, password, phone, trainingType, description);

            try
            {
                connection = dbcon.startConnection();
                pstat = connection.prepareStatement("INSERT INTO Trainers (first_name, last_name, email, password, phone_number, training_type, description) VALUES (?,?,?,?,?,?,?) ");

                pstat.setString(1, firstName);
                pstat.setString(2, lastName);
                pstat.setString(3, email);
                pstat.setString(4, password);
                pstat.setString(5, phone);
                pstat.setString(6, trainingType);
                pstat.setString(7, description);

                i = pstat.executeUpdate();
                System.out.println(i + " Record created");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                connection = dbcon.closeConnection();
            }
        }
    }

    public void loginTrainer()
    {
        connection = dbcon.startConnection();

        String email;
        String password;

        System.out.println("Enter your email: ");
        email = input.next();
        System.out.println("Enter your password: ");
        password = input.next();

        try
        {
            String retrieve = "SELECT * FROM  Trainers WHERE email = ? AND password = ?";

            pstat = connection.prepareStatement(retrieve);
            pstat.setString(1, email);
            pstat.setString(2, password);

            resultSet = pstat.executeQuery();

            if(resultSet.next())
            {
                System.out.println("Welcome " + " " + resultSet.getString("first_name"));
            }
            else
            {
                System.out.println("Invalid email or password");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection = dbcon.closeConnection();
        }
    }
}
