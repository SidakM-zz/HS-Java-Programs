
public class Chequing extends Account{
	public Chequing(double balance, Customer owner){
		super(balance,owner);//send the values to the account
	}
	public boolean withdraw(double amt){
		if(amt>this.getBalance()-0.5 || amt == 0){//if teh amount is greater than the balance minus 50 cents or zero return false
			return false;
		}else{//otherwise subtract amount from balance
			this.setBalance(this.getBalance() - (amt+0.5));//for each withrawal deduct 50cents
			return true;
		}
	}
	public static void main(String[] args){
		Chequing acc = new Chequing(1000, new Customer());//create an accunt class with a $1000 blance and a new Customer
		acc.deposit(1000);//deposit a $1000 into the account
		System.out.println(acc.getBalance());//print out the new balance
		acc.withdraw(1000);//take out $1000 from the account-fee charged
		System.out.println(acc.getBalance());//print out the new balance 		
		
		System.out.println(acc.getNum());//get the account number
		
		acc.setBalance(1000);//set the balance to $1000
		System.out.println(acc.getBalance());//print out the new balance
	}
	

}
