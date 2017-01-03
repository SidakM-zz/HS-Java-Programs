import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

public class UserInterface extends JFrame implements ActionListener {//This class will extend JFrame but implement action listener(so when adding an actionlistener to any object an instance of this class can be reffereed to)
	private JTextField textFieldName;//Textfields decclared here so they can be accessed by the action listener implemented methods
	private JTextField textFieldPhone;
	private JTextField textFieldStreet;
	private JTextField textFieldPostalCode;
	private JButton btnAddNewCustomer,btnUpdateExistingCustomer ;
	private JComboBox comboBox;
	private JLabel lblCityOutput;
	private JPanel chsCus, innerchsCus;
	private int numCus =0;//will count the total number of customers
	private ArrayList<Customer> Customers = new ArrayList<Customer>();//a private array list of all the customer and their information
	private ArrayList<JButton> savedCustomers = new ArrayList<JButton>();//an array list of buttons which refer to all the saved customers
	private ArrayList<Savings> customerSavings = new ArrayList<Savings>();//an array list of all the customers savings accounts
	private ArrayList<Chequing> customerChequing = new ArrayList<Chequing>();//an array list of all the customer's chequing accounts
	private JTextField textFieldBalance;
	private JTextField textFieldWithdraw;
	private JTextField textFieldSavingsBalance;
	private JTextField textFieldSavingsWithdraw;
	private JTextField textFieldSavingsDeposit;
	private JTextField  textFieldDeposit;
	private JButton btnInitiateTransaction, btnSavingsInitiateTransaction;
	private JToggleButton tglbtnEnableSavings,tglbtnEnable;
	private JLabel lblAccountNumberOutput,lblAccountNumber, lblSavingsAccountNumber;
	private int currentCustomer = 0;//will keep track of the current customer
	private JButton btnClear;
	public static void main(String[] args){///create new user when program runs
		UserInterface use = new UserInterface();
		JOptionPane.showMessageDialog(null, "Pro Tip: Add a new customer AFTER you have entered his/her personal information");
		use.setVisible(true);//will make the frame visible
	}
	public UserInterface() {
		/*Comments for all major UI methods used in this program
			
			gbc_innerchsCus.fill = GridBagConstraints.BOTH;//will fill the component BOTH horizontally and vertically
			GridBagConstraints gbc_chsCus = new GridBagConstraints(); //will create a gbc that can be used in conjunction with any component that is being added to another component with a gridbaglayout
			gbc_chsCus.insets = new Insets(0, 0, 5, 0);//Insets will create spacing on 4 sides between components 
			gbc_chsCus.gridx = 0; //specifies the objects location on the horizontal plane in a grid bag layout
			gbc_chsCus.gridy = 0;//specifies the objects location on the vertical plane in a grid bag layout
			gbl_chsCus.columnWeights= new double[]{1.0, Double.MIN_VALUE};//adjusts the column weights after all edits have been made, array length = number of column however if not that many objects added it won't create new columns  
			gbl_chsCus.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};//will adjust the row weights after all other edits have been made 3 rows
			lblCustomerInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));//.sets the font and font size and type
			comboBox.setModel(new DefaultComboBoxModel(new String[] {}));// creates the objects/items in the combo box in this case they are all strings
			btnClear.addActionListener(this);//adds an action listener- since this class implements actionlisteenr referring to an instance of this class is important to access the implemented methods
		*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets the default close operation to be exit on close
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		chsCus = new JPanel();
		GridBagConstraints gbc_chsCus = new GridBagConstraints();
		gbc_chsCus.gridheight = 2;
		gbc_chsCus.insets = new Insets(0, 0, 5, 0);
		gbc_chsCus.fill = GridBagConstraints.BOTH;
		gbc_chsCus.gridx = 0;
		gbc_chsCus.gridy = 0;
		getContentPane().add(chsCus, gbc_chsCus);
		GridBagLayout gbl_chsCus = new GridBagLayout();
		gbl_chsCus.columnWidths = new int[]{51, 0};
		gbl_chsCus.rowHeights = new int[]{333, 0, 0};
		gbl_chsCus.columnWeights= new double[]{1.0, Double.MIN_VALUE};
		gbl_chsCus.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		chsCus.setLayout(gbl_chsCus);
		
		innerchsCus = new JPanel();//This panel was used inside the chsCus because the chsCus was causing problems when new buttons were added when new custoemrs were added by the UI
		GridBagConstraints gbc_innerchsCus = new GridBagConstraints(); 
		gbc_innerchsCus.insets = new Insets(0, 0, 5, 0);
		gbc_innerchsCus.fill = GridBagConstraints.BOTH;
		gbc_innerchsCus.gridx = 0;
		gbc_innerchsCus.gridy = 0;
		chsCus.add(innerchsCus, gbc_innerchsCus);
		GridBagLayout gbl_innerchsCus = new GridBagLayout();
		gbl_innerchsCus.columnWidths = new int[]{51, 0};
		gbl_innerchsCus.rowHeights = new int[]{14, 0, 0, 0};
		gbl_innerchsCus.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_innerchsCus.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		innerchsCus.setLayout(gbl_innerchsCus);
		
		JLabel lblCustomers = new JLabel("Customers");
		lblCustomers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCustomers = new GridBagConstraints();
		gbc_lblCustomers.insets = new Insets(0, 0, 5, 0);
		gbc_lblCustomers.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCustomers.gridx = 0;
		gbc_lblCustomers.gridy = 0;
		innerchsCus.add(lblCustomers, gbc_lblCustomers);
		
		JPanel information = new JPanel();
		GridBagConstraints gbc_information = new GridBagConstraints();
		gbc_information.gridheight = 2;
		gbc_information.weighty = 10.0;
		gbc_information.weightx = 3.0;
		gbc_information.fill = GridBagConstraints.BOTH;
		gbc_information.gridx = 1;
		gbc_information.gridy = 0;
		getContentPane().add(information, gbc_information);
		GridBagLayout gbl_information = new GridBagLayout();
		gbl_information.columnWidths = new int[]{0, 0};
		gbl_information.rowHeights = new int[]{0, 0, 0};
		gbl_information.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_information.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		information.setLayout(gbl_information);
		
		JPanel customer = new JPanel();
		GridBagConstraints gbc_customer = new GridBagConstraints();
		gbc_customer.insets = new Insets(0, 0, 5, 0);
		gbc_customer.fill = GridBagConstraints.BOTH;
		gbc_customer.gridx = 0;
		gbc_customer.gridy = 0;
		information.add(customer, gbc_customer);
		GridBagLayout gbl_customer = new GridBagLayout();
		gbl_customer.columnWidths = new int[]{323, 105, 55, 0};
		gbl_customer.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_customer.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_customer.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		customer.setLayout(gbl_customer);
		
		JLabel lblCustomerInformation = new JLabel("Customer Information");
		lblCustomerInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCustomerInformation = new GridBagConstraints();
		gbc_lblCustomerInformation.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCustomerInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerInformation.gridx = 1;
		gbc_lblCustomerInformation.gridy = 0;
		customer.add(lblCustomerInformation, gbc_lblCustomerInformation);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		customer.add(lblName, gbc_lblName);
		
		textFieldName = new JTextField();
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 1;
		customer.add(textFieldName, gbc_textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone Number:");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 2;
		customer.add(lblPhone, gbc_lblPhone);
		
		textFieldPhone = new JTextField();
		GridBagConstraints gbc_textFieldPhone = new GridBagConstraints();
		gbc_textFieldPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPhone.gridx = 1;
		gbc_textFieldPhone.gridy = 2;
		customer.add(textFieldPhone, gbc_textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street:");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 0;
		gbc_lblStreet.gridy = 3;
		customer.add(lblStreet, gbc_lblStreet);
		
		textFieldStreet = new JTextField();
		GridBagConstraints gbc_textFieldStreet = new GridBagConstraints();
		gbc_textFieldStreet.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldStreet.gridx = 1;
		gbc_textFieldStreet.gridy = 3;
		customer.add(textFieldStreet, gbc_textFieldStreet);
		textFieldStreet.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("Postal Code:");
		GridBagConstraints gbc_lblPostalCode = new GridBagConstraints();
		gbc_lblPostalCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostalCode.gridx = 0;
		gbc_lblPostalCode.gridy = 4;
		customer.add(lblPostalCode, gbc_lblPostalCode);
		
		textFieldPostalCode = new JTextField();
		GridBagConstraints gbc_textFieldPostalCode = new GridBagConstraints();
		gbc_textFieldPostalCode.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPostalCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPostalCode.gridx = 1;
		gbc_textFieldPostalCode.gridy = 4;
		customer.add(textFieldPostalCode, gbc_textFieldPostalCode);
		textFieldPostalCode.setColumns(10);
		
		JLabel lblProvince = new JLabel("Province:");
		GridBagConstraints gbc_lblProvince = new GridBagConstraints();
		gbc_lblProvince.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvince.gridx = 0;
		gbc_lblProvince.gridy = 5;
		customer.add(lblProvince, gbc_lblProvince);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan"}));
		comboBox.setToolTipText("Name");
		comboBox.addActionListener(this);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		customer.add(comboBox, gbc_comboBox);
		
		JLabel lblCity = new JLabel("City:");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 6;
		customer.add(lblCity, gbc_lblCity);
		
		lblCityOutput = new JLabel("");
		GridBagConstraints gbc_lblCityOutput = new GridBagConstraints();
		gbc_lblCityOutput.insets = new Insets(0, 0, 5, 5);
		gbc_lblCityOutput.gridx = 1;
		gbc_lblCityOutput.gridy = 6;
		customer.add(lblCityOutput, gbc_lblCityOutput);
		
		btnUpdateExistingCustomer = new JButton("Update Existing Customer");
		btnUpdateExistingCustomer.addActionListener(this);
		GridBagConstraints gbc_btnUpdateExistingCustomer = new GridBagConstraints();
		gbc_btnUpdateExistingCustomer.anchor = GridBagConstraints.WEST;
		gbc_btnUpdateExistingCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateExistingCustomer.gridx = 1;
		gbc_btnUpdateExistingCustomer.gridy = 7;
		customer.add(btnUpdateExistingCustomer, gbc_btnUpdateExistingCustomer);
		
		btnAddNewCustomer = new JButton("Add New Customer");
		btnAddNewCustomer.addActionListener(this);
		GridBagConstraints gbc_btnAddNewCustomer = new GridBagConstraints();
		gbc_btnAddNewCustomer.anchor = GridBagConstraints.WEST;
		gbc_btnAddNewCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddNewCustomer.gridx = 1;
		gbc_btnAddNewCustomer.gridy = 8;
		customer.add(btnAddNewCustomer, gbc_btnAddNewCustomer);
		
		lblAccountNumberOutput = new JLabel("");
		GridBagConstraints gbc_lblAccountNumberOutput = new GridBagConstraints();
		gbc_lblAccountNumberOutput.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountNumberOutput.gridx = 1;
		gbc_lblAccountNumberOutput.gridy = 9;
		customer.add(lblAccountNumberOutput, gbc_lblAccountNumberOutput);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.WEST;
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 1;
		gbc_btnClear.gridy = 10;
		customer.add(btnClear, gbc_btnClear);
		
		JPanel Accounts = new JPanel();
		GridBagConstraints gbc_Accounts = new GridBagConstraints();
		gbc_Accounts.weighty = 30.0;
		gbc_Accounts.fill = GridBagConstraints.BOTH;
		gbc_Accounts.gridx = 0;
		gbc_Accounts.gridy = 1;
		information.add(Accounts, gbc_Accounts);
		GridBagLayout gbl_Accounts = new GridBagLayout();
		gbl_Accounts.columnWidths = new int[]{364, 10, 0};
		gbl_Accounts.rowHeights = new int[]{10, 0};
		gbl_Accounts.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Accounts.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		Accounts.setLayout(gbl_Accounts);
		
		JPanel chequingPanel = new JPanel();
		GridBagConstraints gbc_chequingPanel = new GridBagConstraints();
		gbc_chequingPanel.insets = new Insets(0, 0, 0, 5);
		gbc_chequingPanel.fill = GridBagConstraints.VERTICAL;
		gbc_chequingPanel.gridx = 0;
		gbc_chequingPanel.gridy = 0;
		Accounts.add(chequingPanel, gbc_chequingPanel);
		GridBagLayout gbl_chequingPanel = new GridBagLayout();
		gbl_chequingPanel.columnWidths = new int[]{45, 0, 0, 0};
		gbl_chequingPanel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0};
		gbl_chequingPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_chequingPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		chequingPanel.setLayout(gbl_chequingPanel);
		
		JLabel lblChequing = new JLabel("Chequing");
		lblChequing.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblChequing = new GridBagConstraints();
		gbc_lblChequing.insets = new Insets(0, 0, 5, 5);
		gbc_lblChequing.gridx = 1;
		gbc_lblChequing.gridy = 0;
		chequingPanel.add(lblChequing, gbc_lblChequing);
		
		tglbtnEnable = new JToggleButton("Enable");
		tglbtnEnable.addActionListener(this);
		GridBagConstraints gbc_tglbtnEnable = new GridBagConstraints();
		gbc_tglbtnEnable.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnEnable.gridx = 1;
		gbc_tglbtnEnable.gridy = 1;
		chequingPanel.add(tglbtnEnable, gbc_tglbtnEnable);
		
		JLabel lblBalance = new JLabel("Balance:");
		GridBagConstraints gbc_lblBalance = new GridBagConstraints();
		gbc_lblBalance.anchor = GridBagConstraints.EAST;
		gbc_lblBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblBalance.gridx = 0;
		gbc_lblBalance.gridy = 2;
		chequingPanel.add(lblBalance, gbc_lblBalance);
		
		textFieldBalance = new JTextField();
		textFieldBalance.setText("0");
		textFieldBalance.setEnabled(false);
		GridBagConstraints gbc_textFieldBalance = new GridBagConstraints();
		gbc_textFieldBalance.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBalance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBalance.gridx = 1;
		gbc_textFieldBalance.gridy = 2;
		chequingPanel.add(textFieldBalance, gbc_textFieldBalance);
		textFieldBalance.setColumns(10);
		
		JLabel lblAccNum = new JLabel("Acc. Num:");
		GridBagConstraints gbc_lblAccNum = new GridBagConstraints();
		gbc_lblAccNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccNum.gridx = 0;
		gbc_lblAccNum.gridy = 3;
		chequingPanel.add(lblAccNum, gbc_lblAccNum);
		
		lblAccountNumber = new JLabel("");
		GridBagConstraints gbc_lblAccountNumber = new GridBagConstraints();
		gbc_lblAccountNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountNumber.gridx = 1;
		gbc_lblAccountNumber.gridy = 3;
		chequingPanel.add(lblAccountNumber, gbc_lblAccountNumber);
		
		JLabel lblWithdraw = new JLabel("Withdraw:");
		GridBagConstraints gbc_lblWithdraw = new GridBagConstraints();
		gbc_lblWithdraw.anchor = GridBagConstraints.EAST;
		gbc_lblWithdraw.insets = new Insets(0, 0, 5, 5);
		gbc_lblWithdraw.gridx = 0;
		gbc_lblWithdraw.gridy = 4;
		chequingPanel.add(lblWithdraw, gbc_lblWithdraw);
		
		textFieldWithdraw = new JTextField();
		textFieldWithdraw.setText("0");
		textFieldWithdraw.setEnabled(false);
		GridBagConstraints gbc_textFieldWithdraw = new GridBagConstraints();
		gbc_textFieldWithdraw.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldWithdraw.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldWithdraw.gridx = 1;
		gbc_textFieldWithdraw.gridy = 4;
		chequingPanel.add(textFieldWithdraw, gbc_textFieldWithdraw);
		textFieldWithdraw.setColumns(10);
		
		JLabel lblDeposit = new JLabel("Deposit:");
		GridBagConstraints gbc_lblDeposit = new GridBagConstraints();
		gbc_lblDeposit.anchor = GridBagConstraints.EAST;
		gbc_lblDeposit.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeposit.gridx = 0;
		gbc_lblDeposit.gridy = 5;
		chequingPanel.add(lblDeposit, gbc_lblDeposit);
		
		textFieldDeposit = new JTextField();
		textFieldDeposit.setText("0");
		textFieldDeposit.setEnabled(false);
		GridBagConstraints gbc_textFieldDeposit = new GridBagConstraints();
		gbc_textFieldDeposit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDeposit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDeposit.gridx = 1;
		gbc_textFieldDeposit.gridy = 5;
		chequingPanel.add(textFieldDeposit, gbc_textFieldDeposit);
		textFieldDeposit.setColumns(10);
		
		btnInitiateTransaction = new JButton("Initiate Transaction");
		btnInitiateTransaction.setEnabled(false);
		btnInitiateTransaction.addActionListener(this);
		GridBagConstraints gbc_btnInitiateTransaction = new GridBagConstraints();
		gbc_btnInitiateTransaction.insets = new Insets(0, 0, 0, 5);
		gbc_btnInitiateTransaction.gridx = 1;
		gbc_btnInitiateTransaction.gridy = 6;
		chequingPanel.add(btnInitiateTransaction, gbc_btnInitiateTransaction);
		
		JPanel savingsPanel = new JPanel();
		GridBagConstraints gbc_savingsPanel = new GridBagConstraints();
		gbc_savingsPanel.fill = GridBagConstraints.BOTH;
		gbc_savingsPanel.gridx = 1;
		gbc_savingsPanel.gridy = 0;
		Accounts.add(savingsPanel, gbc_savingsPanel);
		GridBagLayout gbl_savingsPanel = new GridBagLayout();
		gbl_savingsPanel.columnWidths = new int[]{197, 60, 0};
		gbl_savingsPanel.rowHeights = new int[]{22, 0, 0, 0, 0, 0, 0, 0};
		gbl_savingsPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_savingsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		savingsPanel.setLayout(gbl_savingsPanel);
		
		JLabel lblSavings = new JLabel("Savings");
		lblSavings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSavings = new GridBagConstraints();
		gbc_lblSavings.insets = new Insets(0, 0, 5, 0);
		gbc_lblSavings.anchor = GridBagConstraints.NORTH;
		gbc_lblSavings.gridx = 1;
		gbc_lblSavings.gridy = 0;
		savingsPanel.add(lblSavings, gbc_lblSavings);
		
		tglbtnEnableSavings = new JToggleButton("Enable");
		tglbtnEnableSavings.addActionListener(this);
		GridBagConstraints gbc_tglbtnEnableSavings = new GridBagConstraints();
		gbc_tglbtnEnableSavings.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnEnableSavings.gridx = 1;
		gbc_tglbtnEnableSavings.gridy = 1;
		savingsPanel.add(tglbtnEnableSavings, gbc_tglbtnEnableSavings);
		
		JLabel lblSavingBalance = new JLabel("Balance:");
		GridBagConstraints gbc_lblSavingBalance = new GridBagConstraints();
		gbc_lblSavingBalance.anchor = GridBagConstraints.EAST;
		gbc_lblSavingBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblSavingBalance.gridx = 0;
		gbc_lblSavingBalance.gridy = 2;
		savingsPanel.add(lblSavingBalance, gbc_lblSavingBalance);
		
		textFieldSavingsBalance = new JTextField();
		textFieldSavingsBalance.setText("0");
		textFieldSavingsBalance.setEnabled(false);
		GridBagConstraints gbc_textFieldSavingsBalance = new GridBagConstraints();
		gbc_textFieldSavingsBalance.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSavingsBalance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSavingsBalance.gridx = 1;
		gbc_textFieldSavingsBalance.gridy = 2;
		savingsPanel.add(textFieldSavingsBalance, gbc_textFieldSavingsBalance);
		textFieldSavingsBalance.setColumns(10);
		
		JLabel lblSavingsAccNum = new JLabel("Acc. Num:");
		GridBagConstraints gbc_lblSavingsAccNum = new GridBagConstraints();
		gbc_lblSavingsAccNum.anchor = GridBagConstraints.EAST;
		gbc_lblSavingsAccNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblSavingsAccNum.gridx = 0;
		gbc_lblSavingsAccNum.gridy = 3;
		savingsPanel.add(lblSavingsAccNum, gbc_lblSavingsAccNum);
		
		lblSavingsAccountNumber = new JLabel("");
		GridBagConstraints gbc_lblSavingsAccountNumber = new GridBagConstraints();
		gbc_lblSavingsAccountNumber.insets = new Insets(0, 0, 5, 0);
		gbc_lblSavingsAccountNumber.gridx = 1;
		gbc_lblSavingsAccountNumber.gridy = 3;
		savingsPanel.add(lblSavingsAccountNumber, gbc_lblSavingsAccountNumber);
		
		JLabel lblSavingsWithdraw = new JLabel("Withdraw:");
		GridBagConstraints gbc_lblSavingsWithdraw = new GridBagConstraints();
		gbc_lblSavingsWithdraw.anchor = GridBagConstraints.EAST;
		gbc_lblSavingsWithdraw.insets = new Insets(0, 0, 5, 5);
		gbc_lblSavingsWithdraw.gridx = 0;
		gbc_lblSavingsWithdraw.gridy = 4;
		savingsPanel.add(lblSavingsWithdraw, gbc_lblSavingsWithdraw);
		
		textFieldSavingsWithdraw = new JTextField();
		textFieldSavingsWithdraw.setText("0");
		textFieldSavingsWithdraw.setEnabled(false);
		GridBagConstraints gbc_textFieldSavingsWithdraw = new GridBagConstraints();
		gbc_textFieldSavingsWithdraw.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSavingsWithdraw.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSavingsWithdraw.gridx = 1;
		gbc_textFieldSavingsWithdraw.gridy = 4;
		savingsPanel.add(textFieldSavingsWithdraw, gbc_textFieldSavingsWithdraw);
		textFieldSavingsWithdraw.setColumns(10);
		
		JLabel lblSavingsDeposit = new JLabel("Deposit:");
		GridBagConstraints gbc_lblSavingsDeposit = new GridBagConstraints();
		gbc_lblSavingsDeposit.anchor = GridBagConstraints.EAST;
		gbc_lblSavingsDeposit.insets = new Insets(0, 0, 5, 5);
		gbc_lblSavingsDeposit.gridx = 0;
		gbc_lblSavingsDeposit.gridy = 5;
		savingsPanel.add(lblSavingsDeposit, gbc_lblSavingsDeposit);
		
		textFieldSavingsDeposit = new JTextField();
		textFieldSavingsDeposit.setText("0");
		textFieldSavingsDeposit.setEnabled(false);
		GridBagConstraints gbc_textFieldSavingsDeposit = new GridBagConstraints();
		gbc_textFieldSavingsDeposit.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSavingsDeposit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSavingsDeposit.gridx = 1;
		gbc_textFieldSavingsDeposit.gridy = 5;
		savingsPanel.add(textFieldSavingsDeposit, gbc_textFieldSavingsDeposit);
		textFieldSavingsDeposit.setColumns(10);
		
		btnSavingsInitiateTransaction = new JButton("Initiate Transaction");
		btnSavingsInitiateTransaction.addActionListener(this);
		btnSavingsInitiateTransaction.setEnabled(false);
		GridBagConstraints gbc_btnSavingsInitiateTransaction = new GridBagConstraints();
		gbc_btnSavingsInitiateTransaction.gridx = 1;
		gbc_btnSavingsInitiateTransaction.gridy = 6;
		savingsPanel.add(btnSavingsInitiateTransaction, gbc_btnSavingsInitiateTransaction);
		setSize(1000,500);
		//pack();//pack all items together to smallest size
	}
	@Override
	public void actionPerformed(ActionEvent e) {//action listener implemented method will take the source of the click
		// TODO Auto-generated method stub
		if(e.getSource() == comboBox){///set city based on province(extension)
			if(comboBox.getSelectedItem().equals("Ontario")){
				lblCityOutput.setText("Toronto");
			}else if(comboBox.getSelectedItem().equals("Quebec")){
				lblCityOutput.setText("Quebec City");
			}else if(comboBox.getSelectedItem().equals("Manitoba")){
				lblCityOutput.setText("Winnipeg");
			}else if(comboBox.getSelectedItem().equals("Saskatchewan")){
				lblCityOutput.setText("Regina ");
			}else if(comboBox.getSelectedItem().equals("New Brunswick")){
				lblCityOutput.setText("Fredericton");
			}else if(comboBox.getSelectedItem().equals("Alberta")){
				lblCityOutput.setText("Edmonton");
			}else if(comboBox.getSelectedItem().equals("British Columbia")){
				lblCityOutput.setText("Victoria");
			}else if(comboBox.getSelectedItem().equals("Newfoundland and Labrador")){
				lblCityOutput.setText("St. John’s");
			}else if(comboBox.getSelectedItem().equals("Prince Edward Island")){
				lblCityOutput.setText("Charlottetown");
			}else if(comboBox.getSelectedItem().equals("Nova Scotia")){
				lblCityOutput.setText("Halifax");
			}
		}else if(e.getSource() == btnAddNewCustomer){//if add a new customer is clicked
			//create and add a new customer to the arrayList with the values taken from the appropriate labels and boxes
			if(textFieldName.getText().equals("")){//if blank
				JOptionPane.showMessageDialog(getComponent(0), "Invalid Input");
			}else{
				currentCustomer = numCus;//the current customer is the total customers
				Customers.add(new Customer(textFieldName.getText(), textFieldPhone.getText(), textFieldStreet.getText(), textFieldPostalCode.getText(),comboBox.getSelectedItem().toString(), lblCityOutput.getText()));
				customerSavings.add(new Savings(0,Customers.get(numCus)));//add a new savings account with a currently blank balance
				customerChequing.add(new Chequing(0,Customers.get(numCus)));//add a new Chequing account with a currently blank balance
			
				JButton temp = new JButton();//create a temp Jbutton and set its text
				temp.setText(textFieldName.getText());
				temp.addActionListener(this);//add an action listener before hand
				temp.addActionListener(this);//add an action listener
				savedCustomers.add(temp);//add the temp JButton to the arraylist 
				GridBagConstraints gbc_btnTemp = new GridBagConstraints();//create gridBag COntraints
				gbc_btnTemp.anchor = GridBagConstraints.CENTER;
				gbc_btnTemp.gridx = 0;
				gbc_btnTemp.gridy = numCus + 1;//below the previous button
				gbc_btnTemp.insets = new Insets(0,0,5,0);//spacing between 
				innerchsCus.add(savedCustomers.get(numCus), gbc_btnTemp);//add the current button to the Jpanel with the gridbagconstraints
				revalidate();//update the frame	
				numCus++;//increase the total num of customers


				textFieldBalance.setEnabled(false);//disable all the account fields if not already disabled and set the balances to zero
				textFieldBalance.setText("0");
				lblAccountNumber.setText("");
				textFieldWithdraw.setEnabled(false);
				textFieldDeposit.setEnabled(false);
				btnInitiateTransaction.setEnabled(false);	
			
				textFieldSavingsBalance.setEnabled(false);
				textFieldSavingsBalance.setText("0");
				lblSavingsAccountNumber.setText("");
				textFieldSavingsWithdraw.setEnabled(false);
				textFieldSavingsDeposit.setEnabled(false);
				btnSavingsInitiateTransaction.setEnabled(false);
			
				//when adding new customer change state of enable buttons
				tglbtnEnable.setSelected(false);
				tglbtnEnableSavings.setSelected(false);
		}
		}else if(e.getSource() == btnUpdateExistingCustomer){//if the update for info is called update all the info based on the current customer
			System.out.println(currentCustomer);
			Customers.get(currentCustomer).setName(textFieldName.getText());
			Customers.get(currentCustomer).setPhone(textFieldPhone.getText());
			Customers.get(currentCustomer).setStreet(textFieldStreet.getText());
			Customers.get(currentCustomer).setPostal(textFieldPostalCode.getText());
			Customers.get(currentCustomer).setProvince(comboBox.getSelectedItem().toString());
			Customers.get(currentCustomer).setCity(lblCityOutput.getText());
			savedCustomers.get(currentCustomer).setText(textFieldName.getText());//update customer name on the side panel button
		}else if(e.getSource() == tglbtnEnable){//if the chequing account is enabled enable all its fields and create the appropriate object
			textFieldBalance.setEnabled(true);
			textFieldWithdraw.setEnabled(true);
			textFieldDeposit.setEnabled(true);
			btnInitiateTransaction.setEnabled(true);
			textFieldBalance.setText("0");
		}else if(e.getSource() == tglbtnEnableSavings){//if the savings account is enabled enable all its fields and create the appropriate object
			textFieldSavingsBalance.setEnabled(true);
			textFieldSavingsWithdraw.setEnabled(true);
			textFieldSavingsDeposit.setEnabled(true);
			btnSavingsInitiateTransaction.setEnabled(true);
			textFieldSavingsBalance.setText("0");
		}else if(e.getSource() == btnInitiateTransaction){//if a chequing transaction is being initiated
			customerChequing.get(currentCustomer).setBalance(Double.parseDouble(textFieldBalance.getText()));//set the initial balance
			boolean valid;
			valid = customerChequing.get(currentCustomer).withdraw(Double.parseDouble(textFieldWithdraw.getText()));//withdraw cash
			if(valid == false && Double.parseDouble(textFieldWithdraw.getText())>0){//if transaction was invalid and the withdrawal amount is greater than zero
				JOptionPane.showMessageDialog(null, "Invalid Transaction");//display msg dialog 
			}
			customerChequing.get(currentCustomer).deposit(Double.parseDouble(textFieldDeposit.getText()));//then deposit if anything to deposit
			textFieldBalance.setText(String.valueOf(customerChequing.get(currentCustomer).getBalance()));//set the new balance on the UI
			lblAccountNumber.setText(String.valueOf(customerChequing.get(currentCustomer).getNum()));//set the account number as well
			textFieldWithdraw.setText("0");//reset the withdraw and deposit values
			textFieldDeposit.setText("0");
		}else if(e.getSource() == btnSavingsInitiateTransaction){//if a savings transaction is trying to be initiated
			customerSavings.get(currentCustomer).setBalance(Double.parseDouble(textFieldSavingsBalance.getText()));//set the initial balance
			boolean valid;
			valid = customerSavings.get(currentCustomer).withdraw(Double.parseDouble(textFieldSavingsWithdraw.getText()));//withdraw cash
			if(valid == false && Double.parseDouble(textFieldSavingsWithdraw.getText()) > 0){//if transaction was invalid and the withdrawal amount is greater than zero
				JOptionPane.showMessageDialog(null, "Invalid Transaction");//display msg dialog 
			}
			customerSavings.get(currentCustomer).deposit(Double.parseDouble(textFieldSavingsDeposit.getText()));//then deposit if anything to deposit
			textFieldSavingsBalance.setText(String.valueOf(customerSavings.get(currentCustomer).getBalance()));//set the new balance on the UI
			lblSavingsAccountNumber.setText(String.valueOf(customerSavings.get(currentCustomer).getNum()));//set the account number as well
			textFieldSavingsWithdraw.setText("0");//reset the withdraw and deposit values
			textFieldSavingsDeposit.setText("0");
		}else if(e.getSource() == btnClear){//if the clear button is pressed clear all the customer information
			textFieldName.setText("");
			textFieldPhone.setText("");
			textFieldStreet.setText("");
			textFieldPostalCode.setText("");
			comboBox.setSelectedItem("");
			lblCityOutput.setText("");
		}else{//if none of the above buttons pressed thus a customer name was pressed		
			int i = savedCustomers.indexOf(e.getSource());//get the source of the customer
			currentCustomer = i;//the currentCustomer becomes the customer clicked on
			//display that customer's information
			textFieldName.setText(Customers.get(i).getName());//get and set the name 
			textFieldPhone.setText(Customers.get(i).getPhone());//get their phone number
			textFieldStreet.setText(Customers.get(i).getStreet());//get the street
			textFieldPostalCode.setText(Customers.get(i).getPostal());//get the pc 
			lblCityOutput.setText(Customers.get(i).getCity());
			
			//setting the province 
			if(Customers.get(i).getProvince().equals("Ontario")){//if the customer's province is the "" then set the selected item in the combo box to the ""
				comboBox.setSelectedItem("Ontario");
			}else if(Customers.get(i).getProvince().equals("Quebec")){
				comboBox.setSelectedItem("Quebec");
			}else if(Customers.get(i).getProvince().equals("Manitoba")){
				comboBox.setSelectedItem("Manitoba");
			}else if(Customers.get(i).getProvince().equals("Saskatchewan")){
				comboBox.setSelectedItem("Saskatchewan");
			}else if(Customers.get(i).getProvince().equals("New Brunswick")){
				comboBox.setSelectedItem("New Brunswick");
			}else if(Customers.get(i).getProvince().equals("Alberta")){
				comboBox.setSelectedItem("Alberta");
			}else if(Customers.get(i).getProvince().equals("British Columbia")){
				comboBox.setSelectedItem("British Columbia");
			}else if(Customers.get(i).getProvince().equals("Newfoundland and Labrador")){
				comboBox.setSelectedItem("Newfoundland and Labrador");
			}else if(Customers.get(i).getProvince().equals("Prince Edward Island")){
				comboBox.setSelectedItem("Prince Edward Island");
			}else if(Customers.get(i).getProvince().equals("Nova Scotia")){
				comboBox.setSelectedItem("Nova Scotia");
			}
			
			//Chequing Accounts Update
			if(customerChequing.get(currentCustomer).getBalance() == 0){//if the balance of the chequing account is equal to zero disable it
				tglbtnEnable.setSelected(false);//deselect the toggle button
				textFieldBalance.setEnabled(false);//disable the rest of the text fields
				textFieldWithdraw.setEnabled(false);
				textFieldDeposit.setEnabled(false);
				btnInitiateTransaction.setEnabled(false);
				textFieldBalance.setText("0");//set the textfied to be zero aswell
				lblAccountNumber.setText("");//no account number if balance zero
			}else{//other wise
				tglbtnEnable.setSelected(true);//enable all the textfields
				textFieldBalance.setEnabled(true);
				textFieldWithdraw.setEnabled(true);
				textFieldDeposit.setEnabled(true);
				btnInitiateTransaction.setEnabled(true);
				
				textFieldBalance.setText(String.valueOf(customerChequing.get(currentCustomer).getBalance()));//set the balance
				lblAccountNumber.setText(String.valueOf(customerChequing.get(currentCustomer).getNum()));//get the account number and set the text in the Jlabel to that
				textFieldWithdraw.setText("0");//set the rest of the textfield to zero
				textFieldDeposit.setText("0");
			}
			//Savings Account Update
			if(customerSavings.get(currentCustomer).getBalance() == 0){//if the balance of the chequing account is equal to zero disable it
				tglbtnEnableSavings.setSelected(false);//deselect the toggle button
				textFieldSavingsBalance.setEnabled(false);//disable the rest of the text fields
				textFieldSavingsWithdraw.setEnabled(false);
				textFieldSavingsDeposit.setEnabled(false);
				btnSavingsInitiateTransaction.setEnabled(false);
				textFieldSavingsBalance.setText("0");//set the textfield to zero
				lblSavingsAccountNumber.setText("");//no account number if balacne zero
			}else{//other wise
				tglbtnEnableSavings.setSelected(true);//enable all the textfields
				textFieldSavingsBalance.setEnabled(true);
				textFieldSavingsWithdraw.setEnabled(true);
				textFieldSavingsDeposit.setEnabled(true);
				btnSavingsInitiateTransaction.setEnabled(true);
				
				textFieldSavingsBalance.setText(String.valueOf(customerSavings.get(currentCustomer).getBalance()));//set the balance
				lblSavingsAccountNumber.setText(String.valueOf(customerSavings.get(currentCustomer).getNum()));//get the account number and set the text in the Jlabel to that
				textFieldSavingsWithdraw.setText("0");//set the rest of the textfield to zero
				textFieldSavingsDeposit.setText("0");
			}
			
		}
		
		
		
	}

}
