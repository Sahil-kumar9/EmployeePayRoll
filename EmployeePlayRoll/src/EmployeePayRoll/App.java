package EmployeePayRoll;

import java.util.ArrayList;

abstract class Employee{
    private final int employee_id;
    private final String employee_name;

    public Employee(int employee_id, String employee_name){
        this.employee_name = employee_name;
        this.employee_id = employee_id;
    }

    public int getEmployee_id(){
        return employee_id;
    }

//    public String getEmployee_name(){
//        return employee_name;
//    }

    public abstract double calculateSal();

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' + calculateSal() +
                '}';
    }
}

class FullTimeEmployee extends Employee{

    private final double monthlySal;

    public FullTimeEmployee(int employee_id, String employee_name, double monthlySal){
        super(employee_id,employee_name);
        this.monthlySal = monthlySal;
    }

    @Override
    public double calculateSal(){
        return monthlySal;
    }
}

class PartTimeEmployee extends Employee{
    private final int hourlyWorked;
    private final double hourlyRate;

    public PartTimeEmployee(int employee_id, String employee_name, int hourlyWorked, double hourlyRate){
        super(employee_id,employee_name);
        this.hourlyRate = hourlyRate;
        this.hourlyWorked = hourlyWorked;
    }

    public double calculateSal(){
        return hourlyRate * hourlyWorked;
    }
}

class PayRoll{
    private final ArrayList<Employee> employeesList;

   public PayRoll(){
       employeesList = new ArrayList<>();
   }

    public void addEmployee(Employee employee){
       employeesList.add(employee);
    }

    public void removeAEmployee(int id){
       Employee employeeRemove = null;
       for (Employee employee : employeesList){
           if(employee.getEmployee_id() == id){
               employeeRemove = employee;
               break;
           }
       }
       if(employeeRemove != null){
           employeesList.remove(employeeRemove);
       }
       else {
           System.out.println("Employee ID Not Found...");
       }
    }

    public void getEmployee(){
       for (Employee employee:employeesList){
           System.out.println(employee);
       }
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("Employee Pay Roll System...");
        PartTimeEmployee employee1 = new PartTimeEmployee(1,"Alex",2,200);
        FullTimeEmployee employee2 = new FullTimeEmployee(2,"Rob",20000);
        PayRoll payRoll = new PayRoll();
        System.out.println("Adding The Employee");
        payRoll.addEmployee(employee1);
        payRoll.addEmployee(employee2);
        System.out.println("Displaying The Employee");
        payRoll.getEmployee();
        System.out.println(employee1.calculateSal());
        System.out.println("Removing The Employee");
        payRoll.removeAEmployee(4);
        payRoll.getEmployee();

    }
}
