package com.project.first;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

	private Handler handler;
	Random r = new Random();

	public EnemyBossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 3;
	}

	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, 96, 96);
	}

	public void tick() {
		x += velX;
		y += velY;

		
//		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1; // 상하 반경 제한
//		if(x <= 0 || x >= Game.WIDTH - 96) velX *= -1; // 좌우 반경 제한
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.darkGray, 16, 16, 0.09f, handler)); // 0.00f = 잔상 효과 증가 감소 
	}

	public void render(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}


}