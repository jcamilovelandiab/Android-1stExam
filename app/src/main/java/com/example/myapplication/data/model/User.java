package com.example.myapplication.data.model;


public class User {

    private String email;
    private String password;
    private String name;
    private Gender gender;
    private String phone;
    private String birthDate;
    private String homeCountry;

    public User(String email, String password, String name, String phone, String homeCountry, Gender gender){
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender= gender;
        this.phone = phone;
        this.homeCountry = homeCountry;
    }

    public String getEmail(){ return this.email; }
    public String getPassword(){ return this.password; }
    public String getName(){ return this.name; }

    public Gender getGender(){ return this.gender; }
    public String getPhone(){ return this.phone; }
    public String getHomeCountry(){ return this.homeCountry; }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender.toString() +
                ", phone='" + phone + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", homeCountry='" + homeCountry + '\'' +
                '}';
    }

}
