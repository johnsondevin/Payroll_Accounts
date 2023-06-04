public class Employee {
    private int employee_id;
	private String employee_name;
	private float hourly_wage;
	private int hours_worked;
	private float payment;

	static int newId = 1;

	public Employee(String name, float wage){
        employee_id = newId++;
        employee_name = name;
        hourly_wage = wage;
        hours_worked = 0;
    }

	public int get_id(){
        return employee_id;
    }

	public void display(){
        System.out.println("Employee ID: " + employee_id);
        System.out.println("Name of Employee: " + employee_name);
        System.out.println("Hourly Wage: $" + hourly_wage);
        System.out.println("Current Hours Worked: " + hours_worked);
    }

	public void add_hours(float num){
        hours_worked += num;
    }

	public void release_funds(){
        payment = hours_worked * hourly_wage;
        System.out.println("Your total payment is: $" + payment);
        hours_worked = 0;
    }

	public float get_wage(){
        return hourly_wage;
    }

	public float get_hours(){
        return hours_worked;
    }
}
