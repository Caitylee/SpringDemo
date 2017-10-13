package com.qfedu.spring1706;

public class Sword implements Weapon {
	private boolean isSuper;
	
	public Sword(boolean isSuper) {
		this.isSuper = isSuper;
	}
	
	@Override
	public int getInjury() {
		return 50;
	}

	@Override
	public int getAddtionalInjury() {
		return isSuper ? CommonUtil.randomInt(10, 20) : 0;
	}

}
