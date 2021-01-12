package com.weylar.idrisaminu.model;

public class Patient {
   private String name;
   private int age;
   private String email;
   private Gender gender;

   public Patient(String name, int age, String email, Gender gender){
       this.name = name;
       this.age = age;
       this.email = email;
       this.gender = gender;
   }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }
}
