package circle_rect.core;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

@SuppressWarnings("serial")
public class Tree extends Applet{

	/** 
	 * 
	 *	Name: Benjamin DosSantos 
	 *	Assignment: Peer Programming – Christmas Tree
	 *	Project Description: a.	This program 
	 *  is intended to make a Christmas Tree 
	 *  of a predefined amount of horizontal 
	 *  rows and circle size. Code has been 
	 *  added to place a randomly color selected 
	 *  ornament (1 in 4 chance). Also the base 
	 *  of the tree will be generated with the 
	 *  same width of the Christmas tree circles. 
	 * 
	 **/
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static double width = screenSize.getWidth();
	static double height = screenSize.getHeight();
	
	Color bgcolor = Color.DARK_GRAY;

	int ball_width = 20;
	int ball_height = ball_width;
	int ball_x = (int) (width / 2);
	int ball_y = (int) (height / 4);
	int number_rows = 15;

	public void init(){
		this.setSize(new Dimension(screenSize));
		this.setBackground(bgcolor);
	}
	
	public void paint(Graphics g){
		Random ran = new Random();
		int ball_count = 0;
		for(int r = 0; r < number_rows; r++){
			Color ball_color = Color.GREEN;
			for (int i = 0; i <= ball_count; i++){
				int red = ran.nextInt(255);
				int green = ran.nextInt(255);
				int blue = ran.nextInt(255);
				Color ball_alt = new Color(red, green, blue);
				if(ball_count == 0){
					g.setColor(Color.RED);
					g.fillRect(ball_x, ball_y - 2, ball_width + 2, ball_height + 2);
					ball_x -= ball_width;
				}else{
					if(ran.nextInt(5) == 1){
						g.setColor(ball_alt);
						g.fillRect(ball_x, ball_y, ball_width, ball_height);
						ball_x -= ball_width;
					}else{
						g.setColor(ball_color);
						g.fillRect(ball_x, ball_y, ball_width, ball_height);
						ball_x -= ball_width;
					}
				}
			}
			ball_count += 2;
			ball_y += ball_height;
			ball_x += ball_width * ball_count;
		}
		for (int i = 0; i < (number_rows / 2); i++){
			ball_x = width / 2;
			g.setColor(new Color(139, 69, 19));
			g.fillRect(ball_x, ball_y, ball_width, ball_height);
			ball_x += ball_width;
			ball_y += ball_height;
		}
		g.setColor(Color.GREEN);
		g.fillRect(0, ball_y, width, height);
	}
}