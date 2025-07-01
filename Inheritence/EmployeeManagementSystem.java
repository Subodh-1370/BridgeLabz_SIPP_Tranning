class EmployeeManagementSystem {
    String name;
    int id;
    int salary;

    EmployeeManagementSystem(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDitails() {
        System.out.println("Name: " + name + ", Id: " + id + ", Salary: " + salary);
    }
}

class Manager extends EmployeeManagementSystem {
    int teamSize;

    Manager(String name, int id, int salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDitails() {
        super.displayDitails(); // Optional: to also show common details
        System.out.println("Role: Manager, Team Size: " + teamSize);
    }
}

class Developer extends EmployeeManagementSystem {
    String programmingLanguage;

    Developer(String name, int id, int salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDitails() {
        super.displayDitails(); // Optional
        System.out.println("Role: Developer, Programming Language: " + programmingLanguage);
    }
}

class Intern extends EmployeeManagementSystem {
    int duration; // in months

    Intern(String name, int id, int salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    void displayDitails() {
        super.displayDitails(); // Optional
        System.out.println("Role: Intern, Duration: " + duration + " months");
    }
}

class Main1{
    public static void main(String[] args) {
        EmployeeManagementSystem E1 = new Manager("Abhishek", 99, 30000, 5);
        EmployeeManagementSystem E2 = new Developer("John", 100, 20000, "Java");
        EmployeeManagementSystem E3 = new Intern("Ravi", 101, 10000, 6);

        E1.displayDitails();
        E2.displayDitails();
        E3.displayDitails();
    }
}
