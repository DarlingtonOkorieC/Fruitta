package com.example.darlington.dokinta.Model;

import java.util.jar.Attributes;

/**
 * Created by darlington on 5/7/19.
 */

public class User {
    private String Name;
    private String Password;

    public User(){

    }

    public User(String name, String password){
        Name = name;
        Password = password;

    }
    public String getName(){
        return Name;
    }

    public void setName(String name){
        Name = name;

    }

    public String getPassword(){
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
