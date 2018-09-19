//Package
package employeemanager;

//Imports
import java.util.ArrayList;

public class HR {

    //Instantiate a new ArrayList that holds employee references.
    static ArrayList<Employee> employeeList = new ArrayList<>();
    //Register new employee by adding it to the arraylist. Returns true if everything is ok & false if something went wrong.
    boolean registerEmployee(Employee employee){
        try{
            employeeList.add(employee);
            return true;
        } catch (Exception ex){
            System.out.println("Exception caught: " + ex);
        }
        return false;
    }
    //Delete an employee from the arraylist based on id. Returns true if everything is ok & false if something went wrong.
    boolean removeEmployee(int id){
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
    //Update name attribute of employee based on id. Returns true if everything is ok & false if something went wrong.
    boolean updateEmployeeName(int id, String newName){
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
    //Update birthdate attribute of employee based on id. Returns true if everything is ok & false if something went wrong.
    boolean updateEmployeeBirthdate(int id, String date){
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
    //Updates department of employee by creating a new employee object and deleting the old one from the arraylist.
    boolean updateEmployeeDepartment(int id, int department){
        try{
            for (Employee employee : employeeList) {
                if(employee.getId() == id){
                    switch (department){
                        //1 for devops
                        case 1:
                            employee = new DevOps(employee.getName(), employee.getAge(), employee.getHourlyRate(), employee.getGender(), employee.getBirthDate());
                            removeEmployee(id);
                            employee.setId(id);
                        //2 for Test
                        case 2:
                            employee = new Tester(employee.getName(), employee.getAge(), employee.getHourlyRate(), employee.getGender(), employee.getBirthDate());
                            removeEmployee(id);
                            employee.setId(id);
                            break;
                        //3 for Development
                        case 3:
                            employee = new Developer(employee.getName(), employee.getAge(), employee.getHourlyRate(), employee.getGender(), employee.getBirthDate());
                            removeEmployee(id);
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
    //Updates the salary attribute of employee based on id. Returns true if everything is ok & false if something went wrong.
    boolean updateEmployeeSalary(int id, double newSalary){
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
    //Searches employee by name.
    ArrayList<Employee> searchEmployeeByName(String name){
        //Create new arraylist that will hold references to the found employees.
        ArrayList<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if(employee.getName().equalsIgnoreCase(name)){
                //Adds the found employee reference to new arraylist.
                foundEmployees.add(employee);
            }
        }
        //Returns all of the employees found.
        return foundEmployees;
    }
    //Searches for an employee based on id and returns it.
    Employee searchEmployeeById(int id){
        for (Employee employee : employeeList) {
            if(employee.getId()== id){
                return employee;
            }
        }
        return null;
    }
    //Returns all of the employee in a specific department.
    ArrayList<Employee> searchEmployeeByDepartment(String department){
        //Create new arraylist that will hold references to the found employees.
        ArrayList<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employeeList) {
            //If userinput matches subclass it will add the employee to the foundEmployees list.
            if(department.equals("DevOps") && employee instanceof DevOps){
                foundEmployees.add(employee);
            }else if(department.equals("Tester") && employee instanceof Tester){
                foundEmployees.add(employee);
            }else if(department.equals("Developer") && employee instanceof Developer){
                foundEmployees.add(employee);
            }
        }
        //Returns the arraylist containing the found employees.
        return foundEmployees;
    }
    //Calculates the averagewage in the company.
    double calculateAverageWage(){
        double totalWage = 0;
        for (Employee employee : employeeList) {
            totalWage += employee.calculateSalary();
        }
        return totalWage / employeeList.size();
    }
    //Returns max salary in the company.
    double maxSalary(){
        double maxSalary = 0;
        for (Employee employee : employeeList) {
            if(employee.calculateSalary() > maxSalary){
                maxSalary = employee.calculateSalary();
            }
        }
        return maxSalary;
    }
    //Returns minimum salary in the company.
    double minSalary(){
        //Sets the first salary in the employeelist to minSalary and checks all remaining salaries against it.
        double minSalary = employeeList.get(0).calculateSalary();
        for (Employee employee : employeeList) {
            if(employee.calculateSalary() < minSalary){
                minSalary = employee.calculateSalary();
            }
        }
        return minSalary;
    }
    //Returns total bonus in the company.
    double calculateTotalBonus(){
        double totalBonus = 0;
        for (Employee employee : employeeList) {
            totalBonus += employee.getBonus();
        }
        return totalBonus;
    }
    //Calculate and return total gender distribution.
    double calculateGenderPercentage(){
        try{
            return ((Tester.getnWomen() + Developer.getnWomen() + DevOps.getnWomen()) / (double)employeeList.size() * 100);
        }
        catch(ArithmeticException ex){
            return 0;
        }
    }
    //Returns arraylist of strings containing gender distribution in the different departments.
    ArrayList<String> calculateGenderPercentagePerDepartment(){
        ArrayList<String> genderList = new ArrayList<>();
        genderList.add("Tester | Men: " + Math.round(genderPercentageTester()) + "% Women: " + (int)(100-genderPercentageTester()) + "%");
        genderList.add("Developer | Men: " + Math.round(genderPercentageTester()) + "% Women: " + (int)(100-genderPercentageDeveloper()) + "%");
        genderList.add("DevOps | Men: " + Math.round(genderPercentageTester()) + "% Women: " + (int)(100-genderPercentageDevOps()) + "%");
        return genderList;
    }
    //Calculates and returns gender distribution in test department.
    double genderPercentageTester(){
        try{
            return (Tester.getnMen() / (double)Tester.getTotalTesters() * 100);
        } catch (ArithmeticException ex){
            return 0;
        }
    }
    //Calculates and returns gender distribution in development department.
    double genderPercentageDeveloper(){
        try{
            return (Developer.getnMen() / (double)Developer.getTotalOfDevelopers() * 100);
        } catch (ArithmeticException ex){
            return 0;
        }
    }
    //Calculates and returns gender distribution in devops department.
    double genderPercentageDevOps(){
        try{
            return (DevOps.getnMen() / (double)DevOps.getTotalOfDevOps() * 100);
        } catch (ArithmeticException ex){
            return 0;
        }
    }
    //Debug
    void debug(){
        registerEmployee(new DevOps("Botany Stinkyrash", 1, 120, 'F',  "1990-07-20"));
        registerEmployee(new DevOps("Bombadil Cramplesnutch", 1, 112, 'M', "1990-07-20"));
        registerEmployee(new DevOps("Rinkydink Anglerfish", 1, 84, 'M', "1990-07-20"));
        registerEmployee(new Tester("Baseballmitt Concubine", 1, 122, 'F',  "1990-07-20"));
        registerEmployee(new Tester("Botany Cankersore", 1, 152, 'M',  "1990-07-20"));
        registerEmployee(new Tester("Tiddleywomp Chesterfield", 1, 321, 'M',  "1990-07-20"));
        registerEmployee(new Developer("Bandicoot Crackerjack", 1, 132, 'F',  "1990-07-20"));
        registerEmployee(new Developer("Buckyball Bonaparte", 1, 151, 'M',  "1990-07-20"));
        registerEmployee(new Developer("Burlington Lingerie", 1, 156, 'M',  "1990-07-20"));
    }
}
