
package employeemanager;

import javafx.application.Application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManager {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Test");
        boolean running = true;
        Employee emp1 = new DevOps("DevOps1", 1, 1, 'M', 1, new Date(1990, 07, 10), "DevOps");
        Employee emp2 = new DevOps("DevOps2", 1, 1, 'M', 1, new Date(1990, 07, 10), "DevOps");
        Employee emp3 = new DevOps("DevOps3", 1, 1, 'M', 1, new Date(1990, 07, 10), "DevOps");
        Tester test1 = new Tester("Tester1", 1, 1, 'F', 1, new Date(), "TestDepartment");
        Tester test2 = new Tester("Tester2", 1, 1, 'F', 1, new Date(), "TestDepartment");
        Tester test3 = new Tester("Tester3", 1, 1, 'F', 1, new Date(), "TestDepartment");
        Developer developer1 = new Developer("Developer1", 1, 1, 'F', 1, new Date(), "DeveloperDepartment");
        Developer developer2 = new Developer("Developer2", 1, 1, 'F', 1, new Date(), "DeveloperDepartment");
        Developer developer3 = new Developer("Developer3", 1, 1, 'F', 1, new Date(), "DeveloperDepartment");


        HR hr = new HR();
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
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt();
        System.out.println("Hourly wage: ");
        double hourlyWage = sc.nextDouble();
        System.out.println("Gender (M / F): ");
        String gender = sc.nextLine();
        System.out.println("Date (YYYY-MM-DD: ");
        String date = sc.nextLine();
        SimpleDateFormat birthDate = new SimpleDateFormat(date);
        switch(department){
            case 1:
                new DevOps(name, age, hourlyWage, gender.charAt(0), birthDate, "DevOps");
                sDepartment = "DevOps";
                break;
            case 2:
                sDepartment = "Test";
                break;
            case 3:
                sDepartment = "Developer";
                break;
            default:
                break;
        }

    }
    
}
