package employeemanager;

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
    public boolean updateEmployeeBirthdate(int id, Date date){
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
    public boolean updateEmployeeDepartment(int id, String newDepartment){
        try{
            for (Employee employee : employeeList) {
                if(employee.getId() == id){
                    employee.setDepartment(newDepartment);
                    return true;
                }
            }
        }catch (Exception ex){
            System.out.println("Exception caught: " + ex);
        }
        return false;
    }
    public boolean updateEmployeeDepartment(int id, double newSalary){
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
    public Employee searchEmployeeByName(String name){
        for (Employee employee : employeeList) {
            if(employee.getName().equalsIgnoreCase(name)){
                return employee;
            }
        }
        return null;
    }
    public Employee searchEmployeeById(int id){
        for (Employee employee : employeeList) {
            if(employee.getId()== id){
                return employee;
            }
        }
        return null;
    }
    public Employee searchEmployeeByDepartment(String department){
        for (Employee employee : employeeList) {
            if(employee.getDepartment()== department){
                return employee;
            }
        }
        return null;
    }
    public void displayAllEmployees(){
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
