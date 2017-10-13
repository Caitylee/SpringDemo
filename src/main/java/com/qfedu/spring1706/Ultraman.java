package com.qfedu.spring1706;

public class Ultraman extends Fighter {
	private Integer mp;
	private Weapon weapon;
	
	public Ultraman(String name, Integer hp, Integer mp) {
		super(name, hp);
		this.mp = mp;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	@Override
	public int getCurrentInjury() {
		return weapon != null ? 
				weapon.getInjury() + weapon.getAddtionalInjury() :
					CommonUtil.randomInt(15, 31);
	}
	
	public void hugeAttack(Fighter other) {
		int expectedInjury = (int) (other.hp * 0.75);
		int injury = expectedInjury > 50 ? expectedInjury : 50;
		other.setHp(other.hp - injury);
	}
	
	public void magicAttack(Fighter[] others) {
		int injury = CommonUtil.randomInt(10, 31);
		if (mp >= injury) {
			for (Fighter other : others) {
				other.setHp(other.hp - injury);
			}
			mp -= injury;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s奥特曼生命值: %d\n", name, hp) + 
				String.format("%s奥特曼魔法值: %d", name, mp);
	}
}
