package BAM.Circle_Dots;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

public class CircleDotsCore extends Applet{
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		// Generates a screen size framework
    int Screenwidth = (int) screenSize.getWidth();	// Makes a variable for screen width
	int Screenheight = (int) screenSize.getHeight();	// Makes a variable for screen height
	
	public void init(){		
		Color bgColor = Color.DARK_GRAY;	// Color variable for bgColor 
		this.setSize(new Dimension(Screenwidth, Screenheight));		// Sets the screen size of the applet
		this.setBackground(bgColor);	// Sets the Background color 
	}	// End of init Method
	
	public void paint(Graphics g){
		 
		// Creates variables for the circle generation 
		double center_x = 0.0, center_y = 0.0, radius = 0.0, xPos = 0.0, yPos = 0.0, width = 0.0, height = 0.0, diameter = 0.0; 
		int dotgen = 1000;	// How many dots to be generated
		Color circlecolor = Color.RED;	// Generates a color for the big circle
		Color activecolor = Color.BLACK;	// sets the color for the dots inside of the circle
		Color inactivecolor = Color.ORANGE;	// sets the color for the dots outside of the circle 
		int dotwidth = 3; // Sets the width of the dot
		int dotheight = dotwidth;	// Sets the dot height to the value of the dot width
		Random ran = new Random();	// Random call
		int minwidth = 150;		// Sets the min width of the big circle
		int widthrange = 500;	// Sets the width range of the big circle
		
		width = ran.nextInt(widthrange) + minwidth;		// Sets the width of the circle
		height = width;	// Sets the height equal to the width
		xPos = ran.nextInt(Screenwidth) - width;	// Randomly generates the xPos of the big circle 
		yPos = ran.nextInt(Screenheight) - height;  // Randomly generates the yPos of the big circle 
	
		g.setColor(circlecolor);	// Sets the color of the big circle
		g.fillOval((int)xPos, (int)yPos, (int)width, (int)height);	// Fills the big circle 
		
		 for (int i = 0; i <= dotgen; i++){		// for the number of dots
			 int dot_xPos = ran.nextInt(Screenwidth);	// randomly generate a xPos for the dot
			 int dot_yPos = ran.nextInt(Screenheight);	// randomly generates a yPos for the dot
			 center_x = xPos + (width / 2);	// Sets the center of the circle x
			 center_y = yPos + (height / 2); // Sets the center of the circle y
			 diameter = width;	// Sets the diameter of the circle
			 radius = diameter / 2;	// Sets the radius of the circle
			
			 if (isPointInCircle(center_x, center_y, radius, dot_xPos, dot_yPos)){		// Checks if the dot is in the circle
				 g.setColor(activecolor);	// sets the color to the color of dots inside the circle
				 g.fillOval(dot_xPos, dot_yPos, dotwidth, dotheight); 	// Draws the dot
			 }else{		// if the dot is not in the circle
				 g.setColor(inactivecolor);	// Sets the color to the color of dots outside the circle
				 g.fillOval(dot_xPos, dot_yPos, dotwidth, dotheight); 	// Fills the dot
			 }// end of else
		 }	// End of for loop 
	}	// End Of Paint Method
	/**
	 * Do not touch the code below!!!!!!!!!!!!!!!!!!
	 * @param centerX
	 * @param centerY
	 * @param radius
	 * @param x
	 * @param y
	 * @return
	 */
	boolean isInRectangle(double centerX, double centerY, double radius, double x, double y){
		return x >= centerX - radius && x <= centerX + radius && y >= centerY - radius && y <= centerY + radius;		// Returns booleans of check values
	}//end of isinrectangle
	
	public boolean isPointInCircle(double centerX, double centerY, double radius, double x, double y){
	    if(isInRectangle(centerX, centerY, radius, x, y)){		// Checks if the point is in the rectangle that outlines the circle
	        double dx = centerX - x;	// Sets the double to the value of the centerx - x
	        double dy = centerY - y;	// Sets the double to the value of the centery - y
	        dx *= dx;	// squares the value of dx
	        dy *= dy;	// squares the value of dy
	        double distanceSquared = dx + dy;	// sets the distanceSqured to the value of dx + dy
	        double radiusSquared = radius * radius;		// Squares the value of the radius
	        return distanceSquared <= radiusSquared;	// Checks if the distance is less then or equal to the radius
	    }//end of if
	    return false;	// Returns false if the point is not in the circle 
	}//end of is pointcircle
}	// End Of Class
