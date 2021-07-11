package ru.geekbrains.lesson5.homework;

public class Employee {

    private String fullName;
    private String post;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public String getFullName() {
        return fullName;
    }

    public String getPost() {
        return post;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public Employee(String fullName, String post, int age, int salary, String email, String phone) {
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println(this.fullName + ", " + this.post + ", " + this.age + ", " + this.salary +
                this.email + ", " + this.phone);
    }
}
