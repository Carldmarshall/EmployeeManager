package employeemanager;

import java.util.ArrayList;
import java.util.HashMap;

public class HR {

    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static boolean registerEmployee(Employee employee){
        try{
            employeeList.add(employee);
            return true;
        } catch (Exception ex){
            System.out.println("Exception caught: " + ex);
        }
        return false;
    }
    public boolean deleteEmployee(int id){
        try{
            for (Employee employee : employeeList) {
                if(employee.getId() == id){
                    employeeList.remove(employee);
                    return true;
                }
            }
        } catch(Exception ex){
            System.out.println("Exception caught: " + ex);
        }
        return false;
    }
    public boolean updateEmployeeName(int id, String newName){
        try{
            for (Employee employee : employeeList) {
                if(employee.getId() == id){
                    employee.setName(newName);
                    return true;
                }
            }
        }catch (Exception ex){
            System.out.println("Exception caught: " + ex);
        }
        return false;
    }
    public boolean updateEmployeeBirthdate(int id, String date){
        try{
            for (Employee employee : employeeList) {
                if(employee.getId() == id){
                    employee.setBirthDate(date);
                    return true;
                }
            }
        }catch (Exception ex){
            System.out.println("Exception caught: " + ex);
        }
        return false;
    }
    public boolean updateEmployeeDepartment(int id, int deparment){
        try{
            for (Employee employee : employeeList) {
                if(employee.getId() == id){
                    switch (deparment){
                        case 1:
                            employee.setDepartment("DevOps");
                            break;
                        case 2:
                            employee.setDepartment("Test");
                            break;
                        case 3:
                            employee.setDepartment("Development");
                            break;
                    }

                    return true;
                }
            }
        }catch (Exception ex){
            System.out.println("Exception caught: " + ex);
        }
        return false;
    }
    public boolean updateEmployeeSalary(int id, double newSalary){
        try{
            for (Employee employee : employeeList) {
                if(employee.getId() == id){
                    employee.setHourlyRate(newSalary);
                    return true;
                }
            }
        }catch (Exception ex){
            System.out.println("Exception caught: " + ex);
        }
        return false;
    }
    public ArrayList<Employee> searchEmployeeByName(String name){
        ArrayList<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if(employee.getName().equalsIgnoreCase(name)){
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }
    public Employee searchEmployeeById(int id){
        for (Employee employee : employeeList) {
            if(employee.getId()== id){
                return employee;
            }
        }
        return null;
    }
    public ArrayList<Employee> searchEmployeeByDepartment(String department){
        ArrayList<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if(employee.getDepartment().equals(department)){
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }
    public void displayAllEmployees(){
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
    public double calculateAverageWage(){
        double totalWage = 0;
        for (Employee employee : employeeList) {
            totalWage += employee.calculateSalary();
        }
        return totalWage / employeeList.size();
    }
    public double maxSalary(){
        double maxSalary = 0;
        for (Employee employee : employeeList) {
            if(employee.calculateSalary() > maxSalary){
                maxSalary = employee.calculateSalary();
            }
        }
        return maxSalary;
    }
    public double minSalary(){
        double minSalary = employeeList.get(0).calculateSalary();
        for (Employee employee : employeeList) {
            if(employee.calculateSalary() < minSalary){
                minSalary = employee.calculateSalary();
            }
        }
        return minSalary;
    }
    public double calculateTotalBonus(){
        double totalBonus = 0;
        for (Employee employee : employeeList) {
            totalBonus += employee.getBonus();
        }
        return totalBonus;
    }
    public double calculateGenderPercentage(){
        double women = 0;
        for (Employee employee : employeeList) {
            if (employee.getGender() == 'F') women++;
        }
        return (women / employeeList.size()) * 100;
    }
    public HashMap<String, Integer> calculateGenderPercentagePerDepartment(){
        HashMap<String, Integer> genderDepartment = new HashMap<>();
        int menTester = 0;
        int menDeveloper = 0;
        int menDevOps = 0;
        int nDevOps = 0;
        int nDeveloper = 0;
        int nTester = 0;
        for (Employee employee : employeeList) {
            if(employee instanceof Tester){
                nTester++;
                if(employee.getGender() == 'M') menTester++;
            }else if(employee instanceof Developer){
                nDeveloper++;
                if(employee.getGender() == 'M') menDeveloper++;
            }else if(employee instanceof DevOps){
                nDevOps++;
                if(employee.getGender() == 'M') menDevOps++;
            }
        }
        genderDepartment.put("Tester",(menTester / nTester) * 100);
        genderDepartment.put("Developer",(menDeveloper / nDeveloper) * 100);
        genderDepartment.put("DevOps",(menDevOps / nDevOps) * 100);
        return genderDepartment;
    }

}
