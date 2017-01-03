import java.util.Random;


public class Account {
	private double balance;//class variables
	private long accountNumber;
	private Customer owner;
	
	
	public static void main(String[] args){
		Account acc = new Account(1000, new Customer());//create an accunt class with a $1000 blance and a new Customer
		acc.deposit(1000);//deposit a $1000 into the account
		System.out.println(acc.getBalance());//print out the new balance
		acc.withdraw(1000);//take out $1000 from the account
		System.out.println(acc.getBalance());//print out the new balance 		
		
		System.out.println(acc.getNum());//print the account number
		acc.genNum();
		System.out.println(acc.getNum());//generate a new account number and print it
		
		acc.setBalance(1000);//set the balance to $1000
		System.out.println(acc.getBalance());//print out the new balance
	}
	public Account(double balance, Customer owner){//contructor where th initial balance and the owner is set on creation
		genNum();
		this.balance = balance;
		this.owner = owner;
	}
	private long genNum(){ //generate random number that is nine digits long
		Random rand = new Random();
		this.accountNumber = (long)(rand.nextDouble() * 999999999);//set
		return this.accountNumber;
	}
	public long getNum(){//get the random number
		return this.accountNumber;
	}
	public Account(){//blank account
	}
	public void setBalance(double balance){//set the balance
		this.balance = balance; 
	}
	public double getBalance(){//get the balance
		return balance; 
	}
	public boolean withdraw(double amount){//withraw your money
		if(amount>balance){//if teh amount is greater than the balance return false
			return false;
		}else{//otherwise subtract amount from balance
			balance = balance - amount;
			return true;
		}		
	}
	public void deposit(double amt){//deposit amount into the balance
		balance = balance + amt;
	}
	public void account(Customer owner){//set the customer for the account
		this.owner = owner;
	}
}
