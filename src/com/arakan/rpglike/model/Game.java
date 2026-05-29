package com.arakan.rpglike.model;

import java.util.Random;
import java.util.Scanner;

import com.arakan.rpglike.character.enemy.Enemy;
import com.arakan.rpglike.character.enemy.EnemyFactory;
import com.arakan.rpglike.character.player.Player;

public class Game {
	private static final int ACTION_GO = 1;
	private static final int ACTION_ATTACK = 1;
	private static final int ACTION_STAND = 2;
	private static final int ACTION_ESCAPE = 0;
	Player player;
	Enemy enemy;
	Boolean isEscape = false;
	
	Scanner scanner;
	Random rand;
	EnemyFactory enemyFactory;
	
	public Game() {
		this.scanner = new Scanner(System.in);
		this.rand = new Random();
		this.enemyFactory = new EnemyFactory();
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
		isEscape = false;
		while(!isEscape) {
			System.out.println(this.player.getName()+" Lv."+player.getLevel()+ "\nHP: "+this.player.getHp());
			System.out.println(this.enemy.getName() + "\nHP: "+this.enemy.getHp());
			action = selectBattleAction();
			if(action == ACTION_ATTACK) {
				player.attack(enemy);
				
				if(enemy.isDead()) {
					System.out.println(enemy.getName()+"を倒した！");
					player.gainExp(enemy.getExp());
					break;
				}
				enemy.attack(player);
			}
			else if(action == ACTION_STAND) {
				int num = this.rand.nextInt(2);
				if(num == 0) {					
					enemy.attack(player);
				}else if(num == 1) {
					System.out.println(enemy.getName()+"は様子を見ている！");
					continue;
				}
			}
			else if(action == ACTION_ESCAPE) {
				int num = this.rand.nextInt(2);
				if(num == 0) {	
					System.out.println("逃げられなかった...");
					enemy.attack(player);
					isEscape = false;
				}else if(num == 1) {
					System.out.println("逃げた...");
					isEscape = true;
					break;
				}
			}
		}
		
	}
	
	public void createEnemy() {
		this.enemy = enemyFactory.createRandomEnemy();
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
