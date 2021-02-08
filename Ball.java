package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
		public double x,y;
		public int width,height;
		
		public double dx,dy;
		public double speed = 2.0;	
		
		public Ball(int x, int y) {
			this.x = x;
			this.y = y;
			this.width = 3;
			this.height = 3;
			
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
		}
	
	
		public void tick() {
			
			if(x+(dx*speed) + width >= Game.WIDTH) {
				dx*=-1;	
			}else if(x+(dx*speed) < 0) {
				dx*=-1;
			}
			
			if(y >= Game.HEIGHT)
			{
				//PONTO DO INIMIGO.
				System.out.println("Perdemu");
				new Game();
				return;
			}else if(y < 0) {
				//PONTO DO JOGADOR.
				System.out.println("Ganhemu");
				new Game();
				return;
			}
			
			Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),width,height);

			Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.width,Game.player.height);
			Rectangle boundsInimigo = new Rectangle((int)Game.inimigo.x,(int)Game.inimigo.y,Game.inimigo.width,Game.inimigo.height);
			
			if(bounds.intersects(boundsPlayer)) {
				int angle = new Random().nextInt(120 - 45) + 45 + 1;
				dx = Math.cos(Math.toRadians(angle));
				dy = Math.sin(Math.toRadians(angle));
				if(dy > 0);
					dy*=-1;
					
			}else if(bounds.intersects(boundsInimigo)) {
					dy*=-1;
				
					
			}	
			x+=dx*speed;
			y+=dy*speed;
			
			
						
		}
		
		public void render(Graphics g) {
			g.setColor(Color.white);
			g.fillRect((int)x,(int)y, width,height);
			
		}

}
