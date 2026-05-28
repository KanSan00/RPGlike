package com.arakan.rpglike.model;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private static final int ACTION_GO = 1;
	private static final int ACTION_ATTACK = 1;
	private static final int ACTION_STAND = 2;
	private static final int ACTION_ESCAPE = 0;
	Player player;
	Enemy enemy;
	
	Scanner scanner;
	Random rand;
	
	public Game() {
		this.scanner = new Scanner(System.in);
		this.rand = new Random();
		
		this.player = new Player("",100,100,10);
	}
	
	public void start() {
		System.out.println("あなたのお名前は？");
		String name = this.scanner.nextLine();
		this.player.setName(name);
		
		while(this.player.getHp() > 0) {			
			int action = selectAction();			
			if(action == ACTION_GO) {
				int num = this.rand.nextInt(2);
				if(num == 0) {
					System.out.println("特に何もない先に進もう");
					continue;
				}
				else if(num == 1) {	
					System.out.println("敵が現れた！");
					battle();
				}
			}else {
				System.out.println("冒険をやめた");
				break;
			}
		}
	}
	
	public void battle() {
		int action = -1;
		createEnemy();
		while(action != ACTION_ESCAPE) {
			System.out.println(this.player.getName() + " HP: "+this.player.getHp());
			System.out.println(this.enemy.getName() + " HP: "+this.enemy.getHp());
			action = selectBattleAction();
			if(action == ACTION_ATTACK) {
				player.attack(enemy);
				
				if(enemy.isDead()) {
					System.out.println(enemy.getName()+"を倒した！");
					System.out.println(player.getName()+"は"+enemy.getExp()+"EXPを獲得した！");
					player.setExp(enemy.getExp());
					break;
				}
			}
			else if(action == ACTION_STAND) {
				int num = this.rand.nextInt(2);
				if(num == 0) {					
					enemy.attack(player);
				}else if(num == 1) {
					System.out.println(enemy.getName()+"は様子を見ている！");
				}
			}
			else if(action == ACTION_ESCAPE) {
				break;
			}
		}
		
	}
	
	public void createEnemy() {
		this.enemy = new Enemy("スライム",10,10,2,100);
	}
	
	private int selectAction() {
		String startLog =  String.format(
	            "[%d] 先に進む, [%d] 冒険をやめる",
	            ACTION_GO,
	            ACTION_ESCAPE
	        );
	        System.out.println(startLog);
	        
	        int action = -1;
	        while(action != ACTION_GO && action != ACTION_ESCAPE) {
	            String input = this.scanner.nextLine();
	            try {
	                action = Integer.parseInt(input);
	            }
	            catch(Exception e) {
	            }
	        }
	        return action;
	}
	
	private int selectBattleAction(){

		String commandLog =  String.format(
	            "[%d] 攻撃, [%d] 様子を見る, [%d] 逃げる",
	            ACTION_ATTACK,
	            ACTION_STAND,
	            ACTION_ESCAPE
	        );
	        System.out.println(commandLog);
	        
	        int action = -1;
	        while(action != ACTION_ATTACK 
	        		&& action != ACTION_STAND
	        		&& action != ACTION_ESCAPE) {
	            String input = this.scanner.nextLine();
	            try {
	                action = Integer.parseInt(input);
	            }
	            catch(Exception e) {
	            }
	        }
	        return action;
	}
}
