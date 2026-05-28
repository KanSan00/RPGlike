package com.arakan.rpglike.model;

import java.util.Scanner;

public class Game {
	private static final int ACTION_ATTACK = 0;
	private static final int ACTION_STAND = 1;
	private static final int ACTION_ESCAPE = 2;
	Player player;
	Enemy enemy;
	
	Scanner scanner;
	
	public Game() {
		this.scanner = new Scanner(System.in);
		
		this.player = new Player();
	}
	
	public void start() {
		System.out.println("あなたのお名前は？");
		String name = this.scanner.nextLine();
		this.player.setName(name);
		
		int action = selectAction();
		if(action == ACTION_ATTACK) {

		}
		else if(action == ACTION_STAND) {
			
		}
		else if(action == ACTION_ESCAPE) {
			
		}
	}
	
	public void battle() {
		
	}
	
	public void createEnemy() {
		
	}
	
	private int selectAction(){
		String startLog =  String.format(
	            "[%d] 攻撃, [%d] 様子を見る, [%d] 逃げる",
	            ACTION_ATTACK,
	            ACTION_STAND,
	            ACTION_ESCAPE
	        );
	        System.out.println(startLog);
	        
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
