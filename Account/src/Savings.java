
public class Savings extends Account {
	public Savings(double balance, Customer owner){
		super(balance,owner);//send the values to the account
	}
	public boolean withdraw(double amt){
		if(amt>this.getBalance()|| amt==0){//if the amount is greater than the balance or is zeroreturn false
			return false;
		}else if(this.getBalance() > 2000 || this.getBalance() == 2000){//if there is at least 2000 in account then no fee charged
			this.setBalance(this.getBalance() - amt);
			return true;
		}else{//otherwise subtract amount from balance
			this.setBalance(this.getBalance() - amt-1);//subtract one dollar is less than 2000 dollars in account
			return true;
		}
	}
	public static void main(String[] args){
		Savings acc = new Savings(1000, new Customer());//create an accunt class with a $1000 blance and a new Customer
		acc.deposit(999);//deposit a $999 into the account
		System.out.println(acc.getBalance());//print out the new balance
		acc.withdraw(1000);//take out $1000 from the account-fee charged
		System.out.println(acc.getBalance());//print out the new balance 
		acc.deposit(1999);//deposit a $1999 into the account
		System.out.println(acc.getBalance());//print out the new balance
		acc.withdraw(1000);//take out $1000 from the account-fee not charged
		System.out.println(acc.getBalance());//print out the new balance 
		
		System.out.println(acc.getNum());//get the account number
		
		acc.setBalance(1000);//set the balance to $1000
		System.out.println(acc.getBalance());//print out the new balacne
	}

}
