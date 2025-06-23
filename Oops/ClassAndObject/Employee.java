import java.util.Scanner;
class Employee {
    String name;
    int id;
    double salary;
//Constructor
    Employee(String name,int id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;

    }
//  Display Employee Details
    void displayDealils(){
        System.out.println("  Em_Name:-"+name+"  Em_Id:-"+id+"  Em_Salary:-"+salary);
    }
//Main Function
    public static void main(String[] args) {
        Scanner detail = new Scanner(System.in);       //Input
        String name = detail.next();
        int id = detail.nextInt();
        double salary = detail.nextDouble();
        Employee e=new Employee(name , id , salary);
        e.displayDealils();
    }
}
