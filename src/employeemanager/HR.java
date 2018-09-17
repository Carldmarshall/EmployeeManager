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
    public boolean updateEmployeeDepartment(int id, int department){
        try{
            for (Employee employee : employeeList) {
                if(employee.getId() == id){
                    switch (department){
                        //1 for devops
                        case 1:
                            employee = new DevOps(employee.getName(), employee.getAge(), employee.getHourlyRate(), employee.getGender(), employee.getBirthDate());
                            deleteEmployee(id);
                            employee.setId(id);
                        //2 for Test
                        case 2:
                            employee = new Tester(employee.getName(), employee.getAge(), employee.getHourlyRate(), employee.getGender(), employee.getBirthDate());
                            deleteEmployee(id);
                            employee.setId(id);
                            break;
                        //3 for Development
                        case 3:
                            employee = new Developer(employee.getName(), employee.getAge(), employee.getHourlyRate(), employee.getGender(), employee.getBirthDate());
                            deleteEmployee(id);
                            employee.setId(id);
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
            if(department.equals("DevOps") && employee instanceof DevOps){
                foundEmployees.add(employee);
            }else if(department.equals("Tester") && employee instanceof Tester){
                foundEmployees.add(employee);
            }else if(department.equals("Developer") && employee instanceof Developer){
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
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
        return (Tester.nWomen + Developer.nWomen + DevOps.nWomen / employeeList.size()) * 100;
    }
    public ArrayList<String> calculateGenderPercentagePerDepartment(){
        ArrayList<String> genderList = new ArrayList<>();
        genderList.add("Tester | Men: " + genderPercentageTester() + "% Women: " + (100-genderPercentageTester()) + "%");
        genderList.add("Developer | Men: " + genderPercentageDeveloper() + "% Women: " + (100-genderPercentageDeveloper()) + "%");
        genderList.add("DevOps | Men: " + genderPercentageDevOps() + "% Women: " + (100-genderPercentageDevOps()) + "%");
        return genderList;
    }
    public int genderPercentageTester(){
        try{
            return Math.round(Tester.nWomen + Tester.nMen) / Tester.nMen;
        } catch (ArithmeticException ex){
            return 0;
        }
    }
    public int genderPercentageDeveloper(){
        try{
            return Math.round(Developer.nWomen + Developer.nMen) / Developer.nMen;
        } catch (ArithmeticException ex){
            return 0;
        }
    }
    public int genderPercentageDevOps(){
        try{
            return Math.round(DevOps.nWomen + DevOps.nMen) / DevOps.nMen;
        } catch (ArithmeticException ex){
            return 0;
        }
    }
}
