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


    public void loginTrainer(String email, String password)
    {
        connection = dbcon.startConnection();

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
