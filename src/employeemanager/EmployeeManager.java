
package employeemanager;

import javafx.application.Application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManager {
    static HR hr = new HR();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Test");
        boolean running = true;
        Employee emp1 = new DevOps("DevOps1", 1, 1, 'M',  "1990-07-20", "DevOps");
        Employee emp2 = new DevOps("DevOps2", 1, 1, 'M', "1990-07-20", "DevOps");
        Employee emp3 = new DevOps("DevOps3", 1, 1, 'M', "1990-07-20", "DevOps");
        Tester test1 = new Tester("Tester1", 1, 1, 'F',  "1990-07-20", "Test");
        Tester test2 = new Tester("Tester2", 1, 1, 'F',  "1990-07-20", "Test");
        Tester test3 = new Tester("Tester3", 1, 1, 'F',  "1990-07-20", "Test");
        Developer developer1 = new Developer("Developer1", 1, 1, 'F',  "1990-07-20", "Development");
        Developer developer2 = new Developer("Developer2", 1, 1, 'F',  "1990-07-20", "Development");
        Developer developer3 = new Developer("Developer3", 1, 1, 'F',  "1990-07-20", "Development");


        hr.displayAllEmployees();
        while(running){
            System.out.println("What do you want do to?\n" +
                    "1. Enter Employee management.\n" +
                    "2. Enter Employee statistics.\n" +
                    "0. Exit.");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    employeeStatitics();
                    break;
                case 0:
                    System.out.println("Exiting application.");
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
                    break;
            }

        }
    }
    static void employeeManagement(){

        System.out.println("What do you want do to?\n" +
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
                "0. Back to main menu.\n");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                registerEmployee();
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
            case 10:
                displayAllEmployees();
            default:
                break;
        }
    }
    static void employeeStatitics(){
        System.out.println("What do you want do to?\n" +
                "1. Average wage at the company.\n" +
                "2. Maximum salary in the company.\n" +
                "3. Minimum salary in the company.\n" +
                "4. Total bonus.\n" +
                "5. Women in percentage in the company.\n" +
                "6. Men percentage of the various work role categories.\n" +
                "0. Back to main menu.\n");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
    }
    static void registerEmployee(){
        System.out.println("Department?\n" +
                "1. DevOps\n" +
                "2. Test\n" +
                "3. Development");
        int department = sc.nextInt(); // lägg till kontroll
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Hourly wage: ");
        double hourlyWage = sc.nextDouble();
        sc.nextLine();
        System.out.println("Gender (M / F): ");
        String gender = sc.nextLine();
        System.out.println("Date (YYYY-MM-DD: ");
        String birthDate = sc.nextLine();
        switch(department){
            case 1:
                new DevOps(name, age, hourlyWage, gender.charAt(0), birthDate, "DevOps");
                break;
            case 2:
                new Tester(name, age, hourlyWage, gender.charAt(0), birthDate, "Test");
                break;
            case 3:
                new Developer(name, age, hourlyWage, gender.charAt(0), birthDate, "Development");
                break;
            default:
                break;
        }

    }
    static void displayAllEmployees(){
        hr.displayAllEmployees();
    }
    static void removeEmployee(){
        System.out.println("Id of employee to remove: ");
        int id = sc.nextInt();
        hr.deleteEmployee(id); //TODO add if else
    }
    static void updateNameOfEmployee(){
        System.out.println("Id of employee to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("New name: ");
        String newName = sc.nextLine();
        hr.updateEmployeeName(id, newName); //TODO add if else
    }
    static void updateBirthdateOfEmployee(){
        System.out.println("Id of employee to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("New birthdate: ");
        String newBirthDate = sc.nextLine();
        hr.updateEmployeeBirthdate(id, newBirthDate); //TODO add if else
    }
    static void updateDepartmentOfEmployee(){
        System.out.println("Id of employee to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Department?\n" +
                "1. DevOps\n" +
                "2. Test\n" +
                "3. Development");
        int department = sc.nextInt();
        hr.updateEmployeeDepartment(id, department); //TODO add if else
    }
    static void updateSalaryOfEmployee(){
        System.out.println("Id of employee to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("New salary: ");
        String salary = sc.nextLine();
        hr.updateEmployeeBirthdate(id, salary); //TODO add if else
    }
    static void searchEmployeeByName(){
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        Employee employee = hr.searchEmployeeByName(name);
        if(employee != null){
            System.out.println("Found employee: " + employee.getName());
        } else{
            System.out.println("Couldnt find employee with name " + name);
        }

    }
    
}
