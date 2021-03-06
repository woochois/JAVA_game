package com.project.first;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	
	private int timer = 80;
	private int timer2 = 50;
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0; // 속도 velocity
		velY = 2; // 속도 
	}

	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, 96, 96);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		
		if(timer <= 0) {
			velY = 0;
		}else timer--;
		
		if(timer <= 0) {
			timer2--;
		}
		if(timer2 <= 0) { 
			
			if(velX == 0) velX = 2; // 좌우로 움직이는 속도
			
			if(velX > 0) {
				velX += 0.005f; // 보스 좌우로 움직이는 속도 점점 빨라짐
			}else if(velX < 0) {
				velX -= 0.005f; 
			}
			
			velX = Game.clamp(velX, -10, 10); // 보스 좌우 움직임 제한
			
			int spawn = r.nextInt(10); // 총알
			if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x+48, (int)y+48, ID.BasicEnemy, handler));
		}
		
		
//		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1; // 상하 반경 제한
		if(x <= 0 || x >= Game.WIDTH - 96) velX *= -1; // 좌우 반경 제한
		
//		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.1f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect((int)x, (int)y, 96, 96);
		
	}


}
