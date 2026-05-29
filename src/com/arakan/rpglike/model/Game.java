package com.arakan.rpglike.model;

import java.util.Random;
import java.util.Scanner;

import com.arakan.rpglike.character.enemy.Enemy;
import com.arakan.rpglike.character.enemy.EnemyFactory;
import com.arakan.rpglike.character.player.Player;
import com.arakan.rpglike.save.SaveData;
import com.arakan.rpglike.save.SaveManager;

public class Game {
	
	private enum MainMenu{GO, STATUS, QUIT}
	private enum BattleStartMenu{BATTLE, ESCAPE}
	private enum BattleMenu{ATTACK, STAND, ESCAPE}
	
	Player player;
	Enemy enemy;
	
	Scanner scanner;
	Random rand;
	EnemyFactory enemyFactory;
	
	public Game(Player player) {
		this.scanner = new Scanner(System.in);
		this.rand = new Random();
		this.enemyFactory = new EnemyFactory();
		this.player = player;
	}
	
	public void start() {
		if(player.getName().equals("")) {			
			System.out.println("あなたのお名前は？");
			String name = this.scanner.nextLine();
			this.player.setName(name);
		}
		
		while (this.player.getHp() > 0) {			
			MainMenu command = selectMainMenu();			
			if (command == MainMenu.GO) {
				handleExploration();
			}
			else if(command == MainMenu.STATUS) {
				showStatus();
			}
			else {
				System.out.println("冒険をやめた");
				save();
				break;
			}
		}
	}
	
	// 進む処理を独立させ、start()の見通しを良くする
	private void handleExploration() {
		// rand.nextBoolean() で 50% の確率をシンプルに表現
		if (this.rand.nextBoolean()) {
			System.out.println("特に何もない先に進もう");
		} else {	
			System.out.println("敵が現れた！");
			if (selectBattleStartMenu() == BattleStartMenu.BATTLE) {
				battle();						
			} else {
				System.out.println("逃げた...");
			}
		}
	}
	
	private void showStatus() {
		System.out.println(player);
	}
	
	private void battle() {
		// エネミーの生成
		createEnemy();
		boolean isBattleOver = false;
		
		// ループの条件を「バトルが終了していない間」に変更
		while (!isBattleOver) {
			printStatus();
			BattleMenu command = selectBattleMenu();
			
			// switch文を使い、コマンドごとの処理をメソッドに丸投げする
			switch (command) {
				case ATTACK:
					isBattleOver = executeAttackAction();
					break;
				case STAND:
					executeStandAction();
					break;
				case ESCAPE:
					isBattleOver = executeEscapeAction();
					break;
			}
		}
	}
	
	// 3. バトル中の各アクションをメソッドとして抽出（単一責任）
	
	private void printStatus() {
		System.out.println(player.getName() + " Lv." + player.getLevel() + "　HP: " + player.getHp());
		System.out.println(enemy.getName() + " HP: " + enemy.getHp());
	}

	private boolean executeAttackAction() {
		player.attack(enemy);
		if (enemy.isDead()) {
			System.out.println(enemy.getName() + "を倒した！");
			player.gainExp(enemy.getExp());
			return true; // バトル終了
		}
		enemy.attack(player);
		return player.isDead(); // プレイヤーが死んだらバトル終了
	}

	private void executeStandAction() {
		if (this.rand.nextBoolean()) {					
			enemy.attack(player);
		} else {
			System.out.println(enemy.getName() + "は様子を見ている！");
		}
	}

	private boolean executeEscapeAction() {
		if (this.rand.nextBoolean()) {	
			System.out.println("逃げた...");
			return true; // バトル終了
		} else {
			System.out.println("逃げられなかった...");
			enemy.attack(player);
			return player.isDead();
		}
	}
	
	/**
	 * ランダムにエネミーを生成
	 */
	public void createEnemy() {
		this.enemy = enemyFactory.createRandomEnemy();
	}
	
	// 2. 入力処理の共通化ヘルパーメソッド
	private int promptForInput(String message, int maxChoice) {
		System.out.println(message);
		while (true) {
			String input = this.scanner.nextLine();
			try {
				int action = Integer.parseInt(input);
				if (action >= 0 && action <= maxChoice) {
					return action;
				}
			} catch (NumberFormatException e) {
				// 数字以外が入力された場合は無視してループを続ける
			}
			System.out.println("正しい番号を入力してください。");
		}
	}
	
	
	
	private MainMenu selectMainMenu() {
		String msg = String.format("[%d] 先に進む, [%d] ステータスを見る, [%d] 冒険をやめる", 1, 2, 0);
		int choice = promptForInput(msg, 2);
		switch (choice) {
			case 1:  return MainMenu.GO;
			case 2:  return MainMenu.STATUS;
			default: return MainMenu.QUIT;
		}
	}
		
	private BattleStartMenu selectBattleStartMenu() {
		String msg = String.format("[%d] 戦う, [%d] 逃げる", 1, 0);
		int choice = promptForInput(msg, 1);
		return choice == 1 ? BattleStartMenu.BATTLE : BattleStartMenu.ESCAPE;
	}
		
	private BattleMenu selectBattleMenu() {
		String msg = String.format("[%d] 攻撃, [%d] 様子を見る, [%d] 逃げる", 1, 2, 0);
		int choice = promptForInput(msg, 2);
			
		switch (choice) {
			case 1:  return BattleMenu.ATTACK;
			case 2:  return BattleMenu.STAND;
			default: return BattleMenu.ESCAPE;
		}
	}
		
		/**
		 * セーブ
		 */
	private void save() {
		 SaveData data = new SaveData();
		 data.setData(player);
		 SaveManager.save(data);
	}
}
