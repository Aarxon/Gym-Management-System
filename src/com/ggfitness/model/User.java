package com.ggfitness.model;

public class User
{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int phone;
    private Membership membership;
    public User(String firstName, String lastName, String email, String password, int phone, Membership memberShip)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.membership = membership;
    }

    public User(String firstName, String lastName, String email, String password, int phone)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }


    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}
