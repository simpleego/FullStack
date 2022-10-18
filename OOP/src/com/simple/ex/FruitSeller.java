package com.simple.ex;

public class FruitSeller {
	private int numOfApple = 10;
	private int myMoney = 0;
	private final int APPLE_PRICE = 1000;//��� �ܰ�
	
	public int getAPPLE_PRICE() {
		return APPLE_PRICE;
	}

	// �Ǹű��
	public int saleApple(int money) {
		// ��� üũ�Ͽ� �Ǹ�
		
		int num = money / APPLE_PRICE;
		if(numOfApple >= num) {
			numOfApple -= num;
			myMoney += money;			
			System.out.println("���� ��� : "+numOfApple+"��");
			return num;
		}else {		
			System.out.println("���� ��� : "+numOfApple+"��");
			System.out.println("���� ����� ���� ���ڶ��ϴ�.");
			return 0;
		}
	}
	
	public void showPrice() {
		System.out.println("��� : "+APPLE_PRICE);
	}

	@Override
	public String toString() {
		return "������ [�������=" + numOfApple + ", �Ǹűݾ�=" + myMoney + ", ����ܰ�=" + APPLE_PRICE + "]";
	}
	
	
	
	

}
