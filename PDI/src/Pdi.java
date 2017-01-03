import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class Pdi {
	public static void main(String[] args)throws IOException{//create new bufferd reader object then throw an IO exception
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the make and model of your favourite car");//prompt user to enter make price and tax rate
		String make = read.readLine();
		System.out.println("Enter the price of your car");
		double price = Double.parseDouble(read.readLine());
		System.out.println("Enter the sales tax percentage in your area");
		double tax = calcTax(Double.parseDouble(read.readLine()), price); //call method and pass price and tax rate to calculate the tax
		double PDI = calcPdi(price);//calculate and return the PDI charges
		NumberFormat frm = NumberFormat.getCurrencyInstance();//format the text based on currency
		System.out.println("Your car the " + make + " will have a " + frm.format(PDI) + " Pre-Delivery Inspection Charge. \n" + "You will also be charged " + frm.format(tax) + " in taxes. \n" + "The total price of your car will be " + frm.format(price+tax+PDI));
		//the line above will print out the make PDI, tax, and total cost of the car. Each will be written on a new line due to \n while all the values will be formatted as a currency. Total is the sum of price taxes and PDI
	}	

	private static double calcPdi(double price) {
		double pdi = price * 0.02;//pdi is 2 percent of yhe price
		return pdi;//return the pdi charges
	}

	private static double calcTax(double taxRate, double price) {//will accept tax rate and price
		double tax =0;
		tax = price * taxRate/100;//since tax rate was a percentage needs to be divided by 100
		return tax;//return the tax
	}
}
