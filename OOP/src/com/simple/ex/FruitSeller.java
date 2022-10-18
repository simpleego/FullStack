package com.simple.ex;

public class FruitSeller {
	private int numOfApple = 10;
	private int myMoney = 0;
	private final int APPLE_PRICE = 1000;//사과 단가
	
	public int getAPPLE_PRICE() {
		return APPLE_PRICE;
	}

	// 판매기능
	public int saleApple(int money) {
		// 재고량 체크하여 판매
		
		int num = money / APPLE_PRICE;
		if(numOfApple >= num) {
			numOfApple -= num;
			myMoney += money;			
			System.out.println("남은 사과 : "+numOfApple+"개");
			return num;
		}else {		
			System.out.println("남은 사과 : "+numOfApple+"개");
			System.out.println("남은 사과가 개수 모자랍니다.");
			return 0;
		}
	}
	
	public void showPrice() {
		System.out.println("사과 : "+APPLE_PRICE);
	}

	@Override
	public String toString() {
		return "사과장수 [사과개수=" + numOfApple + ", 판매금액=" + myMoney + ", 사과단가=" + APPLE_PRICE + "]";
	}
	
	
	
	

}
