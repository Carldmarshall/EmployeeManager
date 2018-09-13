/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanager;

import java.text.SimpleDateFormat;

/**
 *
 * @author cm
 */
public class Tester extends Employee{
    private final int TESTER_BONUS = 1207;

    public Tester(String name, int age, double hourlyRate, char gender, String birthDate, String department){
        super(name, age, hourlyRate, gender, birthDate, department);
        HR.registerEmployee(this);
    }

    @Override
    public double getBonus() {
        return super.calculateSalary()*7/100+TESTER_BONUS;
        
    }
}
