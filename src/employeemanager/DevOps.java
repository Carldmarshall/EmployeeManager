//Package
package employeemanager;

//Start of class
public class DevOps extends Employee {
    private final int BONUS = 1890;
    private static int nMen = 0;
    private static int nWomen = 0;

    public DevOps(String name, int age, double hourlyRate, char gender, String birthDate){
        super(name, age, hourlyRate, gender, birthDate);
        manOrWoman(gender);
    }

    //Getters
    public static int getTotalOfDevOps(){
        return nMen + nWomen;
    }
    public static int getnMen() {
        return nMen;
    }
    public static int getnWomen() {
        return nWomen;
    }

    //Override methods
    @Override
    public double getBonus() {
        return (super.calculateSalary()/100)+BONUS;
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

    //Other methods
}
