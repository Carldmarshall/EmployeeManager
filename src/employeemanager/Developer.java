package employeemanager;

public class Developer extends Employee{
    private final int DEV_BONUS = 1500;
    public static int nMen = 0;
    public static int nWomen = 0;
    public Developer(String name, int age, double hourlyRate, char gender, String birthDate){
        super(name, age, hourlyRate, gender, birthDate);
        manOrWoman(gender);
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
    @Override
    public void manOrWoman(char gender){
        if(gender == 'F'){
            nWomen++;
        }else{
            nMen++;
        }
    }
}
