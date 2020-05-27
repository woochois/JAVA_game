package com.project.first;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 100) { // 적의 출현 점수 수치 ( 레벨업 )
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if(hud.getLevel() == 2) { // 출현하는 적의 종류 및 수
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}else if(hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}else if(hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
			}else if(hud.getLevel() == 5) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				handler.addObject(new FastestEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastestEnemy, handler));
			}else if(hud.getLevel() == 6) {
				handler.addObject(new FastestEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastestEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
			}else if(hud.getLevel() == 7) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
			}else if(hud.getLevel() == 8) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				handler.addObject(new FastestEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastestEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				handler.addObject(new FastestEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastestEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				handler.addObject(new FastestEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastestEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				handler.addObject(new FastestEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastestEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
			}else if(hud.getLevel() == 9) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
			}else if(hud.getLevel() == 10) {
				handler.clearEnemys(); // 출현해있던 적 삭제 - 보스 준비
				handler.addObject(new EnemyBoss((Game.WIDTH / 2)-48, -120, ID.EnemyBoss, handler));
			}
		}
	}
}
