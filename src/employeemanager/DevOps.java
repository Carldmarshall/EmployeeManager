package employeemanager;

public class DevOps extends Employee {
    private final int DEVOPS_BONUS = 1890;
    public static int nMen = 0;
    public static int nWomen = 0;

    public DevOps(String name, int age, double hourlyRate, char gender, String birthDate){
        super(name, age, hourlyRate, gender, birthDate);
        manOrWoman(gender);
        HR.registerEmployee(this);
    }

    @Override
    public double getBonus() {
        return super.calculateSalary()*7/100+DEVOPS_BONUS;

    }
    @Override
    public String toString() {
        return "DevOps | " + super.toString();
    }
    @Override
    public void manOrWoman(char gender){
        if(gender == 'F'){
            nWomen++;
        }else{
            nMen++;
        }
    }
}
