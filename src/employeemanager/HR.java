package employeemanager;

import java.util.ArrayList;

public class HR {
    static ArrayList<Employee> employees = new ArrayList<>();

    public boolean registerEmployee(Employee employee){
        try{
            employees.add(employee);
            return true;
        } catch (Exception ex){
            System.out.println("Exception caught: " + ex);
        }
        return false;
    }
    public boolean deleteEmployee(int id){
        try{
            for (Employee employee : employees) {
                if(employee.getId() == id){
                    employees.remove(employee);
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
            for (Employee employee : employees) {
                if(employee.getId() == id){
                    employee.setName(newName);
                    return true;
                }
            }
        }catch (Exception ex){
            System.out.println("Exception caught: " + ex);
            return false;
        }
    }
    public boolean updateEmployeeBirthdate(int id, Date date){
        try{
            for (Employee employee : employees) {
                if(employee.getId() == id){
                    employee.setBirthdate(date);
                    return true;
                }
            }
        }catch (Exception ex){
            System.out.println("Exception caught: " + ex);
            return false;
        }
    }
}
