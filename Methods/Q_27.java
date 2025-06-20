import java.util.Random;

public class Q_27 {
    public static double[][] generateEmployeeData(int count) {
        double[][] data = new double[count][2];
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            double salary = rand.nextInt(90000) + 10000; // 5-digit salary
            double years = rand.nextInt(11); // 0 to 10 years
            data[i][0] = salary;
            data[i][1] = years;
        }

        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] employees) {
        double[][] updated = new double[employees.length][3]; // [old_salary, bonus, new_salary]

        for (int i = 0; i < employees.length; i++) {
            double salary = employees[i][0];
            double years = employees[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;

            updated[i][0] = salary;
            updated[i][1] = bonus;
            updated[i][2] = newSalary;
        }

        return updated;
    }

    public static void displayResults(double[][] employees, double[][] updated) {
        double totalOld = 0, totalBonus = 0, totalNew = 0;

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-20s %-15s\n", "Emp_ID", "Old Salary", "Years of Service", "Bonus", "New Salary");
        System.out.println("-----------------------------------------------------------------------");

        for (int i = 0; i < employees.length; i++) {
            double oldSalary = updated[i][0];
            double years = employees[i][1];
            double bonus = updated[i][1];
            double newSalary = updated[i][2];

            totalOld += oldSalary;
            totalBonus += bonus;
            totalNew += newSalary;

            System.out.printf("Emp-%02d     %-15.2f %-20.0f %-15.2f %.2f\n", i + 1, oldSalary, years, bonus, newSalary);
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("TOTALS:      %-15.2f %-20s %-15.2f %.2f\n", totalOld, "-", totalBonus, totalNew);
    }

    public static void main(String[] args) {
        int employeeCount = 10;
        double[][] employeeData = generateEmployeeData(employeeCount);
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);
        displayResults(employeeData, updatedData);
    }
}
