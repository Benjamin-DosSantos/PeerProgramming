package circle_rect.core;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

@SuppressWarnings("serial")
public class UpsideDown extends Applet{

	/** 
	 * 
	 *	Name: Benjamin DosSantos 
	 *	Assignment: Peer Programming – Upside Down Christmas Tree
	 *	Project Description: a.	This program 
	 *  is intended to make an Upside Down Christmas Tree 
	 *  of a predefined amount of horizontal 
	 *  rows and circle size. Code has been 
	 *  added to place a randomly color selected 
	 *  ornament (1 in 4 chance). Also the base 
	 *  of the tree will be generated with the 
	 *  same width of the Christmas tree circles. 
	 * 
	 **/
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = (int) screenSize.getWidth();
	static int height = (int) screenSize.getHeight();
	
	Color bgcolor = Color.DARK_GRAY;

	int start_x_pos = width / 2;
	int start_y_pos = height - 300;
	int ball_width = 1;
	int ball_height = ball_width;
	int ball_x = start_x_pos;
	int ball_y = start_y_pos;
	int number_rows = 500;

	public void init(){
		this.setSize(new Dimension(width, height));
		this.setBackground(bgcolor);
	}
	
	public void paint(Graphics g){
		Color ball_color = Color.GREEN;
		int ball_count = 0;
		for(int r = 0; r < number_rows; r++){
			for(int i = 0; i <= ball_count ; i++){
				Random ran = new Random();
				int red = ran.nextInt(255);
				int green = ran.nextInt(255);
				int blue = ran.nextInt(255);
				Color ball_alt = new Color(red, green, blue);
				if(ball_count == 0){
					g.setColor(Color.YELLOW);
					g.fillOval(ball_x, ball_y, ball_width, ball_height);
					ball_x -= ball_width;
				}else{
					if(ran.nextInt(5) == 1){
						g.setColor(ball_alt);
						g.fillOval(ball_x, ball_y, ball_width, ball_height);
						ball_x -= ball_width;
					}else{
						g.setColor(ball_color);
						g.fillOval(ball_x, ball_y, ball_width, ball_height);
						ball_x -= ball_width;
					}
				}
			}
			ball_count += 2;
			ball_x += ball_width * ball_count;
			ball_y -= ball_height;
		}	
		for (int i = 0; i < (number_rows / 2); i++){
			ball_x = width / 2;
			g.setColor(new Color(139, 69, 19));
			g.fillRect(start_x_pos, start_y_pos + ball_width, ball_width, ball_height);
			start_y_pos += ball_height;
		}
	}
}