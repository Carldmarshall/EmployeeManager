package employeemanager;

public class Tester extends Employee{
    private final int TESTER_BONUS = 1207;
    public static int nMen = 0;
    public static int nWomen = 0;
    public Tester(String name, int age, double hourlyRate, char gender, String birthDate){
        super(name, age, hourlyRate, gender, birthDate);
        manOrWoman(gender);
        HR.registerEmployee(this);
    }

    @Override
    public double getBonus() {
        return super.calculateSalary()*7/100+TESTER_BONUS;
    }

    @Override
    public String toString() {
        return "Tester | " + super.toString();
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
