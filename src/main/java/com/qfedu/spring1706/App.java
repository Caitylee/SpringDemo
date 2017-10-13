package com.qfedu.spring1706;

public class App {
	
	public static boolean isAllDead(Monster[] ms) {
		for (Monster monster : ms) {
			if (monster.getHp() > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void showMonstersInfo(Monster[] ms) {
		for (Monster monster : ms) {
			System.out.println(monster);
		}
	}
	
	public static Monster selectAliveMonster(Monster[] ms) {
		Monster temp = null;
		do {
			temp = ms[CommonUtil.randomInt(0, ms.length)];
		} while (temp.getHp() == 0);
		return temp;
	}
	
	public static void main(String[] args) {
		Ultraman u = new Ultraman("骆昊", 500, 100);
		Weapon weapon = new Sword(true);
		u.setWeapon(weapon);
		Monster[] ms = {
				new Monster("舒玲", 250),
				new Monster("雷静", 500),
				new Monster("张莹", 500)
		};
		System.out.println(u);
		showMonstersInfo(ms);
		int round = 1;
		do {
			System.out.printf("=======第%d回合=======\n", round);
			Monster m = selectAliveMonster(ms);
			m.attack(u);
			if (u.getHp() > 0) {
				boolean useHuge = false;
				boolean useMagic = false;
				if (u.getHp() < 100) {
					useHuge = CommonUtil.randomInt(1, 100) >= 50;
				} else {
					useMagic = CommonUtil.randomInt(1, 100) >= 80;
				}
				if (useHuge) {
					System.out.println("**奥特曼使用了超大**");
					u.hugeAttack(m);
				} else if (useMagic) {
					System.out.println("**奥特曼使用了魔法**");
					u.magicAttack(ms);
				} else {
					u.attack(m);
				}
			}
			System.out.println(u);
			showMonstersInfo(ms);
			round += 1;
		} while (u.getHp() > 0 && !isAllDead(ms));
		if (u.getHp() > 0) {
			System.out.println("奥特曼胜利!");
		} else {
			System.out.println("小怪兽胜利!");
		}
	}
}
