//Package
package employeemanager;

//Start of class
public abstract class Employee {

    private final int MONTHLY_HOURS = 166;
    private static int nEmployees;
    private int id;
    private String name;
    private int age;
    private double hourlyRate;
    private char gender;
    private String birthDate;

    public Employee(String name, int age, double hourlyRate, char gender, String birthDate) {
        this.name = name;
        this.age = age;
        this.hourlyRate = hourlyRate;
        this.gender = gender;
        this.birthDate = birthDate;
        nEmployees++;
        this.id = nEmployees;
    }

    //Setters
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void setId(int id) {
        this.id = id;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public char getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public String getBirthDate() {
        return birthDate;
    }

    //Override methods
    @Override
    public String toString() {
        return "[" + id + "] " + name + " [Salary] " + (int)calculateSalary()  + "kr [Bonus] " + (int)getBonus() + "kr";
    }

    //Abstract mehods
    abstract double getBonus();
    abstract void manOrWoman(char gender);

    //Other methods
    public double calculateSalary() {
        return getHourlyRate()*MONTHLY_HOURS;
    }

    //Comparator
    int compareTo(Employee e1, Employee e2){
        return e1.getAge() - e2.getAge();
    }

}
