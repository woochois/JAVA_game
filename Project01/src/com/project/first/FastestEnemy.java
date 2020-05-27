package com.project.first;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastestEnemy extends GameObject{

	private Handler handler;
	
	public FastestEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 13; // 좌우 속도 및 각도
		velY = 13; // 상하 속도 및 각도
	}

	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.blue, 16, 16, 0.2f, handler)); // 0.00f = 잔상 효과 증가 감소 
		
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}


}
