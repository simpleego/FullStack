package com.simple.ex;

public class FruitBuyer {
	private int myMoney = 7000;
	private int numOfApple = 0;
	
	public void buyApple(FruitSeller seller,int money) {
		if(myMoney >= money) {
		
			if(myMoney >= seller.getAPPLE_PRICE() ) {
				
				numOfApple += seller.saleApple(money);			
				if(numOfApple != 0) {
					myMoney -= money;			
				}
			}
		}
	}

	@Override
	public String toString() {
		return "������ [ ������ �ܾ�=" + myMoney + ", �������=" + numOfApple + "]";
	}
	
}
