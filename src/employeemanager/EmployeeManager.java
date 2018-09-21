/*
* Labb 2 - ITHS Javautvecklare 2018 - Stockholm
* Made by: Pontus Paulsson & Carl M
*/


//Package
package employeemanager;

//Import
import java.util.ArrayList;
import java.util.Scanner;

//Start of class
public class EmployeeManager {
    //Instantiate a new HR object that will handle the employee management.
    private static HR hr = new HR();
    //Instantiate a new Scanner object to handle the programs input.
    private static Scanner sc = new Scanner(System.in);
    //Program starting point.
    public static void main(String[] args) {
        hr.debug(); //adds "dummy" people to the employeeList
        mainMenu(); //shows mainmenu
    }
    //Prints main menu
    private static void mainMenu(){
        boolean running = true;
        while(running){
            System.out.println("What do you want do to?\n" +
                    "1. Enter Employee management.\n" +
                    "2. Enter Employee statistics.\n" +
                    "0. Exit.");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            //Switch-case to handle main menu input.
            switch (choice){
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    employeeStatitics();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
        System.out.println("Exiting application...");
    }
    //Displays menu for employee management
    private static void employeeManagement(){
        boolean running = true;
        while (running) {
            System.out.println("--------------------------------------------");
            System.out.println("MANAGEMENT - What do you want do to?\n" +
                    "1. Register employee.\n" +
                    "2. Delete employee.\n" +
                    "3. Update name of employee.\n" +
                    "4. Update the birthdate of employee.\n" +
                    "5. Update the department of employee.\n" +
                    "6. Update Salary of employee.\n" +
                    "7. Search employee by name.\n" +
                    "8. Search employee number.\n" +
                    "9. Search employee by department.\n" +
                    "10. Display all employees.\n" +
                    "0. Back to main menu.");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    createNewEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    updateNameOfEmployee();
                    break;
                case 4:
                    updateBirthdateOfEmployee();
                    break;
                case 5:
                    updateDepartmentOfEmployee();
                    break;
                case 6:
                    updateSalaryOfEmployee();
                    break;
                case 7:
                    searchEmployeeByName();
                    break;
                case 8:
                    searchEmployeeById();
                    break;
                case 9:
                    searchEmployeeByDepartment();
                    break;
                case 10:
                    displayAllEmployees();
                    break;
                default:
                    running = false;
                    break;
            } //end of switch
        } // end of while
    }
    //Displays menu for employee statistics
    private static void employeeStatitics(){
        boolean running = true;
        while(running){
            System.out.println("--------------------------------------------");
            System.out.println("STATISTICS - What do you want do to?\n" +
                    "1. Average wage at the company.\n" +
                    "2. Maximum salary in the company.\n" +
                    "3. Minimum salary in the company.\n" +
                    "4. Total bonus.\n" +
                    "5. Total genderdistribution in the company.\n" +
                    "6. Genderdistribution in departments.\n" +
                    "0. Back to main menu.");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    calculateSalary();
                    break;
                case 2:
                    getMaxSalary();
                    break;
                case 3:
                    getMinSalary();
                    break;
                case 4:
                    getTotalBonus();
                    break;
                case 5:
                    calculateGenderPercentage();
                    break;
                case 6:
                    calculateGenderPercentagePerDepartment();
                    break;
                case 0:
                    running = false;
                    break;
            } //end of switch
        } //end of while
    }
    //Calls the registerEmployee method with a new Employee object.
    private static void createNewEmployee(){
        //Choose department
        System.out.println("Department?\n" +
                "1. DevOps\n" +
                "2. Test\n" +
                "3. Development");
        int department = sc.nextInt(); // lägg till kontroll
        sc.nextLine();
        //Input info about new employee
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Hourly wage: ");
        double hourlyWage = sc.nextDouble();
        sc.nextLine();
        System.out.print("Gender (M / F): ");
        String gender = sc.nextLine();
        //While loop to make sure user enters correct gender.
        while(!gender.equals("M") && !gender.equals("F")){
            System.out.println("Wrong input. Please try again.");
            System.out.print("Gender (M / F): ");
            gender = sc.nextLine();
        } // end of while
        System.out.print("Date (YYYY-MM-DD: ");
        String birthDate = sc.nextLine();
        //Switch-case to handle the different subclasses (departments)
        switch(department){
            case 1:
                registerEmployee(new DevOps(name, age, hourlyWage, gender.charAt(0), birthDate));
                break;
            case 2:
                registerEmployee(new Tester(name, age, hourlyWage, gender.charAt(0), birthDate));
                break;
            case 3:
                registerEmployee(new Developer(name, age, hourlyWage, gender.charAt(0), birthDate));
                break;
            default:
                break;
        }

    }
    //Display all employees
    private static void displayAllEmployees(){
        //Loops thru arraylist and calls .tostring method on all employee object and then prints the returned string to console.
        for (Employee employee : HR.employeeList) {
            System.out.println(employee);
        }
    }
    //Removes an employee object from the arraylist.
    private static void removeEmployee(){
        System.out.println("Id of employee to remove: ");
        int id = sc.nextInt();
        //Calls removeEmployee method of hr object.
        if(hr.removeEmployee(id)){
            System.out.println("Employee successfully removed.");
        }else{
            System.out.println("Something went wrong when removing the employee. Please try again.");
        }
    }
    //Updates the name attribute of an employee.
    private static void updateNameOfEmployee(){
        System.out.println("Id of employee to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("New name: ");
        String newName = sc.nextLine();
        //Calls updateEmployee of hr object
        if(hr.updateEmployeeName(id, newName)){
            System.out.println("Update successful.");
        }else{
            System.out.println("Something went wrong when updating employee. Please try again.");
        }
    }
    //Updates the birthday attribute of an employee.
    private static void updateBirthdateOfEmployee(){
        System.out.println("Id of employee to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("New birthdate: ");
        String newBirthDate = sc.nextLine();
        //Calls updateEmployeeBirthdate of hr object.
        if(hr.updateEmployeeBirthdate(id, newBirthDate)){
            System.out.println("Update successful.");
        }else{
            System.out.println("Something went wrong when updating employee. Please try again.");
        }
    }
    //Updates the department of an employee.
    private static void updateDepartmentOfEmployee(){
        System.out.println("Id of employee to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Department?\n" +
                "1. DevOps\n" +
                "2. Test\n" +
                "3. Development");
        System.out.println("Choice: ");
        int department = sc.nextInt();
        //Calls updateEmployeeDepartment in HR class.
        if(hr.updateEmployeeDepartment(id, department)){
            System.out.println("Update successful.");
        }else{
            System.out.println("Something went wrong when updating employee. Please try again.");
        }
    }
    //Updates the salary attribute of the employee.
    private static void updateSalaryOfEmployee(){
        System.out.println("Id of employee to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("New salary: ");
        double salary = sc.nextDouble();
        //Calls updateEmployeeSalary in HR class
        if(hr.updateEmployeeSalary(id, salary)){
            System.out.println("Update successful.");
        }else{
            System.out.println("Something went wrong when updating employee. Please try again.");
        }
    }
    //Search employee by name
    private static void searchEmployeeByName(){
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        //Create new arraylist and store the result from hr.searchEmployeeByName in it.
        ArrayList<Employee> foundEmployees = hr.searchEmployeeByName(name);
        //If arraylist > 0, print out the arraylist.
        if(foundEmployees.size() > 0){
            for (Employee foundEmployee : foundEmployees) {
                System.out.println("Found employee: " + foundEmployee.getName());
            }
        } else{
            System.out.println("Couldnt find employee with name " + name);
        }

    }
    //Search employee by Id
    private static void searchEmployeeById(){
        sc.nextLine();
        System.out.print("Id: ");
        int id = sc.nextInt();
        //Calls searchEmployeeById of the hr object.
        Employee employee = hr.searchEmployeeById(id);
        if(employee != null){
            System.out.println("Found employee: " + employee.getName());
        } else{
            System.out.println("Couldnt find employee with id " + id);
        }

    }
    //Search employee by department
    private static void searchEmployeeByDepartment(){
        sc.nextLine();
        System.out.println("Department?\n" +
                "1. DevOps\n" +
                "2. Test\n" +
                "3. Development");
        System.out.print("Choice: ");
        int department = sc.nextInt();
        //Declares a new ArrayList of type employee and sets it referencetype to null.
        ArrayList<Employee> foundEmployees = null;
        //Switch-case that calls hr.SearchEmployeeDepartment and stores the result in foundEmployee ArrayList.
        switch (department) {
            case 1:
                foundEmployees = hr.searchEmployeeByDepartment("DevOps");
                break;
            case 2:
                foundEmployees = hr.searchEmployeeByDepartment("Test");
                break;
            case 3:
                foundEmployees = hr.searchEmployeeByDepartment("Development");
                break;
        }
        //If arraylist > 0 print the arraylist.
        if(foundEmployees != null && foundEmployees.size() > 0){
            for (Employee foundEmployee : foundEmployees) {
                System.out.println("Found employee: " + foundEmployee.getName());
            }
        } else{
            System.out.println("Couldn't find any employees in that department.");
        }

    }
    //Prints average monthly wage without bonuses.
    private static void calculateSalary(){
        System.out.println("Average monthly wage (without bonus): " + (int)hr.calculateAverageWage() + "kr");
    }
    //Prints maximum salary in the company.
    private static void getMaxSalary(){
        System.out.println("Max salary is: " + (int)hr.maxSalary() + "kr");
    }
    //Prints minimum salary in the company.
    private static void getMinSalary(){
        System.out.println("Min salary is: " + (int)hr.minSalary() + "kr");
    }
    //Prints total bonus in the company
    private static void getTotalBonus(){
        System.out.println("Total bonus: " + (int) hr.calculateTotalBonus() + "kr");
    }
    //Prints gender distribution in the company.
    private static void calculateGenderPercentage(){
        System.out.println("Women: " + (int)hr.calculateGenderPercentage() + "% Men: " + (100-(int)hr.calculateGenderPercentage() + "%"));
    }
    //Prints gender distribution per department in the company.
    private static void calculateGenderPercentagePerDepartment(){
        ArrayList<String> genderList = hr.calculateGenderPercentagePerDepartment();
        for (String s :genderList) {
            System.out.println(s);
        }
    }
    //Registers a new employee.
    private static void registerEmployee(Employee employee){
        if(hr.registerEmployee(employee)){
            System.out.println("Successfully registered new employee.");
        }else{
            System.out.println("Something went wrong with registering the new employee. Please try again.");
        }
    }
}
