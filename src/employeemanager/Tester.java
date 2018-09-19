//Package
package employeemanager;

//Start of class
public class Tester extends Employee{
    private final int BONUS = 1207;
    private static int nMen = 0;
    private static int nWomen = 0;
    public Tester(String name, int age, double hourlyRate, char gender, String birthDate){
        super(name, age, hourlyRate, gender, birthDate);
        manOrWoman(gender);
    }

    //Getters
    public static int getTotalTesters(){
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
    @Override
    public double getBonus() {
        return super.calculateSalary()*7/100+BONUS;
    }

    //Other methods

}
