package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	
	
	private static final int WIDTH = 0;
	private static final int RIGTH = 0;
	public boolean right,left;
	public int x,y;
	int width;
	int height;
	
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 3;
		
	}

	public void tick() {
		if(right)
		{
			x++;
		}
		else if(left)	{
			x--;
		}
		
		if(x+width > Game.WIDTH)
		{
			x = Game.WIDTH - width;
		}
		else if(x < 0) {
			x = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x,y, width,height);
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getRigth() {
		return RIGTH;
	}
}
