package com.qfedu.spring1706;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component //不清楚是哪个层
/*
@Controller //表示层
@Service  //业务层
@Repository //持久层
*/

//配置Spring的方法
//1.XML
//2.XML+Annotation
//3.Code+Annotation
public class Ultraman extends Fighter {
	private Integer mp;
	@Autowired //自动装配
	private Weapon weapon;

	public Ultraman(){

	}


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

	public Weapon getWeapon() {
		return weapon;
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
