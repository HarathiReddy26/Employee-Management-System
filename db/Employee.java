package model;

public class Employee {
    private int id;
    private String name;
    private String gender;
    private String phoneNum;
    private String email;
    private String designation;
    private double salary;

    public Employee(int id, String name, String gender, String phoneNum, String email, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.email = email;
        this.designation = designation;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getPhoneNum() { return phoneNum; }
    public String getEmail() { return email; }
    public String getDesignation() { return designation; }
    public double getSalary() { return salary; }
}
