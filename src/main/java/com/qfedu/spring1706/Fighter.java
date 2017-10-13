package com.qfedu.spring1706;

public abstract class Fighter {
	protected String name;
	protected Integer hp;

	public Fighter(){

	}

	public Fighter(String name, Integer hp) {
		this.name = name;
		this.hp = hp;
	}
	
	public abstract int getCurrentInjury();
	
	public void attack(Fighter other) {
		other.setHp(other.hp - getCurrentInjury());
	}

	public String getName() {
		return name;
	}

	public Integer getHp() {
		return hp;
	}
	
	protected void setHp(Integer hp) {
		this.hp = hp < 0 ? 0 : hp;
	}

}
