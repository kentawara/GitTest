package Vending;

public class Maintenance {
	
	int count_bill = 0;  //他クラスの変数を持ってくる
	int count_coin_500 = 0;//カウント変数
	int count_coin_100 = 0;//カウント変数
	int count_coin_50 = 0;//カウント変数
	int count_coin_10 = 0;//カウント変数
	int[] stock = {10,10,10,0,10,10,10,10};
	
	public void mtnc(String str) {
	
		if(str.equals("1")) {
			money_display();
		}
		if(str.equals("2")) {
			item_display();
		}
		if(str.equals("3")) {
			money_reset();
			System.out.println("リセット完了");
		}
		if(str.equals("4")) {
			item_add();
			System.out.println("在庫追加完了");
		}
		
	}
	
	public void  money_display() {
			
			System.out.println("1000:"+ count_bill + "枚");
			System.out.println("500:"+ count_coin_500 + "枚");
			System.out.println("100:"+ count_coin_100 + "枚");
			System.out.println("50:"+ count_coin_50 + "枚");
			System.out.println("10:"+ count_coin_10 + "枚");
			
		}
	public void  item_display() {
		
		for(int i=0;i<6;i++) {
			Stock.stock(i);
		}
		
	}
	
	public void money_reset() {
		
		count_bill = 20;
		count_coin_500 = 20;
		count_coin_100 = 20;
		count_coin_50 = 20;
		count_coin_10 = 20;
		
	}
	
	public void item_add() {
		
		stock[0] = 20;
		stock[1] = 20;
		stock[2] = 20;
		stock[3] = 20;
		stock[4] = 20;
		stock[5] = 20;
		stock[6] = 20;
		stock[7] = 20;
	}
}
