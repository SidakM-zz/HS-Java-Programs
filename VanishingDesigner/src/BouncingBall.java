import java.awt.*;

// class BouncingBall
// Author: Sidak Manchanda(Improving on Design by Vanishing Designer)
// April. 2016
// Animates a blue bouncing ball. The speed of the animation
// is controlled by an input to the draw method.

public class BouncingBall extends Panel {
	private long delay;
	private String color ="blue";//default color can be changed
	private long repetitions = 1;

	// Overridden paint method for painting the BouncingBall panel
	public void paint(Graphics g) {
		super.paint(g); // calls paint method from Panel.

		int radius = (getSize().width / 8) / 2;//the radius is the width of the window divided by 10 then divided by 2
		int panelWidth = getSize().width;//assign the height and width of the panel to variables
		int panelHeight = getSize().height;

		int X1 = 0 ;//top left
		int Y1 = 0 ;
		
		int X2 = getSize().width - radius*2;//top right
		int Y2 = 0;
		
		int X3 = 0;//bottom left
		int Y3 = getSize().height -radius*2;
		
		int X4 = getSize().width - radius*2;//bottom right
		int Y4 = getSize().height - radius*2;
		
		int X = (int) (Math.random()*(getSize().width)) + radius;//get a random starting x and y position
		int Y = (int) (Math.random()*(getSize().width)) + radius;
		int dx = 1;//the increments of movement in x and y direction
		int dy = 1;
		
		int XX = (int) (Math.random()*(getSize().width)) + radius;//get a random starting x and y position
		int YY = (int) (Math.random()*(getSize().width)) + radius;
		int dXX = 1;//the increments of movement in x and y direction
		int dYY = 1;
		int midCirc = radius*2;//radius for middle circle
		setBackground(new Color(57,255,20));
		int hyp = (int) Math.sqrt(Math.pow(panelHeight, 2) + Math.pow(panelWidth, 2));//find the hypotenuese of the panel using pythagorean theorem
		for (int count =  0;  count < this.repetitions ;count++ ){//do for the amount of repetitions
			
			for(int u =0; u < hyp; u++){//loop until hypotenues reched
										
				g.setColor(getBackground());//get the background color
				g.fillRect(0, 0, panelWidth, panelHeight);//fill the background with blank
				
				try{//try this if error
					Color col = (Color) Color.class.getField(color.toUpperCase()).get(null);//get the color String(all uppercase) as a field and get that field casting it to a color and assign its value to the object color
					g.setColor(col);//get the color from the upperCase String
				}catch(Exception i){//catch and set color to blue
					g.setColor(Color.blue);
				}
				X1 += 1;//add 1 to x and y of top left circle each time
				Y1 += 1;
				g.fillOval(X1, Y1, radius*2, radius*2);//draw the circle
				
				X2 -= 1;//subtract 1 from x and add 1 to y value of top right circle each time
				Y2 += 1;
				g.fillOval(X2, Y2, radius*2, radius*2);
				
				X3 += 1;// add 1 to x and subtract 1 from y of bottom left circle each time
				Y3 -= 1;
				g.fillOval(X3, Y3, radius*2, radius*2);
				
				X4 -= 1;//subtract 1 from bottom right circle each time
				Y4 -= 1;
				g.fillOval(X4, Y4, radius*2, radius*2);
				
				X += dx;//add the increments to the x and y position
				Y += dy;
				XX += dXX;//add the increments to the x and y position - bouncing ball 2
				YY += dYY;
				
				if (Y + radius > panelHeight){//if the ball(position + radius) goes over the bottom of the panel ---  equal is not used just in case the first position/ starting position of the ball is one of the corners so the addition is done before hand
					dy = -dy;//reverse the direction of the increment of movement in y direction
					Y = panelHeight - radius;//will ensure that the ball is positioned just above the bottom
				} else if (Y - radius < 0) {// if it goes above the top
					dy = -dy;//change the direction of increment
					Y = radius;//and position below the top
				}		
				if (X + radius > panelWidth) {//if it goes over the right
					dx = -dx;//change direction of increment in x direction
					X = panelWidth - radius;//set the x position just to the left of the panel
				} else if (X - radius < 0) {//if it goes over the left
					dx = -dx; // change direction of increment in x direction
					X = radius; // set the x position just to the right of the panel
				}
				g.setColor(new Color(0,255,255));
				g.fillOval(X-radius, Y-radius, 2*radius, 2*radius);//fill the oval at the x and y positions subtracting the radius as it was added to the random at the beggining
				
				
				if (YY + radius > panelHeight){//if the ball(position + radius) goes over the bottom of the panel ---  equal is not used just in case the first position/ starting position of the ball is one of the corners so the addition is done before hand
					dYY = -dYY;//reverse the direction of the increment of movement in YY direction
					YY = panelHeight - radius;//will ensure that the ball is positioned just above the bottom
				} else if (YY - radius < 0) {// if it goes above the top
					dYY = -dYY;//change the direction of increment
					YY = radius;//and position below the top
				}		
				if (XX + radius > panelWidth) {//if it goes over the right
					dXX = -dXX;//change direction of increment in XX direction
					XX = panelWidth - radius;//set the XX position just to the left of the panel
				} else if (XX - radius < 0) {//if it goes over the left
					dXX = -dXX; // change direction of increment in XX direction
					XX = radius; // set the XX position just to the right of the panel
				}
				g.setColor(new Color(0,255,255));
				g.fillOval(XX-radius, YY-radius, 2*radius, 2*radius);//fill the oval at the XX and YY positions subtracting the radius as it was added to the random at the beggining
				
				
				
				
				delay(delay);//delay
			}
			//reset all the x values for the circle each time
			g.setColor(new Color(57,255,20));//clear tha background
			g.fillRect(0, 0, panelWidth, panelHeight);
			X1 = 0 ;//top left
			Y1 = 0 ;
			
			X2 = getSize().width - radius*2;//top right
			Y2 = 0;
			
			X3 = 0;//bottom left
			Y3 = getSize().height -radius*2;
			
			X4 = getSize().width - radius*2;//bottom right
			Y4 = getSize().height - radius*2;		
			
		}
	}

	// method to set delay value and draw the BouncingBall Panel
	public void draw(long d, String color, Long repetitions) {//will get the delay, color and repetitions
		this.delay = d;//set the class variables to the ones received
		this.color = color;
		this.repetitions = repetitions;
		repaint();//repaint
	}

	// method to delay the drawing of next circle
	public void delay(long d) {
		// this wastes time
		for (long i = 1; i <= d; i++) {
			double garbage = Math.PI * Math.PI; // ???
		}
	}// delay method

} // end class BouncingBall
