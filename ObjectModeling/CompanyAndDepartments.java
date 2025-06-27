import java.util.ArrayList;
import java.util.List;

// Employee class
class Employee {
    private String name;
    private String position;

    // Constructor
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void displayInfo() {
        System.out.println("  - Employee: " + name + " (" + position + ")");
    }
}

// Department class (part of Company)
class Department {
    private String departmentName;
    private List<Employee> employees;

    // Constructor
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    // Add employee to department
    public void addEmployee(String name, String position) {
        Employee emp = new Employee(name, position);
        employees.add(emp);
    }

    public void showDepartmentInfo() {
        System.out.println("Department: " + departmentName);
        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }

    public void clearEmployees() {
        employees.clear(); // Simulate deletion
    }
}

// Company class (Composition)
class Company {
    private String companyName;
    private List<Department> departments;

    // Constructor
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Add a new department
    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    // Display company structure
    public void showCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.showDepartmentInfo();
        }
        System.out.println();
    }

    // Delete company (clears all departments and employees)
    public void deleteCompany() {
        System.out.println("Deleting company: " + companyName + " and all its departments & employees.");
        for (Department dept : departments) {
            dept.clearEmployees();
        }
        departments.clear();
    }
}

// Main class
public class CompanyAndDepartments {
    public static void main(String[] args) {
        // Create company
        Company techCorp = new Company("TechCorp");

        // Create departments
        Department devDept = new Department("Development");
        devDept.addEmployee("Alice", "Developer");
        devDept.addEmployee("Bob", "Senior Developer");

        Department hrDept = new Department("Human Resources");
        hrDept.addEmployee("Charlie", "HR Manager");

        // Add departments to company
        techCorp.addDepartment(devDept);
        techCorp.addDepartment(hrDept);

        // Display structure
        techCorp.showCompanyStructure();

        // Delete company (composition => departments and employees also deleted)
        techCorp.deleteCompany();

        // Try displaying again (should be empty)
        techCorp.showCompanyStructure();
    }
}
