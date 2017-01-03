public class Employee
{
	private String lName, fName;  //private class data for names and id.
	private String empID;
	private double salary;

	public Employee(String fName, String lName, String ID)//meaningful cosntructor
	{
		this.fName = fName;
		this.lName = lName;
		this.empID = ID;
	}

	public String getFirstName()
	//gets first name
	{
		return fName;
	}

	public String getLastName()
	//gets last name
	{
		return lName;
	}

	public String getID()
	//gets employee ID
	{
		return empID;
	}

	public void setFirstName(String fn)
	//sets first name
	{
		fName = fn;
	}

	public void setLastName(String ln)
	//sets last name
	{
		lName = ln;
	}

	public void setID(String ID)
	//sets employee ID
	{
		empID = ID;
	}

	public void setSalary(double sal)
	//gets salary
	{
		salary = sal;
	}

	public double getSalary()
	//gets salary
	{
		return salary;
	}
	public String toString()
	// returns a string representation of Employee
	{
		return "Employee: " + fName + ", " + lName + ", " + empID;
	}

	public static void main (String args[]) //self testing main method
	{
		// create employee object and test all methods
		Employee emp = new Employee ("John", "Smith", "P0444444");
		System.out.println(emp.toString());
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		System.out.println(emp.getID());
		// change employee information
		emp.setFirstName("Joanne");
		emp.setLastName("Johnson");
		emp.setID("P0123456");
		// display again
		System.out.println(emp.toString());
	}

}