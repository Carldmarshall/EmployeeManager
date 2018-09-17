package employeemanager;

public class Developer extends Employee{
    private final int DEV_BONUS = 1500;

    public Developer(String name, int age, double hourlyRate, char gender, String birthDate){
        super(name, age, hourlyRate, gender, birthDate);
        HR.registerEmployee(this);
    }

    @Override
    public double getBonus() {
        return super.calculateSalary()*7/100+DEV_BONUS;
    }

    @Override
    public String toString() {
        return "Developer | " + super.toString();
    }
}
