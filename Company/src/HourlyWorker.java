
public class HourlyWorker extends Employee {
	private double hours, hourlyRate;//set the hours and hourly rate
	public HourlyWorker(String fName, String lName,double hourlyRate, String ID, double hours) {
		super(fName, lName, ID);//set the first lastname and ID for the employee 
		this.hours = hours;//set the hours and hourly rate for this instance of hourly worker
		this.hourlyRate=hourlyRate;
		// TODO Auto-generated constructor stub
	}
	public HourlyWorker(){//other wise create hourly worker with no parameters
		super(null, null,null);
	}
	
	public void setHours(double hours){//set hours
		this.hours = hours;
	}
	public void setHourly(double hourlyRate){//set hourly rate
		this.hourlyRate = hourlyRate;
	}
	public double getHours(){//return the hours worked
		return this.hours;
	}
	public double getHourly(){//return the hourly rate
		return this.hourlyRate;
	}
	public double earnings(){//calculate the earnings
		double earnings;
		if(hours > 40){//if overtime work,for every hours over forty pay than 1.5 times as much then add the salary
			 earnings = 1.5 * hourlyRate * (hours-40) + hourlyRate * 40 + this.getSalary();
		}else{//otherwise earnings is normal salary and  hourlyRate times amount of hours worked
			 earnings = hourlyRate * hours + this.getSalary();
		}
		return earnings;//return the earnings
	}
	public String toString(){//give info about the employee first name and last name
		return "Hourly Worker: " + this.getFirstName() + " " + this.getLastName();
	}
	public static void main(String[] args){//self testing main
		HourlyWorker hour = new HourlyWorker("Sidak", "Swag", 35, "1234", 50);//create new hourly worker
		hour.setSalary(20);//set salary and print out info
		System.out.println(hour.toString());
		System.out.println("Earnigns are " + hour.earnings());
		System.out.println("Salary is " + hour.getSalary());
		hour.setFirstName("Swagdack");//change its information
		hour.setLastName("Quack Quack");
		hour.setHourly(2);
		hour.setHours(5);
		hour.setSalary(30);
		System.out.println(hour.toString());//print out its info
		System.out.println("Earnigns are " + hour.earnings());
		System.out.println("Salary is " + hour.getSalary());
		
		
	}
}
