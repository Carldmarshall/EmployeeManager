
package employeemanager;

import java.text.SimpleDateFormat;

public class DevOps extends Employee {

    public DevOps(String name, int age, double hourlyRate, char gender, SimpleDateFormat birthDate, String department){
        super(name, age, hourlyRate, gender, birthDate, department);
        HR.registerEmployee(this);
    }



    @Override
    void calculateSalary() {

    }
}
