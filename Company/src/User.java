import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class User extends JFrame implements ActionListener {
	JLabel hourly,commision,boss,hourlyEarn, comEarn;
	JTextField hourlyF,hourlyL,hourlyID,hourlySal,hourlyHour,hourlyRate;
	JTextField comF,comL,comID,comSal,comCom,comSales;
	JTextField bossF,bossL,bossID,bossSal,bossBonus;
	JButton subHour, subCom, subBoss;
	HourlyWorker hWorker = new HourlyWorker();
	CommissionWorker cWorker = new CommissionWorker();
	Boss bWorker = new Boss();
	public User(){
		super("Employees");
		setSize(1200,400);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	    
	    setLayout( new GridLayout(3,9));  
	    
	    commision = new JLabel("Commision Worker");
	    add(commision);
	    comF = new JTextField("Enter First Name");
	    add(comF);
	    comL = new JTextField("Enter Last Name");
	    add(comL);
	    comID = new JTextField("Enter Employee ID");
	    add(comID);
	    comSal = new JTextField("Enter Employee Salary");
	    add(comSal);
	    comCom = new JTextField("Commision Percentage");
	    add(comCom);
	    comSales = new JTextField("Enter Number of Sales");
	    add(comSales);
	    comEarn= new JLabel("Earnings: ");
	    add(comEarn);
	    subCom = new JButton("Enter");
	    subCom.addActionListener(this);
	    add(subCom);
	    
	    hourly = new JLabel("Hourly Worker");
	    add(hourly);
	    hourlyF = new JTextField("Enter First Name");
	    add(hourlyF);
	    hourlyL = new JTextField("Enter Last Name");
	    add(hourlyL);
	    hourlyID = new JTextField("Enter Employee ID");
	    add(hourlyID);
	    hourlySal = new JTextField("Enter Employee Salary");
	    add(hourlySal);
	    hourlyHour = new JTextField("Enter Hours Worked");
	    add(hourlyHour);
	    hourlyRate = new JTextField("Enter Hourly Pay");
	    add(hourlyRate);
	    hourlyEarn= new JLabel("Earnings: ");
	    add(hourlyEarn);	
	    subHour = new JButton("Enter");
	    subHour.addActionListener(this);
	    add(subHour);

	    boss = new JLabel("Boss");
	    add(boss);
	    bossF = new JTextField("Enter First Name");
	    add(bossF);
	    bossL = new JTextField("Enter Last Name");
	    add(bossL);
	    bossID = new JTextField("Enter Employee ID");
	    add(bossID);
	    bossSal = new JTextField("Enter Employee Salary");
	    add(bossSal);
	    bossBonus = new JTextField("Enter Bonus");
	    add(bossBonus);
	    subBoss = new JButton("Enter");
	    subBoss.addActionListener(this);
	    add(subBoss);  
	    
	}
	public static void main(String[] args){
		User frame = new User();
		frame.setVisible(true);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == subHour){
			hWorker.setFirstName(hourlyF.getText());
			hWorker.setLastName(hourlyL.getText());
			hWorker.setID(hourlyID.getText());
			hWorker.setSalary(Double.parseDouble(hourlySal.getText()));
			hWorker.setHourly(Double.parseDouble(hourlyRate.getText()));
			hWorker.setHours(Double.parseDouble(hourlyHour.getText()));
			hourlyEarn.setText("Earnings: $" + hWorker.earnings());
		}if(e.getSource() == subBoss){
			bWorker.setFirstName(bossF.getText());
			bWorker.setLastName(bossL.getText());
			bWorker.setID(bossID.getText());
			bWorker.setSalary(Double.parseDouble(bossSal.getText()));
			bWorker.setBonus(Double.parseDouble(bossBonus.getText()));
		}if(e.getSource() == subCom){
			cWorker.setFirstName(comF.getText());
			cWorker.setLastName(comL.getText());
			cWorker.setID(comID.getText());
			cWorker.setSalary(Double.parseDouble(comSal.getText()));
			cWorker.setCommision(Double.parseDouble(comCom.getText()));
			cWorker.setSales(Integer.parseInt(comSales.getText()));
			comEarn.setText(String.valueOf("Earnings: $" + cWorker.earnings()));
		}
	}
}
