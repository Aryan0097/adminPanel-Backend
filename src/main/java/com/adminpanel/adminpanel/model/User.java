package com.adminpanel.adminpanel.model;

import lombok.Data;

@Data
public class User {
    private long userId;
    private String userName;
    private String phoneNumber;
    private String Email;
    private String userCountry;
    private String userCity;
    private String password;
   
}
