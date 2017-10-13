package com.qfedu.spring1706;

public class Monster extends Fighter {

	public Monster(String name, Integer hp) {
		super(name, hp);
	}

	@Override
	public int getCurrentInjury() {
		return CommonUtil.randomInt(10, 21);
	}

	@Override
	public String toString() {
		return String.format("%s小怪兽生命值: %d", name, hp);
	}
}
