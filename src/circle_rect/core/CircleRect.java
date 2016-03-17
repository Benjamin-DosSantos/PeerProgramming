package circle_rect.core;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

/** 
 * 
 *	Name: Benjamin DosSantos 
 *	Assignment: Peer Programming - Grid
 *	Project Description: a.	This program 
 *	is intended to make a grid of squares 
 *	of a pre-determined size and make a grid
 *  with the maximum number of possible circles 
 *  with that size that will fit on the screen. 
 * 
 **/

public class CircleRect extends Applet{

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = (int) screenSize.getWidth();
	static int height = (int) screenSize.getHeight();
	
	Color bgcolor = new Color(000, 000, 255);
	
	int ball_width = 100;
	int ball_height = ball_width;
	int ball_x = 0;
	int ball_y = 0;
	
	int number_rows = (width / ball_width) * 3;
	int number_col = height / ball_height;
	
	public void init(){
		this.setSize(new Dimension(width, height));
		this.setBackground(bgcolor);
	}
	
	public void paint(Graphics g){
		
		Random ran = new Random();
		
		for(int c = 0; c < number_col; c++){
			for(int r = 0; r < number_rows; r++){
				int ball_red = ran.nextInt(155) + 100;
				int ball_green = ran.nextInt(155) + 100;
				int ball_blue = ran.nextInt(155) + 100;
				Color ball_color = new Color(ball_red, ball_green, ball_blue);
				g.setColor(ball_color);
				g.fillOval(ball_x, ball_y, ball_width, ball_height);
				ball_x = ball_x + ball_width;
			}
			ball_y = ball_y + ball_height;
			ball_x = 0;
		}
	}
}