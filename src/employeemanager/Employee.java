
package employeemanager;

import java.util.Date;

public abstract class Employee {
    
    static int id;

    public static int getId() {
        return id;
    }
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    private int age;
    private double hourlyRate;
    private char gender;
    private double bonus;
    private Date birthDate;

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    abstract void calculateSalary ();
}
