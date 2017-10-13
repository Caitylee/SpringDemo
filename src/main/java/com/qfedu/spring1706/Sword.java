package com.qfedu.spring1706;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //首选
public class Sword implements Weapon {
	private boolean isSuper;

	public Sword(){
	}

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
