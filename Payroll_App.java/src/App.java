import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        List<Employee> roster = new ArrayList<Employee>();

        int loop = 1;

        while(loop != 0){
            System.out.println("0: Exit Program");
            System.out.println("1: Display Employee Roster");
            System.out.println("2: Add Employee");
            System.out.println("3: Add Hours");
            System.out.println("4: Pay Accounts");
            System.out.println("5: Remove Employee");

            System.out.println("Selection: ");
            loop = input.nextInt();

            switch (loop){

                case 0:
                    loop = 0;
                    break;

		        case 1:
                    display_roster(roster);
                    break;

                case 2:
                    add_employee(roster, input);
                    break;

                case 3:
                    int id;
                    float hours;

                    System.out.println("Enter the Employee ID: ");
                    id = input.nextInt();

                    System.out.println("Enter the number of hours: ");
                    hours = input.nextFloat();

                    // List iterator for List<Employee>
                    for (ListIterator<Employee> it = roster.listIterator(); it.hasNext();){
                        Employee employee = it.next();
                        if (employee.get_id() == id){
                            employee.add_hours(hours);
                        }
                    }
                    break;

                case 4:
                    pay_accounts(roster);
                    break;

                case 5:
                    remove_employee(roster, input);
                    break;
            }
        }
    }

    // Display all employees in the system
    static void display_roster(List<Employee> roster){
        for (Employee employee : roster) {
            employee.display();
        }
    }

    // Add employee into the system
    static void add_employee(List<Employee> roster, Scanner input){
        String name;
        float wage;

        System.out.println("Enter the employee's name: ");
        name = input.next();

        System.out.println("Enter a starting wage: $");
        wage = input.nextFloat();

        Employee worker = new Employee(name, wage);
        roster.add(worker);
    } 

    // Pay all employees
    static void pay_accounts(List<Employee> roster){
        for(Employee employee : roster){
            employee.release_funds();
        }

        System.out.println("Employees have been paid.");
    }

    // Remove employee from the system
    static void remove_employee(List<Employee> roster, Scanner input){
        int number;
        System.out.println("Enter the employee ID: ");
        number = input.nextInt();

        for (ListIterator<Employee> it = roster.listIterator(); it.hasNext();){
            Employee employee = it.next();
            if (employee.get_id() == number){
                roster.remove(employee);
            }
        }
    }
}
