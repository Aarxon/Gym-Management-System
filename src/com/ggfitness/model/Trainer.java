package com.ggfitness.model;

public class Trainer extends User
{
    private String trainingType;
    private String description;

    public Trainer(String firstName, String lastName, String email, String password, int phone, String trainingType, String description)
    {
        super(firstName, lastName, email, password, phone);
        this.trainingType = trainingType;
        this.description = description;
    }

}
