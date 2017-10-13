package com.qfedu.spring1706;

public class Stone implements Weapon {

	@Override
	public int getInjury() {
		return 10;
	}

	@Override
	public int getAddtionalInjury() {
		return CommonUtil.randomInt(0, 6);
	}

}
