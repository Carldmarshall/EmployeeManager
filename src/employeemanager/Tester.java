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

    public Tester(String name, int age, double hourlyRate, char gender, String birthDate, String department){
        super(name, age, hourlyRate, gender, birthDate, department);
        HR.registerEmployee(this);
    }

    @Override
    void calculateSalary() {

    }
}
