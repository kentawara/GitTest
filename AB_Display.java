package Vending;

//商品欄、価格の表示クラス
public class AB_Display implements Account{
	
	AB_Display(){
		
	}
	
	public void dis_1() {
		System.out.print("商品：");
		for(int i=0; i<beverage.length; i++) {
			System.out.print((i+1) + "." + beverage[i] + ", ");
		}
		System.out.println("\n");
		
		System.out.print("在庫：");
		for(int i=0; i<stock.length; i++) {
			if( stock[i] == 0) {
				System.out.print("  " + (i+1) + "." + " 無し ");
			}else {
				System.out.print("  " + (i+1) + "." + " 在り ");
			}
			
		}
		System.out.println("\n");
		
		System.out.print("価格：");
		for(int i=0; i<price.length; i++) {
			System.out.print("  " + (i+1) + "." + price[i] + "円,");
		}
		System.out.println("\n");
		
		System.out.print("使用可能コイン：");
		for(int i=0; i<coin.length-1; i++) {
			System.out.print("  " + (i+1) + "." + coin[i] + "円,");
		}
		System.out.println("\n");
		
		System.out.println("使用可能紙幣：" + bill + "円");
		System.out.println();
		
		System.out.println("1990円以内でお金を投入してください");
		System.out.println();
	}
}
