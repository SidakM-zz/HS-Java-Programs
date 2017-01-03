
public class CommissionWorker extends Employee {
	private double commision;
	private int sales;
	public CommissionWorker(String fName, String lName, String ID, double commission,int sales) {
		super(fName, lName, ID);
		this.commision = commision;
		this.sales = sales;
		// TODO Auto-generated constructor stub
	}
	public CommissionWorker() {//create an empty commision worker
		super(null, null, null);
		// TODO Auto-generated constructor stub
	}
	public double earnings(){//calculate earnings and return them
		double earnings = commision/100 * sales;
		return earnings;
	}
	public void setCommision(double commision){//set the commission
		this.commision = commision;//this instances commission is commision
	}
	public void setSales(int sales){//set the amount of sales
		this.sales= sales;//set this instances sales as sales
	}
	public int getSales(){//get sales
		return this.sales;//return the sales
	}
	public double getCommision(){//get the commision
		return this.commision;
	}
	public String toString(){
		return "Commision Worker: " + this.getFirstName() + " " + this.getLastName();
	}
	
 
}
