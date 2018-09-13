
package employeemanager;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {

    static int nEmployees;
    private int id;
    private String name;
    private int age;
    private double hourlyRate;
    private char gender;
    private String birthDate;
    private String department;
   

    public Employee(String name, int age, double hourlyRate, char gender, String birthDate, String department) {
        this.name = name;
        this.age = age;
        this.hourlyRate = hourlyRate;
        this.gender = gender;
        this.birthDate = birthDate;
        this.department = department;
        nEmployees++;
        this.id = nEmployees;
        
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public abstract double getBonus();
    public double getHourlyRate() {
        return hourlyRate;
    }
     public double calculateSalary() {
       
            return getHourlyRate()*160;
    

    }

    @Override
    public String toString() {
        return "ID: " + id + " Employee: " + name + " Department: " + department + " Birthdate: " + birthDate.toString();
    }

   
}
