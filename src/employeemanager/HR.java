package employeemanager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
}
