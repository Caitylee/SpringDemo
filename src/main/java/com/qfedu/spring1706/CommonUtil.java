package com.qfedu.spring1706;

public final class CommonUtil {
	
	private CommonUtil() {
		throw new AssertionError();
	}
	
	/**
	 * 生成[min, max)范围的随机整数
	 * @param min 下限值(闭区间)
	 * @param max 上限值(开区间)
	 * @return 随机整数
	 */
	public static int randomInt(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}
}
