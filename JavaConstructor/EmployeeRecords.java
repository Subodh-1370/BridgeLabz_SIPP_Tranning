public class EmployeeRecords {
    public int employeeID;
    protected String department;
    private double salary;

    public EmployeeRecords(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends EmployeeRecords {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void showManagerInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {
        Manager m = new Manager(201, "IT", 80000);
        m.showManagerInfo();
        System.out.println("Salary: ₹" + m.getSalary());
    }
}
