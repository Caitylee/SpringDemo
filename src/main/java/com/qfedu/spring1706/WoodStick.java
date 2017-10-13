package com.qfedu.spring1706;

public class WoodStick implements Weapon {

	@Override
	public int getInjury() {
		return 5;
	}

	@Override
	public int getAddtionalInjury() {
		return 0;
	}

}
