/* Easy Level: Employee Management System Problem Statement 📝 Write a Java program to implement an ArrayList that stores employee details (ID, Name, and Salary). Allow users to:
Add employees
Update employee details
Remove employees
Search for employees
Key Concepts Used 🛠️ ArrayList: To store employee objects.
Encapsulation: Employee details are stored in a class with private fields and public getters/setters.
User Interaction: Using Scanner for input/output operations.
How to Run 🏃‍♂️ Navigate to the Easy/ folder.
Compile and run the EmployeeManagement.java file.
Follow the on-screen instructions to manage employee details. */

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class A4easy {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee Details");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search for Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addEmployee(employees, scanner);
                    break;
                case 2:
                    updateEmployee(employees, scanner);
                    break;
                case 3:
                    removeEmployee(employees, scanner);
                    break;
                case 4:
                    searchEmployee(employees, scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee(ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        Employee employee = new Employee(id, name, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    private static void updateEmployee(ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.print("Enter new employee name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new employee salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();
                employee.setName(name);
                employee.setSalary(salary);
                System.out.println("Employee details updated successfully!");
                return;
            }
          }
        System.out.println("Employee not found!");
    }
    private static void removeEmployee(ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter employee ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Employee removed successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    private static void searchEmployee(ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter employee ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Employee Salary: " + employee.getSalary());
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}