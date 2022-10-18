package com.simple.ex;

public class OOPMain {

	public static void main(String[] args) {
		FruitSeller  
		   appleSeller = new FruitSeller();
		
		FruitBuyer buyer1 = new FruitBuyer();
		FruitBuyer buyer2 = new FruitBuyer();
		FruitBuyer buyer3 = new FruitBuyer();
		
		appleSeller.showPrice();
		System.out.println(appleSeller);
		System.out.println(buyer1);
		
		// 사과구매
		buyer1.buyApple(appleSeller, 3000);
		System.out.println(appleSeller);
		System.out.println(buyer1);
		// 사과구매
		buyer1.buyApple(appleSeller, 1000);
		System.out.println(appleSeller);
		System.out.println(buyer1);
		// 사과구매
		buyer1.buyApple(appleSeller, 3000);
		System.out.println(appleSeller);
		System.out.println(buyer1);
		// 사과구매
		buyer1.buyApple(appleSeller, 3000);
		System.out.println(appleSeller);
		System.out.println(buyer1);
		
	}

}
