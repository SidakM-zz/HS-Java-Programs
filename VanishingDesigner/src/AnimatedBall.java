import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

// The AnimatedBall class.
// Author: Vanishing Designer
// Oct. 2004
// Uses Class BouncingBall to animate a blue ball

public class AnimatedBall extends JFrame implements ActionListener
{
		private Button btnBounce, btnStopBounce;	// declare a button to play
		private TextField txtSpeed, txtColor, txtRepitit;	// declare a text field to enter number
		private Label lblSpeed, lblColor, lblRepitit;

		private Panel controls,buttonPanel;	// generic panel for controls
		private BouncingBall display;	// drawing panel for ball
		Container frame;
		public static void main(String[] args){
			AnimatedBall ba = new AnimatedBall();
		}
		public AnimatedBall ()
		{
			// Set up the controls on the applet
			frame = getContentPane();
			btnBounce = new Button ("GO");		 //initialize the bounce button and set its text    
			btnBounce.setFont(new Font("Dialog", Font.PLAIN, 18));
            btnStopBounce = new Button("Stop Bounce");
			//initialize the objects for the textfields on the top panel
			txtSpeed = new TextField("2", 10);//set the font size type and name for all labels
			lblSpeed = new Label("Enter Speed");			
			lblSpeed.setFont(new Font("Calibri", Font.BOLD, 14));
			txtColor = new TextField("Orange", 10);
			lblColor = new Label("Color");			
			lblColor.setFont(new Font("Calibri", Font.BOLD, 14));
			txtRepitit = new TextField("2", 10);
			lblRepitit = new Label("Repititons");
			lblRepitit.setFont(new Font("Calibri", Font.BOLD, 14));
			
			//initialize the panels
			display = new BouncingBall();//create the panel objects
			controls = new Panel();
			controls.setLayout(new GridLayout(6,1));//add a grid layout so the inouts are organized vertically
			buttonPanel = new Panel();////will hold the button
			//add the buttons to the button panel using the border layout for orientation
			buttonPanel.add(btnBounce, BorderLayout.CENTER);
			//buttonPanel.add(btnStopBounce, BorderLayout.CENTER);
			
			getContentPane().setLayout(new BorderLayout());	// set the frame layout 

		   // add controls to panel on top
			controls.add (lblSpeed);
			controls.add (txtSpeed);
			controls.add (lblColor);
			controls.add (txtColor);
			controls.add (lblRepitit);
			controls.add (txtRepitit);
			
			frame.add(controls, BorderLayout.EAST);// add panel to the left
			
			frame.add(display, BorderLayout.CENTER);//add panel to center
			
			
			frame.add(buttonPanel, BorderLayout.SOUTH);//add the button panel to the bottom
			
			btnBounce.addActionListener(this);//add the actionlistener to the button
			btnStopBounce.addActionListener(this);
			//add action listener

			setSize(600,600);//set the size of the frame
			setVisible(true);//set the frame to be visible
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the default close operation to colse the program and dispose of all reasources

		} // init method

		public void paint (Graphics g)
		{
			// paint no longer used
			// we are not painting on the JFrame - remove

		} // paint method


		public void actionPerformed (ActionEvent e)
		{
			

			if (e.getSource() == btnBounce){//if bounce button is clicked
				//get the color speed and duration of the ball
				long speed= (long) (10000000/Double.parseDouble(txtSpeed.getText()));//divide 10000000 by the speed number(1 is normal, 2 the delay will shorten, 3 the delay will be shorter and so on)
				String color = txtColor.getText();
				long duration = Long.parseLong(txtRepitit.getText());
				display.draw(speed, color, duration);				
			}else if(e.getSource() == btnStopBounce){//if stop bounce button is clicked
				display.setEnabled(false);//disable the panel
				display.setEnabled(true);//enable the panel
			}

		} // action method

} // AnimatedBall class
