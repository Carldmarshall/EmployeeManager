package employeemanager;

public class DevOps extends Employee {
    private final int DEVOPS_BONUS = 1890;

    public DevOps(String name, int age, double hourlyRate, char gender, String birthDate, String department){
        super(name, age, hourlyRate, gender, birthDate, department);
        HR.registerEmployee(this);
    }

    @Override
    public double getBonus() {
        return super.calculateSalary()*7/100+DEVOPS_BONUS;
        
    }
}
