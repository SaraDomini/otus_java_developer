package ru.otus.kva.oop.userApp;

import java.util.Calendar;

public class User {
    private String lastName;
    private String firstName;
    private String middleName;
    private int yearOfBirth;
    private String email;

    //геттеры
    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    //сеттеры
    public void setLastName(String lastName) {
        if (lastName != null){
            this.lastName = lastName;
        }
    }

    public void setFirstName(String firstName) {
        if (firstName != null){
            this.firstName = firstName;
        }
    }

    public void setMiddleName(String middleName) {
        if (middleName != null){
            this.middleName = middleName;
        }
    }

    public void setYearOfBirth(int yearOfBirth) {
        Calendar calendar = Calendar.getInstance();
        if (yearOfBirth > 1900 && yearOfBirth <= (calendar.get(Calendar.YEAR) - 10)) {
            this.yearOfBirth = yearOfBirth;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //конструкторы
    public User(String lastName, String firstName, String middleName, int yearOfBirth, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public User(String lastName, String firstName, String middleName, int yearOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.yearOfBirth = yearOfBirth;
    }

    //методы
    public void printInfo() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + middleName);
        System.out.println("Год рождения: " + yearOfBirth);
        System.out.println("e-mail: " + email);
    }
}
