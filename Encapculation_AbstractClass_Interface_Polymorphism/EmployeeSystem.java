// Interface for Department
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract class Employee
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation: Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + getDepartmentDetails());
        System.out.println("Final Salary: " + calculateSalary());
    }

    // Interface methods
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

// Subclass for Full-Time Employee
class FullTimeEmployee extends Employee {
    private double fixedBonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedBonus) {
        super(employeeId, name, baseSalary);
        this.fixedBonus = fixedBonus;
    }

    public double calculateSalary() {
        return getBaseSalary() + fixedBonus;
    }
}

// Subclass for Part-Time Employee
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}

// Main class
public class EmployeeSystem {
    public static void main(String[] args) {
        // Polymorphism: List of Employee references
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee(101, "Alice", 30000, 5000);
        employees[0].assignDepartment("HR");

        employees[1] = new PartTimeEmployee(102, "Bob", 10000, 20, 500);
        employees[1].assignDepartment("Support");

        employees[2] = new FullTimeEmployee(103, "Charlie", 35000, 8000);
        employees[2].assignDepartment("Development");

        // Display all employees using Employee reference (Polymorphism)
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
