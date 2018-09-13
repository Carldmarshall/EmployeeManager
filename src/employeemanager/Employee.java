
package employeemanager;
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
    
    abstract void calculateSalary ();
}
